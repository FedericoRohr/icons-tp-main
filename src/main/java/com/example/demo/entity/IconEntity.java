package com.example.demo.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.dto.PaisDTO;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="icon")
@Getter @Setter
@SQLDelete(sql="UPDATE icon SET deleted = true WHERE id=?")
@Where(clause="deleted=false")
public class IconEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private Long id;
	
	private String imagen;
	private String denominacion;
	private boolean deleted=Boolean.FALSE;
	
	@Column(name="fecha_creacion")
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private LocalDate fechaCreacion;
	
	private long altura;
	private String historia;
	
	@ManyToMany(mappedBy="icons", cascade=CascadeType.ALL)
	private List<PaisEntity>paises = new ArrayList<>();
	

}
