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
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(
		name="measurement",
		indexes = { 
				@Index(name = "idx_measurement_concept_id", columnList = "measurement_concept_id"), 
				@Index(name = "idx_measurement_fperson_id", columnList = "person_id")
				}
		)
public class Measurement extends BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="measurement_seq_gen")
	@SequenceGenerator(name="measurement_seq_gen", sequenceName="measurement_id_seq", allocationSize=1)
	@Column(name = "measurement_id")
	@Access(AccessType.PROPERTY)
	private Long id;

	@ManyToOne
	@JoinColumn(name="person_id", nullable=false)
	private FPerson fPerson;

	@ManyToOne
	@JoinColumn(name="measurement_concept_id", nullable=false)
	private Concept measurementConcept;

	@Column(name = "measurement_date")
	@Temporal(TemporalType.DATE)
	private Date measurementDate;

	@Column(name = "measurement_datetime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date measurementDateTime;

	@Column(name = "measurement_time")
	// @Temporal(TemporalType.TIME)
	private String measurementTime;

	@ManyToOne
	@JoinColumn(name = "measurement_type_concept_id", nullable = false)
	private Concept measurementTypeConcept;

	@ManyToOne
	@JoinColumn(name = "operator_concept_id")
	private Concept operatorConcept;

	@Column(name = "value_as_number")
	private Double valueAsNumber;

	@ManyToOne
	@JoinColumn(name = "value_as_concept_id")
	private Concept valueAsConcept;

	@ManyToOne
	@JoinColumn(name = "unit_concept_id")
	private Concept unitConcept;
	
	@Column(name = "range_low")
	private Double rangeLow;

	@Column(name = "range_high")
	private Double rangeHigh;

	@ManyToOne
	@JoinColumn(name="provider_id")
	private Provider provider;

	@ManyToOne
	@JoinColumn(name = "visit_occurrence_id")
	private VisitOccurrence visitOccurrence;

	@ManyToOne
	@JoinColumn(name = "visit_detail_id")
	private VisitDetail visitDetail;

	@Column(name="measurement_source_value")
	private String measurementSourceValue; 

	@ManyToOne
	@JoinColumn(name="measurement_source_concept_id", nullable = false)
	private Concept measurementSourceConcept; 

	@Column(name="unit_source_value")
	private String unitSourceValue; 

	@Column(name="value_source_value")
	private String valueSourceValue;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public FPerson getFPerson() {
		return fPerson;
	}
	
	public void setFPerson(FPerson fPerson) {
		this.fPerson = fPerson;
	}
	
	public Concept getMeasurementConcept() {
		return measurementConcept;
	}
	
	public void setMeasurementConcept(Concept measurementConcept) {
		this.measurementConcept = measurementConcept;
	}
	
	public Date getMeasurementDate() {
		return measurementDate;
	}
	
	public void setMeasurementDate(Date measurementDate) {
		this.measurementDate = measurementDate;
	}
	
	public Date getMeasurementDateTime() {
		return measurementDateTime;
	}
	
	public void setMeasurementDateTime(Date measurementDateTime) {
		this.measurementDateTime = measurementDateTime;
	}
	
	public String getTime() {
		return measurementTime;
	}
	
	public void setTime(String measurementTime) {
		this.measurementTime = measurementTime;
	}
	
	public Concept getMeasurementTypeConcept() {
		return measurementTypeConcept;
	}
	
	public void setMeasurementTypeConcept(Concept measurementTypeConcept) {
		this.measurementTypeConcept = measurementTypeConcept;
	}

	public Concept getOperatorConcept() {
		return operatorConcept;
	}
	
	public void setOperationConcept(Concept operatorConcept) {
		this.operatorConcept = operatorConcept;
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
	
	public Concept getUnitConcept() {
		return unitConcept;
	}
	
	public void setUnitConcept(Concept unitConcept) {
		this.unitConcept = unitConcept;
	}
	
	public Double getRangeLow() {
		return rangeLow;
	}
	
	public void setRangeLow(Double rangeLow) {
		this.rangeLow =rangeLow;
	}
	
	public Double getRangeHigh() {
		return rangeHigh;
	}
	
	public void setRangeHigh(Double rangeHigh) {
		this.rangeHigh = rangeHigh;
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
	
	public void setVisitOccurrence (VisitOccurrence visitOccurrence) {
		this.visitOccurrence = visitOccurrence;
	}
	
	public VisitDetail getVisitDetail() {
		return this.visitDetail;
	}
	
	public void setVisitDetail(VisitDetail visitDetail) {
		this.visitDetail = visitDetail;
	}
	
	public String getMeasurementSourceValue() {
		return measurementSourceValue;
	}
	
	public void setMeasurementSourceValue(String measurementSourceValue) {
		this.measurementSourceValue = measurementSourceValue;
	}

	public Concept getMeasurementSourceConcept() {
		return measurementSourceConcept;
	}
	
	public void setMeasurementSourceConcept(Concept measurementSourceConcept) {
		this.measurementSourceConcept = measurementSourceConcept;
	}

	public String getUnitSourceValue() {
		return unitSourceValue;
	}
	
	public void setUnitSourceValue(String unitSourceValue) {
		this.unitSourceValue = unitSourceValue;
	}

	public String getValueSourceValue() {
		return valueSourceValue;
	}
	
	public void setValueSourceValue(String valueSourceValue) {
		this.valueSourceValue = valueSourceValue;
	}
	
	@Override
	public Long getIdAsLong() {
		return getId();
	}
}
