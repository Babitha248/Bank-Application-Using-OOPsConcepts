package test;

public interface Transaction {
	
	public static final Balance bc=new Balance();
	
	public void process(int amt);

}
