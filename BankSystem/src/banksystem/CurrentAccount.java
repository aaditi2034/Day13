/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Arpit GUPTA
 */
public class CurrentAccount {
    
    final int  min_lim =1;
    final int max_lim = 20;
    final double min_bal = 500;
    String name[] = new String[20];
    int accNo[] = new int[20];
    String accType[] = new String[20];
    double balAmt[] = new double[20];
    int totRec=0;
    
    BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
    
    public void newEntry(){
        String str;
        int acno;
        double amt;
        boolean permit;
        permit=true;
        if(totRec==max_lim)
        {
            System.out.println("\nSorry...limit over... we cannot admit you in our bank.\n");
            permit=false;
        }
        if(permit==true)
        {
            totRec++;
            System.out.println("\n=====RECORDING NEW ENTRY=====");
            try{
                accNo[totRec]=totRec;
                System.out.println("Account Number : "+accNo[totRec]);
                
                System.out.print("Enter Name : ");
                name[totRec]=obj.readLine();
                accType[totRec]="Current Account";
                System.out.println("Account Type : "+accType[totRec]);
                System.out.println("Enter Initial Amount to be deposited : ");
                str=obj.readLine();
                balAmt[totRec]=Double.parseDouble(str);
            }catch(IOException | NumberFormatException e){}
        }
    }

    public void display(){
        String str;
        int acno=0;
        boolean valid=true;
        System.out.println("=====DISPLAYING DETAILS OF CUSTOMER=====");
        try{
            System.out.println("Enter Account number : ");
            str=obj.readLine();
            acno=Integer.parseInt(str);
            if(acno < min_lim || acno > totRec){
                System.out.println("\nInvalid Account Number ");
                valid=false;
            }
            if(valid==true){
                System.out.println("Account Number : "+accNo[acno]);
                System.out.println("Name : "+name[acno]);
                System.out.println("Account Type : "+accType[acno]);
                System.out.println("Balance Amount : "+balAmt[acno]);
            }
        }catch(IOException | NumberFormatException e){}
    }
    
    public void deposit(){
        String str;
        double amt;
        int acno;
        boolean valid=true;
        System.out.println("=====DEPOSIT AMOUNT=====");
        try{
            System.out.println("Enter Account No : ");
            str=obj.readLine();
            acno=Integer.parseInt(str);
            if(acno < min_lim || acno > totRec){
                System.out.println("Invalid Account Number ");
                valid=false;
            }
            if(valid==true){
                System.out.print("Enter Amount you want to Deposit : ");
                str=obj.readLine();
                amt=Double.parseDouble(str);
                balAmt[acno]=balAmt[acno]+amt;
                System.out.println("After Updation...");
                System.out.println("Balance Amount : "+balAmt[acno]);
            }
        }catch(IOException | NumberFormatException e){}
    }
    
    public void withdraw(){
        String str;
        double amt,checkamt;
        int acno;
        boolean valid=true;
        System.out.println("=====WITHDRAW AMOUNT=====");
        try{
            System.out.println("Enter Account No : ");
            str=obj.readLine();
            acno=Integer.parseInt(str);
            if(acno < min_lim || acno > totRec){
                System.out.println("\nInvalid Account Number \n");
                valid=false;
            }
            if(valid==true){
                System.out.println("Balance is : "+balAmt[acno]);
                System.out.print("Enter Amount you want to withdraw : ");
                System.out.flush();
                str=obj.readLine();
                amt=Double.parseDouble(str);
                checkamt=balAmt[acno]-amt;
                if(checkamt >= min_bal){
                    balAmt[acno]=checkamt;
                    System.out.println("\nAfter Updation...");
                    System.out.println("Account Number : "+acno);
                    System.out.println("Balance Amount : "+balAmt[acno]+" ");
                }
                else{
                    System.out.println("\nAs per Bank Rule you should maintain minimum balance of Rs 500");
                }
            }
        }catch(IOException | NumberFormatException e){}
    }
}

    

