package com.lisl.pay.app.mango.trasaction;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.TransactionManager;

/**
 * Created by Administrator on 2017/3/17.
 */
@Aspect
@Component///不好使
public class MangoTransaction {
    @Autowired
    private TransactionManager transactionManager;
    //@Pointcut("execution(* com.lisl.pay.app.mango.service.*.*(..))")
    @Pointcut("@annotation(com.lisl.pay.app.mango.trasaction.Transaction)")
    public void mangoTran() {
    }

    @Around("mangoTran()")
    public Object tranAround(ProceedingJoinPoint joinPoint) throws Exception,Throwable{
        System.out.println("开始--------------------------------------------");
        Object object = null;
        transactionManager.begin();

        object= joinPoint.proceed(joinPoint.getArgs());

        transactionManager.rollback();

        System.out.println("结束--------------------------------------------");
        return object;
    }
}
