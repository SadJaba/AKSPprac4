package com.example.akspprac4.domain.service;

import com.example.akspprac4.domain.model.Word;

import java.util.List;

public interface WordService {
    public List<Word> getAllWords();
    public void refresh();
    public void saveWord(Word newWord);
}
