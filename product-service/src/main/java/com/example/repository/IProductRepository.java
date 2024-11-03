package com.boughrous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boughrous.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {}