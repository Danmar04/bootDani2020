package com.rest.dani.apidani.services;

import com.rest.dani.apidani.VO.Employee;
import com.rest.dani.apidani.configuration.error.DaniException;
import com.rest.dani.apidani.controllers.dto.EmployeeDTO;
import com.rest.dani.apidani.controllers.dto.ListEmployeesDTO;
import com.rest.dani.apidani.controllers.mappers.EmployeeToEmployeeDTOMapper;
import com.rest.dani.apidani.controllers.mappers.EmployeeToListEmployeeDTOMapper;
import com.rest.dani.apidani.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{

    //private List<Employee> employeeMemoryList = new ArrayList<>();

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO getEmployeeById(int id) throws DaniException {
        Employee aux = employeeRepository.findEmployeeById(id);
        if(aux == null){
            throw new DaniException("Employee not found");
        }
        EmployeeDTO auxDto = EmployeeToEmployeeDTOMapper.INSTANCE.employeeToEmployeeDTO(aux);
        return auxDto;
    }

    @Override
    public List<ListEmployeesDTO> getEmployees() {
        return EmployeeToListEmployeeDTOMapper.INSTANCE.employeeToListEmployeesDTO(employeeRepository.findAll());
    }

    @Override
    public void createEmployee(EmployeeDTO employeeDTO) throws DaniException {
        Employee aux = employeeRepository.findEmployeeByNameAndSurname(employeeDTO.getName(), employeeDTO.getSurname());
        //comporbamos si el user eexiste
        if(aux != null){
            throw new DaniException("employee already exist");
        }
        Employee employee = EmployeeToEmployeeDTOMapper.INSTANCE.employeeDTOToEmployee(employeeDTO);
        employeeRepository.save(employee);

    }

    @Override
    public void deleteEmployee(int id) throws DaniException {
        Employee aux = employeeRepository.findEmployeeById(id);
        if(aux == null){
            throw new DaniException("employee not found");
        }

        employeeRepository.removeEmployeesById(id);
    }

    @Override
    public void updateEmployee(int id, EmployeeDTO employeeDTO) throws DaniException {
        Employee aux = employeeRepository.findEmployeeById(id);
        if(aux != null) {
            if (employeeDTO.getAge() != null) {
                aux.setAge(employeeDTO.getAge());
            }
            if (employeeDTO.getName() != null) {
                aux.setName(employeeDTO.getName());
            }
            //TODO: Rellenar
            aux.setAge(employeeDTO.getAge());
            employeeRepository.save(aux);
        }
        else{
            throw new DaniException("employee not found");
        }

    }


}
