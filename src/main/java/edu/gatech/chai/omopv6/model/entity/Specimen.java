package edu.gatech.chai.omopv6.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(
        name="specimen",
        indexes = {
                @Index(name = "idx_specimen_concept_id", columnList = "specimen_concept_id"),
                @Index(name = "idx_specimen_fperson_id", columnList = "person_id")
        }
)@Inheritance(strategy = InheritanceType.JOINED)
public class Specimen extends BaseEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="specimen_seq_gen")
    @SequenceGenerator(name="specimen_seq_gen", sequenceName="specimen_id_seq", allocationSize=1)
    @Column(name = "specimen_id")
    @Access(AccessType.PROPERTY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private FPerson fPerson;

    @ManyToOne
    @JoinColumn(name = "specimen_concept_id", nullable = false)
    private Concept specimenConceptId;

    @ManyToOne
    @JoinColumn(name = "specimen_type_concept_id", nullable = false)
    private Concept specimenTypeConceptId;

    @Column(name = "specimen_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date specimenDate;

    @Column(name = "specimen_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date specimenDateTime;

    @Column(name = "quantity")
    private Float quantity;

    @ManyToOne
    @JoinColumn(name = "unit_concept_id")
    private Concept unitConceptId;

    @ManyToOne
    @JoinColumn(name = "anatomic_site_concept_id")
    private Concept anatomicSiteConceptId;

    @ManyToOne
    @JoinColumn(name = "disease_status_concept_id")
    private Concept diseaseStatusConceptId;

    @Column(name = "specimen_source_id")
    private String specimenSourceId;

    @Column(name = "specimen_source_value")
    private String specimenSourceValue;

    @Column(name = "unit_source_value")
    private String unitSourceValue;

    @Column(name = "anatomic_site_source_value")
    private String anatomicSiteSourceValue;

    @Column(name = "disease_status_source_value")
    private String diseaseStatusSourceValue;

    public FPerson getfPerson() {
        return fPerson;
    }

    public void setfPerson(FPerson fPerson) {
        this.fPerson = fPerson;
    }

    public Concept getSpecimenConceptId() {
        return specimenConceptId;
    }

    public void setSpecimenConceptId(Concept specimenConceptId) {
        this.specimenConceptId = specimenConceptId;
    }

    public Concept getSpecimenTypeConceptId() {
        return specimenTypeConceptId;
    }

    public void setSpecimenTypeConceptId(Concept specimenTypeConceptId) {
        this.specimenTypeConceptId = specimenTypeConceptId;
    }

    public Date getSpecimenDate() {
        return specimenDate;
    }

    public void setSpecimenDate(Date specimenDate) {
        this.specimenDate = specimenDate;
    }

    public Date getSpecimenDateTime() {
        return specimenDateTime;
    }

    public void setSpecimenDateTime(Date specimenDateTime) {
        this.specimenDateTime = specimenDateTime;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Concept getUnitConceptId() {
        return unitConceptId;
    }

    public void setUnitConceptId(Concept unitConceptId) {
        this.unitConceptId = unitConceptId;
    }

    public Concept getAnatomicSiteConceptId() {
        return anatomicSiteConceptId;
    }

    public void setAnatomicSiteConceptId(Concept anatomicSiteConceptId) {
        this.anatomicSiteConceptId = anatomicSiteConceptId;
    }

    public Concept getDiseaseStatusConceptId() {
        return diseaseStatusConceptId;
    }

    public void setDiseaseStatusConceptId(Concept diseaseStatusConceptId) {
        this.diseaseStatusConceptId = diseaseStatusConceptId;
    }

    public String getSpecimenSourceId() {
        return specimenSourceId;
    }

    public void setSpecimenSourceId(String specimenSourceId) {
        this.specimenSourceId = specimenSourceId;
    }

    public String getSpecimenSourceValue() {
        return specimenSourceValue;
    }

    public void setSpecimenSourceValue(String specimenSourceValue) {
        this.specimenSourceValue = specimenSourceValue;
    }

    public String getUnitSourceValue() {
        return unitSourceValue;
    }

    public void setUnitSourceValue(String unitSourceValue) {
        this.unitSourceValue = unitSourceValue;
    }

    public String getAnatomicSiteSourceValue() {
        return anatomicSiteSourceValue;
    }

    public void setAnatomicSiteSourceValue(String anatomicSiteSourceValue) {
        this.anatomicSiteSourceValue = anatomicSiteSourceValue;
    }

    public String getDiseaseStatusSourceValue() {
        return diseaseStatusSourceValue;
    }

    public void setDiseaseStatusSourceValue(String diseaseStatusSourceValue) {
        this.diseaseStatusSourceValue = diseaseStatusSourceValue;
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

    public void setFPerson(FPerson fPerson) {
        this.fPerson = fPerson;
    }

    @Override
    public Long getIdAsLong() {
        return getId();
    }

}