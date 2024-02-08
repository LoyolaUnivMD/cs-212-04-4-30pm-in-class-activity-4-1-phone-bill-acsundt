// import neccessary packages

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Scanner;
import java.lang.String;
class PhoneBill {

    //main method
    public static void main(String[] args) {

        //Make neccessary objects
        Scanner input = new Scanner(System.in);
        DecimalFormat dfmt = new DecimalFormat("$#.00");

        //establish valid package types and initialize variables
        String[] packageTypes = {"green", "blue", "purple"};
        boolean packageValid;
        String phonePackage;
        String lowerPackage;

        //Get and error check the package type from user
        do {
            System.out.println("What package do you have?");
            phonePackage = input.nextLine();
            lowerPackage = phonePackage.toLowerCase();

            packageValid = Objects.equals(lowerPackage, packageTypes[0]) || Objects.equals(lowerPackage, packageTypes[1]) || Objects.equals(lowerPackage, packageTypes[2]);
            if (!packageValid){
                System.out.println("Invalid Package Type");
            }
        }
        while (!packageValid);

        //Get input from user
        System.out.println("How much GBs of data did you use?");
        int gbsDataUsed = input.nextInt();

        double billTotal = 0;

        //Path for green package
        if(Objects.equals(lowerPackage,packageTypes[0])){
            if(gbsDataUsed > 2){
                billTotal+= gbsDataUsed*15;
            }
            //Adjust bill total
            billTotal += 49.99;
            //Ask about coupon if needed
            if (billTotal>75){
                System.out.println("Do you have a coupon?(Y/N)");
                String couponCheck = input.next();
                if(Objects.equals(couponCheck, "Y")) {
                    billTotal -= 20;
                }
            }
        }

        //blue path
        else if(Objects.equals(lowerPackage,packageTypes[1])){
            if(gbsDataUsed > 4){
                billTotal+=10*gbsDataUsed;
            }
            //adjust bill cost total
            billTotal+=70;
        }
        //purple path
        else{
            billTotal+=99.95;
        }
        //output total bill cost in proper dfmt
        System.out.println("Your total bill cost is "+dfmt.format(billTotal));



        }
        
    }
