package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.service.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		//getting repo from bean object
		//UserMasterRepo UserMasterRepo = context.getBean(UserMasterRepo.class);
		
//		
//		//System.out.println("===== "+UserMasterRepo.getClass().getName());
//		
//		//setting data for entity obj
//		UserMasterEntity entity=new UserMasterEntity();
//		entity.setId(102);
//		entity.setName("ajay");
//		entity.setEmail("ajay@17gmail.com");
//		entity.setGender("ma;e");
//		entity.setCity("usa");
//		entity.setAge(30);
//		//insert  record
//		UserMasterRepo.save(entity);
//		System.out.println("inserted data succesfully");
		
		UserService userService = context.getBean(UserService.class);
		userService.saveUser();
		//userService.getUser();
		//userService.getUsers();
		//userService.getUserss();
		//userService.deleteByid();
		//userService.test();
		//userService.testFindByMethods();
		//userService.testCustomQueries();
		
	}
 
}   
 