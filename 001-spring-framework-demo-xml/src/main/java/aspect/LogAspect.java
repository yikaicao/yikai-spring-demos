package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Aspect
public class LogAspect {

    @Around("execution(* service.*.*(..))")
    public Object businessService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Method method = ((MethodSignature)proceedingJoinPoint.getSignature()).getMethod();
        System.out.println("execute method: " + method.getName());
        return proceedingJoinPoint.proceed();
    }
}
