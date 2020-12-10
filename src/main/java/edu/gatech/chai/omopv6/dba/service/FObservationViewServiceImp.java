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
package edu.gatech.chai.omopv6.dba.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import edu.gatech.chai.omopv6.jpa.dao.FObservationViewDao;
import edu.gatech.chai.omopv6.model.entity.FObservationView;

// TODO: Auto-generated Javadoc
/**
 * The Class FObservationViewServiceImp.
 */
@Service
public class FObservationViewServiceImp extends BaseEntityServiceImp<FObservationView, FObservationViewDao> implements FObservationViewService {

	/**
	 * Instantiates a new f observation view service imp.
	 */
	public FObservationViewServiceImp() {
		super(FObservationView.class);
	}
	
	/* (non-Javadoc)
	 * @see edu.gatech.chai.omopv5.dba.service.FObservationViewService#findDiastolic(java.lang.Long, java.lang.Long, java.util.Date, java.lang.String)
	 */
	public FObservationView findDiastolic(Long conceptId, Long personId, Date date, Date time) {
		EntityManager em = getEntityDao().getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<FObservationView> criteria = builder.createQuery(FObservationView.class);
		Root<FObservationView> from = criteria.from(FObservationView.class);
		criteria.select(from).where(
				builder.equal(from.get("observationConcept").get("id"), conceptId),
				builder.equal(from.get("fPerson").get("id"), personId),
				builder.equal(from.get("date"), date),
				builder.equal(from.get("time"),  time)
				);
		TypedQuery<FObservationView> query = em.createQuery(criteria);
		List<FObservationView> results = query.getResultList();
		if (results.size() > 0) {
			return results.get(0);				
		} else {
			return null;
		}
	}
}
