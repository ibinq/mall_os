package com.bing.mall_back.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/13 8:22
 */
@Data
public class OrderDTO {

    private Long id;

    private Long orderNo;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime paymentTime;

    private String username;

    private BigDecimal payment;

    private String statusStr;

    private Integer status;

}
