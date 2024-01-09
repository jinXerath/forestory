package com.forestory.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.forestory.domain.Forestory;
import com.forestory.dto.ForestoryDTO;

import lombok.Setter;

@SpringBootTest
public class ForestoryRepositoryTests {
	
	@Setter(onMethod_ = @Autowired)
	private ForestoryRepository forestoryRepository;
	
	@Test
	public void forestorySave() {
		ForestoryDTO forestoryDTO = new ForestoryDTO();
		forestoryDTO.set
		
	}
	
//	@Test
//	public void UserSaveTest() {
//		User user1 = new User();
//		log.info("user 객체 생성");
//		user1.setUserEmail("user1@naver.com");
//		user1.setUserPw("user1");
//		user1.setUserPhone(01011111111);
//		user1.setUserName("지난");
//		user1.setUserNick("지난");
//		user1.setUserleavedate("내일");
//		user1.setUserStatus(1);
//		userRepository.save(user1);
//		log.info("user1 객체 생성 완료");
//	}

}
