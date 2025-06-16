package com.example.ProgettoIDS_SpringBoot.Repository;

import com.example.ProgettoIDS_SpringBoot.Model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
}
