package kafka;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@Slf4j
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    //private JSON json;

    public void send(Message message) {
        /*Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());*/
        log.info("+++++++++++++++++++++  message = {}", JSON.toJSON(message).toString());
        kafkaTemplate.send("test", JSON.toJSON(message).toString());
    }

    public static void main(String[] args) {
        KafkaSender k = new KafkaSender();
        k.send(new Message());
    }
}

