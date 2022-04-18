
package cruiseshipboarding_classes_solution;


public class Passenger {
    private String firstname;
    private String surname;
    private String expenses;

    public Passenger() {
    }

    public Passenger(String firstname, String surname, String expenses) {
        this.firstname = firstname;
        this.surname = surname;
        this.expenses = expenses;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getExpenses() {
        return expenses;
    }

    public void setExpenses(String expenses) {
        this.expenses = expenses;
    }

}
