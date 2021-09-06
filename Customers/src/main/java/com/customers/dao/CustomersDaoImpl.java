package com.customers.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customers.model.Customers;

@Repository
@Transactional
public class CustomersDaoImpl implements CustomersDao{
	
	@Autowired
	SessionFactory cuSessionFactory;

	

	public List<Customers> getDetails() {
		try {
		Query query=cuSessionFactory.getCurrentSession().createQuery("select s.custName as custName  ,sum(transationValue) as transationValue from Customers s group by s.custName");
		return query.getResultList();
		}catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
		
	}



	public List<Customers> getDetailsMonthly() {
		try {
		@SuppressWarnings("deprecation")
		Criteria cr=cuSessionFactory.getCurrentSession().createCriteria(Customers.class);
		return cr.list();
		}catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
		
	}

}
