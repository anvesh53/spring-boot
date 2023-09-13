package in.ashokit.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.UserMasterEntity;
import in.ashokit.repository.UserMasterRepo;

@Service
public class UserService 
{
	@Autowired
	private UserMasterRepo userMasterRepo;
	
	public void saveUser()
	{
	
	//SAVE ALL//insert multiple records
	
			UserMasterEntity entity1=new UserMasterEntity();
			entity1.setId(102);
			entity1.setName("ajay");
			entity1.setEmail("ARUN@17gmail.com");
			entity1.setGender("ma;e");
			entity1.setCity("HYD");
			entity1.setAge(3);
			
			UserMasterEntity entity2=new UserMasterEntity();
			entity2.setId(104);
			entity2.setEmail("thAUN@17gmail.com");
			entity2.setName("tharuni");
			entity2.setGender("female");
			entity2.setCity("nkd");
			entity2.setAge(13);
			List<UserMasterEntity> enti = Arrays.asList(entity1,entity2);
			userMasterRepo.saveAll(enti);
}
	//select * from user_master where user_id  (101)
	public void getUser()//findById
	{
		Optional<UserMasterEntity> byId = userMasterRepo.findById(201);
		if(byId.isPresent())
		{
			System.out.println(byId.get()+"id is present");
		}
		else
		{
			System.out.println("not present");
		}
	}
	//select * from user_master where user_id in (101,102);
	public void getUsers()//findAllById()
	{
		List<Integer> list = Arrays.asList(101,102);
		Iterable<UserMasterEntity> findAllById = userMasterRepo.findAllById(list);
		findAllById.forEach(e->{
			System.out.println(e);//used to print all the data avalilable in collection
		});
		
	}
	//findall to retriive all  record from table
	public void getUserss()
	{
		List<Integer> findall = Arrays.asList(101,102);
		Iterable<UserMasterEntity> findAll2 = userMasterRepo.findAll();
		findAll2.forEach(z->{
			System.out.println(z);
		});
	}
	public void deleteByid()
	{
		userMasterRepo.deleteById(100);
		//userMasterRepo.deleteAllById(Arrays.asList(103,104));//delete both  
		//userMasterRepo.deleteAll();
	}
	public void test()
	{
		long count = userMasterRepo.count();//to know the count of records
		System.out.println("total records in the table== >"+count);
		boolean existsById = userMasterRepo.existsById(101);
		System.out.println("id is present or not-=>"+existsById);
	}
	public void testFindByMethods()
	{
		//List<UserMasterEntity> list = userMasterRepo.findByCity("hyd");//finding by city
		//List<UserMasterEntity> list = userMasterRepo.findByAgeGreaterThanEqual(5);//finding by age
		//List<UserMasterEntity> list = userMasterRepo.findByGender("ma;e");
		List<UserMasterEntity> list = userMasterRepo.findByGenderAndCity("ma;e","HYD");
		list.forEach(entity->{
			System.out.println(entity);
		});
	}
	
	
	
	public void testCustomQueries()
	{
//		List<String> list = userMasterRepo.getIndiansEmails("HYD");
//		list.forEach(emails->{
//			System.out.println(emails);
//		});
		
		//userMasterRepo.updateAgeById(32, 101);
		userMasterRepo.deleteUserById(101);
	}
}
