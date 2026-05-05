package club.devhub.messageboard.param;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 分页参数
 */
@Data
public class PagingParam {
    /**
     * 当前页码
     * 注意:我没有写@NotNull,允许前端不填,因为我提供了默认值
     */
    @Min(value = 1, message = "页码最小为1")
    private Integer current = 1;
    /**
     * 每页显示几条
     * 注意:我没有写@NotNull,允许前端不填,因为我提供了默认值
     */
    @Min(value = 1, message = "单页条数最小为1")
    @Max(value = 100, message = "单页条数最大为100")
    private Integer pageSize = 10;

}