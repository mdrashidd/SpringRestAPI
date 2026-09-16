package com.rashid.ashrafii.SpringRestAPI.repositories;

import com.rashid.ashrafii.SpringRestAPI.controller.EmployeeController;
import com.rashid.ashrafii.SpringRestAPI.dto.EmployeeDTO;
import com.rashid.ashrafii.SpringRestAPI.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

}
