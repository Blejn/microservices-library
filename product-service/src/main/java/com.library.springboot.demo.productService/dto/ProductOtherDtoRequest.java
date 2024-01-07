package com.library.springboot.demo.productService.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Data
public class ProductOtherDtoRequest {
    private Long id;
    private String description;
    private Boolean availability;
    private int quantity;
    private String name;
    private BigDecimal price;

}
