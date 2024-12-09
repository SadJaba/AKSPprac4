package com.example.akspprac4.websocket;

import com.example.akspprac4.domain.model.Word;
import com.example.akspprac4.domain.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebSocketPageController {

    private final WordService wordService;

    @GetMapping("/")
    public String index(Model model) {
        List<Word> words = wordService.getAllWords();
        model.addAttribute("words", words);
        return "index";
    }
}
