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
@Table(name="domain")
public class Domain extends BaseEntity {
	@Id
	@Column(name="domain_id", nullable=false)
	@Access(AccessType.PROPERTY)
	private Long id;

	@Column(name="domain_name", nullable=false)
	private String domainName;

	@ManyToOne
	@JoinColumn(name="domain_concept_id", nullable=false)
	private Concept domainConcept;
	
	public Domain() {
		super();
	}
	
	public Domain(Long id) {
		super();
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDomainName() {
		return this.domainName;
	}
	
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	
	public Concept getDomainConcept() {
		return domainConcept;
	}
	
	public void setDomainConcept(Concept domainConcept) {
		this.domainConcept = domainConcept;
	}
}
