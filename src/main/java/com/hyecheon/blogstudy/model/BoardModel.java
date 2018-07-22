package com.hyecheon.blogstudy.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class BoardModel {
	private Long id;
	@NotNull
	private String title;
	private String content;
	private Long hit;
	@NotNull
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{4,11}$", message = "5~12자 영문과 숫자 _  가 가능합니다.")
	private String auth;
	private Date createdAt;
	private Date updatedAt;
}
