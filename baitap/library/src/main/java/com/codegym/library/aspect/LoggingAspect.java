package com.codegym.library.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @After("execution(* com.codegym.library.service.borrow.BorrowService.save(..))")
    public void logBorrow() {
        logger.info("Một cuốn sách đã được mượn");
    }

    @After("execution(* com.codegym.library.service.borrow.BorrowService.returnBorrow(..))")
    public void logReturn() {
        logger.info("Một cuốn sách đã được trả");
    }
}
