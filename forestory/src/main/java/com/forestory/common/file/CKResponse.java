package com.forestory.common.file;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CKResponse {
	
	// 업로드한 이미지 개수
	private Integer uploaded;
	
	// 파일명
	private String fileName;
	
	// 이미지 저장 경로
	private String url;
}
