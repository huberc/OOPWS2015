package oop.core;

@DevelopedBy("Michael Langowski")
public aspect ObjectConstruction {

   pointcut objectConstruction() : (initialization(oop..new(..)) && !initialization(oop.core.ObjectConstruction.new(..)));
   
   @DevelopedBy("Michael Langowski")
   after() : objectConstruction(){
       System.out.println("ASPECTJ: After new object creation: " + thisJoinPoint);
   }
   
}
