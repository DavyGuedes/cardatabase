package br.ufc.alu.cardatabase.repository;

import br.ufc.alu.cardatabase.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * OwnerRepository
 * @author Marcos Davy Guedes Dias
 */
@RepositoryRestResource
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
