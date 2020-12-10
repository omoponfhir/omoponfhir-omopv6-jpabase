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

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import edu.gatech.chai.omopv6.jpa.dao.BaseEntityDao;
import edu.gatech.chai.omopv6.model.entity.BaseEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseEntityServiceImp.
 *
 * @param <T> the generic BaseEntity type
 * @param <V> the generic BaseEntityDao type
 */
public abstract class BaseEntityServiceImp<T extends BaseEntity, V extends BaseEntityDao<T>>  implements IService<T> {

	/** The v dao. */
	@Autowired
	private V vDao;
	
	/** The entity class. */
	private Class<T> entityClass;
	
	/**
	 * Instantiates a new base entity service imp.
	 *
	 * @param entityClass the entity class
	 */
	public BaseEntityServiceImp(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	/**
	 * Gets the entity dao.
	 *
	 * @return the entity dao
	 */
	public V getEntityDao() {
		return vDao;
	}
	
	/**
	 * Gets the entity class.
	 *
	 * @return the entity class
	 */
	public Class<T> getEntityClass() {
		return this.entityClass;
	}
	
	/* (non-Javadoc)
	 * @see edu.gatech.chai.omopv5.dba.service.IService#findById(java.lang.Long)
	 */
	@Transactional(readOnly = true)
	public T findById(Long id) {
		return vDao.findById(entityClass, id);
	}

	/* (non-Javadoc)
	 * @see edu.gatech.chai.omopv5.dba.service.IService#searchByColumnString(java.lang.String, java.lang.String)
	 */
	@Transactional(readOnly = true)
	public List<T> searchByColumnString(String column, String value) {
		EntityManager em = vDao.getEntityManager();
		List<T> retvals = new ArrayList<T>();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(entityClass);
		Root<T> root = query.from(entityClass);
		
		String[] columnPath = column.split("\\.");
		Path<String> path = root.get(columnPath[0]);
		for (int i=1; i<columnPath.length; i++) {
			path = path.get(columnPath[i]);
		}
		Predicate where = builder.like(builder.lower(path), value.toLowerCase());

		query.select(root);
		query.where(where);
		
		retvals = em.createQuery(query).getResultList();
		return retvals;	
	}

	/* (non-Javadoc)
	 * @see edu.gatech.chai.omopv5.dba.service.IService#searchByColumnString(java.lang.String, java.lang.Long)
	 */
	@Transactional(readOnly = true)
	public List<T> searchByColumnString(String column, Long value) {
		EntityManager em = vDao.getEntityManager();
		List<T> retvals = new ArrayList<T>();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(entityClass);
		Root<T> root = query.from(entityClass);
		
		String[] columnPath = column.split("\\.");
		Path<String> path = root.get(columnPath[0]);
		for (int i=1; i<columnPath.length; i++) {
			path = path.get(columnPath[i]);
		}
		Predicate where = builder.equal(path, value);

		query.select(root);
		query.where(where);
		
		retvals = em.createQuery(query).getResultList();
		return retvals;	
	}
	
	/* (non-Javadoc)
	 * @see edu.gatech.chai.omopv5.dba.service.IService#create(edu.gatech.chai.omopv5.model.entity.BaseEntity)
	 */
	@Transactional
	public T create(T entity) {
		vDao.add(entity);
		return entity;
	}
	
	/* (non-Javadoc)
	 * @see edu.gatech.chai.omopv5.dba.service.IService#removeById(java.lang.Long)
	 */
	@Transactional
	public Long removeById(Long id) {
		return vDao.delete(entityClass, id);
	}

	/* (non-Javadoc)
	 * @see edu.gatech.chai.omopv5.dba.service.IService#update(edu.gatech.chai.omopv5.model.entity.BaseEntity)
	 */
	@Transactional
	public T update(T entity) {
		vDao.merge(entity);
		return entity;
	}
	
	/* (non-Javadoc)
	 * @see edu.gatech.chai.omopv5.dba.service.IService#getSize()
	 */
	@Transactional(readOnly = true)
	public Long getSize() {
		EntityManager em = vDao.getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		
		String pgOptimized = System.getenv("PG_OPTIMIZED"); 
		Table t = entityClass.getAnnotation(Table.class);
		// reference: https://wiki.postgresql.org/wiki/Count_estimate
		if (pgOptimized != null && "true".equalsIgnoreCase(pgOptimized) && t != null) {
			String tableName = t.name();
			String queryString = "SELECT p.reltuples AS approximate_row_count FROM pg_class p WHERE p.relname = :table_name";
			Query query = em.createNativeQuery(queryString);
			query = query.setParameter("table_name", tableName);
			float res = (float) query.getSingleResult();
			return (long) res;
		} else {
			CriteriaQuery<Long> query = builder.createQuery(Long.class);
			Root<T> root = query.from(entityClass);
	
			query.select(builder.count(root));		
			return em.createQuery(query).getSingleResult();		
		}
	}

	/* (non-Javadoc)
	 * @see edu.gatech.chai.omopv5.dba.service.IService#getSize(java.util.List)
	 */
	@Transactional(readOnly = true)
	public Long getSize(List<ParameterWrapper> paramList) {
		// Construct predicate from this map.
		EntityManager em = vDao.getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);
		Root<T> root = query.from(entityClass);

		List<Predicate> predicates = ParameterWrapper.constructPredicate(builder, paramList, root);		
		if (predicates == null || predicates.isEmpty()) return 0L;

		query.select(builder.count(root));
		query.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
		
		return em.createQuery(query).getSingleResult();
	}
	
