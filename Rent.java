import java.util.Scanner;

class Vehicle{
String vehicleNumber;
    String brand;
    double rentperday;
    Vehicle( String vehicleNumber,String brand,double rentperday){
this.vehicleNumber=vehicleNumber;
this.brand=brand;
this.rentperday=rentperday;
    }

double calculateRent(int actualday,int planday){
return (rentperday*planday);
}
void display(){
  System.out.println("Brand : "+brand);
    System.out.println("vehicle number : "+vehicleNumber);
  
}
}
//subclass for car
class Car extends Vehicle{

    Car(String vehicleNumber,String brand,double rentperday){
        super(vehicleNumber, brand, rentperday);
    }
    //overriding means run method with present value,
@Override
    double calculateRent(int actualday,int planday){
      if(actualday>planday){
        System.out.println("Extra days panalty: 500per days ");
          return (rentperday*actualday)+(actualday-planday)*500;
      }
      else{
        return (rentperday*planday);
      }
    }
}
//sub class for bike
class Bike extends Vehicle{
    Bike(String vehicleNumber,String brand,double rentperday){
        super(vehicleNumber, brand, rentperday);
    }
     @Override
    double calculateRent(int actualday,int planday){
        if(actualday>planday){
            System.out.println("Extra days panalty: 150per day");
return (rentperday*actualday)+(actualday-planday)*150;
        }
        else{
        return (rentperday*planday);
        }
    }
}
//main class starts
public class Rent{
    public static void main(String args[]){
        //taking input
       Scanner sc=new Scanner(System.in);
        String carbrand=sc.nextLine(); 
       String carnumber=sc.nextLine();
       
        double carrentperday=sc.nextDouble();
        sc.nextLine();

        Vehicle v1=new Car(carnumber,carbrand,carrentperday);
       
        String bikebrand=sc.nextLine();
         String bikenumber=sc.nextLine();
       
        double bikerentperday=sc.nextDouble();

        Vehicle v2=new Bike(bikenumber,bikebrand,bikerentperday);
 
      
        int planday=sc.nextInt();
  int actualday=sc.nextInt();

  if(planday<=0||actualday<=0){
    System.out.println("Inavild day! days not be zero or negative.");
    return ;
  }
        System.out.println("Car Details:");
        v1.display();
       if(actualday>planday){
           System.out.println("planday = "+planday);
         System.out.println("Car Rent for "+ actualday +" days: "+v1.calculateRent(actualday,planday));
       }
       else{
         System.out.println("Car Rent for "+ planday +" days: "+v1.calculateRent(actualday,planday));
       }
System.out.println(" ");
System.out.println("Bike Details:");
v2.display();
if(actualday>planday){
    System.out.println("planday = "+planday);
    System.out.println("Bike Rent for "+ actualday +" days: "+v2.calculateRent(actualday,planday));
       
}
else{
  
    System.out.println("Bike Rent for "+ planday +" days: "+v2.calculateRent(actualday,planday));
       
}
    }
}