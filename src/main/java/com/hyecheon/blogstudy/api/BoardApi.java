package com.hyecheon.blogstudy.api;

import com.hyecheon.blogstudy.domain.Board;
import com.hyecheon.blogstudy.services.BoardService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/boards")
public class BoardApi {

	final private BoardService boardService;

	@Autowired
	public BoardApi(final BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping({""})
	public List<Board> retrieveAllBoards() {
		return boardService.getListAll();
	}

	@GetMapping({"/{id}"})
	public Resource<Board> retrieveBoard(@PathVariable final Long id) {
		final Board user = boardService.findById(id);
		final Resource<Board> resource = new Resource<>(user);
		final ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllBoards());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	@DeleteMapping({"/{id}"})
	public void deleteById(@PathVariable final Long id) {
		boardService.deleteById(id);
	}

	@PutMapping({""})
	public Board updateBoard(@RequestBody final Board board) throws NotFoundException {
		if (board.getId() == null) {
			throw new NotFoundException("not found id ");
		}
		return save(board);
	}

	@PostMapping(path = {""})
	public ResponseEntity<Board> createBoard(@Valid @RequestBody final Board board) {
		final Board savedBoard = save(board);
		final URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedBoard.getId()).toUri();
		return ResponseEntity.created(location).body(savedBoard);
	}

	private Board save(final Board board) {
		return boardService.save(board);
	}
}
