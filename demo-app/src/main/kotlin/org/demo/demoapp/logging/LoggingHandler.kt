package org.demo.demoapp.logging

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class LoggingHandler {

    val log = LoggerFactory.getLogger(javaClass)

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    fun controller() {
    }

    @Pointcut("execution(public * *(..))")
    fun publicMethod() {
    }

    @Before("controller() && publicMethod()")
    fun logOperation(joinPoint: JoinPoint) {
        log.info("Calling {}", joinPoint.signature.name)
    }
}