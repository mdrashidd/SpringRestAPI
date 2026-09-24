package com.rashid.ashrafii.SpringRestAPI.dto;

import com.rashid.ashrafii.SpringRestAPI.annotation.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
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

    @NotEmpty(message = "Name is a required field")
    @Size(min=3, max=20, message= "Employee name should contain at least 3 characters and at most 20 characters")
    @NotNull
    private String name;

    @NotEmpty(message = "Department is required field")
    private String department;

    @NotNull(message = "Salary is a required field")
    @Min(value=100,message="Salary can not be less than 100")
    @Max(value=199999, message="Salary can not be so large")
    private Double salary;

    @PastOrPresent(message = "Date can not be in future")
    private LocalDate dateOfJoining;

    @NotNull(message = "isActive is a required field")
    private Boolean isActive;

    @EmployeeRoleValidation(message = "Role can either be USER or ADMIN")
    private String role;

    @NotNull(message = "Age is a required field")
    @Min(value=18, message = "Employee age should be greater than 18")
    private int age;
}
