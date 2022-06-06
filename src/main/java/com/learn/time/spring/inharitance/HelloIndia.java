package com.learn.time.spring.inharitance;

//public class HelloIndia {
public class HelloIndia extends HelloIndiaParent {
   private HelloUkraine helloUkraine;

   public HelloIndia(HelloUkraine helloUkraine) {
      this.helloUkraine = helloUkraine;
   }

   private String message1;
   private String message2;
   private String message3;

   public void setMessage1(String message){
      this.message1 = message;
   }
   public void setMessage2(String message){
      this.message2 = message;
   }
   public void setMessage3(String message){
      this.message3 = message;
   }
   public void getMessage1(){
      System.out.println("India Message1 : " + message1);
   }
   public void getMessage2(){
      System.out.println("India Message2 : " + message2);
   }
   public void getMessage3(){
      System.out.println("India Message3 : " + message3);
   }

//   private String message1;
//   private String message2;
//   private String message3;
   private String message4;

//   public void setMessage1(String message){
//      this.message1 = message;
//   }
//   public void setMessage2(String message){
//      this.message2 = message;
//   }
//   public void setMessage3(String message){
//      this.message3 = message;
//   }
   public void setMessage4(String message){
      this.message4 = message;
   }
//   public void getMessage1(){
//      System.out.println("India Message1 : " + message1);
//   }
//   public void getMessage2(){
//      System.out.println("India Message2 : " + message2);
//   }
//   public void getMessage3(){
//      System.out.println("India Message3 : " + message3);
//   }
   public void getMessage4(){
      System.out.println("India Message34 : " + message4);
   }

   public void setHelloUkraine(HelloUkraine helloUkraine) {
      this.helloUkraine = helloUkraine;
   }
}