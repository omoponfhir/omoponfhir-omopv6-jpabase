/*******************************************************************************
 * Copyright (c) 2019 Georgia Tech Research Institute
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *******************************************************************************/
package edu.gatech.chai.omopv6.model.entity;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="visit_occurrence")
public class VisitOccurrence extends BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="visit_seq_gen")
	@SequenceGenerator(name="visit_seq_gen", sequenceName="visit_occurrence_id_seq", allocationSize=1)
	@Column(name="visit_occurrence_id", nullable=false)
	@Access(AccessType.PROPERTY)
	private Long id;
	
	@ManyToOne()
	@JoinColumn(name="person_id", nullable=false)
	private FPerson fPerson;
	
	@ManyToOne()
	@JoinColumn(name="visit_concept_id", nullable=false)
	private Concept visitConcept;
	
	@Column(name="visit_start_date", nullable=false)
	private Date visitStartDate;
	
	@Column(name="visit_start_datetime")
	private Date visitStartDateTime;
	
	@Column(name="visit_end_date", nullable=false)
	private Date visitEndDate;
	
	@Column(name="visit_end_datetime")
	private Date visitEndDateTime;
	
	@ManyToOne
	@JoinColumn(name="visit_type_concept_id", nullable=false)
	private Concept visitTypeConcept;
	
	@ManyToOne()
	@JoinColumn(name="provider_id")
	private Provider provider;
	
	@ManyToOne()
	@JoinColumn(name="care_site_id")
	private CareSite careSite;
	
	@Column(name="visit_source_value")
	private String visitSourceValue;
	
	@ManyToOne
	@JoinColumn(name="visit_source_concept_id")
	private Concept visitSourceConcept;

	@ManyToOne
	@JoinColumn(name="admitted_from_concept_id")
	private Concept admittedFromConcept;

	@ManyToOne
	@JoinColumn(name="admitting_source_concept_id")
	private Concept admittingSourceConcept;

	@Column(name="admitting_source_value")
	private String admittingSourceValue;
	
	@ManyToOne
	@JoinColumn(name="discharge_to_concept_id")
	private Concept dischargeToConcept;
		
	@Column(name="discharge_to_source_value")
	private String dischargeToSourceValue;
	
	@ManyToOne
	@JoinColumn(name="preceding_visit_occurrence_id")
	private VisitOccurrence precedingVisitOccurrence;
		

	public VisitOccurrence() {
	}
	
	public VisitOccurrence(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FPerson getFPerson() {
		return fPerson;
	}
	
	public void setFPerson(FPerson person) {
		this.fPerson = person;
	}
	
	public Concept getVisitConcept() {
		return visitConcept;
	}
	
	public void setVisitConcept(Concept visitConcept) {
		this.visitConcept = visitConcept;
	}
	
	public Date getVisitStartDate() {
		return visitStartDate;
	}
	
	public void setVisitStartDate(Date visitStartDate) {
		this.visitStartDate = visitStartDate;
	}
	
	public Date getVisitStartDateTime() {
		return visitStartDateTime;
	}
	
	public void setVisitStartDateTime(Date visitStartDateTime) {
		this.visitStartDateTime = visitStartDateTime;
	}
	
	public Date getVisitEndDate() {
		return visitEndDate;
	}
	
	public void setVisitEndDate(Date visitEndDate) {
		this.visitEndDate = visitEndDate;
	}
	
	public Date getVisitEndDateTime() {
		return visitEndDateTime;
	}
	
	public void setVisitEndDateTime(Date visitEndDateTime) {
		this.visitEndDateTime = visitEndDateTime;
	}
	
	public Concept getVisitTypeConcept() {
		return visitTypeConcept;
	}
	
	public void setVisitTypeConcept(Concept visitTypeConcept) {
		this.visitTypeConcept = visitTypeConcept;
	}
	
	public Provider getProvider() {
		return provider;
	}
	
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
	public CareSite getCareSite() {
		return careSite;
	}
	
	public void setCareSite(CareSite careSite) {
		this.careSite = careSite;
	}
	
	public String getVisitSourceValue() {
		return visitSourceValue;
	}
	
	public void setVisitSourceValue(String visitSourceValue) {
		this.visitSourceValue = visitSourceValue;
	}
	
	public Concept getVisitSourceConcept() {
		return visitSourceConcept;
	}
	
	public void setVisitSourceConcept(Concept visitSourceConcept) {
		this.visitSourceConcept = visitSourceConcept;
	}
	
	public Concept getAdmittedFromConcept() {
		return admittedFromConcept;
	}
	
	public void setAdmittedFromConcept(Concept admittedFromConcept) {
		this.admittedFromConcept = admittedFromConcept;
	}

	public Concept getAdmittingSourceConcept() {
		return admittingSourceConcept;
	}
	
	public void setAdmittingSourceConcept(Concept admittingSourceConcept) {
		this.admittingSourceConcept = admittingSourceConcept;
	}

	public String getAdmittingSourceValue() {
		return admittingSourceValue;
	}
	
	public void setAdmittingSourceValue(String admittingSourceValue) {
		this.admittingSourceValue = admittingSourceValue;
	}
	
	public Concept getDischargeToConcept() {
		return dischargeToConcept;
	}
	
	public void setDischargeToConcept(Concept dischargeToConcept) {
		this.dischargeToConcept = dischargeToConcept;
	}

	public String getDischargeToSourceValue() {
		return dischargeToSourceValue;
	}
	
	public void setDischargeToSourceValue(String dischargeToSourceValue) {
		this.dischargeToSourceValue = dischargeToSourceValue;
	}
	
	public VisitOccurrence getPrecedingVisitOccurrence() {
		return precedingVisitOccurrence;
	}
	
	public void setPrecedingVisitOccurrence(VisitOccurrence precedingVisitOccurrence) {
		this.precedingVisitOccurrence = precedingVisitOccurrence;
	}

	@Override
	public Long getIdAsLong() {
		return getId();
	}
	
}
