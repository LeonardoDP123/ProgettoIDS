package com.example.ProgettoIDS_SpringBoot.Repository;

import com.example.ProgettoIDS_SpringBoot.Model.Pacchetto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacchettoRepository extends JpaRepository<Pacchetto, Integer> {
}
