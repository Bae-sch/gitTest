package com.study.springboot.dto;

import lombok.Data;

@Data
public class Transaction2Dto {
	private String consumerId;
	private int amount;
	public String getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
