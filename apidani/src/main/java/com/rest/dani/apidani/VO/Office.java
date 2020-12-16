package com.rest.dani.apidani.VO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "office")
public class Office implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_office;

    @Column (name ="name")
    private String name;

    @Column (name = "country")
    private String country;

    @OneToMany(mappedBy = "office")
    private List<Employee> employees;


    public Integer getId_office() {
        return id_office;
    }

    public void setId_office(Integer id_office) {
        this.id_office = id_office;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
