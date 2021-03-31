package com.guanghui.controller;


import commons.entity.Payment;
import commons.util.BaseController;
import commons.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
public class OrderController extends BaseController {
    private static final String PAYMENT_KEY="http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 消费端调用服务端提供的增加订单接口
     * @param payment
     * @return
     */
    @RequestMapping("/consumer/addPayment")
    public ResponseResult addPayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_KEY+"/payment/addPayment",payment,ResponseResult.class);
    }

    /**
     * 消费端调用服务端提供的获取订单接口
     * @param id
     * @return
     */
    @GetMapping("/consumer/getPaymentById/{id}")
    public ResponseResult getPaymentById(@PathVariable("id") long id){
        return restTemplate.getForObject(PAYMENT_KEY+"/payment/getPaymentById/"+id,ResponseResult.class);
    }
}
