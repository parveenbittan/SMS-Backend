package com.scheduler.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.scheduler.demo.entity.Attendence;

public interface AttendenceRepository extends JpaRepository<Attendence, Long>{
	
	@Query(" FROM com.scheduler.demo.entity.Attendence s where s.attendenceeDate =:date and  s.studentIdFk=:studentId order by s.studentIdFk Limit 1")
	Optional<Attendence> findByDateAndStudent(@Param("date")String date ,@Param("studentId")Long studentId );

	Optional<Attendence> findFirstByOrderByAttendenceIdDesc();
}
