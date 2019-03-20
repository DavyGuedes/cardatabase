package br.ufc.alu.cardatabase.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.ufc.alu.cardatabase.domain.User;

/**
 * UserRepository
 * @author Marcos Davy Guedes Dias
 */
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>{
    
    Optional<User> findByUsername(String username);
    List<User> findByRole(String role);
    
}