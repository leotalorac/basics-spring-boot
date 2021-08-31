package com.fundamentosplatzi.springboot.fundamentosplatzi.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation){
        this.myOperation=myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Inside method printWithDependency");
        int number =1;
        LOGGER.debug("Sum 1 to number " + number);
        System.out.println(myOperation.sum(number));
        System.out.println("Hello from a bean with dependency implementation");
    }
}
