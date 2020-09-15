package toy2.test;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import toy2.config.ApplicationConfig;
import toy2.service.QuizService;


public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); 
		//QuizService quizService = ac.getBean(QuizService.class);
		Set<Integer> set =new HashSet<>();
		int size=1;
		set.add(size);
		set.add(1);
		System.out.println("ok");
		//System.out.println(quizService.getQuizzes());
		
		System.out.println("local test");
		while(set.size()<=5) {
			size=size+1;
			set.add(size);
			System.out.println(set.size());
		}
			
		
		
	}

}
