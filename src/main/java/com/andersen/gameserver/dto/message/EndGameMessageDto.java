package com.andersen.gameserver.dto.message;

import com.andersen.gameserver.dto.GameInfoDto;

public record EndGameMessageDto(
        GameInfoDto gameInfo,
        String server
){}
