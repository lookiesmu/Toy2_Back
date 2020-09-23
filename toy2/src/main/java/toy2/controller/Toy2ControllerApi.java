package toy2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import toy2.dao.UserDao;
import toy2.dto.QuizDto;
import toy2.dto.ScoreDto;
import toy2.dto.UserQuizDto;
import toy2.service.QuizService;
import toy2.service.UserService;
import toy2.service.security.CustomUserDetails;


@RestController
@RequestMapping(path="/quizzes")
public class Toy2ControllerApi {
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDao userDao;
	
	//퀴즈조회
	@GetMapping
	public Map<String,Object> getQuizzes(){
		List<QuizDto> quizList= quizService.getQuizzes();
		


		Map<String, Object> map = new HashMap<>();
		map.put("quizList", quizList);
		
		
		return map;
		
	}
	
	//유저의 퀴즈 조회
	@GetMapping(path="/{nickname}")
	public Map<String,Object> getUserQuiz(@PathVariable (name = "nickname") String nickname){
		
				
		List<QuizDto> quizList= quizService.getUserQuizzes(nickname);
		
		Map<String, Object> map = new HashMap<>();
		map.put("quizList", quizList);
		
		return map;
		
	}
	
	//유저가 만든 퀴즈 등록
	@PostMapping
	public void insertUserQuiz(@RequestBody Map<String, Object> requestParam, @AuthenticationPrincipal CustomUserDetails user) {
		
		int num;
		
		UserQuizDto userQuiz=new UserQuizDto();
		userQuiz.setQuizID((int) requestParam.get("quizId"));
		userQuiz.setUserID(user.getUserId());
		userQuiz.setAnswer((int) requestParam.get("answer"));

		num=quizService.insertUserQuiz(userQuiz);
		
		if(num==0) {
			System.out.println("User Quiz insert fail");
		}
		else {
			System.out.println("User Quiz insert success");
		}
				
	}
	
	
	//Score 등록
	@PostMapping(path="/{nickname}")
	public Map<String, Object> insertScore(@RequestBody Map<String, Object> requestParam, 
			@PathVariable (name = "nickname") String nickname,
			@AuthenticationPrincipal CustomUserDetails user) {
//		{"answerer": "answerer_nickname",
//			"score":"40"}
		int flag;
		Map<String, Object> map = new HashMap<>();
		
		String examiner=nickname;
		String answerer=(String) requestParam.get("answerer");
		String score=(String) requestParam.get("score");
		
		ScoreDto scoreDto=new ScoreDto();
		Long answererId=userDao.findByNickName(answerer).getUserId();
		if (quizService.checkExistAnswerer(answererId)) { //중복없으면
			scoreDto.setAnswerer(answererId);
			scoreDto.setExaminer(userDao.findByNickName(examiner).getUserId());
			scoreDto.setScore(Integer.parseInt(score));
			
			flag=quizService.insertScore(scoreDto);
			
			
			if(flag==0) {
				System.out.println("User Quiz insert fail");
				map.put("success", null);
				return map;
			}
			else {
				System.out.println("User Quiz insert success");
				map.put("success","true");
				return map;
			}
			
		}else {//중복있으면
			map.put("success","false");
			return map;
		}				
		
		
	}
	

}
