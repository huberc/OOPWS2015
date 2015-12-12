package core;

public aspect ObjectConstructionAspect {

   pointcut objectConstruction() : initialization(..);
   
   after() : objectConstruction(){
       System.out.println("New object created!");
   }
   
}
