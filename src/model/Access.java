package model;

import java.util.ArrayList;
import java.util.List;

import exception.NoDayException;
import exception.UnderageException;

public class Access {
	
	List<Customer> customers;
	public Access() {
		customers= new ArrayList<>();
	}
	
	public void AddCustomer(String id, int num, int day ) throws UnderageException, NoDayException {
		
		if(id.equals("TI")) {
			throw new UnderageException();
		}
		else if((CheckId(num)%2==0 && day%2==0) || (CheckId(num)%2!=0 && day%2!=0)) {
			throw new NoDayException(day,num);
		}
		else if(CheckList(num)) {
			System.out.println("Already exist a id with this number");
		}
		else {
			customers.add(new Customer(id,num));
			System.out.println("The customer has been registered");
		}
	}
	
	public int CheckId(int id) {
		String nm= String.valueOf(id);
		boolean c= false;
		char[] digits1 = nm.toCharArray();
		int r=0;
        for(int i = 0; i < digits1.length && !c; i++) {
            if(i==digits1.length-2) {
            	r=Character.getNumericValue(digits1[i]);
            	c=true;
            }
        }
        return r;
	}
	
	public boolean CheckList(int num) {
		boolean ans=false;
		for(int i = 0; i < customers.size(); i++) {
			if(customers.get(i).getNum()==num) {
				ans=true;
			}
		}
		return ans;
	}
}
