package club.devhub.messageboard.advice;

import club.devhub.messageboard.vo.CommonResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一包装 Controller 返回值
 */
@RestControllerAdvice(basePackages = "club.devhub.messageboard.controller")
public class CommonResultWrapper implements ResponseBodyAdvice<Object> {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    @SneakyThrows
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body == null) {
            return CommonResult.success();
        }
        if (body instanceof String) {
            return objectMapper.writeValueAsString(CommonResult.success(body));
        }
        if (body instanceof CommonResult) {
            return body;
        }
        return CommonResult.success(body);
    }
}
