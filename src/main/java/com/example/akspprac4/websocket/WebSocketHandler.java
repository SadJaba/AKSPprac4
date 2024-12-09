package com.example.akspprac4.websocket;

import com.example.akspprac4.domain.model.Word;
import com.example.akspprac4.domain.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
@RequiredArgsConstructor
public class WebSocketHandler extends TextWebSocketHandler {

    private final WordService wordService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        if ("REFRESH".equalsIgnoreCase(payload)) {
            wordService.refresh();
            session.sendMessage(new TextMessage("All words have been cleared."));
        } else {
            Word word = new Word();
            word.setWord(payload);
            wordService.saveWord(word);
            session.sendMessage(new TextMessage("Word saved: " + payload));
        }
    }
}
