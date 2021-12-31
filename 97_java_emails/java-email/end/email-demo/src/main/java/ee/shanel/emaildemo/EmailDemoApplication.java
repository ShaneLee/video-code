package ee.shanel.emaildemo;

import ee.shanel.emaildemo.config.EmailProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(EmailProperties.class)
@SpringBootApplication
public class EmailDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailDemoApplication.class, args);
	}

}
