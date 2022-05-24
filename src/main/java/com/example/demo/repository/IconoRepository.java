package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.IconEntity;

@Repository
public interface IconoRepository extends JpaRepository<IconEntity,Long> {

}
	