package oop.core;

@DevelopedBy("Michael Langowski")
public aspect ObjectConstruction {

	pointcut objectConstruction() : (initialization(oop..new(..)) && !initialization(oop.core.ObjectConstruction.new(..)));

	pointcut mainMethodCall() : target(Test) && execution(public static void main(String[]));
	
	private int objCount = 0;
	
	@DevelopedBy("Michael Langowski")
	after() : objectConstruction(){
		//System.out.println("ASPECTJ: After new object creation: " + thisJoinPoint);
		objCount++;
	}
	
	@DevelopedBy("Michael Langowski")
	after() : mainMethodCall(){
		System.out.println("Object construction aspect: Es wurden insgesamt " + objCount + " neue Objekte angelegt!");
	}

}
