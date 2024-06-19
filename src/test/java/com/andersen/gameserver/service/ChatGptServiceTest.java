package com.andersen.gameserver.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ChatGptServiceTest {

    @Spy
    @InjectMocks
    ChatGptService spy;

    @Mock
    ChatClient.Builder chatClientBuilder;

    @Test
    void randomUsername() {
        ChatClient chatClient = mock(ChatClient.class);
        ChatClient.ChatClientRequestSpec chatClientRequestSpec =
                mock(ChatClient.ChatClientRequestSpec.class);
        ChatClient.CallResponseSpec callResponseSpec = mock(ChatClient.CallResponseSpec.class);
        ChatResponse chatResponse = mock(ChatResponse.class);
        Generation generation = mock(Generation.class);
        AssistantMessage assistantMessage = mock(AssistantMessage.class);
        doReturn(chatClient)
                .when(chatClientBuilder).build();
        doReturn(chatClientRequestSpec)
                .when(chatClient).prompt();
        doReturn(chatClientRequestSpec)
                .when(chatClientRequestSpec).user(anyString());
        doReturn(callResponseSpec)
                .when(chatClientRequestSpec).call();
        doReturn(chatResponse)
                .when(callResponseSpec).chatResponse();
        doReturn(generation)
                .when(chatResponse).getResult();
        doReturn(assistantMessage)
                .when(generation).getOutput();
        doReturn("BestPlayer1337")
                .when(assistantMessage).getContent();

        String actual = spy.randomUsername();

        verify(chatClientBuilder).build();
        verify(chatClient).prompt();
        verify(chatClientRequestSpec).user(anyString());
        verify(chatClientRequestSpec).call();
        verify(callResponseSpec).chatResponse();
        verify(chatResponse).getResult();
        verify(generation).getOutput();
        verify(assistantMessage).getContent();
        assertNotNull(actual);
        assertEquals("BestPlayer1337", actual);
    }
}