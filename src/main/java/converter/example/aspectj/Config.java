package converter.example.aspectj;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan ("converter.example")
@EnableAspectJAutoProxy
public class Config {
}
