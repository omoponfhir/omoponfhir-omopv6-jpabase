package edu.gatech.chai.omopv6.jpa.dao;

import org.springframework.stereotype.Repository;

import edu.gatech.chai.omopv6.model.entity.ConceptRelationship;
import edu.gatech.chai.omopv6.model.entity.ConceptRelationshipPK;

@Repository
public class ConceptRelationshipDao extends BaseEntityDao<ConceptRelationship> {
	public ConceptRelationship findById(Class<ConceptRelationship> entityClass, ConceptRelationshipPK conceptRelationshipPk) {
		return getEntityManager().find(entityClass, conceptRelationshipPk);
	}
	
	public void delete(Class<ConceptRelationship> entityClass, ConceptRelationshipPK conceptRelationshipPk) {
		ConceptRelationship entity = findById(entityClass, conceptRelationshipPk);
		if (entity != null) {
			getEntityManager().remove(entity);
		} 
	}
	
}
