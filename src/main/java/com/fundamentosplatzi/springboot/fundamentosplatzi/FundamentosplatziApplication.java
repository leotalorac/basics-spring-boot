package com.fundamentosplatzi.springboot.fundamentosplatzi;

import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentosplatzi.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentosplatzi.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentosplatzi.entity.User;
import com.fundamentosplatzi.springboot.fundamentosplatzi.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentosplatzi.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosplatziApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;

	private UserPojo userPojo;

	private UserRepository userRepository;

	Log LOGGER = LogFactory.getLog(FundamentosplatziApplication.class);

//	inject a dependency from one of the n implementation
	public FundamentosplatziApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,MyBean myBean,MyBeanWithDependency myBeanWithDependency,MyBeanWithProperties myBeanWithProperties, UserPojo userPojo,UserRepository userRepository){
		this.componentDependency=componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosplatziApplication.class, args);
	}

//	implements the command line application
	@Override
	public void run(String... args) throws Exception {
		this.examples();
		this.saveUsersInDataBase();
		this.getInformationJpqlFromUser();
	}


	private void getInformationJpqlFromUser(){
		LOGGER.info("User with mail luis@gmail.com findByUserEmail" +
				userRepository.findByUserEmail("luis@gmail.com")
						.orElseThrow(()->new RuntimeException("User not found")));

		userRepository.findAndSort("L",
						Sort.by("id").descending())
				.forEach(user -> LOGGER.info("User with sort method " + user));
	}
	private void saveUsersInDataBase(){
		User user1 = new User("Luis","luis@gmail.com", LocalDate.of(2021, 3,20));
		User user2 = new User("Juanito","juanitos@gmail.com", LocalDate.of(2020,12,20));
		User user3 = new User("Daniela","daniela@gmail.com", LocalDate.of(2020,12,10));
		User user4 = new User("Luisa","luisa@gmail.com", LocalDate.of(2020,12,10));
		List<User> users = Arrays.asList(user1,user2,user3,user4);
		userRepository.saveAll(users);
		System.out.println();
	}

	public void examples(){
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
