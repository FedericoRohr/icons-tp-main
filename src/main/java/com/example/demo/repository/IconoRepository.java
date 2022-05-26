package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.IconEntity;

@Repository
public interface IconoRepository extends JpaRepository<IconEntity,Long>, JpaSpecificationExecutor<IconEntity> {
List<IconEntity>findAll(Specification<IconEntity>spect);
}
	