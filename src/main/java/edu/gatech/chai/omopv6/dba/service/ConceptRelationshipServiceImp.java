package edu.gatech.chai.omopv6.dba.service;

import org.springframework.stereotype.Service;

import edu.gatech.chai.omopv6.jpa.dao.ConceptRelationshipDao;
import edu.gatech.chai.omopv6.model.entity.ConceptRelationship;
import edu.gatech.chai.omopv6.model.entity.ConceptRelationshipPK;

// TODO: Auto-generated Javadoc
/**
 * The Class ConceptRelationshipServiceImp.
 */
@Service
public class ConceptRelationshipServiceImp extends BaseEntityServiceImp<ConceptRelationship, ConceptRelationshipDao>
		implements ConceptRelationshipService {

	/**
	 * Instantiates a new concept relationship service imp.
	 */
	public ConceptRelationshipServiceImp() {
		super(ConceptRelationship.class);
	}

	/* (non-Javadoc)
	 * @see edu.gatech.chai.omopv5.dba.service.ConceptRelationshipService#findById(edu.gatech.chai.omopv5.model.entity.ConceptRelationshipPK)
	 */
	@Override
	public ConceptRelationship findById(ConceptRelationshipPK conceptRelationshipPk) {
		return getEntityDao().findById(getEntityClass(), conceptRelationshipPk);
	}

	/* (non-Javadoc)
	 * @see edu.gatech.chai.omopv5.dba.service.ConceptRelationshipService#removeById(edu.gatech.chai.omopv5.model.entity.ConceptRelationshipPK)
	 */
	@Override
	public void removeById(ConceptRelationshipPK conceptRelationshipPk) {
		getEntityDao().delete(getEntityClass(), conceptRelationshipPk);
	}
	
}
