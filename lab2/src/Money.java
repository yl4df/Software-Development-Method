//Defines some nonnegative amount of money
//NEEDS MODIFICATION

public class Money
{
	private long dollars;	//A number of dollars	
	private long cents;		//A number of cents

	//Constructor creates a Money object using the amount of money in 
	//dollars and cents represented with a decimal number
	public Money(double amount)
	{
		if (amount < 0)
		{
			System.out.println(
					"Error: Negative amounts of money are not allowed.");
			System.exit(0);
		}
		else
		{
			long allCents = Math.round(amount*100);
			dollars = allCents/100;
			cents = allCents%100;
		}
	}

	//MUST COMPLETE THIS
	//Copy constructor that uses one Money object to make 
	//a deeply copied Money object
	public Money(Money m)
	{
      this.dollars = m.dollars;
      this.cents = m.cents;
	}

	//Adds the calling Money object to the parameter Money object
	public Money add(Money otherAmount)
	{
		Money sum = new Money(0);
		sum.cents = this.cents + otherAmount.cents;
		long carryDollars = sum.cents/100;
		sum.cents = sum.cents%100;
		sum.dollars = this.dollars
				+ otherAmount.dollars + carryDollars;
		return sum;
	}

	//Subtracts the parameter Money object from the calling Money 
	//object and returns the difference
	public Money subtract (Money amount)
	{
		Money difference = new Money(0);
		if (this.cents < amount.cents)
		{
			this.dollars = this.dollars - 1;
			this.cents = this.cents + 100;
		}
		difference.dollars = this.dollars - amount.dollars;
		difference.cents = this.cents - amount.cents;
		return difference;
	}

	//Compares instance variable of the calling object 
	//with the parameter object.  It returns -1 if the 
	//dollars and the cents of the calling object are 
	//less than the dollars and the cents of the parameter
	//object, 0 if the dollars and the cents of the calling
	//object are equal to the dollars and cents of the 
	//parameter object, and 1 if the dollars and the cents
	//of the calling object are more than the dollars and 
	//the cents of the parameter object.
	public int compareTo(Money amount)
	{
		int value;
		if(this.dollars < amount.dollars)
		{
			value = -1;
		}
		else if (this.dollars > amount.dollars)
		{
			value = 1;
		}
		else if (this.cents < amount.cents)
		{
			value = -1;
		}
		else if (this.cents > amount.cents)
		{
			value = 1;
		}
		else
		{
			value = 0;
		}
		return value;
	}

	//MUST COMPLETE THIS
	public boolean equals(Object obj)
	{
     if ( obj != null && obj instanceof Money) {
    	 
    	 Money otherObj = (Money) obj;
    	 if ( this.dollars == otherObj.dollars && this.cents == otherObj.cents) {
    		 return true;
    	 }
     }
     return false;
	}

	//MUST COMPLETE THIS
	public String toString()
	{
     if(this.cents <10) {
    	 return "$"+this.dollars+".0"+this.cents;
     }
     else {
    	 return "$"+this.dollars+"."+this.cents;
     }
	}
}