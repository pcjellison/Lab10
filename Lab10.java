import java.util.*;
import java.io.*;

public class Lab10 {
	public static void main(String[] args) throws FileNotFoundException
	{
		ArrayList<Account> list = new ArrayList<Account>();
		
		Scanner s = new Scanner(System.in);
		try
		{
			System.out.print("Enter the name of the input file: ");
			String filename = s.nextLine();
		
			//YOU DO THIS:
			//Open the file in the 'filename' variable
			//Parse each line, create an Account object, and add it to the list
			Scanner inFile = new Scanner (new File (filename));
			while (inFile.hasNextLine())
			{
				try
				{
				String input = inFile.nextLine();
				String [] items = input.split(",");
				list.add(new Account(Integer.parseInt(items[0]), items[1], Double.parseDouble(items[2])));
				}
				catch(Exception e)
				{
					System.out.println("Invalid data in file. Skipping a record.");
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("File not found. Check filename and rerun program");
			System.exit(0);
		}
		char option;
		do {
			System.out.print("Enter (p)rint, (d)eposit, (w)ithdrawal, (l)ookup, or (q)uit: ");
			option = (s.nextLine()).charAt(0);
			switch (option) {
				case 'p':	// print - find and display and account object
					System.out.print("Enter account number: ");
					int num = Integer.parseInt(s.nextLine());
					
					Account a = find(list, num);
					System.out.println(a);
					break;

				case 'd':	// deposit money into an account
					try
					{
						System.out.print("Enter account number: ");
						 num = Integer.parseInt(s.nextLine());
						//YOU DO THIS:
						//Call 'find' method below to retrieve the account with entered account number
						 Account d = find(list, num);
						
						System.out.print("Enter deposit amount: ");
						double dep = Double.parseDouble(s.nextLine());
						
						//YOU DO THIS:
						//Call deposit method on the account retrieved from find method to deposit 'dep'
						double add = dep;
						d.deposit(add);
						System.out.println(d.getBalance());
					}
					catch (Exception e)
					{
						System.out.println("Enter numbers only. No characters allowed");
						System.out.print("Enter (p)rint, (d)eposit, (w)ithdrawal, (l)ookup, or (q)uit: ");
						option = (s.nextLine()).charAt(0);
					}
					
					break;

				case 'w':	// withdraw money from an account
					System.out.print("Enter account number: ");
					num = Integer.parseInt(s.nextLine());
					//YOU DO THIS:
					//Call 'find' method below to retrieve the account with entered account number
					Account w = find(list, num);
					
					System.out.print("Enter withdrawal amount: ");
					double with = Double.parseDouble(s.nextLine());
					
					//YOU DO THIS:
					//Call withdrawal method on the account retrieved from find method to withdraw 'with'
					double minus = with;
					w.withdrawal(minus);
					System.out.println(w.getBalance());
					
					break;

				case 'l':	// lookup - find an account and display using account name
					System.out.print("Enter name: ");
					String name = s.nextLine();
					
					//YOU DO THIS:
					//Loop through each account, calling get to get each one (or using an Iterator)
						//for each account, see if object's name matches the name entered by user (ignore case)
						//if found, print the number for that account
					for(int i=0; i<list.size(); i++)
					{
						Account valid = list.get(i);
						String check = valid.getName();
						
						if(check.equals(name))
						{
							System.out.println(valid.getNum());
						}
					}
						
					break;
			} // end switch
		} while (option != 'q');
	} // end main
	
	public static Account find(ArrayList<Account> accounts, int num) 
	{
		//YOU DO THIS
		//loop through accounts, calling get to get each account (or using an Iterator)
			//for each account, see if object's account number matches the number entered by user
			//if found, return that account
		for(int i=0; i<accounts.size(); i++)
		{
			Account valid = accounts.get(i);
			int check = valid.getNum();
			if(check == num)
			{
				return valid;
			}
		}
		
		//leave this at the very end of the method in case the account isn't found
		return null;
	}	// end find
}