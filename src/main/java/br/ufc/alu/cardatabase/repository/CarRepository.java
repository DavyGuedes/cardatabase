package br.ufc.alu.cardatabase.repository;

import br.ufc.alu.cardatabase.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * CarRepository
 * @author Marcos Davy Guedes Dias
 */

@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car, Long> {

}
