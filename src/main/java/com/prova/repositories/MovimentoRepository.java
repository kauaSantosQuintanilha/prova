package com.prova.repositories;

import com.prova.models.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface MovimentoRepository extends JpaRepository<Movimento, Long> {
    Optional<Movimento> findById(Long id);

}
