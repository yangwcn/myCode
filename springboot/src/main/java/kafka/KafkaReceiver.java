package kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import webSocket.server.MyWebSocket;

import java.util.Optional;

@Component
@Slf4j
public class KafkaReceiver {
    @KafkaListener(id=KafkaGroup.GROUP_CONSUMER_2_LISTENER,containerFactory = "myContainerFactory",
            topics = {"test"}, groupId = KafkaGroup.GROUP_CONSUMER_2)
    public void listen(ConsumerRecord<?, ?> record) {

        Optional<?> kafkamessage = Optional.ofNullable(record.value());

        if (kafkamessage.isPresent()) {

            Object message = kafkamessage.get();

            log.info("----------------- record =" + record);
            log.info("------------------ message =" + message);
            MyWebSocket.sendMessage(message);
        }
    }

    @KafkaListener(id=KafkaGroup.GROUP_CONSUMER_3_LISTENER,containerFactory = "myContainerFactory",
            topics = {"test"}, groupId = KafkaGroup.GROUP_CONSUMER_3)
    public void listen2(ConsumerRecord<?, ?> record) {

        Optional<?> kafkamessage = Optional.ofNullable(record.value());

        if (kafkamessage.isPresent()) {

            Object message = kafkamessage.get();

            log.info("++++++++++++++++++ record =" + record);
            log.info("++++++++++++++++++ message =" + message);
        }
    }
}
