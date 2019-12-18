package com.fmall.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLogAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(ServiceLogAspect.class);
    /**
     * AOP通知
     *  1. 前置通知：在方法调用前执行
     *  2. 后置通知：在方法正常调用后执行
     *  3. 环绕通知：在方法调用之前之后都分别可以执行的通知
     *  4. 异常通知：在方法调用过程中发生异常调用
     *  5. 最终通知：在方法调用之后执行
     *
     * 切面表达式
     *  execution 切面表达式执行主体
     *  第一处 * 代表方法返回类型 代表所有类型
     *  第二处 包名代表AOP监控类所在包
     *  第三处 ..代表该包以及子包下边所有类方法
     *  第四处 * 代表类型 * 代表所有类
     *  第五处：*(..) *代表类中的方法名 (..) 表示方法中任何参数
     */
    @Around("execution(* com.fmall.service.impl..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("===> 开始执行 {} - {}", joinPoint.getTarget().getClass(), joinPoint.getSignature().getName());

        // 开始时间
        long startTime = System.currentTimeMillis();

        // 执行目标
        Object result = joinPoint.proceed();

        // 结束时间
        long endTime = System.currentTimeMillis();

        // 执行耗时
        long durationTime = endTime - startTime;

        if (durationTime > 3000) {
            LOGGER.error("===> 执行耗时: {}", durationTime);
        } else {
            LOGGER.info("===> 执行耗时: {}", durationTime);
        }
        return result;
    }


}
