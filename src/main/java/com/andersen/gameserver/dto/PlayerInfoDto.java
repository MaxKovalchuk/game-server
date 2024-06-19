package com.andersen.gameserver.dto;


public record PlayerInfoDto(
        String name,
        int kills,
        int deaths,
        int assists
)
{}
