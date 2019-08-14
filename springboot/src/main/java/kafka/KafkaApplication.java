package kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;
import java.util.UUID;

//@SpringBootApplication
public class KafkaApplication {

        /*SpringApplication.run(Application.class, args);*/

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(KafkaApplication.class, args);

        KafkaSender sender = context.getBean(KafkaSender.class);
        KafkaManager kafkaManager = context.getBean(KafkaManager.class);
        kafkaManager.startListener(KafkaGroup.GROUP_CONSUMER_2_LISTENER);
        for (int i = 0; i < 3; i++) {
            //调用消息发送类中的消息发送方法
            Message message = new Message();
            message.setId(System.currentTimeMillis());
            message.setMsg(UUID.randomUUID().toString());
            message.setSendTime(new Date());
            sender.send(message);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
