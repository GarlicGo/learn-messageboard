package club.devhub.messageboard.service;

import club.devhub.messageboard.vo.PageResult;
import club.devhub.messageboard.vo.ReportVO;

/**
 * 针对表【t_report(举报表)】的Service
 */
public interface ReportService {

    /**
     * 获取举报的列表(提供分页)
     */
    PageResult<ReportVO> getList(Integer current, Integer pageSize);

    /**
     * 根据reportId,评审指定的举报
     */
    void review(Long userId, Long reportId, Boolean illegal);
}
