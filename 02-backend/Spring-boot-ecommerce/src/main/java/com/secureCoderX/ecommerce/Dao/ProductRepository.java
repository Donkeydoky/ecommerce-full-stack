package com.secureCoderX.ecommerce.Dao;

import com.secureCoderX.ecommerce.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
public interface ProductRepository extends JpaRepository<Product, Long> {

    //SELECT * FROM product WHERE category_id = ?
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    //SELECT * FROM product p WHERE p.name LIKE CONCAT('%', :name , '%')
    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
