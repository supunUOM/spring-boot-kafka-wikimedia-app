package com.supun.consumer;

import com.supun.entity.WikimediaData;
import com.supun.services.WikimediaDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaDatabaseConsumer {

    private final WikimediaDataService wikimediaDataService;

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumer(String eventMessage) {
        log.info(String.format("Event message received -> %s", eventMessage));
        var wikimediaData = WikimediaData.builder()
                .wikiEventData(eventMessage)
                .build();
        var savedData = wikimediaDataService.saveWikimediaData(wikimediaData);
        log.info("saved data object -> ", savedData);

    }
}
