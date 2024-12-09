package com.example.akspprac4.domain.service.impl;

import com.example.akspprac4.domain.model.Word;
import com.example.akspprac4.domain.repository.WordRepository;
import com.example.akspprac4.domain.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;

    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }
    public void refresh(){
        wordRepository.deleteAll();
    }

    public void saveWord(Word newWord) {
        wordRepository.save(newWord);
    }
}
