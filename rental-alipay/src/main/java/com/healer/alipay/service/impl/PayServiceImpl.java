package com.healer.alipay.service.impl;

import com.alipay.api.AlipayApiException;

import com.healer.alipay.entitys.AlipayBean;
import com.healer.alipay.service.PayService;
import com.healer.alipay.utils.Alipay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private Alipay alipay;


    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return alipay.pay(alipayBean);
    }
}
