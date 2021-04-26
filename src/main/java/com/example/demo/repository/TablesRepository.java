package com.example.demo.repository;

import com.example.demo.model.Order;
import com.example.demo.model.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TablesRepository extends JpaRepository<Tables, Long> {

    @Override
    Optional<Tables> findById(Long number);



}
