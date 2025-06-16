package com.example.ProgettoIDS_SpringBoot.Repository;

import com.example.ProgettoIDS_SpringBoot.Model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdottoRepository extends JpaRepository<Prodotto, Integer> {
}
