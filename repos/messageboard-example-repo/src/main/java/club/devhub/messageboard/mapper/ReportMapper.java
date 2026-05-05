package club.devhub.messageboard.mapper;


import club.devhub.messageboard.entity.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 针对表【t_report(举报表)】的数据库操作Mapper
 */
@Mapper
public interface ReportMapper {

    /**
     * 创建一条新举报
     */
    void insert(@Param("reportType") Integer reportType, @Param("targetId") Long targetId, @Param("reason") String reason, @Param("userId") Long userId);

    /**
     * 统计一个用户是否已经举报过某条特定的留言或者评论了(由reportType和targetId确定)
     */
    int count(@Param("reportType") Integer reportType, @Param("targetId") Long targetId, @Param("userId") Long userId);

    /**
     * 获取举报列表
     */
    List<Report> getList();

    /**
     * 根据reportId获取举报
     */
    Report getById(@Param("reportId") Long reportId);

    /**
     * 删除所有针对于指定对象(一条特定的留言或者评论,由reportType和targetId确定)的所有举报
     */
    void deleteBatch(@Param("reportType") Integer reportType, @Param("targetId") Long targetId);
}




