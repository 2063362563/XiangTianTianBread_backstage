package com.fan.xiangtiantianbread.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author fan
 * @description 支付
 * @date 2023-03-25
 */
@Data
public class PayRequest {
    private List<Map<String, Object>> cart;
    private String tel;

    // getters and setters
}

