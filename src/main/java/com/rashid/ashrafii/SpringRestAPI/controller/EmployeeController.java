package com.rashid.ashrafii.SpringRestAPI.controller;

import com.rashid.ashrafii.SpringRestAPI.dto.EmployeeDTO;
import com.rashid.ashrafii.SpringRestAPI.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.NoSuchMechanismException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long employeeId) throws Exception {
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(employeeId);

        return employeeDTO
                .map(employeeDTO1 ->  ResponseEntity.ok(employeeDTO1))
                .orElseThrow(()-> new NoSuchElementException("Resource not found"));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployee(){
        return ResponseEntity.ok(employeeService.getEmployee());
    }


    @PostMapping
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeedto){
        EmployeeDTO employeeDTO =  employeeService.saveEmployee(employeedto);
        if(employeeDTO==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> putEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId){
        employeeDTO = employeeService.putEmployeeById(employeeDTO,employeeId);
        if(employeeDTO==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }

    @DeleteMapping(path="/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId){
        Boolean deleted = employeeService.deleteEmployeeById(employeeId);
        if(deleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

  /*  @PatchMapping(path="{employeeId}")
    public EmployeeDTO patchEmployeeById(@RequestBody Map<String, Object> map , @PathVariable Long employeeId){
        return employeeService.patchEmployeeById(map,employeeId);
    } */



}
