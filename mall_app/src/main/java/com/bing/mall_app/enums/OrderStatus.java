package com.bing.mall_app.enums;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/9 13:31
 */
public enum OrderStatus {
//    1.待付款 2.待收货 3.已完成 4.售后
    TO_BE_PAID(1),
    GOODS_TO_BE_RECEIVED(2),
    COMPLETED(3),
    AFTER_SALE(4);

    OrderStatus(Integer value) {
        this.value = value;
    }

    private Integer value;

    public Integer getValue() {
        return value;
    }
}
