package com.springboot.chapter6.main

/***omit imports***/

@MapperScan(basePackages="com.springboot.chapter6" annotationClass= Repository.class)
@SpringBootApplication(scanBasePackages="com.springboot.chapter6")
public class Chapter6Application{
	public static void main(String[] args){
		SpringApplication.run(Chapter6Application.class, args);
	}
	
	@Autowired
	PlatformTransactionManager transactionManager = null;
	
	@PostConstruct
	public void viewTransactionManager(){
		// ����ǰ����ϵ�۲�
		System.out.println(transactionManager.getClass().getName());
	}
}