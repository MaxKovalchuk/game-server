package com.andersen.gameserver.service;

import com.andersen.gameserver.dto.GameInfoDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class EndGameServiceTest {

    @Spy
    @InjectMocks
    EndGameService spy;

    @Mock
    ChatGptService chatGptService;

    @Test
    void gameInfoDto() {
        GameInfoDto actual = spy.gameInfoDto();

        assertNotNull(actual);
        assertNotNull(actual.blueTeam());
        assertEquals(5, actual.blueTeam().size());
        assertNotNull(actual.redTeam());
        assertEquals(5, actual.redTeam().size());
        assertTrue(actual.blueTeamWon() != actual.redTeamWon());
    }
}