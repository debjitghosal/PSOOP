package Constructor;
import java.util.*;
import java.lang.*;
class Account
{
	double bal;
	double rate;
	double min_bal;
	Account(double bal,double rate)
	{
		this.bal=bal;
		this.min_bal=1000;
		this.rate=rate;
	}
	Account(double min_bal)
	{
		this.bal=1000;
		this.min_bal=min_bal;
		this.rate=7.0;
	}
	Account(double bal,double rate,double min_bal)
	{
		this.bal=bal;
		this.min_bal=min_bal;
		this.rate=rate;
	}
	Account()
	{
		this.bal=1000;
		this.min_bal=1000;
		this.rate=7.0;
	}
	public void withdraw()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount you want to withdraw:");
		double withdraw=sc.nextDouble();	
		if(withdraw<bal && (bal-withdraw)>=min_bal)
		{
			bal-=withdraw;
			System.out.println("Cash withdrwal sucessfully done. Your balance is now "+bal);
		}
		else if(withdraw>bal)
		{
			System.out.println("Insufficient balance.");
		}
		else if(withdraw<bal && (bal-withdraw)<min_bal)
		{
			System.out.println("Balnce after withdrawal less than minimum required balance. Withdrwal failed.");
		}
	}
	public void deposit()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount you want to deposit:");
		double deposit=sc.nextDouble();	
		bal+=deposit;
		System.out.println("Cash deposit sucessfully done. Your balance is now "+bal);
	}
	public void ci()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of years you want to deposit:");
		int t=sc.nextInt();
		double bal_after = bal*Math.pow((1+(rate/100)),t);
		System.out.println("Your balance after "+t+"years will be "+bal_after);
	}
	public void display()
	{
		System.out.println("Your balance is:"+bal);
		System.out.println("ROI is:"+rate);
	}
}


class Interface
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Open new account\n2.Account activities\n3.Exit");
		int ch1=sc.nextInt();
		Account acc;
		switch (ch1)
		{
			case 1:
			{
				System.out.println("Enter the type of account you want:");
				System.out.println("1.Savings\n2.Current\n3.Exit");
				int ch2=sc.nextInt();
				switch (ch2)
				{
					case 1:
					{
						acc=new Account();
						System.out.println("Account created sucessfully.");
						break;
					}
					case 2:
					{
						System.out.println("what rate of intrest do you want?");
						double rate=sc.nextDouble();
						acc=new Account(rate);
						break;
					}
					case 3:
					{
						break;
					}
					default:System.out.println("invalid input");
						break;
				}
				
			}
			case 2:
			{
				System.out.println("Enter your balance:");
				double balance=sc.nextDouble();
				System.out.println("Enter your rate:");
				double rate=sc.nextDouble();
				acc=new Account(balance,rate);
				System.out.println("1.Withdraw\n2.Deposit\n3.calculate CI\n 4.exit");
				int ch3=sc.nextInt();
				switch (ch3)
				{
					case 1:
					{
						acc.withdraw();
						break;
					}
					case 2:
					{
						acc.deposit();
						break;
					}
					case 3:
					{
						acc.ci();
						break;
					}
					case 4:
					{
						break;
					}
					default:System.out.println("invalid input");
						break;
				}
			}
			case 3:
			{
				break;
			}
			default:System.out.println("invalid input");
				break;
		}
	}
}
