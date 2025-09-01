
package com.dio.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dio.board.model.Card;

public interface CardRepository extends JpaRepository<Card, Long> {}
