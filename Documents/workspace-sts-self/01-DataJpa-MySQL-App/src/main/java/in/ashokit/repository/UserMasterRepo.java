package in.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import in.ashokit.entity.UserMasterEntity;
import jakarta.transaction.Transactional;

public interface UserMasterRepo extends CrudRepository<UserMasterEntity, Integer> 
{
	//select * from user_master where user_city=:city;
	public List<UserMasterEntity> findByCity(String city);
	//select * from user_master where user-age >=:age
	public List<UserMasterEntity> findByAgeGreaterThanEqual(int age);
	//select * frpm user_master where user_gender=:gender
	public List<UserMasterEntity>  findByGender(String gender);
	//select * from user_master where user_gender=gender and user_city=city;
	public List<UserMasterEntity> findByGenderAndCity(String gender,String city);
	@Query("select email from UserMasterEntity where city=:city")//HQL QUERUY TAKES ONLY ENTITY CLASS NAME AND CLASS VARIABLES
	public List<String> getIndiansEmails(String city);//IF we r retrieving perticular list of emails we have to take List<String>,if we want to all  coloumns in table then use List<TABLENAME>

	@Query("from UserMasterEntity")//hql query,this is equal to select * from tablename in sql query
	public List<UserMasterEntity> getAllUsers();
	
	@Query(value = "select * from user_master",nativeQuery = true)//sql
	public List<UserMasterEntity> getAllUsersSql();
	
	
	@Query("update UserMasterEntity set age=:age where id=:userId")//named positional query
	@Transactional
	@Modifying
	public void updateAgeById(int age,int userId);
	
	@Query("delete from UserMasterEntity where id=:uid")
	@Transactional
	@Modifying
	public void deleteUserById(int uid);
}
   