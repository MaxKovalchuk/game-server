package com.andersen.gameserver.service;

import com.andersen.gameserver.dto.GameInfoDto;
import com.andersen.gameserver.dto.PlayerInfoDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EndGameService {

    private final ChatGptService chatGptService;

    public GameInfoDto gameInfoDto() {
    /*
        Here could be a chatGpt integration. But turns out it costs money.
        Andersen, please give me more money, so I could afford chat gpt integration.
    */
    //  String username = chatGptService.randomUsername();

        Random random = new Random();
        boolean redTeamWon = random.nextBoolean();
        return new GameInfoDto(
                random.nextLong(600000),
                redTeamWon,
                !redTeamWon,
                generateTeam(random),
                generateTeam(random)
        );
    }

    private List<PlayerInfoDto> generateTeam(Random random) {
        List<PlayerInfoDto> team = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String username = "user" + random.nextInt(20);

            PlayerInfoDto player = new PlayerInfoDto(
                    username,
                    random.nextInt(30),
                    random.nextInt(30),
                    random.nextInt(30)
            );

            team.add(player);
        }

        return team;
    }

}
