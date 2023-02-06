package com.jacaranda.miPrimerApi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "catId")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int catId;
	private String name;
	private String description;
	@OneToMany(mappedBy="category")
	private List<Elements> elements;
	
	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
		this.elements = new ArrayList<Elements>();
	}
	public Category(int catId, String name, String description) {
		super();
		this.catId = catId;
		this.name = name;
		this.description = description;
		this.elements = new ArrayList<Elements>();
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Elements> getElements() {
		return elements;
	}
	public void setElements(List<Elements> elements) {
		this.elements = elements;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		return Objects.hash(catId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return catId == other.catId;
	}

	
	
	
}
