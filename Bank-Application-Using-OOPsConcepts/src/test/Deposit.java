package test;

public class Deposit implements Transaction {

	@Override
	public void process(int amt) {
		// TODO Auto-generated method stub
		System.out.println("Amt deposited: "+amt);
		bc.bal=bc.bal+amt;
		System.out.println("Balance Amt: "+bc.getBalance());
		System.out.println("Transaction Completed...");
		}
	}


