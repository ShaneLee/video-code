package ee.shanel.emaildemo.publisher;

import ee.shanel.emaildemo.config.EmailProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailMessagePublisher implements MessagePublisher
{
    private final EmailProperties emailProperties;

    private final JavaMailSender javaMailSender;

    @Override
    public void publish(final String message)
    {
        final var mail = new SimpleMailMessage();

        mail.setFrom(emailProperties.getSender());
        mail.setSubject("Hello from Spring Boot!");
        mail.setText(message);
        mail.setTo("povicot268@ehstock.com");

        javaMailSender.send(mail);
    }
}
