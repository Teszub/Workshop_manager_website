package com.example.workshopmanager.repository;

import com.example.workshopmanager.model.Price;
import com.example.workshopmanager.model.PriceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findPriceByPriceCategory(PriceCategory priceCategory);

}
