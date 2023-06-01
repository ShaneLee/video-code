package ee.shanel.emaildemo.config;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "email")
@ConstructorBinding
@Getter
@Builder(toBuilder = true)
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class EmailProperties
{
    private final String sender;
}
