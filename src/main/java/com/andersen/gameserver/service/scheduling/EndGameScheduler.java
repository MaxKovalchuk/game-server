package com.andersen.gameserver.service.scheduling;

import com.andersen.gameserver.dto.GameInfoDto;
import com.andersen.gameserver.dto.message.EndGameMessageDto;
import com.andersen.gameserver.service.EndGameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EndGameScheduler {

    @Value("${server.name}")
    private String serverName;
    @Value("${kafka.producer.end-game-topic}")
    private String endGameTopic;

    private final KafkaTemplate<String, EndGameMessageDto> kafkaTemplate;
    private final EndGameService endGameService;

    @Scheduled(cron = "${scheduler.cron.end-game}")
    public void execute() {
        log.info("Sending new message to end-game kafka topic ...");

        GameInfoDto gameInfoDto = endGameService.gameInfoDto();
        kafkaTemplate.send(endGameTopic, new EndGameMessageDto(gameInfoDto, serverName));
    }

}
