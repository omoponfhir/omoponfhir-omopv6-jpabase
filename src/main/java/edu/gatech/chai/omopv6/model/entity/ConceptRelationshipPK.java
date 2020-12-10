package edu.gatech.chai.omopv6.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ConceptRelationshipPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "concept_id_1")
    private Long conceptId1;

    @Column(name = "concept_id_2")
    private Long conceptId2;
    
    @Column(name="relationship_id")
	private String relationshipId;
    
    public ConceptRelationshipPK() {
    }
    
    public ConceptRelationshipPK(Long conceptId1, Long conceptId2, String relationshipId) {
    	this.conceptId1 = conceptId1;
    	this.conceptId2 = conceptId2;
    	this.relationshipId = relationshipId;
    }

    public Long getConceptId1() {
		return this.conceptId1;
	}
	
	public void setConceptId1(Long conceptId1) {
		this.conceptId1 = conceptId1;
	}

	public Long getConceptId2() {
		return this.conceptId2;
	}
	
	public void setConceptId2(Long conceptId2) {
		this.conceptId2 = conceptId2;
	}
	
	public String getRelationshipId() {
		return relationshipId;
	}
	
	public void setRelationshipId(String relationshipId) {
		this.relationshipId = relationshipId;
	}
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((relationshipId == null) ? 0 : relationshipId.hashCode());
		result = prime * result + conceptId1.intValue() + conceptId2.intValue();
		return result;
	}
    
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConceptRelationshipPK other = (ConceptRelationshipPK) obj;
		if (relationshipId == null) {
			if (other.relationshipId != null)
				return false;
		} else if (!relationshipId.equals(other.relationshipId))
			return false;
		if (conceptId1 != other.conceptId1)
			return false;
		if (conceptId2 != other.conceptId2)
			return false;
		
		return true;
	}
}
