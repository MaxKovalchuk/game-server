package com.andersen.gameserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatGptService {

    private final ChatClient.Builder chatClientBuilder;

    public String randomUsername() {
        ChatClient chatClient = chatClientBuilder.build();
        ChatResponse chatResponse = chatClient.prompt()
                .user("Give me a random username for a shooter game")
                .call()
                .chatResponse();

        return chatResponse.getResult().getOutput().getContent();

    }

}
