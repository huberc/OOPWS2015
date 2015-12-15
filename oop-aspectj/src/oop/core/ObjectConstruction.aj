package oop.core;

public aspect ObjectConstruction {

   pointcut objectConstruction() : (initialization(oop..new(..)) && !initialization(oop.core.ObjectConstruction.new(..)));
   
   after() : objectConstruction(){
       System.out.println("ASPECTJ: After new object creation: " + thisJoinPoint);
   }
   
}
