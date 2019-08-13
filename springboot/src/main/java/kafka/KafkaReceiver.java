package kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class KafkaReceiver {
    @KafkaListener(topics = {"test"}, groupId = "consumer-2")
    public void listen(ConsumerRecord<?, ?> record) {

        Optional<?> kafkamessage = Optional.ofNullable(record.value());

        if (kafkamessage.isPresent()) {

            Object message = kafkamessage.get();

            log.info("----------------- record =" + record);
            log.info("------------------ message =" + message);
        }
    }
}
