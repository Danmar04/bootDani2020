package com.rest.dani.apidani.controllers;

import com.rest.dani.apidani.configuration.error.DaniException;
import com.rest.dani.apidani.controllers.dto.EmployeeDTO;
import com.rest.dani.apidani.controllers.dto.ListEmployeesDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "/employees")
public interface EmployeeApi {

    @GetMapping(value = "")
    ResponseEntity<List<ListEmployeesDTO>> getEmployees();

    @GetMapping(value = "/{id}")
    ResponseEntity<EmployeeDTO> getEmployee(@PathVariable int id) throws DaniException;

    @PostMapping(value = "")
    ResponseEntity<Void> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) throws DaniException;

    @PutMapping(value = "/{id}")
    ResponseEntity<Void> updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeeDTO employeeDTO) throws DaniException;

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteEmployee(@PathVariable int id) throws DaniException;

}
