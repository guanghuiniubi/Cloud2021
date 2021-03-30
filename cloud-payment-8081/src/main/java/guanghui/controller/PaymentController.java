package guanghui.controller;


import commons.entity.Payment;
import commons.util.BaseController;
import commons.util.ResponseResult;
import guanghui.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addPayment")
    public ResponseResult addPayment(@RequestBody Payment payment){
       boolean result= paymentService.save(payment);
       if(!result){
           return failure(CODE_500.getCode(),CODE_500.getMessage());
       }
       log.info(serverPort+"插入成功");
            return successful();

    }

    @GetMapping("/getPaymentById/{id}")
    public ResponseResult getPaymentById(@PathVariable("id") long id){
        Payment payment=paymentService.getById(id);
        if(payment==null){
            return failure(CODE_500.getCode(),CODE_500.getMessage());
        }
        return successful(payment);
    }
}
