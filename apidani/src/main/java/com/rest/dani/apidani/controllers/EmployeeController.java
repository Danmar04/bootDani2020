package com.rest.dani.apidani.controllers;

import com.rest.dani.apidani.configuration.error.DaniException;
import com.rest.dani.apidani.controllers.dto.EmployeeDTO;
import com.rest.dani.apidani.controllers.dto.ListEmployeesDTO;
import com.rest.dani.apidani.services.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController implements EmployeeApi{


   @Autowired
   private EmployeeServiceImp serviceImp;

    @Override
    public ResponseEntity<List<ListEmployeesDTO>> getEmployees() {
        List<ListEmployeesDTO> aux = serviceImp.getEmployees();
        return ResponseEntity.ok().body((aux));
    }

    @Override
    public ResponseEntity<EmployeeDTO> getEmployee(int id) throws DaniException {
       EmployeeDTO aux = serviceImp.getEmployeeById(id);
        if(aux != null){
            return ResponseEntity.ok().body(aux);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> createEmployee(@Valid EmployeeDTO employeeDTO) throws DaniException {

        serviceImp.createEmployee(employeeDTO);
          //  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateEmployee(int id, @Valid EmployeeDTO employeeDTO) throws DaniException {
        serviceImp.updateEmployee(id, employeeDTO);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Void> deleteEmployee(int id) throws DaniException {
        serviceImp.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    public EmployeeController(){

    }
}
