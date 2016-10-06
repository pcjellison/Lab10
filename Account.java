import java.util.*;

public class Account {
	private int num;
	private String name;
	private double balance;
	
	public Account(int n, String na, double b) {
		num = n;
		name = na;
		balance = b;
	}
	
	public void deposit(double add) {
		balance+=add;
	}
	
	public void withdrawal(double minus) {
		balance-=minus;
	}
	
	public int getNum() {
		return num;
	}
	
	public String getName() {
		return name;
	}
	
	public double getBalance() {
		return balance;
	}	
	
	public String toString() {
		return num + ", " + name + ", $" + balance;
	}
}