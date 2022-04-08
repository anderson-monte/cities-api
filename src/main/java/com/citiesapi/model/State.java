package com.citiesapi.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.FetchType;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Entity(name = "State")
@Table(name = "estado")
@TypeDefs({
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class State {
	
	@Id
	private Long id;
	
	@Column(name = "nome")
	private String name;
	
	private String uf;
	private Integer ibge;
	
	@ManyToOne
	@JoinColumn(name = "pais", referencedColumnName = "id")
	private Contry country;

	@Type(type = "jsonb")
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "ddd", columnDefinition = "jsonb")
	private List<Integer> ddd;

	public State() {
	}
	
	
	//Getters and Setters
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUf() {
		return uf;
	}

	public Integer getIbge() {
		return ibge;
	}

	public List<Integer> getDdd() {
		return ddd;
	}

	public Contry getCountry() {
		return country;
	}
}
