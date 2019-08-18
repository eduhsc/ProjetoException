package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
	try {
		System.out.println("Enter account data:");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		String holder = sc.next();
		System.out.print("Inicial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double limit = sc.nextDouble();
		Account acc = new Account(number, holder, balance, limit);
		
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		acc.withDraw(sc.nextDouble());
		System.out.println("New balance: " + String.format("%.2f",acc.getBalance()));
	}
	catch (DomainException e) {
			System.out.println(e.getMessage());
		}
	catch (InputMismatchException e) {
		System.out.println("ERROR:Dados inválidos!");
	}
	catch (RuntimeException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		sc.close();

	}

}
