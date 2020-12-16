package com.rest.dani.apidani.controllers.mappers;

import com.rest.dani.apidani.VO.Employee;
import com.rest.dani.apidani.controllers.dto.ListEmployeesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeToListEmployeeDTOMapper {

    EmployeeToListEmployeeDTOMapper INSTANCE = Mappers.getMapper(EmployeeToListEmployeeDTOMapper.class);

    @Mapping( target = "idEmployee", source = "id")
    ListEmployeesDTO employeeToListEmployeeDTO(Employee employee);

    List<ListEmployeesDTO> employeeToListEmployeesDTO(List<Employee> employee);
}
