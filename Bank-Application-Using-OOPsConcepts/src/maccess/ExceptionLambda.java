package maccess;
import java.util.*;


import test.CheckPinNo;
import test.PinNoLength;
import test.TransactionAnmsLambda;
@SuppressWarnings("serial")
public class ExceptionLambda extends Exception {
	
	public ExceptionLambda(String msg)
	{
		super(msg);
	}
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		int count=0;
		xyz:
		
		while(true)
		{
			try
			{
				System.out.println("Enter the pinNo:");
				int pinNo=s.nextInt();
				
				PinNoLength pnl=new PinNoLength();
				int len= pnl.length(pinNo);
				
				if(len!=4)//Exception Condition
				{
					ExceptionLambda de=new ExceptionLambda("Invalid pin number");
					throw de;
				}
				
				CheckPinNo cpn=new CheckPinNo();
				boolean k=cpn.verify(pinNo);
				
				if(!k)//Exception Condition
				{
					ExceptionLambda de=new ExceptionLambda("Invalid pinNo");
					throw de;
				}
				
				System.out.println("====Chice====");
				System.out.println("1.WithDraw\n2.Deposit");
				System.out.println("Enter the choice");
				switch(s.nextInt())
				{
				case 1:
					System.out.println("Enter the amount:");
					int a1=s.nextInt();
					if(!(a1>=0 && a1%100==0))//Exception Condition
					{
						ExceptionLambda de=new ExceptionLambda("Invalid amt");
						throw de;
					}
					   //Lambda Expression Starts
					TransactionAnmsLambda wd= (int amt)->
					{
						try {
							if(amt>TransactionAnmsLambda.b.bal)//Exception Condition
							{
								Exception wd1 =new Exception("Insufficient fund");
								throw wd1;
				
							}
							System.out.println("Amt WithDrawn"+amt);
							TransactionAnmsLambda.b.bal=TransactionAnmsLambda.b.bal-amt;
							System.out.println("Balance amt:"+ TransactionAnmsLambda.b.getBalance());
							System.out.println("Transaction Completed");
						}//end of try
						
						catch(Exception wd1) {
							throw wd1;//Exception re-throwing
							
						}
					};
					wd.process(a1);
					break xyz;//Stop the loop
					
				case 2:
					System.out.println("Enter the amount");
					int a2=s.nextInt();
					if(!(a2>0 && a2%100==0))//Exception Condition
						{
						ExceptionLambda de=new ExceptionLambda("invalid Amount");
						throw de;
						}
					//Lambda Expression
					
					TransactionAnmsLambda dp= (int amt)->
					{
						System.out.println("Amount deposited"+amt);
						TransactionAnmsLambda.b.bal=TransactionAnmsLambda.b.bal+amt;
						System.out.println("Balance amt"+TransactionAnmsLambda.b.getBalance());
						System.out.println("Transaction Completed...");
					};
						dp.process(a2);
						break xyz;//Stop the loop
						
						default : 
							System.out.println("Invalid choice");
							break xyz;
				}
				
			}//end of try
			
			catch(ExceptionLambda de)
			{
				System.out.println(de.getMessage());
				if(de.getMessage().equals("Invalid amt"))
				{
					break; //stop the loop
				}
				
				count++;
				
				if(count==3)
				{
					System.out.println("Transaction blocked");
					break;//stop the loop
				}
			}
			
			catch(InputMismatchException ime)
			{
				System.out.println("Onlt integer value");
				break; //stop the loop
			}
			catch(Exception ob)
			{
				System.out.println(ob.getMessage());
				break; //stop the loop
			}
		}//end of loop
		
	}
}
