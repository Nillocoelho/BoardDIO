
package com.dio.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dio.board.model.Board;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<Board> findByNameIgnoreCase(String name);
}
