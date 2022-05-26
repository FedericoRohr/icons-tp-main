package com.example.demo.repository.specification;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.demo.dto.IconFilterDTO;
import com.example.demo.entity.IconEntity;
import com.example.demo.entity.PaisEntity;

@Component
public class IconSpecification {

	
	public Specification<IconEntity>getByFilters(IconFilterDTO dto){
		return (root,query,criteriaBuilder) ->{
			List<Predicate> predicates = new ArrayList<>(); 
			
			if(StringUtils.hasLength(dto.getName())) {/// consulta si tiene name 
				predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("denominacion")), "%"+dto.getName()+"%")); /// agrega el name al predicate
			}
			
			if(StringUtils.hasLength(dto.getDate())) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate date= LocalDate.parse(dto.getDate(),formatter);	
				predicates.add(criteriaBuilder.equal(root.<LocalDate>get("fechaCreacion"), date));
			}
			
			if(!CollectionUtils.isEmpty(dto.getCities())) {
				Join<PaisEntity,IconEntity> join= root.join("paises",JoinType.INNER);
				Expression<String> citiesId=join.get("id");
				predicates.add(citiesId.in(dto.getCities()));
			}
			
			/// remove duplicates
			query.distinct(true);
			
			/// order resolver
			
			String orderByField="denominacion";
			query.orderBy(dto.isAsc()? criteriaBuilder.asc(root.get(orderByField)):criteriaBuilder.desc(root.get(orderByField)));
			
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
			
	
		};
	}

}
