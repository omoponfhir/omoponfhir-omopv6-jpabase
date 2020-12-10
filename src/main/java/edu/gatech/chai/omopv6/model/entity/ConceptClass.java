package edu.gatech.chai.omopv6.model.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="concept_class")
public class ConceptClass extends BaseEntity {
	@Id
	@Column(name="concept_class_id", nullable=false)
	@Access(AccessType.PROPERTY)
	private String id;

	@Column(name="concept_class_name", nullable=false)
	private String conceptClassName;

	@ManyToOne
	@JoinColumn(name="concept_class_concept_id", nullable=false)
	private Concept conceptClassConcept;

	@Override
	public Long getIdAsLong() {
		// TODO Auto-generated method stub
		return null;
	}

	public ConceptClass() {
		super();
	}
	
	public ConceptClass(String id) {
		super();
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConceptClassName() {
		return this.conceptClassName;
	}
	
	public void setConceptClassName(String conceptClassName) {
		this.conceptClassName = conceptClassName;
	}
	
	public Concept getConceptClassConcept() {
		return conceptClassConcept;
	}
	
	public void setConceptClassConcept(Concept conceptClassConcept) {
		this.conceptClassConcept = conceptClassConcept;
	}
}
