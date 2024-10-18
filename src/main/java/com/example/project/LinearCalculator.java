package com.example.project;
public class LinearCalculator{
    //FOR EXTRA CREDIT 
    //you should copy and paste all of your code from the LinearCalculator class
    // but NOT printInfo(). Please update it below

    //x1 is first x value for coordinate1//
    private int x1;
    //x2 is first x value for coordinate2//
    private int x2;
    //y1 is first y value for coordinate1//
    private int y1;
    //y1 is first y value for coordinate2//
    private int y2;



    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String point1,String point2){ // <--add 2 string parameters to this constructor
      //find the string value for the point1 coordinates which will be x1 and y1//
      
      //needed index of first para and then comma and the last paraentheses in order to isolate the 2 points x1 and y1//
      int firstParaPoint1 = point1.indexOf("(");
      int commaPoint1 = point1.indexOf(",");
      int lastParaPoint1 = point1.indexOf(")");
      String x1String = point1.substring(firstParaPoint1 + 1, commaPoint1);
      String y1String= point1.substring(commaPoint1+1, lastParaPoint1);

       //find the string value for the point1 coordinates which will be x2 and y2//
       
        //needed index of first para and then comma and the last paraentheses in order to isolate the 2 points x2 and y2//
       int firstParaPoint2 = point2.indexOf("(");
       int commaPoint2  = point2.indexOf(",");
       int lastParaPoint2  = point2.indexOf(")");
       String x2String = point2.substring(firstParaPoint2  + 1, commaPoint2 );
       String y2String= point2.substring(commaPoint2 +1, lastParaPoint2 );

       //changes the x1,y1,x2,y2 values all to integers//
       x1 = Integer.parseInt(x1String);
       y1 = Integer.parseInt(y1String);
       x2 = Integer.parseInt(x2String);
       y2 = Integer.parseInt(y2String);
       //learned this from the google slide posted on how to convert the strings into integers//
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
   //getter method so non-void//
    public int getX1(){
         return x1;
    }
    //getter method so non-void//
    public int getY1(){
        return y1;
    }
    //getter method so non-void//
    public int getX2(){
        return x2;
    }
    //getter method so non-void//
    public int getY2(){
        return y2;
    }
    //setter method so void method//
    public void setX1(int newX1){
        x1 = newX1;

    }
    //setter method so void method//
    public void setY1(int newY1){
        y1 = newY1;
    }
    //setter method so void method//
    public void setX2(int newX2){
        x2 = newX2;
    }
    //setter method so void method//
    public void setY2(int newY2){
        y2 = newY2;
    }
    //the setter method basically updates the modifies the object state//

    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double distance = Math.sqrt(Math.pow((double)x2-x1,2) + Math.pow((double) y2-y1, 2));//I searched the internet for the formula of the distance and based on that made the equation//
        return  roundedToHundredth(distance);
         //learned math.sqrt and math.pow from the labs for unit2 which is helpful//
    }
    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        //checks to see if there is a y intercept and if not then returns -999.99 since if slope undefined then cannot find yint//
        double slope = slope();
        if (slope == -999.99){
            return -999.99;
        }
        //altered for formula from y=mx+b to b= y-(mx)//
        double yIntercept = y1 - (x1 * slope);
        //gotta round everything//
        return roundedToHundredth(yIntercept);
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        double numerator = ((double)y2 - y1);
        double denominator = ((double) x2 - x1);
        //created 2 seperate varibles called numerator and denominator so it is easier to find slope//
        //if denominator is 0 then it is undefined as anthing under 0 is undefined//
        if (denominator == 0){
            return -999.99;
        }
        //returns the slope formula basically//
        double slope = (double) numerator / denominator;
        slope = roundedToHundredth(slope);
        return slope;
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
       double slope = slope();
       double yIntercept = yInt();
    //slope is undefined which means the equation should return undefined//
    if (slope == -999.99) {
        return "undefined";
       }
    // y intercept is negative so it is the same thing and adds it on but as a negative//
     if (yIntercept < 0) {
        return "y=" + slope + "x" + yIntercept;     
    }
    // if y intercept is 0 then no need to add the y intercept//
    if (yIntercept == 0) {
        return "y=" + slope + "x";
    }
    //slope is 0 then just give the  interncept//
    if (slope == 0) {
        return "y=" + yIntercept;
    }
    //else it just returns the original formula without any problems//
    return "y=" + slope + "x+" + yIntercept;
    
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        //got this math.round from https://stackoverflow.com/questions/11701399/round-up-to-2-decimal-places-in-java //
        return Math.round(x * 100.0) / 100.0;
    }



    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1 + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation() ;
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\n" + findSymmetry();
        str += "\n" + Midpoint();
        return str;
    }
    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        double middleX;
        double middleY;

        //find the middle of both x and y points//
        middleX = ((double) x1 + x2) / 2;
        middleY = ((double) y1 + y2) / 2;
 
 
        // sorts the midpoint and finds if there are any symmetry
        // they are both 0 the middle of both then that means they are not only symmetric to the x but also the y axis//
        if (middleX == 0 && middleY == 0) {
            return "Symmetric about the origin";
        }
       //only to the y axis//
        else if(middleY == 0) {
            return "Symmetric about the x-axis";
        }
        //only to the x axis//
        else if(middleX == 0) {
            return "Symmetric about the y-axis";
        }
        //if nothing then there has to be no symetry//
        else {
            return "No symmetry";
        }
    }
 
 
    //Midpoint()->return a string
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        double middleX;
        double middleY;
        //start off the same way with the symmetry part but instead uses those middles to create the midpoint which the middle of 2 of those original coordinates//
        middleX = ((double) x1 + x2) / 2;
        middleY = ((double) y1 + y2) / 2;
 
 
        return "The midpoint of this line is: (" + middleX + "," + middleY + ")";
    }
 
 
 }
 




