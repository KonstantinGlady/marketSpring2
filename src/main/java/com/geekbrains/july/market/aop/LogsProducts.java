package com.geekbrains.july.market.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Aspect
@Component
public class LogsProducts {

    @After("execution(* com.geekbrains.july.market.controllers.ProductsController.saveNewProduct(..))")
    public void saveNewProduct(JoinPoint joinPoint) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true));
        writer.newLine();
        writer.append("after saveNewProduct: ");
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            for (Object o : args) {
                writer.append(String.valueOf(o));
            }
        }
        writer.close();
    }

    @After("execution(* com.geekbrains.july.market.controllers.ProductsController.modifyProduct(..))")
    public void modifyProduct(JoinPoint joinPoint) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true));
        writer.newLine();
        writer.append("after modifyProduct: ");
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            for (Object o : args) {
                writer.append(String.valueOf(o));
            }
        }
        writer.close();
    }
}
