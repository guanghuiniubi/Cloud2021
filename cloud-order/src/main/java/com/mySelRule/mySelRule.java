package com.mySelRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: guanghui
 * @DateTime: 2021/4/1 15:55
 * @Descreption: ribbon的自定义配置类不能建立在@compomentscan注解的扫描范围下
 *               不然会被ribbon的客户端共享掉。无法生效
 */
@Configuration
public class mySelRule {

    @Bean
    public IRule myRule(){
        return new RandomRule(); //随机
    }
}
