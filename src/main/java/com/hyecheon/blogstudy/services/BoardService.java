package com.hyecheon.blogstudy.services;

import com.hyecheon.blogstudy.domain.Board;

import java.util.List;

public interface BoardService {
	List<Board> getListAll();

	Board findById(Long id);

	void deleteById(Long id);

	Board save(Board board);
}
