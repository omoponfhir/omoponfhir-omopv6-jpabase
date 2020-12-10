package edu.gatech.chai.omopv6.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="fact_relationship")
public class FactRelationship extends BaseEntity {

	@Id
	@Column(name="domain_concept_id_1")
	private Long domainConceptId1;

	@Column(name="fact_id_1")
	private Long factId1;

	@Column(name="domain_concept_id_2")
	private Long domainConceptId2;

	@Column(name="fact_id_2")
	private Long factId2;
	
	@ManyToOne
	@JoinColumn(name="relationship_concept_id")
	private Concept relationshipConcept;
	
	public Long getDomainConceptId1() {
		return this.domainConceptId1;
	}
	
	public void setDomainConceptId1(Long domainConceptId1) {
		this.domainConceptId1 = domainConceptId1;
	}
	
	public Long getFactId1() {
		return this.factId1;
	}
	
	public void setFactId1(Long factId1) {
		this.factId1 = factId1;
	}
	
	public Long getDomainConceptId2() {
		return this.domainConceptId2;
	}
	
	public void setDomainConceptId2(Long domainConceptId2) {
		this.domainConceptId2 = domainConceptId2;
	}
	
	public Long getFactId2() {
		return this.factId2;
	}
	
	public void setFactId2(Long factId2) {
		this.factId2 = factId2;
	}
	
	public Concept getRelationshipConcept() {
		return this.relationshipConcept;
	}
	
	public void setRelationshipConcept(Concept relationshipConcept) {
		this.relationshipConcept = relationshipConcept;
	}
	
	@Override
	public Long getIdAsLong() {
		return this.domainConceptId1;
	}
}
