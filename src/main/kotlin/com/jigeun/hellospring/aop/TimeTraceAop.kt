package com.jigeun.hellospring.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
@Component
class TimeTraceAop   {

    @Around("execution(* com.jigeun.hellospring..*(..))")
    fun execute(jointPoint : ProceedingJoinPoint) : Any{
        val start = System.currentTimeMillis()
        println("START : $jointPoint")
        try {
            return jointPoint.proceed()
        }
        finally {
            val finish = System.currentTimeMillis()
            val timeMs = finish - start

            println("END : ${jointPoint}, ${timeMs}ms")

        }


    }
}