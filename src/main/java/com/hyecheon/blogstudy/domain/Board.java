package com.hyecheon.blogstudy.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Data
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String title;

	@Lob
	@Column(name = "content", columnDefinition = "CLOB")
	private String content;
	private Long hit;
	@NotNull
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{4,11}$", message = "5~12자 영문과 숫자 _  가 가능합니다.")
	private String auth;

	@CreationTimestamp
	private Date createdAt;

	@UpdateTimestamp
	private Date updatedAt;
}