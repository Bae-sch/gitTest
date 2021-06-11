package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dao.ITransactionDao3;

@Service
public class LogWriteService {
	@Autowired
	ITransactionDao3 tran3;
	
	public int write(String consumerId, int amount) {
		try {
			tran3.pay(consumerId, amount);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
}
