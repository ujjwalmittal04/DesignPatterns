interface DriverStrategy{
    
    void drive();
}

class NormalDriveStrategy implements DriverStrategy{
    
    public void drive(){
        
        System.out.println("This is the strategy or business logic for driving vehicle normaly");
    }
}

class SpecialDriveStrategy implements DriverStrategy {
     
    public void drive(){
        
        System.out.println("This is the strategy or business logic for driving vehicle specially");
    }
    
}

class Vehicle{
    
    public DriverStrategy strategy;
    
    Vehicle(DriverStrategy obj){
        
        this.strategy = obj;
        
    }
    
    public void drives(){
        strategy.drive();
    }
    
}


class OffRoadVehicle extends Vehicle{
    
    OffRoadVehicle(){
        // this.strategy = new NormalDriveStrategy();
        super(new NormalDriveStrategy());
    }
}


class OnRoadVehicle extends Vehicle{
    
    OnRoadVehicle(){
        //  this.strategy = new NormalDriveStrategy();
         super(new NormalDriveStrategy());
        
    }
    
}


class MotorVehicle extends Vehicle{
    
     MotorVehicle(){
         //this.strategy = new SpecialDriveStrategy();
         super(new SpecialDriveStrategy());
         
        
    }
    
}

class CarVehicle extends Vehicle{
    
     CarVehicle(){
        //  this.strategy = new SpecialDriveStrategy();
         super(new SpecialDriveStrategy());
        
    }
    
}




class HelloWorld {
    public static void main(String[] args) {
        // let us suppose OffRoad Vehicle and OnRoad vehicle have 
       //  same  implementation of Drive strategy 
       
       
       // let us suppose MotorVehicle and Car will have same strategy 
        
        Vehicle vehicle1 = new OffRoadVehicle();
        vehicle1.drives();
        
        Vehicle vehicle2 = new OnRoadVehicle();
        vehicle2.drives();
        
        Vehicle vehicle3 = new MotorVehicle();
        vehicle3.drives();
        
        Vehicle vehicle4 = new CarVehicle();
        vehicle4.drives();
    }
}
