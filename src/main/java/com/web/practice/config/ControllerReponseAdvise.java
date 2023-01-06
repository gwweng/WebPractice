package com.web.practice.config;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.practice.config.annoation.NotControllerResponseAdvise;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


@RestControllerAdvice(basePackages = {"com.web.practice"})
public class ControllerReponseAdvise implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        // response是ResultVo类型，或者注释了NotControllerResponseAdvice都不进行包装
        // 其他的类型都需要封装
        return !methodParameter.getParameterType().isAssignableFrom(ResultVo.class)
                || methodParameter.hasMethodAnnotation(NotControllerResponseAdvise.class);
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 返回String不可直接封装
        if(methodParameter.getGenericParameterType().equals(String.class)){
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(new ResultVo(data));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return new ResultVo(data);
    }
}
