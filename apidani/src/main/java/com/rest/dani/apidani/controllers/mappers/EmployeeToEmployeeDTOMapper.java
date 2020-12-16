package com.rest.dani.apidani.controllers.mappers;

import com.rest.dani.apidani.VO.Employee;
import com.rest.dani.apidani.controllers.dto.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeToEmployeeDTOMapper {

    EmployeeToEmployeeDTOMapper INSTANCE = Mappers.getMapper(EmployeeToEmployeeDTOMapper.class);

    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    Employee employeeDTOToEmployee(EmployeeDTO employee);
}
