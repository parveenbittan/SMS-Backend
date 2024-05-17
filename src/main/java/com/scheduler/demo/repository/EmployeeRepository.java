package com.scheduler.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scheduler.demo.dto.LoginDTO;
import com.scheduler.demo.entity.EmployeeMaster;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeMaster, Long>{
	List<EmployeeMaster> findByOrderByEmpId();
	Optional<EmployeeMaster> findById(Long id);
	Optional<EmployeeMaster> findFirstByOrderByEmpIdDesc();
	@Query("FROM com.scheduler.demo.entity.EmployeeMaster s where s.isActive =true  ")
	List<EmployeeMaster> getActiveEmployee();
	@Query( 
	        nativeQuery = true, 
	        value = "SELECT  u.user_name as username,  r.role_name as role, o.org_name as orgname,\r\n"
	        		+ "o.affidate_no as affidiateno,o.owner_name as ownername,o.address as orgaddress,o.email as orgemail,o.contact,o.contact2,o.board FROM public.users u inner join roles r on r.role_id=u.role_id inner join org o on o.org_id=u.org_id where u.user_name=:name and u.user_password=:password ") 
	List<Object[]> login(@Param("name") String name ,@Param("password") String password); 
	@Query( 
	        nativeQuery = true, 
	        value = "SELECT pm.post_id,pm.post_name	FROM public.emp_post_mapping ep inner join post_master pm on pm.post_id=ep.post_id_fk where ep.emp_id_fk=:empId order by ep.post_id_fk Limit 1 ") 
	List<Object[]> postByEmpId(@Param("empId") Long empId ); 
	
}
