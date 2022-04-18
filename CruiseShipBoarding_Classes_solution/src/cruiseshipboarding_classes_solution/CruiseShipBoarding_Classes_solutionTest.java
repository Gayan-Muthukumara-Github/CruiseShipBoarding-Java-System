package cruiseshipboarding_classes_solution;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CruiseShipBoarding_Classes_solutionTest {







    @Test
    public void testSortingPassengers(){
            //creating dummy data to test the program.


        Passenger p1= new Passenger("Peter","Almeda","1000");
        Passenger p2= new Passenger("Ahmed","Raziq","1100");
        Passenger p3= new Passenger("James","Peter","1200");
        Passenger p4= new Passenger("Nadia","Ali","1500");
        Passenger p5= new Passenger("James","Anderson","1000");
        Passenger p6= new Passenger("Alviro","Peterson","1000");
        Passenger p7= new Passenger("Alex","James","1200");
        Passenger p8= new Passenger("Wendet","Richmond","1100");
        Passenger p9= new Passenger("Jos","Inglis","1600");
        Passenger p10= new Passenger("Alfred","Noel","1500");
        Passenger p11= new Passenger("Vann","Jimmy","1300");

        Cabin cabs1= new Cabin("cab1",p1,p2,p3);
        Cabin cabs2= new Cabin("cab2",p4,p5,p6);
        Cabin cabs3= new Cabin("cab3",p7,p8,p9);

        CruiseShipBoarding_Classes_solution s1= new CruiseShipBoarding_Classes_solution();
        ArrayList<String> expected= new ArrayList<>();
        expected.add("Ahmed");
        expected.add("Alex");
        expected.add("Alviro");
        expected.add("James");
        expected.add("James");
        expected.add("Jos");
        expected.add("Nadia");
        expected.add("Peter");
        expected.add("Wendet");

        Cabin[] cab_arr =new Cabin[3];
        cab_arr[0]=cabs1;
        cab_arr[1]=cabs2;
        cab_arr[2]=cabs3;

        assertArrayEquals(expected.toArray(),s1.sortPassenger(cab_arr).toArray());

    }

    @Test
    public void CheckStoreData(){

        Passenger p1= new Passenger("Peter","Almeda","1000");
        Passenger p2= new Passenger("Ahmed","Raziq","1100");
        Passenger p3= new Passenger("James","Peter","1200");
        Passenger p4= new Passenger("Nadia","Ali","1500");
        Passenger p5= new Passenger("James","Anderson","1000");
        Passenger p6= new Passenger("Alviro","Peterson","1000");
        Passenger p7= new Passenger("Alex","James","1200");
        Passenger p8= new Passenger("Wendet","Richmond","1100");
        Passenger p9= new Passenger("Jos","Inglis","1600");
        Passenger p10= new Passenger("Alfred","Noel","1500");
        Passenger p11= new Passenger("Vann","Jimmy","1300");

        Cabin cabs1= new Cabin("cab1",p1,p2,p3);
        Cabin cabs2= new Cabin("cab2",p4,p5,p6);
        Cabin cabs3= new Cabin("cab3",p7,p8,p9);

        CruiseShipBoarding_Classes_solution s1= new CruiseShipBoarding_Classes_solution();
        ArrayList<String> expected= new ArrayList<>();
        expected.add("Ahmed");
        expected.add("Alex");
        expected.add("Alviro");
        expected.add("James");
        expected.add("James");
        expected.add("Jos");
        expected.add("Nadia");
        expected.add("Peter");
        expected.add("Wendet");

        Cabin[] cab_arr =new Cabin[3];
        cab_arr[0]=cabs1;
        cab_arr[1]=cabs2;
        cab_arr[2]=cabs3;

        assertEquals("Successfully wrote to the file.",s1.storeData(cab_arr));
    }




}