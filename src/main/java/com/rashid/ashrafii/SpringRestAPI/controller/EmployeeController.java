package com.rashid.ashrafii.SpringRestAPI.controller;

import com.rashid.ashrafii.SpringRestAPI.dto.EmployeeDTO;
import com.rashid.ashrafii.SpringRestAPI.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping
    public List<EmployeeDTO> getEmployee(){
        return employeeService.getEmployee();
    }


    @PostMapping
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeedto){
        return employeeService.saveEmployee(employeedto);
    }

    @PutMapping("/{employeeId}")
    public EmployeeDTO putEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId){
        return employeeService.putEmployeeById(employeeDTO,employeeId);
    }

    @DeleteMapping(path="/{employeeId}")
    public Boolean deleteEmployeeById(@PathVariable Long employeeId){
        return employeeService.deleteEmployeeById(employeeId);
    }

  /*  @PatchMapping(path="{employeeId}")
    public EmployeeDTO patchEmployeeById(@RequestBody Map<String, Object> map , @PathVariable Long employeeId){
        return employeeService.patchEmployeeById(map,employeeId);
    } */



}
