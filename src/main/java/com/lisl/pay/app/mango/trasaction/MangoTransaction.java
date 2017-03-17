package com.lisl.pay.app.mango.trasaction;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.jfaster.mango.transaction.Transaction;
import org.jfaster.mango.transaction.TransactionFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/3/17.
 */
@Aspect
@Component
public class MangoTransaction {
    //@Pointcut("execution(* com.lisl.pay.app.mango.service.*.*(..))")
    @Pointcut("@annotation(com.lisl.pay.app.mango.trasaction.Transaction)")
    public void mangoTran() {
    }

    @Around("mangoTran()")
    public Object tranAround(ProceedingJoinPoint joinPoint) throws Exception{
        System.out.println("开始--------------------------------------------");
        Object object = null;
        Transaction transaction = TransactionFactory.newTransaction();
        try {
            object= joinPoint.proceed(joinPoint.getArgs());
        } catch (Exception e) {
            transaction.rollback();
        } catch (Throwable throwable) {
            transaction.rollback();
            throwable.printStackTrace();
        }
        transaction.commit();
        System.out.println("结束--------------------------------------------");
        return object;
    }
}
