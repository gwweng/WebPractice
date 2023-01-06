package com.web.practice.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductInfo {

    private Long productId;

    private String productName;

    private BigDecimal productPrice;

    private String proudctDesc;

    private Integer status;
}
