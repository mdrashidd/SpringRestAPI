package com.rashid.ashrafii.SpringRestAPI.service;


import com.rashid.ashrafii.SpringRestAPI.dto.EmployeeDTO;
import com.rashid.ashrafii.SpringRestAPI.entity.EmployeeEntity;
import com.rashid.ashrafii.SpringRestAPI.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;


@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;

    }

    public Optional<EmployeeDTO> getEmployeeById(Long id){
        return employeeRepository
                .findById(id)
                .map(employeeEntity -> modelMapper
                        .map(employeeEntity, EmployeeDTO.class));
    }


    public EmployeeDTO saveEmployee(EmployeeDTO employeedto) {
        EmployeeEntity employeeEntity = modelMapper.map(employeedto, EmployeeEntity.class);
        EmployeeEntity savedEmployEntity =  employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployEntity,EmployeeDTO.class);

    }

    public List<EmployeeDTO> getEmployee() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for(EmployeeEntity employeeEntity : employeeEntities){
            employeeDTOS.add(modelMapper.map(employeeEntity , EmployeeDTO.class));
        }
        return employeeDTOS;
    }

    public EmployeeDTO putEmployeeById(EmployeeDTO employeeDTO, Long id) {
        existsById(id);
        employeeDTO.setEmployeeId(id);
        return saveEmployee(employeeDTO);
    }

    private void existsById(Long id) {
        Boolean exist = employeeRepository.existsById(id);
        if(!exist) throw new NoSuchElementException("Resource not found");
    }

    public Boolean deleteEmployeeById(Long employeeId){
        existsById(employeeId);
        employeeRepository.deleteById(employeeId);
        return true;
    }

   /* public EmployeeDTO patchEmployeeById(Map<String, Object> map, Long employeeId) {
        if(!existsById(employeeId)) return null;
        EmployeeDTO employeeDTO = getEmployeeById(employeeId);
        for(String key : map.keySet()){
            if(map.get(key)!=null){

            }
        }
    } */
}
