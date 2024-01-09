package com.forestory.dto;


import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.forestory.domain.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {

	private long boardNo;
	
	private String boardCategory;
	
	@NotBlank(message = "* 제목은 필수 입력 값입니다.")
	private String boardTitle;
	
	@NotBlank(message = "* 내용은 필수 입력 값입니다.")
	private String boardContent;
	
	private int boardReadcnt;
	
	private Date boardRegdate;
	
	public static BoardDTO toDto(Board board) {
        return BoardDTO.builder()
        			.boardNo(board.getBoardNo())
                    .boardCategory(board.getBoardCategory())
                    .boardTitle(board.getBoardTitle())
                    .boardContent(board.getBoardContent())
                    .boardReadcnt(board.getBoardReadcnt())
        			.boardRegdate(board.getBoardRegdate())
        			.build();
    }
}
