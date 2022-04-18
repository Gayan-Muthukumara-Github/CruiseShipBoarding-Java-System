
package cruiseshipboarding_classes_solution;


public class Cabin {
    private String cabin_name;

    public Passenger getP1() {
        return p1;
    }

    public void setP1(Passenger p1) {
        this.p1 = p1;
    }

    Passenger p1;

    public Passenger getP2() {
        return p2;
    }

    public void setP2(Passenger p2) {
        this.p2 = p2;
    }

    public Passenger getP3() {
        return p3;
    }

    public void setP3(Passenger p3) {
        this.p3 = p3;
    }

    Passenger p2;
    Passenger p3;
    private String t_expenses;

    public String getT_expenses() {
        return t_expenses;
    }

    public void setT_expenses(String t_expenses) {
        this.t_expenses = t_expenses;
    }



    public String getCabin_name() {
        return cabin_name;
    }

    public void setCabin_name(String cabin_name) {
        this.cabin_name = cabin_name;
    }


    public Cabin() {

    }



    public Cabin(String name,Passenger passenger1,Passenger passenger2,Passenger passenger3) {
        this.cabin_name= name;
        this.p1=passenger1;
        this.p2=passenger2;
        this.p3=passenger3;
    }
    public Cabin(String name,Passenger passenger1,Passenger passenger2,Passenger passenger3,String expenses) {
        this.cabin_name= name;
        this.p1=passenger1;
        this.p2=passenger2;
        this.p3=passenger3;
        this.t_expenses=expenses;
    }

   
    
    
    
    
    
}

