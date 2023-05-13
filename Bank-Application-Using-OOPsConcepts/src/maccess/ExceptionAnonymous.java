package maccess;
import java.util.*;

import test.CheckPinNo;
import test.PinNoLength;
import test.TransactionAnmsLambda;
@SuppressWarnings("serial")
public class ExceptionAnonymous extends Exception {
	
	public ExceptionAnonymous(String msg)
	{
		super(msg);
	}
	public static void main(String []args)
	{
		Scanner s=new Scanner(System.in);
		int count=0;
		xyz:
			
		while(true)
		{
			try 
			{
				System.out.println("Enter the pinNumber: ");
			    int pinNo=s.nextInt();
			    
			    PinNoLength pnl=new PinNoLength();
			    int len=pnl.length(pinNo);
			    
			    if(len!=4)//Exception-Condition
			    {
			    	ExceptionAnonymous de=new ExceptionAnonymous("Invalid pinNo: ");
			    	throw de;
			    	
			    }
			    
			    CheckPinNo cpn=new CheckPinNo();
			    boolean k= cpn.verify(pinNo);
			    
			    if(!k)//Exception Condition
			    {
			    	ExceptionAnonymous de=new ExceptionAnonymous("Invalid pinNo: ");
			    	throw de;		
			    }
			    
			    System.out.println("====Choice====");
			    System.out.println("1.WithDraw\n2.Deposite");
			    System.out.println("Enter the choice");
			    
			    switch(s.nextInt())
			    {
			    
			    case 1: 
			    	System.out.println("Enter the amount: ");
			    	int a1=s.nextInt();
			    	
			    	if(!(a1>=0 && a1%100==0))//Exception Condition
			    	{
			    		ExceptionAnonymous de=new ExceptionAnonymous("invalid amount");
			    				throw de;
			    	}
			    
			    	//Anonymous InnerClass
			    	
			    	TransactionAnmsLambda wd= new TransactionAnmsLambda()
			    	{
			    		public void process(int amt)throws Exception{
			    		try 
			    		{
			    		 if(amt>b.bal)//Exception condition
			    		  {
			    			Exception wd=new Exception("insufficicent fund");
			    			throw wd;
			    		  }
			    		 System.out.println("amt WithDrawn:"+amt);
			    		 b.bal=b.bal-amt;
			    		 System.out.println("Balance amount: "+b.getBalance());
			    				
			    		}//end of try
			    		catch(Exception wd)
			    		{
			    			throw wd;//Exception re-throwing
			    		}
			    	}
			    		
			    	};
			    	wd.process(a1);
			    	break xyz;//stop loop
			    	
			    case 2:
			    	System.out.println("Enter the amount:");
			    	int a2=s.nextInt();
			    	
			    	if(!(a2>0 && a2%100==0))//Exception Condition
			    	{
			    		ExceptionAnonymous de=new ExceptionAnonymous("Invalid amt");
			    		throw de;
			    	}
			    	
			    	//Anonymous Class
			    	
			    	TransactionAnmsLambda dp=new TransactionAnmsLambda() 
			    	{
			    		public void process(int amt) 
			    		{
			    		System.out.println("Amt deposited: "+amt);
			    		b.bal=b.bal+amt;
			    		System.out.println("Balance amt:"+b.getBalance());
			    		System.out.println("Transaction Completed...");
			    		}
			    	};
			    	dp.process(a2);
			    	break xyz;//Stop loop
			    	
			    	default : 
			    		System.out.println("invalid choice...");
			    		break xyz;
			    		
			     }//end of Switch case
				
			}//end of try
			
			catch (ExceptionAnonymous de)
			{
				System.out.println(de.getMessage());
				if(de.getMessage().equals("Invalid amount.."))
				{
					break; //stop the loop
				}
				count++;
				if(count==3)
				{
					System.out.println("Transaction Blocked");
					break;//stop the loop
				}
			}
			
			catch(InputMismatchException ime)
			{
			   System.out.println("Only Interger value");
			   break;//stop the loop
			}
			catch(Exception ob) 
			{
				System.out.println(ob.getMessage());
				break; //stop the loop
			}
		}//end of while loop
	}
	
	

}
