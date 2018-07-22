package com.hyecheon.blogstudy.Exceptions;

public class BoardNotFoundException extends RuntimeException {
	public BoardNotFoundException() {
	}

	public BoardNotFoundException(String message) {
		super(message);
	}
}
