package com.hmall.trade.config;

import cn.hutool.core.util.ObjectUtil;
import com.hmall.common.utils.UserContext;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: violet
 * Date: 2024/8/29 19:54
 */

@Configuration
public class J2M {


    /**
     * 使用json序列化RabbitMQ对象消息，并在其传输用户信息
     * @return
     */
    @Bean
    public MessageConverter messageConverter(){
        Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter() {
            @Override
            public Object fromMessage(Message message) throws MessageConversionException {
                Long userId = message.getMessageProperties().getHeader("user-info");
                if (ObjectUtil.isNotEmpty(userId)){
                    UserContext.setUser(userId);
                }
                return super.fromMessage(message);
            }
        };
        jackson2JsonMessageConverter.setCreateMessageIds(true);
        return jackson2JsonMessageConverter;
    }
}
