package toy2.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import toy2.service.UserService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserService userService;
	
	Logger log= LoggerFactory.getLogger(LoginController.class);

	
	@PostMapping
	public Map<String, String> login(@RequestBody Map<String, String> json, HttpServletResponse response) {
		
		String nickname = json.get("nickname");
		String password = json.get("password");
		Map<String, String> map = userService.checkUserPassword(nickname, password);
		if (map.containsKey("nickname")) {
			response.addHeader("X-AUTH-TOKEN", map.get("token"));
			map.remove("token");
		}
		
		return map;

	}
	
//	
//	@PostMapping("/users") //nickname 중복검사
//	public Map<String,String> checkNickName(@RequestBody Map<String, String> json){
//		String nickname = json.get("nickname");
//		Map<String, String> map = userService.checkNickName(nickname);
//	
//		return map;
//	}
//	
//	@PostMapping("/users/signup") //회원가입
//	public Map<String,String> signUp(@RequestBody Map<String, String> json){
//		String nickname = json.get("nickname");
//		String password = json.get("password");
//		Map<String, String> map = userService.signUp(nickname, password);
//	
//		return map;
//	}
}