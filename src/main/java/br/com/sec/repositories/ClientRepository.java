package br.com.sec.repositories;

import br.com.sec.models.Client;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
