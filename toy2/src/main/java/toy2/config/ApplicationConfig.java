package toy2.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;



@Configuration
@ComponentScan(basePackages = {"toy2.dao", "toy2.service", "toy2.config.security"})
@Import({DBConfig.class})
public class ApplicationConfig {


}
