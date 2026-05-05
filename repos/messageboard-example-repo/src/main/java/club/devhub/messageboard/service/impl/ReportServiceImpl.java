package club.devhub.messageboard.service.impl;


import club.devhub.messageboard.constant.ReportTypeEnum;
import club.devhub.messageboard.entity.Report;
import club.devhub.messageboard.exception.NotFoundException;
import club.devhub.messageboard.mapper.CommentMapper;
import club.devhub.messageboard.mapper.MessageMapper;
import club.devhub.messageboard.mapper.ReportMapper;
import club.devhub.messageboard.service.ReportService;
import club.devhub.messageboard.vo.PageResult;
import club.devhub.messageboard.vo.ReportVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 针对表【t_report(举报表)】的Service实现
 */
@Service
@Slf4j
public class ReportServiceImpl implements ReportService {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public PageResult<ReportVO> getList(Integer current, Integer pageSize) {
        PageHelper.startPage(current, pageSize);
        List<Report> temp = reportMapper.getList();
        PageInfo<Report> pageInfo = new PageInfo<>(temp);
        List<ReportVO> list = new ArrayList<>(pageInfo.getSize());

        for (Report report : temp) {
            String content = null;
            if (ReportTypeEnum.MESSAGE.getCode() == report.getReportType()) {
                content = messageMapper.getContentById(report.getTargetId());
            } else if (ReportTypeEnum.COMMENT.getCode() == report.getReportType()) {
                content = commentMapper.getContentById(report.getTargetId());
            }
            list.add(new ReportVO(report.getReportId(), content != null ? content : "[内容已被删除]", report.getReason(), report.getCreateTime()));
        }

        PageResult<ReportVO> result = new PageResult<>();
        result.setTotal(pageInfo.getTotal());
        result.setPrev(pageInfo.isHasPreviousPage() ? pageInfo.getPrePage() : -1);
        result.setNext(pageInfo.isHasNextPage() ? pageInfo.getNextPage() : -1);
        result.setList(list);
        return result;

    }

    @Override
    @Transactional
    public void review(Long userId, Long reportId, Boolean illegal) {
        Report report = reportMapper.getById(reportId);
        if (report == null) {
            throw new NotFoundException("reportId为" + reportId + "的举报不存在");
        }
        log.info("userId为{}的管理正在处理举报：{}，其意见为illegal={}", userId, report, illegal);
        if (illegal) {
            if (ReportTypeEnum.MESSAGE.getCode() == report.getReportType()) {
                Long messageId = report.getTargetId();
                //如果这条留言已经被他人抢先删除了，那么再删一遍也没影响
                messageMapper.deleteById(messageId);
                commentMapper.deleteBatchByMessageId(messageId);
            } else if (ReportTypeEnum.COMMENT.getCode() == report.getReportType()) {
                Long commentId = report.getTargetId();
                Long messageId = commentMapper.getMessageIdById(commentId);
                log.info("commentId为{}的评论所属的messageId是{}", commentId, messageId);
                int deleted = commentMapper.deleteById(commentId);
                if (deleted != 0) {
                    log.info("由于删除了commentId为{}的评论，将会把messageId为{}的留言执行reduceFloor操作", commentId, messageId);
                    messageMapper.reduceFloor(messageId);
                } else {
                    //能到这里说明deleted=0，这条评论已经被他人抢先删除了
                    //那么就不要去把其所属的留言reduceFloor了
                    log.info("commentId为{}的留言已不存在，没有去删除评论", commentId);
                }
            }
        }
        //对于同种举报，可以一起删除
        reportMapper.deleteBatch(report.getReportType(), report.getTargetId());
    }

}




