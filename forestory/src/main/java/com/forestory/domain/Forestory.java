package com.forestory.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.forestory.dto.ForestoryDTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/* JPA를 사용해서 테이블과 매핑할 클래스 - 이 어노테이션이 명시된 클래스는 JPA가 관리하는 것으로 엔티티라 부른다.*/
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SequenceGenerator(name="forestory_generator", sequenceName = "forestory_seq", initialValue = 1, allocationSize = 1)
@Getter
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
@Builder(builderMethodName = "ForestoryBuilder")
public class Forestory {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "forestory_generator")
   private long forestoryNo; 		// 글 번호
   
   @Column(nullable = false, length = 800) 				// varchar(255)가 기본 800으로 늘려줌
   private String forestoryTitle;	// 글 제목
   
   @Column(nullable = false, columnDefinition = "TEXT") // varchar(255)가 기본 type을 TEXT로 바꿔줌
   private String forestoryContent; // 글 내용
   
   @CreatedDate
   private LocalDateTime forestoryRegdate; // 등록일
  
   @LastModifiedDate
   private LocalDateTime forestoryUptdate; // 수정일
   
   @Column(nullable = false)
   @ColumnDefault("0")
   private int forestoryReadcnt; 	// 조회수
   
   @Column(nullable = false)
   @ColumnDefault("0")
   private int forestroyLikecnt; 	// 좋아요 갯수
   
   @Column(nullable = false)
   @ColumnDefault("0")
   private int forestoryReplycnt;	// 댓글 갯수

   public static ForestoryBuilder builder(ForestoryDTO forestoryDTO) {
	   return ForestoryBuilder()
			   .forestoryTitle(forestoryDTO.getForestoryTitle())
			   .forestoryContent(forestoryDTO.getForestoryContent());
   }
   
   //일대다 관계 추가(사용자는  여러개의 forestory를 포스팅을 할 수 있다.(가진다.))
   // fetch : 대다(toMany) 관계에는 FetchType.LAZY가 기본값이므로 정의할 필요가 없지만 대일(toOne) 관계에는 정의해야 함
//   @ManyToOne
//   @JoinColumn(name = "user_no") // user 테이블의 기본 키인 user_no를 참조
//   private User userNo;
   
}