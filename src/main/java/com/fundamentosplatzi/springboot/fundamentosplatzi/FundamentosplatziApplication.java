package com.fundamentosplatzi.springboot.fundamentosplatzi;

import com.fundamentosplatzi.springboot.fundamentosplatzi.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosplatziApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
//	inject a dependency from one of the n implementation
	public FundamentosplatziApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency){
		this.componentDependency=componentDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosplatziApplication.class, args);
	}

//	implements the command line application
	@Override
	public void run(String... args) throws Exception {
		this.componentDependency.saludar();
	}
}
