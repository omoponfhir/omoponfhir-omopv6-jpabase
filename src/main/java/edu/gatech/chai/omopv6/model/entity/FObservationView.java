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

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import net.jcip.annotations.Immutable;

@Entity
@Immutable
@Table(name="f_observation_view")
public class FObservationView extends BaseEntity {
	@Id
	@Column(name="observation_id")
	@Access(AccessType.PROPERTY)
	private Long id;

	@ManyToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name = "person_id", nullable = false)
	private FPerson fPerson;

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "observation_concept_id", nullable = false)
	private Concept observationConcept;

	@Column(name = "observation_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date observationDate;

	@Column(name = "observation_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date observationDateTime;

	@Column(name = "observation_time")
	private String observationTime;

	@Column(name = "value_as_string")
	private String valueAsString;

	@Column(name = "value_as_number")
	private Double valueAsNumber;

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "value_as_concept_id")
	private Concept valueAsConcept;

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "observation_type_concept_id", nullable = false)
	private Concept observationTypeConcept;

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "provider_id")
	private Provider provider;

	@ManyToOne(cascade = { CascadeType.MERGE }, fetch=FetchType.LAZY)
	@JoinColumn(name = "visit_occurrence_id")
	private VisitOccurrence visitOccurrence;

	@Column(name = "observation_source_value")
	private String observationSourceValue;

	@ManyToOne(cascade = { CascadeType.MERGE }, fetch=FetchType.LAZY)
	@JoinColumn(name = "observation_source_concept_id")
	private Concept observationSourceConcept;

	@ManyToOne(cascade = { CascadeType.MERGE }, fetch=FetchType.LAZY)
	@JoinColumn(name = "qualifier_concept_id")
	private Concept qualifierConcept;

	@Column(name = "qualifier_source_value")
	private String qualifierSourceValue;

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "unit_concept_id")
	private Concept unitConcept;

	@Column(name = "unit_source_value")
	private String unitSourceValue;

	@Column(name = "range_low")
	private BigDecimal rangeLow;

	@Column(name = "range_high")
	private BigDecimal rangeHigh;
	
	@Column(name = "value_source_value")
	private String valueSourceValue;

	@ManyToOne(cascade = { CascadeType.MERGE }, fetch=FetchType.LAZY)
	@JoinColumn(name = "observation_operator_concept_id")
	private Concept observationOperatorConcept;

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

	public Concept getObservationConcept() {
		return observationConcept;
	}

	public void setObservationConcept(Concept observationConcept) {
		this.observationConcept = observationConcept;
	}

	public Date getObservationDate() {
		return observationDate;
	}

	public void setObsdrvationDate(Date observationDate) {
		this.observationDate = observationDate;
	}

	public Date getObservationDateTime() {
		return observationDateTime;
	}

	public void setObsdrvationDateTime(Date observationDateTime) {
		this.observationDateTime = observationDateTime;
	}

	public String getObservationTime() {
		return observationTime;
	}

	public void setObsdrvationTime(String observationTime) {
		this.observationTime = observationTime;
	}

	public String getValueAsString() {
		return valueAsString;
	}

	public void setValueAsString(String valueAsString) {
		this.valueAsString = valueAsString;
	}

	public Double getValueAsNumber() {
		return valueAsNumber;
	}

	public void setValueAsNumber(Double valueAsNumber) {
		this.valueAsNumber = valueAsNumber;
	}

	public Concept getValueAsConcept() {
		return valueAsConcept;
	}

	public void setValueAsConcept(Concept valueAsConcept) {
		this.valueAsConcept = valueAsConcept;
	}

	public Concept getObservationTypeConcept() {
		return observationTypeConcept;
	}

	public void setObservationTypeConcept(Concept observationTypeConcept) {
		this.observationTypeConcept = observationTypeConcept;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public VisitOccurrence getVisitOccurrence() {
		return visitOccurrence;
	}

	public void setVisitOccurrence(VisitOccurrence visitOccurrence) {
		this.visitOccurrence = visitOccurrence;
	}

	public Concept getQualifierConcept () {
		return qualifierConcept;
	}
	
	public void setQualifierConcept (Concept qualifierConcept) {
		this.qualifierConcept = qualifierConcept;
	}
	
	public String getQualifierSourceValue () {
		return qualifierSourceValue;
	}
	
	public void setQualifierSourceValue (String qualifierSourceValue) {
		this.qualifierSourceValue = qualifierSourceValue;
	}
	
	public String getObservationSourceValue() {
		return observationSourceValue;
	}

	public void setObservationSourceValue(String observationSourceValue) {
		this.observationSourceValue = observationSourceValue;
	}

	public Concept getObservationSourceConcept() {
		return observationSourceConcept;
	}
	
	public void setObservationSourceConcept(Concept observationSourceConcept) {
		this.observationSourceConcept = observationSourceConcept;
	}
	
	public Concept getUnitConcept() {
		return unitConcept;
	}

	public void setUnitConcept(Concept unitConcept) {
		this.unitConcept = unitConcept;
	}

	public String getUnitSourceValue() {
		return unitSourceValue;
	}

	public void setUnitSourceValue(String unitSourceValue) {
		this.unitSourceValue = unitSourceValue;
	}
	
	public BigDecimal getRangeLow() {
		return rangeLow;
	}

	public void setRangeLow(BigDecimal rangeLow) {
		this.rangeLow = rangeLow;
	}

	public BigDecimal getRangeHigh() {
		return rangeHigh;
	}

	public void setRangeHigh(BigDecimal rangeHigh) {
		this.rangeHigh = rangeHigh;
	}
	
	public String getValueSourceValue() {
		return valueSourceValue;
	}
	
	public void setValueSourceValue(String valueSourceValue) {
		this.valueSourceValue = valueSourceValue;
	}

	public Concept getObservationOperatorConcept() {
		return observationOperatorConcept;
	}

	public void setObservationOperatorConcept(Concept observationOperatorConcept) {
		this.observationOperatorConcept = observationOperatorConcept;
	}

	@Override
	public Long getIdAsLong() {
		return getId();
	}


}
