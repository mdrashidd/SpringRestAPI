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
    @NotEmpty(message = "Name can not be Empty")
    @Size(min=3, max=20, message= "Employ name must have atleast 3 characters and atmost 20 characters")
    @NotNull
    private String name;
    @NotEmpty(message = "Department is required")
    private String department;
    @Min(value=100,message="Salary can not be less than 100")
    @Max(value=199999, message="Salary can not be so large")
    private Double salary;
    @PastOrPresent
    private LocalDate dateOfJoining;
    private Boolean isActive;
    @NotEmpty(message = "Role is required")
    @EmployeeRoleValidation(message = "Role can be either USER or ADMIN")
    private String role;
    @Min(value=18, message = "Employe age should be greater than 18")
    private int age;
}
