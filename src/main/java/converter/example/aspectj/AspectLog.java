package converter.example.aspectj;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectLog {

    @Pointcut("execution(public String converter.example.Converter.text(String)) && args(text)")
    private void convertCase(String text) {
    }

    @AfterReturning(pointcut = "convertCase(text)", returning = "transformedCase")
    public void afterReturningConvertCase(String text, String transformedCase) {
        System.out.println("Initial line : " + text);
        System.out.println("Converted line: " + transformedCase);
    }

    @AfterThrowing(pointcut = "convertCase(*)", throwing = "exception")
    public void afterThrowingConvertCase(Throwable exception){
        System.out.println("Log exception " + exception);
    }
}


