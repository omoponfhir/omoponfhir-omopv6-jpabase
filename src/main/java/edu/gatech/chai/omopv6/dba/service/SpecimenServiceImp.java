package edu.gatech.chai.omopv6.dba.service;

import edu.gatech.chai.omopv6.jpa.dao.SpecimenDao;
import edu.gatech.chai.omopv6.model.entity.Specimen;

public class SpecimenServiceImp extends BaseEntityServiceImp<Specimen, SpecimenDao> implements SpecimenService {

    /**
     * Instantiates a new Specimen Service
     */
    public SpecimenServiceImp() {
        super(Specimen.class);
    }
}