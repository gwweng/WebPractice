package com.web.practice.controller;



import com.web.practice.config.ResultVo;
import com.web.practice.config.annoation.NotControllerResponseAdvise;
import com.web.practice.dto.ProductDTO;
import com.web.practice.model.ProductInfo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 记录对于Controller的代码优化
 * 1. 统一状态码
 * 2. 全局异常捕获
 * 3. 统一校验
 * 4. 统一响应
 */

@RestController
public class ProductInfoController {

    @PostMapping("/findById")
    public ProductInfo findById(Long id){
        ProductInfo info = new ProductInfo();
        info.setProductId(1L);
        info.setProductName("测试产品");
        info.setProductPrice(BigDecimal.TEN);
        info.setProudctDesc("这是一款测试产品");
        return  info;
    }

    // 改造1：封装ResultVo统一返回标准
    // 改造2: ProductDTO统一校验,增加异常拦截
    @PostMapping("/findByParam")
    public ResultVo findByParam(@RequestBody @Validated  ProductDTO param){
        ProductInfo info = new ProductInfo();
        info.setProductId(1L);
        info.setProductName("测试产品1");
        info.setProductPrice(BigDecimal.TEN);
        info.setProudctDesc("这是一款测试产品2");
        return new ResultVo(info);
    }

    // 改造：增加对普通返回实体的ResultVo封装, ControllerResponseAdvice
    @PostMapping("/findByParam2")
    public ProductInfo findByParam2(@RequestBody @Validated  ProductDTO param){
        ProductInfo info = new ProductInfo();
        info.setProductId(1L);
        info.setProductName("测试产品1");
        info.setProductPrice(BigDecimal.TEN);
        info.setProudctDesc("这是一款测试产品2");
        return info;
    }


    // 改造：个性化返回标记注解
    @GetMapping("/health")
    @NotControllerResponseAdvise
    public String health(){
       return "success";
    }




}
