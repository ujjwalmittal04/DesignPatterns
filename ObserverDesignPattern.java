
import java.util.ArrayList;
import java.util.List;
import java.lang.String;


interface StocksObservable{
    
   
    void add(IStocksObserver obj);
    String getDescription();
    void remove(IStocksObserver obj);
    void notifySubscribers();
    void setUpdatedQuantity(int newQuantityAdded);
    int getQuantity();
    
}

class IphoneObservable implements StocksObservable{
    
    public List<IStocksObserver> observerList = new ArrayList<>();
    public int capacity = 0;
    
    public void add(IStocksObserver obj){
        observerList.add(obj);
    }
    
    public String getDescription(){
        return ("Iphone");
    }
    
    public void notifySubscribers(){
        
        for(IStocksObserver obj : observerList){
            
           obj.update();
        }
    }
    
    public void remove(IStocksObserver obj){
        observerList.remove(obj);
    }
    
    public void setUpdatedQuantity(int newQuantityAdded){
        
         capacity = capacity + newQuantityAdded;
         if(capacity == 0 || capacity == newQuantityAdded){
            notifySubscribers();
        }
    }
    
    public int getQuantity(){
        return capacity;
    }
    
}


interface IStocksObserver{
    
    void update();
}

class EmailNotificationObserver implements IStocksObserver{
    
    String emailId;
    StocksObservable obj;
    
     EmailNotificationObserver(String email , StocksObservable obs){
         this.emailId = email;
         this.obj = obs;
     }
     
     public void update(){
        
        if(obj.getQuantity() == 0){
            System.out.println("Stocks empty for "  + obj.getDescription() + " and email is sent to emailId " + this.emailId);
        }
        else{
            System.out.println("Stocks added to " + obj.getQuantity() + " for "  + obj.getDescription() + " and email is sent to emailId " + this.emailId);
        }
    }
}

class MessageNotificationObserver implements IStocksObserver{
    
    public String phoneNumber;
    public StocksObservable obj;
    
     MessageNotificationObserver(String phoneNumber , StocksObservable obs){
         this.phoneNumber = phoneNumber;
         this.obj = obs; 
     }
     
    public void update(){
        
        if(obj.getQuantity() == 0){
            System.out.println("Stocks empty for "  + obj.getDescription() + " and message is sent to mobile no " + this.phoneNumber);
        }
        else{
            System.out.println("Stocks added to " + obj.getQuantity() + " for "  + obj.getDescription() + " and message is sent to mobile no " + this.phoneNumber);
        }
    }
}



class HelloWorld {
    public static void main(String[] args) {
       
         StocksObservable obsvble = new IphoneObservable();
        
        
        IStocksObserver obs1 = new MessageNotificationObserver("9627725959",obsvble);
         IStocksObserver obs2 = new MessageNotificationObserver("9897259812",obsvble);
          IStocksObserver obs3 = new EmailNotificationObserver("ujjwalm12345@gmail.com",obsvble);
           IStocksObserver obs4 = new EmailNotificationObserver("ujjwalmittalyoyo@gmail.com",obsvble);
           
          
           obsvble.add(obs1);
           obsvble.add(obs2);
           obsvble.add(obs3);
           obsvble.add(obs4);
           
           obsvble.setUpdatedQuantity(20);
           obsvble.setUpdatedQuantity(50);
           obsvble.setUpdatedQuantity(56);
           obsvble.setUpdatedQuantity(-126);
           obsvble.setUpdatedQuantity(30);
    }
}
