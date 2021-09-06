package com.customers.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customers.dao.CustomersDao;
import com.customers.dao.CustomersDaoImpl;
import com.customers.dto.CustomersDto;
import com.customers.model.Customers;

@Service
public class CustomersServiceImpl implements CustomersService {
	
	@Autowired
	CustomersDaoImpl customersDao;
	
	String pattern = "dd/MM/yyyy";
	DateFormat df = new SimpleDateFormat(pattern);

	@Override
	public List<CustomersDto> getCustomersDetails() {
		List<CustomersDto>customersDtos=new ArrayList<>();
		Map<String, Integer> myMap = new HashMap<String, Integer>();
		Map<String,Integer>monthTotal=new HashMap<>();
		Map<String,Integer>month=new HashMap<>();
		List<Customers>customers=customersDao.getDetails();
		Iterator itr = customers.iterator();
		while(itr.hasNext()){
		   Object[] obj = (Object[]) itr.next();
		   myMap.put(String.valueOf(obj[0]), Integer.valueOf(String.valueOf(obj[1])));
		}
		List<Customers>customer=customersDao.getDetailsMonthly();
		
		for(Customers cu:customer) {
			String custName=cu.getCustName();
			int mo=cu.getTransactionDate().getMonth();
			int value=cu.getTransationValue();
			String key=custName + "_" +mo;
			if(!month.containsKey(key)) {
				month.put(key, value);
			}
			else{
					month.put(key, value+month.get(key));
				}
		}
			
		System.out.println(month);
		for(Customers customers2:customer) {
			int mo=customers2.getTransactionDate().getMonth();
			String key=customers2.getCustName() + "_" +mo;
			CustomersDto customersDto=new CustomersDto();
			customersDto.setCustName(customers2.getCustName());
			DateFormat df = DateFormat.getDateInstance( DateFormat.LONG, Locale.UK );
			customersDto.setTransactionDate( df.format( customers2.getTransactionDate()));
			customersDto.setTotal(myMap.get(customers2.getCustName()));
			customersDto.setTotalReward(getPoints(myMap.get(customers2.getCustName())));
			customersDto.setMonthlyTotal(month.get(key));
			customersDto.setMonthlyReward(getPoints(month.get(key)));
			customersDtos.add(customersDto);
		}
		return customersDtos;
		
	}
	
	public int getPoints(int value) {
		int totalPoint=0;
		if(value<=50) {
			return 0;
		}
		else if(value>50 && value<=100) {
			totalPoint+=value-50;
		}
		
		else {
			int divide=value/100;
			int rem=value%100;
			int point=2*rem;
			int point1=200*(divide-1);
			totalPoint+=point;
			totalPoint+=point1;
			totalPoint+=50;
			
			
		}
		return totalPoint;
	}

}
