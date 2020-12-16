package com.rest.dani.apidani.services;

import com.rest.dani.apidani.configuration.error.DaniException;
import com.rest.dani.apidani.controllers.dto.EmployeeDTO;
import com.rest.dani.apidani.controllers.dto.ListEmployeesDTO;

import java.util.List;

public interface EmployeeService {

    public EmployeeDTO getEmployeeById(int id) throws DaniException;

    public List<ListEmployeesDTO> getEmployees();

    public void createEmployee(EmployeeDTO employeeDTO) throws DaniException;

    public void deleteEmployee(int id) throws DaniException;

    public void updateEmployee(int id, EmployeeDTO employeeDTO) throws  DaniException;
}
