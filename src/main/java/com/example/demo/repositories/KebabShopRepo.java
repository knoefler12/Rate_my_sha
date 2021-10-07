package com.example.demo.repositories;

import com.example.demo.models.KebabShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KebabShopRepo extends JpaRepository<KebabShop,Long> {

    @Query(value = "SELECT * FROM kebab_shops ORDER BY RATING DESC", nativeQuery = true)
    Iterable<KebabShop> findKebabShopsOrderedByHighestRating();
}
