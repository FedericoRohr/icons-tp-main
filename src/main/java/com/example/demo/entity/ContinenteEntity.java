package com.example.demo.entity;

import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="continente")
@Getter @Setter
@SQLDelete(sql="UPDATE continente SET deleted = true WHERE id=?")
@Where(clause="deleted=false")
public class ContinenteEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private Long id;
	
	private String imagen;
	
	private String denominacion;

	private boolean deleted=Boolean.FALSE;
	@Override
	public String toString() {
		return "ContinenteEntity [id=" + id + ", imagen=" + imagen + ", denominacion=" + denominacion + "]";
	}

    

}
