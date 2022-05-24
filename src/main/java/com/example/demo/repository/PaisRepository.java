package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.PaisEntity;

public interface PaisRepository extends JpaRepository<PaisEntity,Long> {

}
