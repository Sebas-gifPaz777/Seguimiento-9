package ui;

import java.io.IOException;
import java.util.Scanner;

import exception.NoDayException;
import exception.UnderageException;
import model.Access;

public class Main {
	
	public static Scanner sn= new Scanner(System.in);
	public static Access ac= new Access();
	public static int counter=0;
	public static void main(String[]args) throws IOException {
		boolean exit=false;
		int answer=0;
		
		while(!exit) {
			System.out.println("Choose an option"+"\n1: Register a customer"+"\n2: Tries done"+"\n3: Exit");
			answer=sn.nextInt();
			
			switch(answer) {

			case 1:
				Register();
			break;

			case 2:
				System.out.println("The quantity of tries is "+NetQuantity());
			break;

			case 3:
				exit=true;
			break;
			}
		}
	}
	
	public static void Register() {
		String id="";
		int idnum=0;
		
		System.out.println("Choose a kind of ID"+"\n1:TI-Tarjeta de Identidad"+"\n2:CC-Cédula de Ciudadanía"+"\n3:PP-Pasaporte"+"\n4:CE-Cédula de Extranjería");
		int ans=sn.nextInt();
		switch(ans) {

		case 1:
			id="TI";
			break;
		case 2:
			id="CC";
			break;

		case 3:
			id="PP";
			break;

		case 4:
			id="CE";
			break;
		}
		
		System.out.println("Write your ID number");
		idnum=sn.nextInt();
		sn.nextLine();
		
		System.out.println("Write the current day (dd/mm)");
		String date=sn.nextLine();
		String[] parts=date.split("/");
		int def=Integer.parseInt(parts[0]);
		
		try {
			ac.AddCustomer(id,idnum,def );
			counter++;
		} catch (UnderageException e) {
			counter++;
			System.err.println(e.getMessage());
		} catch (NoDayException e) {
			counter++;
			System.err.println(e.getMessage());
		}
	}
	public static int NetQuantity() {
		return counter;
	}
}
