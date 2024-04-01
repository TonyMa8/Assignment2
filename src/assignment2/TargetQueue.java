package assignment2;

public class TargetQueue extends MyQueue<Position>{
    private MyStack<String> info;

    public TargetQueue(){
        super();
        this.info = new MyStack<String>();
    }
    public void clear(){
        this.info.clear();
        super.clear();
    }
    public void addTargets(String str){
        String num = "";
        boolean needdot = false;
        int prevdot = 0;
       for (int i = 0 ; i<str.length(); i++){
           if (str.charAt(i) == '('){
               if (needdot){
                   if (prevdot != 1){
                       throw new IllegalArgumentException("did not use dot to link positions together or too many dots used ");
                   }
               }
               if (this.info.isEmpty() && num.isEmpty()){
                   this.info.push(String.valueOf(str.charAt(i)));
                   prevdot = 0;
               }else{
                   throw new IllegalArgumentException("Stack & num not empty when encountering a (");
               }
           }
           else if (Character.isDigit(str.charAt(i))){
               num += str.charAt(i);
           }

           else if (str.charAt(i) == ','){

               if (num.isEmpty()){
                   throw new IllegalArgumentException("rip");
               }
               this.info.push(num);
               this.info.push(String.valueOf(str.charAt(i)));
               num="";
           }
           else if (str.charAt(i) == ')'){
               String str1;
               String str2;
               String str3;

               if (this.info.getSize() != 3){
                   throw new IllegalArgumentException("Missing elements");
               }

               if (num.equals("")){
                   throw new IllegalArgumentException("Missing y value");
               }

               str1 = this.info.pop(); //should be ,
               str2 = this.info.pop(); //should be int, dont need to check since already checking if its a digit, digit+digit always int
               str3 = this.info.pop();

               if (str1.equals(",") && str3.equals("(")){
                   int xcoord = Integer.parseInt(str2);
                   int ycoord = Integer.parseInt(num);
                   Position newPos = new Position(xcoord, ycoord);
                   super.enqueue(newPos);
               }
               else{
                   throw new IllegalArgumentException("Stack elements are not in order");
               }

               this.info.clear();
               num="";
               needdot = true;
           }
           else if (str.charAt(i) == '.'){
               if (!(this.info.isEmpty()) || !num.equals("")){
                   throw new IllegalArgumentException("Stack elements and nums are not empty");
               }
               if (prevdot == 1){
                   throw new IllegalArgumentException("too many dots");
               }
               prevdot +=1;

           }
           else {
               throw new IllegalArgumentException("Invalid character");
           }
       }
        if (!this.info.isEmpty()) {
            throw new IllegalArgumentException("Incomplete position string");
        }
    }
}
