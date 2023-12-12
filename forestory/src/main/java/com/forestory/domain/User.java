package com.forestory.domain;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@DynamicInsert
@Entity
@NoArgsConstructor
@Getter
@ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long usrNo;
	
	@Column
	private String userEmail, userPw, userNick, userPhone;
	
//	@Column
//	private String name;
	
	@Column
	private Date userLeavedate;
	
	@Column(nullable = false, columnDefinition = "date default current_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userRegdate = new Date();
	
	@ColumnDefault("true")
	@Column(columnDefinition = "TINYINT(1)")
	private Boolean userState;
	
	// 이름 제외
	@Builder
	public User(String userEmail, String userPw, String userNick, String userPhone,
			Date userLeavedate,  Boolean userState) {
		this.userEmail = userEmail;
		this.userPw = userPw;
		this.userNick = userNick;
		this.userPhone = userPhone;
		this.userLeavedate = userLeavedate;
		this.userState = userState;
	}
	
	
	
}
