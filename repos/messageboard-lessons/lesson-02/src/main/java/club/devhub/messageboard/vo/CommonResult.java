package club.devhub.messageboard.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回模板
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult {

    private Boolean success;
    private Integer code;
    private String message;
    private Object data;

    public static CommonResult success() {
        return new CommonResult(true, 200, "操作成功", null);
    }

    public static CommonResult success(Object data) {
        return new CommonResult(true, 200, "操作成功", data);
    }

    public static CommonResult failure(String message) {
        return new CommonResult(false, -1, message, null);
    }
}
