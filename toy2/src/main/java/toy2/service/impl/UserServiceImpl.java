package toy2.service.impl;

import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import toy2.config.security.JwtTokenProvider;
import toy2.dao.UserDao;
import toy2.service.UserService;
import toy2.service.security.CustomUserDetails;



@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userdao;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	
	@Override
	public Map<String, String> checkUserPassword(String nickname, String password) {
		CustomUserDetails user = userdao.findByNickName(nickname);
		Map<String, String> map = new HashMap<String, String>();
		
		if(user==null || !passwordEncoder.matches(password, user.getPassword())) {
			map.put("success", null);
			
		}else {
			map.put("token", jwtTokenProvider.createToken(Long.toString(user.getUserId())));
			map.put("nickname", user.getUsername());
		}
		
		return map;
		
	}
	
	@Override
	public Map<String,String> checkNickName(String nickname){
		CustomUserDetails user = userdao.findByNickName(nickname);
		Map<String, String> map = new HashMap<String, String>();
		
		if(user==null) {
			map.put("success", "true");
		}else {
			map.put("success", "false");
		}
		
		return map;
		
	}
	
	@Override
	public Map<String,String> signUp(String nickname,String password){
		
		Map<String, String> map = new HashMap<String, String>();
		//CustomUserDetails newUser = CustomUserDetails.builder();
		CustomUserDetails newUser = new CustomUserDetails();
		newUser.setNickname(nickname);
		newUser.setPassword(passwordEncoder.encode(password));
		if(userdao.insertUser(newUser)!=0) { //db에 새 유저정보 넣기 성공시
			map.put("signup", "true");
		}
		else {
			map.put("signup", "false");
		}
		
		return map;
	}
	

	
	
}
