package com.forestory.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForestoryDTO {
	private long forestoryNo;
	
	@NotBlank(message = "글 제목을 입력 해주세요.")
	private String forestoryTitle;
	
	@NotBlank(message = "글 내용을 입력 해주세요.")
	private String forestoryContent;
	
	private LocalDateTime forestoryRegdate, forestoryUpdate;
	
	private int forestoryReadcnt, forestoryLikecnt, forestoryReplycnt;
	
	
	
}
