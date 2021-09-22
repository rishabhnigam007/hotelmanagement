package hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hotelmanagement.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> 
{
	
	@Query(value = "select count(*) from user u where u.fname=:fname and u.lname=:lname and u.password=:password",nativeQuery = true)
	int existsById(@Param("fname") String fname , @Param("lname") String lname, @Param("password") String password);

//	void deleteById(long uid);

//	@Query(value = "select count(*) from user u where u.uid = :uid and u.password = :password" ,nativeQuery = true)
//	int isUserDelete(@Param("uid") long uid, @Param("password") String password);
	
	@Query(value = "select count(email) from user u where u.email=?1",nativeQuery = true)
	int findByEmail(String email);
}