package com.fundamentosplatzi.springboot.fundamentosplatzi;

import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentosplatzi.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentosplatzi.pojo.UserPojo;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosplatziApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;

	private UserPojo userPojo;

	Log LOGGER = LogFactory.getLog(FundamentosplatziApplication.class);

//	inject a dependency from one of the n implementation
	public FundamentosplatziApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,MyBean myBean,MyBeanWithDependency myBeanWithDependency,MyBeanWithProperties myBeanWithProperties, UserPojo userPojo){
		this.componentDependency=componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosplatziApplication.class, args);
	}

//	implements the command line application
	@Override
	public void run(String... args) throws Exception {
		this.componentDependency.saludar();
		this.myBean.print();
		this.myBeanWithDependency.printWithDependency();
		System.out.println(this.myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() +" "+ userPojo.getPassword() + " "+ userPojo.getAge());
		try{
			//Error
			int value = 10/0;
			LOGGER.debug("It works!!" + value);
		}catch (Exception e){
			LOGGER.error("this is an application Error of zero division " + e.getMessage());
		}


	}
}
