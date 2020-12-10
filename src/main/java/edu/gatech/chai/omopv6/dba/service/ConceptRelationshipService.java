package edu.gatech.chai.omopv6.dba.service;

import edu.gatech.chai.omopv6.model.entity.ConceptRelationship;
import edu.gatech.chai.omopv6.model.entity.ConceptRelationshipPK;

// TODO: Auto-generated Javadoc
/**
 * The Interface ConceptRelationshipService.
 */
public interface ConceptRelationshipService extends IService<ConceptRelationship> {
	
	/**
	 * Find by id.
	 *
	 * @param conceptRelationshipPk the concept relationship pk
	 * @return the concept relationship
	 */
	public ConceptRelationship findById(ConceptRelationshipPK conceptRelationshipPk);
	
	/**
	 * Removes the by id.
	 *
	 * @param conceptRelationshipPk the concept relationship pk
	 */
	public void removeById(ConceptRelationshipPK conceptRelationshipPk);
}
