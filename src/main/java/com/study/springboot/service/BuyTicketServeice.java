package com.study.springboot.service;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.study.springboot.dao.ITransaction1Dao;
import com.study.springboot.dao.ITransaction2Dao;

@Service
public class BuyTicketServeice {
	@Autowired
	ITransaction1Dao tran1;
	
	@Autowired
	ITransaction2Dao tran2;
	
	@Autowired
	TransactionTemplate tranTemplate;
	
//	@Autowired
//	PlatformTransactionManager transManager;
//	
//	@Autowired
//	TransactionDefinition transDefinaition;
	
	//@Transactional(propagation=Propagation.REQUIRED)
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public int buy(String consumerId, int amount, String error) {
		
		//TransactionStatus status = transManager.getTransaction(transDefinaition);
		
		try {
			tranTemplate.execute(new TransactionCallbackWithoutResult() {
				
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					tran1.pay(consumerId, amount);//첫번째 insert
					
					//의도적 에러 발생
					if(error.equals("1")) {
						int n =10 / 0;
					}
					
					tran2.pay(consumerId, amount);//두번째 insert
				}
			});
			//tran1.pay(consumerId, amount);
			
			//의도적 에러 발생
//			if(error.equals("1")) {
//				int n =10 / 0;
//			}
//			
//			tran2.pay(consumerId, amount);
			
			//transManager.commit(status);
			return 1;
		} 
		catch(Exception e) {
			//System.out.println("[PlatformTransactionManager] Rollback");
			System.out.println("[Transaction Progagation #2] Rollback");
			//transManager.rollback(status);
			return 0;
		}
	}
}
