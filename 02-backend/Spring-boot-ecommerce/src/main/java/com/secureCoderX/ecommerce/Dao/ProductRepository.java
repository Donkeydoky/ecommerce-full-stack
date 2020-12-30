package com.secureCoderX.ecommerce.Dao;

import com.secureCoderX.ecommerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
