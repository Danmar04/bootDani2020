package com.rest.dani.apidani.VO;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Integer id;

    @NotNull
    @Column(name ="name", length = 50)
    @Size(max = 50)
    private String name;

    @NotNull
    @Column(name = "surname", length = 150)
    @Size(max = 150)
    private String surname;

    @Column(name = "password", length = 250)
    @Size(max = 250)
    private String password;

    @NotNull
    @Column(name = "age")
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "employee_office")
    private Office office;


//    private List<String> knowledge;

    public Employee() {
    }

    public Employee(Integer id, String name, String surname, String password, Integer age, Office office/*, String rol, List<String> knowledge*/) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.age = age;
        this.office = office;
       // this.rol = rol;
      //  this.knowledge = knowledge;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    //    public String getRol() {
//        return rol;
//    }
//
//    public void setRol(String rol) {
//        this.rol = rol;
//    }

//    public List<String> getKnowledge() {
//        return knowledge;
//    }
//
//    public void setKnowledge(List<String> knowledge) {
//        this.knowledge = knowledge;
//    }
}
