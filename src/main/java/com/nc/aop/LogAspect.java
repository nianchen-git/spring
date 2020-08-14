package com.nc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect//这是一个切面
public class LogAspect {
    /*统一切点*/
    @Pointcut("@annotation(Action)")
    public void pointcut(){}
    /**
     * 可以统一定义切点
     * 第一个 * 表示要拦截的目标方法返回值任意（也可以明确指定返回值类型
     * 第二个 * 表示包中的任意类（也可以明确指定类
     * 第三个 * 表示类中的任意方法
     * 最后面的两个点表示方法参数任意，个数任意，类型任意
     */
    @Pointcut("execution(* com.nc.*.*(..))")
    public void pointcut1(){}
    /**
     * 前置通知
     * @param joinPoint 包含目标方法的关键信息
     */
    @Before(value = "pointcut()")
    public void before(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name + "方法开始执行了");
    }

    /**
     *后置通知
     * @param joinPoint 包含目标方法的关键字
     */
    @After(value = "pointcut()")
    public void after(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name + "方法执行结束了");
    }

    /**
     *返回通知
     */
    @AfterReturning(value = "pointcut()", returning = "o")
    public void returning(JoinPoint joinPoint, Object o){
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name + "方法返回: " + o);
    }
    /**
     *异常通知
     */
    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e){
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name + "方法出现异常了：" +e.getMessage());
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint){
        Object proceed = null;
        try{
            proceed = joinPoint.proceed();
        }catch (Exception e){
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }

}
