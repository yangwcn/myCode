package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class KafkaManager {
    @Autowired
    private KafkaListenerEndpointRegistry registry;

    @Autowired
    private ConsumerFactory consumerFactory;

    @Autowired
    private KafkaSender kafkaSender;

    @Bean("myContainerFactory")
    public ConcurrentKafkaListenerContainerFactory myContainerFactory() {
        ConcurrentKafkaListenerContainerFactory container =
                new ConcurrentKafkaListenerContainerFactory();
        container.setConsumerFactory(consumerFactory);
        //禁止自动启动
        container.setAutoStartup(false);
        return container;
    }

    public void startListener(String listenerId) {
        if (!registry.getListenerContainer(listenerId).isRunning()) {
            registry.getListenerContainer(listenerId).start();
        }
        registry.getListenerContainer(listenerId).resume();
    }

    public void stopListener(String listenerId) {
        registry.getListenerContainer(listenerId).stop();
    }

    public void writeMessage() {
        for(int i = 0; i < 10; i++) {
            Message message = new Message();
            message.setId(System.currentTimeMillis());
            message.setMsg(UUID.randomUUID().toString());
            message.setSendTime(new Date());
            kafkaSender.send(message);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(i == 3) {
                this.startListener(KafkaGroup.GROUP_CONSUMER_2_LISTENER);
                this.startListener(KafkaGroup.GROUP_CONSUMER_3_LISTENER);
            }
            if(i == 7) {
                this.stopListener(KafkaGroup.GROUP_CONSUMER_3_LISTENER);
            }
        }
    }
}
