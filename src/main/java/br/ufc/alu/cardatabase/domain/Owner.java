package br.ufc.alu.cardatabase.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Owner entity table
 * 
 * @author Masrcos Davy Guedes Dias
 */

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fisrtname, lastname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Car> cars;



}