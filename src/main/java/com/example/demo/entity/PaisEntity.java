package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="pais")
@Getter @Setter
@SQLDelete(sql="UPDATE pais SET deleted = true WHERE id=?")
@Where(clause="deleted=false")
public class PaisEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private Long id;
	
	private String denominacion;
	
	@Column(name="cantidad_habitantes")
	private Long cantidadHabitantes;
	
	private Float superficie;
	
	private boolean deleted=Boolean.FALSE;
	
	private String Imagen;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
	@JoinColumn(name="continente_id", insertable = false , updatable = false)
	private ContinenteEntity continente;
	
	@Column(name="continente_id", nullable = false)
	private Long continenteId;
	
	@ManyToMany(cascade= {
			CascadeType.PERSIST,
		    CascadeType.MERGE
	})
	@JoinTable(name="icon_pais",
	joinColumns=@JoinColumn(name="pais_id"),
	inverseJoinColumns=@JoinColumn(name="icon_id"))
	private Set<IconEntity>icons= new HashSet<>();
	
	
	public void addIcon(IconEntity icon) {
		icons.add(icon);
	}
	
    public void removeicon(IconEntity icon) {
    	icons.remove(icon);
	}


}
