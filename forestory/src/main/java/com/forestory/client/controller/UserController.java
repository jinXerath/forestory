package com.forestory.client.controller;


import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.forestory.admin.service.UserService;
import com.forestory.domain.User;
import com.forestory.dto.UserDTO;

import lombok.Setter;


@Controller
@RequestMapping("/client/*")
public class UserController {
	
	@Setter(onMethod_= @Autowired)
	private UserService userService;
	
	//로그인 화면
	@GetMapping("/login/loginForm")
	public String loginForm() {
		return "client/login/loginForm";
	}
	
	//회원가입 화면
	@GetMapping("/signUp/signUpForm")
	public String signUpForm() {
		return "client/signUp/signUpForm";
	}
	
	//회원가입 기능
	@PostMapping("/signUp")
	public String signUp(@Valid @ModelAttribute UserDTO userDto, BindingResult result, Model model, RedirectAttributes ras) {
		
//        if(result.hasErrors()) {
//        	ras.addFlashAttribute("errors", result.getFieldErrors());
//        	return "redirect:/client/signUp/signUpForm";
//        }
		
		// 필드와 오류 메시지를 매핑하는 HashMap 생성
        Map<String, String> validErrors = new HashMap<>();
        if(result.hasErrors()) {
	        for (FieldError error : result.getFieldErrors()) {
	            // 필드명과 오류 메시지를 HashMap에 추가
	        	validErrors.put(error.getField(), error.getDefaultMessage());
	        }
	    	
	    	ras.addFlashAttribute("validErrors", validErrors);
	        ras.addFlashAttribute("userDto",userDto);
    	
	        return "redirect:/client/signUp/signUpForm";
        }
        	
		
		// 빌더패턴으로 회원정보 입력
		User user = User.builder()
						.userEmail(userDto.getUserEmail())
						.userPw(userDto.getUserPw())
						.userNick(userDto.getUserNick())
						.userPhone(userDto.getUserPhone())
						.build();
		
		// 중복일 경우 true
		boolean emailValid = userService.existsByUserEmail(user.getUserEmail());
		boolean nickValid = userService.existsByUserNick(user.getUserNick());
		
		if(emailValid || nickValid) {
			if(emailValid) { // 이메일 중복
	        	validErrors.put("userEmail", "이미 사용중인 이메일입니다.");
			}
			if(nickValid) {  // 닉네임 중복
				validErrors.put("userNick", "이미 사용중인 닉네임입니다.");
			}
			ras.addFlashAttribute("validErrors", validErrors);
			return "redirect:/client/signUp/signUpForm";
		}
		
		userService.signUp(user);
		return "redirect:/client/login/loginForm";
	}
	
	// 회원가입 이메일 중복 검사
	@ResponseBody
	@PostMapping(value="/userEmailVaild", produces = "application/json; charset=UTF-8")
	public String userEmailVaild(@RequestBody UserDTO userDto) {
		
		User user = User.builder().userEmail(userDto.getUserEmail()).build();
		
		// email 이 존재할 경우 true 반환
		boolean chkEmail = userService.existsByUserEmail(user.getUserEmail());
		
		String result;
		if(chkEmail) {
			result = "0";
		} else {
			result = "1";
		}
		return result;
	}
	
	// 회원가입 닉네임 중복 검사
	@ResponseBody
	@PostMapping(value="/userNickVaild", produces = "application/json; charset=UTF-8")
	public String userNickVaild(@RequestBody UserDTO userDto) {
		
		User user = User.builder().userEmail(userDto.getUserNick()).build();
		// nick 이 존재할 경우 true 반환
		boolean chkNick = userService.existsByUserNick(user.getUserNick());
		String result;
		if(chkNick) {
			result = "0";
		} else {
			result = "1";
		}
		return result;
	}
}