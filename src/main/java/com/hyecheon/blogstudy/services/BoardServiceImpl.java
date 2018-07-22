package com.hyecheon.blogstudy.services;

import com.hyecheon.blogstudy.Exceptions.BoardNotFoundException;
import com.hyecheon.blogstudy.domain.Board;
import com.hyecheon.blogstudy.repositories.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {
	private final BoardRepository boardRepository;

	public BoardServiceImpl(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	@Override
	public List<Board> getListAll() {
		return boardRepository.findAll();
	}

	@Override
	public Board findById(Long id) {
		final Optional<Board> optionalBoard = boardRepository.findById(id);
		return optionalBoard.orElseThrow(() -> new BoardNotFoundException("id : " + id + " 이 존재 하지 않습니다."));
	}

	@Override
	public void deleteById(Long id) {
		boardRepository.deleteById(id);
	}

	@Override
	public Board save(Board board) {
		return boardRepository.save(board);
	}
}
