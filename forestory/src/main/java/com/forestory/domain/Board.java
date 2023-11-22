package com.forestory.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import lombok.Data;

@DynamicInsert
@Entity
@SequenceGenerator(name="board_generator", sequenceName = "board_seq", initialValue = 1, allocationSize = 1)
@Data
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_generator")
	private long boardNo;	// 자유게시판 글번호
	
	@Column(nullable = false)
	private String boardCategory, boardTitle;	// 분류, 제목
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String boardContent;	// 내용
	
	@ColumnDefault("0")
	private Integer boardReadcnt;	// 조회수
	
	@Column(nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
	@Temporal(TemporalType.DATE)
	private Date boardRegdate = new Date();		// 등록일
	
	
	
}
