package com.guanghui.controller;


import com.guanghui.service.PaymentService;
import commons.entity.Payment;
import commons.util.BaseController;
import commons.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.ws.Response;
import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/payment")
public class PaymentController extends BaseController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/addPayment")
    public ResponseResult addPayment(@RequestBody Payment payment) {
        boolean result = paymentService.save(payment);
        if (!result) {
            return failure(CODE_500.getCode(), CODE_500.getMessage() + serverPort);
        }
        return successful();

    }

    @GetMapping("/getPaymentById/{id}")
    public ResponseResult getPaymentById(@PathVariable("id") long id) {
        Payment payment = paymentService.getById(id);
        if (payment == null) {
            return failure(CODE_500.getCode(), CODE_500.getMessage() + serverPort);
        }
        return successful(CODE_200.getCode(), CODE_200.getMessage() + "服务端口为：" + serverPort, payment);
    }


    /**
     * eureka的服务发现测试
     * @return
     */
    @GetMapping("/payment/getServices")
    public Object getDiscoveryClient() {
        List<String> elements = discoveryClient.getServices();
        for (String element : elements
        ) {
            log.info("element:" + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance:instances
             ) {
            log.info("instance:"+"\t"+instance.getInstanceId()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }

}
