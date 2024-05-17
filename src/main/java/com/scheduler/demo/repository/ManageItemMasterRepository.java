package com.scheduler.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scheduler.demo.entity.ItemMaster;
@Repository
public interface ManageItemMasterRepository extends JpaRepository<ItemMaster, Integer>{
	List<ItemMaster> findByOrderByItemId();
	Optional<ItemMaster> findById(Integer id);
	Optional<ItemMaster> findFirstByOrderByItemIdDesc();
	@Query(" FROM com.scheduler.demo.entity.ItemMaster s where s.isActive =true  ")
	List<ItemMaster> getActiveItem();
	
}
