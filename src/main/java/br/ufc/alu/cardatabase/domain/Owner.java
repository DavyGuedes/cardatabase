package br.ufc.alu.cardatabase.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * Owner entity table
 * 
 * @author Masrcos Davy Guedes Dias
 */

@Entity
@Data
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fisrtname, lastname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Car> cars;

    public Owner(String fisrtname, String lastname, List<Car> cars) {
        this.fisrtname = fisrtname;
        this.lastname = lastname;
        this.cars = cars;
    }
}