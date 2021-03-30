package guanghui.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guanghui.mapper.PaymentMapper;
import com.guanghui.service.PaymentService;
import commons.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {
}
