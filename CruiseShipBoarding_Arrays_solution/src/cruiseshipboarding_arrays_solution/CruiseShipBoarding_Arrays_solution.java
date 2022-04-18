
package cruiseshipboarding_arrays_solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class CruiseShipBoarding_Arrays_solution {

    
    public static void main(String[] args) {
        
    Scanner input = new Scanner(System.in);
    
        char control;
        String[] Cabin = new String[12];
        String[][] details =new String[12][5];
        initialise(Cabin); //better to initialise in a procedure
        


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
                    "> ");

            control=input.next().charAt(0);  //get the input to choose the option of main menu

            if (control=='V'){
                viewAll(Cabin,details);
            }else if(control=='E'){
                checkEmpty(Cabin);
            }else if(control=='A'){
                addPassenger(Cabin,details);
            }else if(control=='D'){
                removePassenger(Cabin,details);
            }else if (control=='O') {
                sortPassenger(Cabin,details);
            }else if(control=='S'){
                storeData(Cabin,details);
            }else if(control=='L'){
                loadData(Cabin,details);
            }else if(control=='F'){
                findCabin(Cabin);
            }else{
                // if user enter wrong input it will broke the program
                break;
            }
            
        }
    }
    private static void viewAll(String[] Cabin,String[][] details){
        //to view values
        for (int x = 0; x < Cabin.length; x++ )
        {
            System.out.println("Cabin " + (x+1) + " occupied by " + Cabin[x]);


            System.out.println("First Name: "+details[x][0]);
            System.out.println("Surname: "+details[x][1]);
            System.out.println("Age: "+details[x][2]);
            System.out.println("City: "+details[x][3]);
            System.out.println("Phone Number: "+details[x][4]);
            System.out.println("------------------------------------------------------");

        }
    }
    private static void checkEmpty(String[] Cabin){
        //check empty rooms and print them
        for (int x = 0; x < Cabin.length; x++ )
        {
            if (Cabin[x].equals("empty")){
                System.out.println("Cabin " + (x+1) + " is empty");
            }
        }
    }
    public static void findCabin(String[] cabin){
        //to get data from a file
        try {
            
            File myObj = new File("data.txt");//the program get the data from data.txt file
            if (myObj.length() == 0)
            {
                System.out.println("File is empty! Add the customer to the cabin and store to the database");
            }
            else
            {
                System.out.println("Enter the Customer name to Search?");
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
                            System.out.println("Cabin Name: "+ words[1]);
                            System.out.println("First Name: "+ words[2]);
                            System.out.println("Sure Name: "+words[3]);
                            System.out.println("Age: "+words[4]);
                            System.out.println("City: "+words[5]);
                            System.out.println("Phone Number: "+words[6]);
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
    private static void addPassenger(String[] Cabin,String[][] details){
        //to add person for counter
        Scanner input=new Scanner(System.in);
        int cusNum;
        while (true) {
            try {
                System.out.print("Enter cabin number (1-12): ");
                cusNum = input.nextInt();
                break;
            }catch (Exception e){
                System.out.println("Enter a correct cabin number.");
                input.nextLine();
            }
        }
        System.out.print("Enter customer name for cabin " + cusNum +" :" ) ;
        input.nextLine();
        String customerName = input.nextLine();
        
        System.out.print("Enter customer First name for cabin " + cusNum +" :" ) ;
        String customerFirstName = input.nextLine();
        
        System.out.print("Enter customer Surname for cabin " + cusNum +" :" ) ;
        String customerSurname = input.nextLine();
        
        System.out.print("Enter customer age for cabin " + cusNum +" :" ) ;
        String age = input.nextLine();
        
        System.out.print("Enter customer city for cabin " + cusNum +" :" ) ;
        String customerCity = input.nextLine();
        
        System.out.print("Enter customer phone number for cabin " + cusNum +" :" ) ;
        String phonenumber = input.nextLine();


        Cabin[cusNum-1] = customerName ;
        details[cusNum-1][0]=customerFirstName;// minus 1 for index is lower than counter number from 1
        details[cusNum-1][1]=customerSurname;
        details[cusNum-1][2]=age;
        details[cusNum-1][3]=customerCity;
        details[cusNum-1][4]=phonenumber;

    }
    private  static void removePassenger(String[] Cabin,String [][] details){
        Scanner input=new Scanner(System.in);
        int boothNum;
        while (true) {//handled wrong input
            try {
                System.out.print("Enter cabin number (1-12): ");
                boothNum = input.nextInt();
                break;
            }catch (Exception e){
                System.out.println("Enter a correct cabin number.");
                input.nextLine();
            }
        }

        Cabin[boothNum-1] = "empty" ;//full name
        details[boothNum-1][0]="empty";// minus 1 for index is lower than counter number from 1
        details[boothNum-1][1]="empty";//surname
        details[boothNum-1][2]="empty";//age
        details[boothNum-1][3]="empty";//city
        details[boothNum-1][4]="empty";;//phone number of the customer
        System.out.println("Successfully removed.");
    }
    private static void sortPassenger(String[] Cabin,String[][] details){
        //this method to
        String [] new_arr=new String[Cabin.length];
        for(int i=0;i< Cabin.length;i++){//to get array clone without referencing
            new_arr[i]=Cabin[i];
        }

        String temp=null;
        for(int i=0;i< new_arr.length;i++){
            for(int j=1;j< new_arr.length;j++){
                if(new_arr[j-1].compareToIgnoreCase(new_arr[j])>0){//mechanism
                    temp=new_arr[j-1];
                    new_arr[j-1]=new_arr[j];
                    new_arr[j]=temp;
                }
            }
        }
        for(int i=0;i< new_arr.length;i++){//to print the array which contains name with the real room number
            if(!new_arr[i].equals("empty")){//removes the empty rooms from printing
                for(int j=0;j< new_arr.length;j++) {
                    if(new_arr[i].equals(Cabin[j])) {
                        System.out.println(new_arr[i] + " got cabin number "+ (j+1));
                        System.out.println("First Name: "+details[j][0]);
                        System.out.println("Surname: "+details[j][1]);
                        System.out.println("Age: "+details[j][2]);
                        System.out.println("City: "+details[j][3]);
                        System.out.println("Phone Number: "+details[j][4]);
                        System.out.println("------------------------------------------------------");

                    }
                }
            }
        }
    }
    private static void storeData(String[] Cabin,String[][]details){
        //method to store data in data.txt file

        try {
            FileWriter myWriter = new FileWriter("data.txt");// file printing is output.txt
            for(int i=0;i<Cabin.length;i++){
                myWriter.write((i+1)+"-"+Cabin[i]+"-"+details[i][0]+"-"+details[i][1]+"-"+details[i][2]+"-"+details[i][3]+"-"+details[i][4]+"\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void loadData(String[] Cabin,String [][]details){
        //to get data from a file
        try {
            File myObj = new File("data.txt");//load data from data.txt
            Scanner myReader = new Scanner(myObj);
            String[] split;//array that store values in line by line
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                split=data.split("-");//split from -
                Cabin[Integer.parseInt(split[0])-1]=split[1];//full name
                details[Integer.parseInt(split[0])-1][0]=split[2];//first name
                details[Integer.parseInt(split[0])-1][1]=split[3];//surname
                details[Integer.parseInt(split[0])-1][2]=split[4];//age
                details[Integer.parseInt(split[0])-1][3]=split[5];//city
                details[Integer.parseInt(split[0])-1][4]=split[6];//phone number

            }
            myReader.close();
            System.out.println("Successfully load data");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    private static void initialise( String Cabin[] ) {
        //initialise values at start
        for (int x = 0; x < Cabin.length; x++ ) {
            Cabin[x] = "empty";
        }
        //System.out.println( "initialise ");
    }
    
}
