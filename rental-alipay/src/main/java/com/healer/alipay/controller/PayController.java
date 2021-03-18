package com.healer.alipay.controller;

import com.alipay.api.AlipayApiException;
import com.healer.alipay.entitys.AlipayBean;
import com.healer.alipay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付宝沙箱测试
 *
 * @date 2020年2月17日
 */
@CrossOrigin
@RestController
public class PayController {

    @Autowired
    private PayService payService;

    /**
     * 阿里支付
     * @param tradeNo
     * @param subject
     * @param amount
     * @param body
     * @return
     * @throws AlipayApiException
     */
    @GetMapping(value = "order/alipay")
    public String alipay(
            @RequestParam String outTradeNo,
            @RequestParam String subject,
            @RequestParam String totalAmount,
            @RequestParam String body) throws AlipayApiException {
        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setOut_trade_no(outTradeNo);
        alipayBean.setSubject(subject);
        alipayBean.setTotal_amount(totalAmount);
        alipayBean.setBody(body);
        return payService.aliPay(alipayBean);
    }

}
