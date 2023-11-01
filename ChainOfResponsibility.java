
abstract class DenominationHandler{
    
    public DenominationHandler nextDenominationtHandler;
    
    public void addNextDenomination(DenominationHandler nextDenominationHandler){
        this.nextDenominationtHandler = nextDenominationHandler;
    }
    
    public abstract void handleAmount(int amount);
}


class PinkNoteHandler extends DenominationHandler{
    
    PinkNoteHandler(DenominationHandler nextDenomination){
        super.addNextDenomination(nextDenomination);
    }
    
    public void handleAmount(int amount){
        
        int count_Notes = amount / 2000;
        if(count_Notes > 0){
            System.out.println(count_Notes + " notes of 2000Rs");
        }
        if(amount % 2000 != 0) 
        this.nextDenominationtHandler.handleAmount(amount%2000);
    }
}

class GreyNoteHandler extends DenominationHandler{
    
    GreyNoteHandler(DenominationHandler nextDenomination){
        super.addNextDenomination(nextDenomination);
    }
    
    public void handleAmount(int amount){
        
        int count_Notes = amount / 500;
        if(count_Notes > 0){
            System.out.println(count_Notes + " notes of 500Rs");
        }
        if(amount % 500 != 0)
        this.nextDenominationtHandler.handleAmount(amount % 500);
    }
}

class PurpleNoteHandler extends DenominationHandler{
    
    PurpleNoteHandler(DenominationHandler nextDenomination){
        super.addNextDenomination(nextDenomination);
    }
    
    public void handleAmount(int amount){
        
        int count_Notes = amount / 100;
        if(count_Notes > 0){
            System.out.println(count_Notes + " notes of 100Rs");
        }
        if(amount % 100 != 0)
        this.nextDenominationtHandler.handleAmount(amount % 100);
    }
}



class HelloWorld {
    public static void main(String[] args) {
        
        DenominationHandler denominationHandler = new PinkNoteHandler(new GreyNoteHandler(new PurpleNoteHandler(null)));
        denominationHandler.handleAmount(7800);
         denominationHandler.handleAmount(7000);
          denominationHandler.handleAmount(10000);
            denominationHandler.handleAmount(400);
          
        
    }
}
       
         
