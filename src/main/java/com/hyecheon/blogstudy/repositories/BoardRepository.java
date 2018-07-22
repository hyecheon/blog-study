package com.hyecheon.blogstudy.repositories;

import com.hyecheon.blogstudy.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

}