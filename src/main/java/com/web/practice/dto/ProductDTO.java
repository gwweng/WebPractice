package com.web.practice.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProductDTO {

    private Long id;

    @NotNull(message = "商品名称不可为空")
    private String name;
}
