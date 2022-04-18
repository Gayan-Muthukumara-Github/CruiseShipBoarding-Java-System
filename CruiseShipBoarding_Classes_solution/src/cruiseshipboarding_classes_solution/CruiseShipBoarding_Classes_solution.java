
package cruiseshipboarding_classes_solution;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class CruiseShipBoarding_Classes_solution {

    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        char control;

        Cabin c1=new Cabin();//4 objects for 4 counters
        Cabin c2=new Cabin();
        Cabin c3=new Cabin();
        Cabin c4=new Cabin();
        Cabin c5=new Cabin();//4 objects for 4 counters
        Cabin c6=new Cabin();
        Cabin c7=new Cabin();
        Cabin c8=new Cabin();
        Cabin c9=new Cabin();//4 objects for 4 counters
        Cabin c10=new Cabin();
        Cabin c11=new Cabin();
        Cabin c12=new Cabin();
        Cabin[] Cabins ={c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12};
        initialise(Cabins); //better to initialise in a procedure

        ArrayList<Cabin> Rest=new ArrayList<>();
        
        while ( true ){
            System.out.println("\n--boarding system for a Cruise ship--\n\n");
            System.out.println("\n--Main Menu--\n");
            System.out.print("\nV: Views All cabins\n" +
                    "E: Display Empty cabins\n" +
                    "A: Add a customer to a cabin\n" +
                    "D: Delete customer from cabin\n" +
                    "F: Find cabin from customer name\n" +
                    "S: Store Program Data into file\n" +
                    "L: Load program data from file\n" +
                    "O: View passengers Ordered alphabetically by name\n"+
                    "T: View Expenses \n "+
                    "> ");

            control=input.next().charAt(0);  //get the input to choose the option of main menu

            if (control=='V'){
                viewAll(Cabins);
            }else if(control=='E'){
                //checkEmpty(Cabin);
            }else if(control=='A'){
                addPassenger(Cabins,Rest);
            }else if(control=='D'){
                removePassenger(Cabins,Rest);
            }else if (control=='O') {
                sortPassenger(Cabins);
            }else if(control=='S'){
                storeData(Cabins);
            }else if(control=='L'){
                loadData(Cabins,false);
            }else if(control=='F'){
                loadData(Cabins,true);
            }else if(control=='T'){
                    viewExpenses(Cabins);
            }
            else{
                // if user enter wrong input it will break the program
                break;
            }
            
        }
    }
    private static void viewAll(Cabin[] Cabins){
        System.out.println("\n---View Passenger---\n");
        for (int x = 0; x < Cabins.length; x++ )//this loop to the number of counters and print values in the given format
        {
            if(Cabins[x]!=null){

            System.out.println("Cabin " + (x+1) + " occupied by " + Cabins[x].p1.getFirstname()+ " and "+Cabins[x].p2.getFirstname() +" and "+ Cabins[x].p3.getFirstname());
            System.out.println(" Passenger 1 First Name: "+Cabins[x].p1.getFirstname());
            System.out.println("Passenger 1 Surname: "+Cabins[x].p1.getSurname());
            System.out.println("Passenger 1 Expenses: "+Cabins[x].p1.getExpenses());
            System.out.println(" Passenger 2 First Name: "+Cabins[x].p2.getFirstname());
            System.out.println("Passenger 2 Surname: "+Cabins[x].p2.getSurname());
            System.out.println("Passenger 2 Expenses: "+Cabins[x].p2.getExpenses());
            System.out.println(" Passenger 3 First Name: "+Cabins[x].p3.getFirstname());
            System.out.println("Passenger 3 Surname: "+Cabins[x].p3.getSurname());
            System.out.println("Passenger 3 Expenses: "+Cabins[x].p3.getExpenses());
            System.out.println("------------------------------------------------------");
        }else{
                continue;
            }
        }
    }
    private static void addPassenger(Cabin[] Cabins,ArrayList<Cabin> list){
        Scanner input=new Scanner(System.in);
        System.out.println("\n---Add Passenger---\n");
        if(isFull(Cabins)){//check the counters are full and return true for full
            //then redirected to the queue



            System.out.println("\n=========Queue=======\n");
            System.out.print("Enter name for cabin:" ) ;
            String Name = input.nextLine();
            System.out.print("Enter Passenger1 First name :" ) ;
            String customer1FirstName = input.nextLine();
            System.out.print("Enter Passenger1 Surname:" ) ;
            String customer1Surname = input.nextLine();
            System.out.print("Enter Passenger1 Expense:" ) ;
            String customer1Expenses = input.nextLine();
            System.out.print("Enter Passenger2 First name :" ) ;
            String customer2FirstName = input.nextLine();
            System.out.print("Enter Passenger2 Surname:" ) ;
            String customer2Surname = input.nextLine();
            System.out.print("Enter Passenger2 Expense:" ) ;
            String customer2Expenses = input.nextLine();
            System.out.print("Enter Passenger3 First name :" ) ;
            String customer3FirstName = input.nextLine();
            System.out.print("Enter Passenger3 Surname:" ) ;
            String customer3Surname = input.nextLine();
            System.out.print("Enter Passenger3 Expense:" ) ;
            String customer3Expenses = input.nextLine();
            int total = Integer.parseInt(customer1Expenses)+Integer.parseInt(customer2Expenses)+ Integer.parseInt(customer3Expenses);
            Passenger p1= new Passenger(customer1FirstName,customer1Surname,customer1Expenses);
            Passenger p2= new Passenger(customer2FirstName,customer2Surname,customer2Expenses);
            Passenger p3= new Passenger(customer3FirstName,customer3Surname,customer3Expenses);
            Cabin cab1=new Cabin(Name,p1,p2,p3,String.valueOf(total));
            list.add(cab1);
            //made a objetct of all values to store



        }else{
            int cabinNum;
            while (true) {//handling errors if give string
                try {
                    System.out.print("Enter cabin number (1-12): ");
                    cabinNum = input.nextInt();
                    break;
                }catch (Exception e){
                    System.out.println("Enter a correct cabin number.");
                    input.nextLine();
                }
            }
            System.out.print("Enter name for cabin " + cabinNum +" :" ) ;
            input.nextLine();
            String cabinName = input.nextLine();
            System.out.print("Enter Passenger1 First name for cabin " + cabinNum+" :" ) ;
            String customer1FirstName = input.nextLine();
            System.out.print("Enter Passenger1 Surname for cabin " + cabinNum+" :" ) ;
            String customer1Surname = input.nextLine();
            System.out.print("Enter Passenger1 Expenses for cabin " + cabinNum+" :" ) ;
            String customer1Expenses = input.nextLine();
            System.out.print("Enter Passenger2 First name for cabin " + cabinNum+" :" ) ;
            String customer2FirstName = input.nextLine();
            System.out.print("Enter Passenger2 Surname for cabin " + cabinNum+" :" ) ;
            String customer2Surname = input.nextLine();
            System.out.print("Enter Passenger2 Expenses for cabin " + cabinNum+" :" ) ;
            String customer2Expenses = input.nextLine();
            System.out.print("Enter Passenger3 First name for cabin " + cabinNum+" :" ) ;
            String customer3FirstName = input.nextLine();
            System.out.print("Enter Passenger3 Surname for cabin " + cabinNum+" :" ) ;
            String customer3Surname = input.nextLine();
            System.out.print("Enter Passenger3 Expenses for cabin " + cabinNum+" :" ) ;
            String customer3Expenses = input.nextLine();

            Passenger p3=new Passenger(customer1FirstName,customer1Surname,customer1Expenses);
            Cabins[cabinNum-1].setP1(p3);
            Passenger p4=new Passenger(customer2FirstName,customer2Surname,customer2Expenses);
            Cabins[cabinNum-1].setP2(p4);
            Passenger p5=new Passenger(customer3FirstName,customer3Surname,customer3Expenses);
            Cabins[cabinNum-1].setP3(p5);
            Cabins[cabinNum-1].setCabin_name(cabinName);
            int total = Integer.parseInt(customer1Expenses)+Integer.parseInt(customer2Expenses)+ Integer.parseInt(customer3Expenses);
            Cabins[cabinNum-1].setT_expenses(String.valueOf(total));
            

        }

    }
    static ArrayList<String> sortPassenger(Cabin[] cabin){
        //method to sort data in alphabetically order
        System.out.println("\n---Sort Passenger Alphabetically---\n");
        ArrayList<String> passengernames= new  ArrayList<String>(36);
        for(int i=0;i< cabin.length;i++){
            passengernames.add(cabin[i].p1.getFirstname());
            passengernames.add(cabin[i].p2.getFirstname());
            passengernames.add(cabin[i].p3.getFirstname());
        }
        Collections.sort(passengernames, String.CASE_INSENSITIVE_ORDER);
        for(String name:passengernames) {
            System.out.println(name);
        }
        return passengernames;
    }


    private  static void removePassenger(Cabin[] cabin,ArrayList<Cabin> list){
        System.out.println("\n---Remove Passenger---\n");
        Scanner input=new Scanner(System.in);
        int cabinNum;
        while (true) {//handled the input errors in remove passengers
            try {
                System.out.print("Enter cabin number (1-4): ");
                cabinNum = input.nextInt();
                break;
            }catch (Exception e){// this will run when error has occur
                System.out.println("Enter a correct cabin number.");
                input.nextLine();
            }
        }

        //initialize all items in the empty in the given index to remove a passenger from the counter
        cabin[cabinNum-1].p1.setFirstname(null);// minus 1 for index is lower than counter number from 1
        cabin[cabinNum-1].p1.setSurname(null);
        cabin[cabinNum-1].p1.setExpenses(null);
        cabin[cabinNum-1].p2.setFirstname(null);// minus 1 for index is lower than counter number from 1
        cabin[cabinNum-1].p2.setSurname(null);
        cabin[cabinNum-1].p2.setExpenses(null);
        cabin[cabinNum-1].p3.setFirstname(null);// minus 1 for index is lower than counter number from 1
        cabin[cabinNum-1].p3.setSurname(null);
        cabin[cabinNum-1].p3.setExpenses(null);
        cabin[cabinNum-1].p1.setFirstname(null);// minus 1 for index is lower than counter number from 1
        cabin[cabinNum-1].setCabin_name(null);
        cabin[cabinNum-1].setT_expenses(null);

        //setting list values to the cabin
        cabin[cabinNum-1].p1.setFirstname(list.get(0).p1.getFirstname());// minus 1 for index is lower than counter number from 1
        cabin[cabinNum-1].p1.setSurname(list.get(0).p1.getSurname());
        cabin[cabinNum-1].p1.setExpenses(list.get(0).p1.getExpenses());
        cabin[cabinNum-1].p2.setFirstname(list.get(0).p2.getFirstname());// minus 1 for index is lower than counter number from 1
        cabin[cabinNum-1].p2.setSurname(list.get(0).p2.getSurname());
        cabin[cabinNum-1].p2.setExpenses(list.get(0).p2.getExpenses());
        cabin[cabinNum-1].p3.setFirstname(list.get(0).p3.getFirstname());// minus 1 for index is lower than counter number from 1
        cabin[cabinNum-1].p3.setSurname(list.get(0).p3.getSurname());
        cabin[cabinNum-1].p3.setExpenses(list.get(0).p3.getExpenses());
        cabin[cabinNum-1].setCabin_name(list.get(0).getCabin_name());
        cabin[cabinNum-1].setT_expenses(list.get(0).getT_expenses());
        // remove the first element of the rest.
        list.remove(0);

    }
    static String storeData(Cabin[] cabin){
        String msg="";
        try {
            FileWriter myWriter = new FileWriter("data.txt");// file printing is data.txt
            for(int i=0;i<cabin.length;i++){
                myWriter.write((i+1)+"-"+cabin[i].p1.getFirstname()+"-"+cabin[i].p1.getSurname()+"-"+cabin[i].p1.getExpenses()+"-"+cabin[i].p2.getFirstname()+"-"+cabin[i].p2.getSurname()+"-"+cabin[i].p2.getExpenses()+"-"+cabin[i].p3.getFirstname()+"-"+cabin[i].p3.getSurname()+"-"+cabin[i].p3.getExpenses()+"\n");
            }
            myWriter.close();//close the write
            msg="Successfully wrote to the file.";
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return msg;
    }

    public static void loadData(Cabin[] cabin,boolean Search){
        //to get data from a file


        try {
            File myObj = new File("data.txt");//the program get the data from data.txt file
            Scanner myReader = new Scanner(myObj); //made the scanner
            String[] split = new String[10];// the array that store values from the file line by line
            while (myReader.hasNextLine()) {//runs line by line in file
                String data = myReader.nextLine();
                split=data.split("-");
                cabin[Integer.parseInt(split[0])-1].p1.setFirstname(split[1]);//set name for couter obh
                cabin[Integer.parseInt(split[0])-1].p1.setSurname(split[2]);
                cabin[Integer.parseInt(split[0])-1].p1.setExpenses(split[3]);
                cabin[Integer.parseInt(split[0])-1].p2.setFirstname(split[4]);//set name for couter obh
                cabin[Integer.parseInt(split[0])-1].p2.setSurname(split[5]);
                cabin[Integer.parseInt(split[0])-1].p2.setExpenses(split[6]);
                cabin[Integer.parseInt(split[0])-1].p3.setFirstname(split[7]);//set name for couter obh
                cabin[Integer.parseInt(split[0])-1].p3.setSurname(split[8]);
                cabin[Integer.parseInt(split[0])-1].p3.setExpenses(split[9]);

            }

            if(Search ) {
                System.out.println("Enter the Customer First name to Search?");
                Scanner scn = new Scanner(System.in);
                String search_word = scn.nextLine().trim();
                FileReader fr= new FileReader(myObj);
                BufferedReader br= new BufferedReader(fr);
                String s;
                LineNumberReader lnr= new LineNumberReader(new FileReader(myObj));
                int linenumber=0;
                while((s=br.readLine())!=null){
                    String[] words=s.split("-");
                    linenumber++;
                    for (int i=0;i<words.length;i++){
                        if(search_word.equals(words[i])){
                            System.out.println("Cabin no: "+words[0]);
                            System.out.println("passenger Surname: "+ words[i+1]);
                            System.out.println("passenger Expense: "+ words[i+2]);

                        }


                    }
                }


            }
        } catch (FileNotFoundException e) {//if the process got an error this code lines will run
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Boolean isFull(Cabin Cabins[]) {
        //this method check the counters are full or not and return true when full and false for otherwise
        boolean b = false;

//2
        for (int i = 0; i < Cabins.length; i++) {
            if (i==Cabins.length-1) {
                b= false;
            }
        }
        return b;
//3

    }

    private static void initialise( Cabin Cabins[] ) {
        //initialise values in the start
        for (int x = 0; x < Cabins.length; x++ ) {
            Cabins[x].setCabin_name("empty");
            Passenger p1= new Passenger("Empty","Empty","Empty");
            Passenger p2= new Passenger("Empty","Empty","Empty");
            Passenger p3= new Passenger("Empty","Empty","Empty");
            Cabins[x].setP1(p1);
            Cabins[x].setP2(p2);
            Cabins[x].setP3(p3);
            Cabins[x].setT_expenses("Empty");
        }
        //System.out.println( "initialise ");
    }
    public static void viewExpenses(Cabin[] cabin){
            System.out.println("Press 1 to view Expenses per passenger; Press 2 for Total Expenses");
            Scanner scn= new Scanner(System.in);
            int number= scn.nextInt();
            if(number==1){
                for(int i=0;i<cabin.length;i++){
                    System.out.println(cabin[i].p1.getFirstname()+" "+cabin[i].p1.getExpenses());
                    System.out.println(cabin[i].p2.getFirstname()+" "+cabin[i].p2.getExpenses());
                    System.out.println(cabin[i].p3.getFirstname()+" "+cabin[i].p3.getExpenses());
                }
            }else if(number==2){
                for(int i=0;i<cabin.length;i++){
                    int total=+ Integer.parseInt(cabin[i].getT_expenses());
                    System.out.println("Total Expenses: "+String.valueOf(total));
                }

            }

    }







    
}
