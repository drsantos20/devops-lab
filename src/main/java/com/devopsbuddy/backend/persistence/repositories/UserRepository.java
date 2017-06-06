/**
 * 
 */
package com.devopsbuddy.backend.persistence.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devopsbuddy.backend.persistence.domain.backend.User;

/**
 * @author Daniel on 24 de abr de 2017
 */
@Repository
@Transactional(readOnly=true)
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
	
	User findByEmail(String mail);
	
	@Transactional
	@Modifying
	@Query("update User u set u.password =:password where u.id =:userId")
	void updateUserPassword(@Param("userId") long userId, @Param("password") String password);

}
