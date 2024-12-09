package com.example.akspprac4.domain.repository;

import com.example.akspprac4.domain.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long> {
}
