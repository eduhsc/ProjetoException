package model.entities;

import model.exceptions.DomainException;

public class Account {

	private int number;
	private String holder;
	private double balance;
	private double withDrawLimit;
	
	public Account() {
		
	}
	
	public Account(int number, String holder, double balance, double withDrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withDrawLimit;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public double getBalance() {
		return balance;
	}
	
	public double getWithDrawLimit() {
		return withDrawLimit;
	}
	public void setWithDrawLimit(double withDrawLimit) {
		this.withDrawLimit = withDrawLimit;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public void withDraw(double amount) {
		if (amount > this.withDrawLimit) {
			throw new DomainException("Withdraw error: The amount exceeds the withdraw limit");
		}
		if (amount > this.balance) {
			throw new DomainException("Withdraw error: Not enough balance");
		}
			
		this.balance -= amount;
	}
	
}
