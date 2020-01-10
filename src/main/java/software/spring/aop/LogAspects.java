package software.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

//日志切面类
@Aspect
public class LogAspects {
	@Pointcut("execution(public int software.spring.aop.Calculator.*(..))")
	public void pointCut(){}
	
	//@before代表在目标方法执行前切入, 并指定在哪个方法前切入
	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint){
		System.out.println(joinPoint.getSignature().getName()+"除法运行....参数列表是:{"+Arrays.asList(joinPoint.getArgs())+"}");
	}

	@After("pointCut()")
	public void logEnd(JoinPoint joinPoint){
		System.out.println(joinPoint.getSignature().getName()+"除法结束......");
		
	}

	@AfterReturning(value="pointCut()",returning="result")
	public void logReturn(Object result){
		System.out.println("除法正常返回......运行结果是:{"+result+"}");
	}

	@AfterThrowing(value="pointCut()",throwing="exception")
	public void logException(Exception exception){
		System.out.println("运行异常......异常信息是:{"+exception+"}");
	}
	
	@Around("pointCut()")
	public Object Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("@Around:执行目标方法之前...");
		Object obj = proceedingJoinPoint.proceed();//相当于开始调div地
		System.out.println("@Around:执行目标方法之后...");
		return obj;
	}
}
