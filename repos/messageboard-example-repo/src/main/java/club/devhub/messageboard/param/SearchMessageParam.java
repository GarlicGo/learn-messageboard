package club.devhub.messageboard.param;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 留言搜索参数
 */
@Data
public class SearchMessageParam {

    /**
     * 查看的留言种类
     * 注意:我没有写@NotNull,允许前端不填,因为null表示不限制种类
     */
    @Min(value = 0, message = "留言类别最小为0")
    @Max(value = 4, message = "留言类别最大为4")
    private Integer category;

    /**
     * 指定留言发布者的ID
     * 注意:我没有写@NotNull,允许前端不填,因为null表示不限制发布者
     */
    @Min(value = 1, message = "用户ID最小为1")
    private Long userId;
}
