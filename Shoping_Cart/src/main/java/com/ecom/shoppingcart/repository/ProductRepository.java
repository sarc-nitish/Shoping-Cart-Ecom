package com.ecom.shoppingcart.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.shoppingcart.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // ================= BASIC =================
    List<Product> findByIsActiveTrue();

    Page<Product> findByIsActiveTrue(Pageable pageable);

    List<Product> findTop8ByOrderByIdDesc();

    // ================= CATEGORY =================
    List<Product> findByCategory_Name(String category);

    Page<Product> findByCategory_Name(String category, Pageable pageable);

    // ================= SEARCH =================
    List<Product> findByTitleContainingIgnoreCase(String keyword);

    Page<Product> findByTitleContainingIgnoreCase(String keyword, Pageable pageable);

    // ================= ACTIVE + SEARCH (SAFE) =================
    Page<Product> findByIsActiveTrueAndTitleContainingIgnoreCase(
            String keyword, Pageable pageable);

    Page<Product> findByIsActiveTrueAndCategory_Name(
            String category, Pageable pageable);
}
