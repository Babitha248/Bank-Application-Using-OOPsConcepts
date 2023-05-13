package test;

public class Withdraw implements Transaction {

	@Override
	public void process(int amt) {
		if(amt<=bc.bal) {
			System.out.println("Amt WithDrawn: "+amt);
			bc.bal=bc.bal-amt;
			System.out.println("Balance amt:  "+bc.getBalance());

			System.out.println("Transaction Completed...");

			}else {
			System.out.println("Insufficient fund...");
			}
	}

}