	/**
	 * Adds the sort.
	 *
	 * @param builder the builder
	 * @param root the root
	 * @param sort the sort
	 * @return the list
	 */
	protected List<Order> addSort (CriteriaBuilder builder, Root<T> root, String sort) {
		List<Order> orders = new ArrayList<Order>();
		if (sort != null && !sort.isEmpty()) {
			String[] sort_ = sort.split(",");
			for (int i=0; i<sort_.length; i++) {
				String[] items = sort_[i].split(" ");
				if ("ASC".equals(items[1])) {
					orders.add(builder.asc(root.get(items[0])));
				} else {
					orders.add(builder.desc(root.get(items[0])));
				}
			}
		} else {
			orders.add(builder.asc(root.get("id")));
		}
		
		return orders;
	}
	
	/* (non-Javadoc)
	 * @see edu.gatech.chai.omopv5.dba.service.IService#searchWithoutParams(int, int, java.lang.String)
	 */
	@Transactional(readOnly = true)
	public List<T> searchWithoutParams(int fromIndex, int toIndex, String sort) {
		int length = toIndex - fromIndex;
		EntityManager em = vDao.getEntityManager();		
		List<T> retvals = new ArrayList<T>();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(entityClass);
		Root<T> root = query.from(entityClass);
		
		query.select(root);
		
		// Sort		
		query.orderBy(addSort(builder, root, sort));
		
		if (length <= 0) {
			retvals = em.createQuery(query)
					.getResultList();
		} else {
//			TypedQuery<T> sq = em.createQuery(query);
//			String queryString = sq.unwrap(org.hibernate.query.Query.class).getQueryString();
//			System.out.println("TESTING for QUERY:"+queryString);
//
			retvals = em.createQuery(query)
					.setFirstResult(fromIndex)
					.setMaxResults(length)
					.getResultList();
		}
		return retvals;	
	}

	/* (non-Javadoc)
	 * @see edu.gatech.chai.omopv5.dba.service.IService#searchWithParams(int, int, java.util.List, java.lang.String)
	 */
	@Transactional(readOnly = true)
	public List<T> searchWithParams(int fromIndex, int toIndex, List<ParameterWrapper> paramList, String sort) {
		int length = toIndex - fromIndex;
		EntityManager em = vDao.getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(entityClass);
		Root<T> root = query.from(entityClass);
		
		List<T> retvals = new ArrayList<T>();
		
		List<Predicate> predicates = ParameterWrapper.constructPredicate(builder, paramList, root);		
		if (predicates == null || predicates.isEmpty()) return retvals; // Nothing. return empty list
	
		query.select(root);
		query.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		// Sort		
		if (sort != null) {
			query.orderBy(addSort(builder, root, sort));
		}

		if (length <= 0) {
			retvals = em.createQuery(query)
					.getResultList();			
		} else {
			retvals = em.createQuery(query)
					.setFirstResult(fromIndex)
					.setMaxResults(length)
					.getResultList();
		}
		return retvals;
	}

}
