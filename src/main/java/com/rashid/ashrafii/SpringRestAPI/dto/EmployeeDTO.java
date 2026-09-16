package com.rashid.ashrafii.SpringRestAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long employeeId;
    private String name;
    private String department;
    private Double salary;
    private LocalDate dateOfJoining;
    private Boolean isActive;
}
