package ee.shanel.emaildemo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import ee.shanel.emaildemo.publisher.MessagePublisher;

@Configuration
@RequiredArgsConstructor
public class EmailInitializingBean implements InitializingBean
{
    private final MessagePublisher messagePublisher;

    @Override
    public void afterPropertiesSet()
    {
        System.out.println("Sending email");
        messagePublisher.publish("Hello, I'm a Nigerian prince");
    }
}
