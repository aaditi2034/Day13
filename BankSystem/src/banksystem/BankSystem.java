/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Date;
import java.util.HashMap;
import java.text.SimpleDateFormat;


/**
 *
 * @author Arpit GUPTA
 */
public class BankSystem{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args){ 
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        String str;
        int quit = 0,choice=0;
        CurrentAccount c_obj = new CurrentAccount();
        SaviingAccount s_obj = new SaviingAccount();
	//miniState = new ArrayList<String>();
        
        System.out.println("***************WELCOME TO BANKING SYSTEM*************************");
        
	//char y='y';
	while(quit!=1)        
	{								
            try{
		System.out.println("Enter 1 for Current Account");
                System.out.println("Enter 2 for Saving Account");
                str = br.readLine();
                int x = Integer.parseInt(str);
                if(x==1)
                {
                    do{
                        System.out.println("Choose Your Choices ...");
                        System.out.println("1. New Record Entry");
                        System.out.println("2. Display Record Details");
                        System.out.println("3. Deposit...");
                        System.out.println("4. Withdraw...");
                        System.out.println("5. Quit");
                        System.out.print("Enter your choice : ");
                        
                        str=br.readLine();
                        choice=Integer.parseInt(str);
                        switch(choice)
                        {
                            case 1 :c_obj.newEntry();
                            break;
                            case 2 :c_obj.display();
                            break;  
                            case 3 :c_obj.deposit();
                            break;
                            case 4 :c_obj.withdraw();
                            break;
                            case 5 :System.out.println("\n.....Closing Current Account.....");
                            break;
                            default:System.out.println("\nInvalid Choice \n");
                        }
                    }while(choice!=5);
                    
                }
                else
                {
                    do
                    {
                        System.out.println("Choose Your Choices ...");
                        System.out.println("1. New Record Entry");
                        System.out.println("2. Display Record Details");
                        System.out.println("3. Deposit...");
                        System.out.println("4. Withdraw...");
                        System.out.println("5. Quit");
                        System.out.print("Enter your choice : ");
                        str = br.readLine();
                        choice = Integer.parseInt(str);
                        switch(choice)
                        {
                            case 1 :s_obj.newEntry();
                            break;
                            case 2 :s_obj.display();
                            break;
                            case 3 :s_obj.deposit();

                            break;
                            case 4 :s_obj.withdraw();
                            break;
                            case 5 :System.out.println("\n.....Closing Saving Account...");
                            break;
                            default:System.out.println("\nInvalid Choice \n");
                        }
                    }while(choice!=5);
                }
                System.out.print("\nEnter 1 for Exit : ");
                str=br.readLine();
                quit=Integer.parseInt(str);
                
                /*
                System.out.println("Enter the Account Holder Name");
		String name = br.readLine();
		System.out.println("Enter the Account no");
		int num = Integer.parseInt(br.readLine());
		System.out.println("Enter the Current Balance");
		int bal = Integer.parseInt(br.readLine());
		if(bal<0)
                    System.out.println("Amount can't be negative");
		else{
		    y='n';				//if all inputs are valid the loop does not work again
                    BankSystem accob = new BankSystem(name,num,bal);
		    accob.call();
		}*/
	    }catch (NumberFormatException | IOException e){System.out.println("Please give valid inputs");}
	}
    }
}

    
