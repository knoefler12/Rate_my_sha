package com.example.demo.repositories;

import com.example.demo.models.KebabShop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KebabShopRepo extends JpaRepository<KebabShop,Long> {
    Iterable<KebabShop> findKebabShopsByOOrderByRating(KebabShop kebabShop, double rating);
}
