package com.example.demo.repositories;

import com.example.demo.models.KebabShop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KebabShopRepo extends JpaRepository<KebabShop,Long> {

}
