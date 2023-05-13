package maccess;
import test.*;
import java.util.Scanner;

public class UsingAnonymousBankMainClass {
		public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
		 int count=0;
		 xyz:
		 while(true)
		 {
			 System.out.println("Enter the pinNo:");
			 int pinNo = s.nextInt();
			 PinNoLength pnl = new PinNoLength();
			 int len = pnl.length(pinNo);
			 if(len==4) {
			 CheckPinNo cpn = new CheckPinNo();
			 boolean k = cpn.verify(pinNo);
			 if(k) {
			 System.out.println("===Choice===");
			 System.out.println("1.Withdraw\n2.Deposite");
			 System.out.println("Enter the choice");
			 
			 switch(s.nextInt()) {
			 case 1:
				 System.out.println("Enter the Amount:");
				 int a1=s.nextInt();
				 if(a1>=0 && a1%100==0) {
					 //Anonymous InnerClass as implementation class 
					 Transaction wd = new Transaction()
					 {
					 public void process(int amt) {
						 if(amt<=bc.bal) {
							 System.out.println("Amt WithDrawn:"+amt);
							 bc.bal=bc.bal-amt;
							 System.out.println("Balance amt:"+bc.getBalance());
							 System.out.println("Transaction Completed...");
					 }
						 else {
							 System.out.println("Insufficient fund..");
						 }
					 }
					 
					 };
					     wd.process(a1);
				 }
				 else {
					 System.out.println("Invalid amount...");
				 }
				 break xyz;//stop loop
			
			 case 2:
				 System.out.println("Enter the amt:");
				 int a2 = s.nextInt();
				 if(a2>0 && a2%100==0) {
					//Anonymous InnerClass as implementation class
					  Transaction dp = new Transaction()
					  {
					  public void process(int amt) {
					  System.out.println("Amt deposited:"+amt);
					  bc.bal=bc.bal+amt;
					 System.out.println("Balance amt:"+bc.getBalance());
					 System.out.println("Transaction Completed...");
				 }
			 };
			 dp.process(a2);
				 }else {
					 System.out.println("Invalid amount...");
				 }
				 break xyz;
				 default:
					 System.out.println("Invalid Choice...");
					 break xyz;
					 }//end of switch
			 }else {
				 System.out.println("InCorrect pinNo...");
				 count++;
				 }
				 }else {
				 System.out.println("Invalid pinNo...");
				 count++;
				 }
			 if(count==3) {
				 System.out.println("Transaction blocked..");
				 break;//stop loop
			 }
		 }//end of loop
		}
		
	}

