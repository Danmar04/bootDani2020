package com.rest.dani.apidani.repositories;

import com.rest.dani.apidani.VO.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findEmployeeByNameAndSurname(String name, String surname);

    Employee findEmployeeById(Integer id);

    void removeEmployeesById(Integer id);

    Employee findEmployeeByOffice(Integer employee_office);
}
