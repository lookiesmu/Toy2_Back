package toy2.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	 @Override
	    protected Class<?>[] getRootConfigClasses() {
	        return new Class<?>[]{toy2.config.ApplicationConfig.class,
	        	toy2.config.security.SecurityConfig.class};
	    }

	    // Spring MVC 설정 파일 클래스를 지정한다.
	    @Override
	    protected Class<?>[] getServletConfigClasses() {
	        return new Class<?>[]{toy2.config.WebMvcContextConfiguration.class	        	};
	    }

	    // getServletMapping()은 DispatcherServlet이 매핑되기 위한 하나 혹은 여러 개의 path를 지정한다.
	    // 위의 코드에서는 애플리케이션 기본 서블릿인 /에만 매핑이 되어 있다. 그리고 이것은 애플리케이셔으로 들어오는 모든 요청을 처리한다.
	    // 원래 서블릿에서는 /을 처리하는 DefaultServlet이 설정되어 있다.
	    // "/"를 설정한다는 것은 모든 요청을 DispatcherServlet이 처리한다는 것을 의미한다.
	    @Override
	    protected String[] getServletMappings() {
	        return new String[]{"/"};
	    }

	    // 필터를 설정한다.
	    @Override
	    protected Filter[] getServletFilters() {
	        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
	        encodingFilter.setEncoding("UTF-8");

	        return new Filter[]{encodingFilter};
	    }
}
