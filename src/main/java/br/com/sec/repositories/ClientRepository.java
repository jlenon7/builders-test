package br.com.sec.repositories;

import br.com.sec.models.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM Client c WHERE c.age BETWEEN :since_age AND :max_age ORDER BY c.id")
    Page<Client> findAllBetween(
            @Param("since_age") Long sinceAge,
            @Param("max_age") Long max_age,
            Pageable pageable
    );
}
