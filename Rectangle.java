import java.util.*;

 class Area_inheritance {
    int base,height;
    void initialize(){

    base = 4;
    height =5;}
}
class Triangle extends Area_inheritance {
    void Area(){
        initialize();
        System.out.printf("Area=%.2f \n",(0.5*base*height));
    }
}
public class Rectangle extends Area_inheritance{
    void Area(){
        initialize();
        System.out.printf("Area=%d \n",(base*height));
    }
    public static void main(String[]args){
        Triangle figure1=new Triangle();
        Rectangle figure2=new Rectangle();
        figure1.Area();
        figure2.Area();
    }
}
