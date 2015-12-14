package oop.core;

public aspect ObjectConstructionAspect {

   pointcut objectConstruction() : (initialization(oop..new(..)) && !initialization(oop.core.ObjectConstructionAspect.new(..)));
   
   after() : objectConstruction(){
       System.out.println("New object created!");
   }
   
}
