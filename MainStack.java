
/**
 * 
 */
package com.assignment.myPack;

/**
 * @author DivyaVipin
 *
 */
class StackOverFlowException extends Exception
{
	String exceptionMessage;
	StackOverFlowException(String message) {
    	exceptionMessage=message;
    }
    public String toString(){ 
       return exceptionMessage;
    }
}
class FixedStack implements Stack
{

	int fixedArray[];
	int top;
	int size;
	FixedStack(int size)
	{
		this.fixedArray= new int [size];
		this.top=-1;
		this.size=size;
	}
	@Override
	public void push(int l) {
		// TODO Auto-generated method stub
		
		if(this.top == this.size-1)
		{
			try {
				throw new StackOverFlowException("Stack overflow");
			} catch (StackOverFlowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
		fixedArray[++top]=l;
		
		System.out.println("Added StackElements : "+l);
		}
		
	}

	@Override
	public int pop() {
		// TODO Auto-generated method stub
		if (top < 0){

			System.out.println("Stack Underflow!");

			return 0;

		} else {

			return fixedArray[top--];

		}
	}
	
}
class VariableStack implements Stack
{
	int varArr[];
	int size;
	int top;
VariableStack(int size)
{
	this.varArr=new int[size];
	this.top=-1;
	this.size=size;
}
	@Override
	public void push(int l) {
		// TODO Auto-generated method stub
		if(this.top == this.size - 1){
			System.out.println(("Stack is full. Increasing the capacity."));
			increaseCapacity();
		}
		System.out.println("Adding: "+l);
			varArr[++top] =l;
	
		
	}
	private void increaseCapacity()
	{
		int[] newStack = new int[this.size*2];
		for(int i=0;i<size;i++){
		newStack[i] = this.varArr[i];
		}
		this.varArr = newStack;
		this.size = this.size*2;
	
	}

	@Override
	public int pop() {
		// TODO Auto-generated method stub
		if (top < 0){

			System.out.println("Stack Underflow!");

			return 0;

		} else {

			return varArr[top--];

		}
	}
	
}
public class MainStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("FIXED STACK");
		System.out.println("*************");
		FixedStack fixed=new FixedStack(5);
		for(int i=0;i<6;i++)
			{
				fixed.push(i);
			}
		System.out.println("VARIABLE STACK");
		System.out.println("*************");
		VariableStack variable=new VariableStack(5);
		for(int t=0;t<6;t++)
			{
				variable.push(t);
			}

	}

}
