/*
Sai Srinivas Khandavilli
March 4, 2025
Purpose: A program for a hotel to get information
         needed for booking a stay at the hotel.
*/

// Importing scanner
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

      // Variable in is used to scan
      Scanner in = new Scanner (System.in);

      // Declaration of the 10 pieces of information
      String fullName, roomType, paymentMethod, phoneNumber;
      int age, numOfGuests;
      char roomService, parking;
      double lugageWeight, lengthOfStay;

      // Declaration of billing information
      double subtotal, total;
      String message = "tbd";

      /* 
         Outputting 10 questions, scanning the user input, 
         and storing it in the apropriate variable
      */
      System.out.print("Enter your full name (no spaces): ");
      fullName = in.next();
      
      System.out.print("\nEnter your age: ");
      age = in.nextInt();
      
      System.out.print("\nEnter number of guests: ");
      numOfGuests = in.nextInt();
      
      System.out.print("\nEnter room type (Suite/Deluxe/Double/Single): ");
      roomType = in.next();
      
      System.out.print("\nEnter payment method (Credit/Debit/Cash): ");
      paymentMethod = in.next();
      
      System.out.print("\nDo you want room service? (Y/N): ");
      roomService = in.next().charAt(0);
      
      System.out.print("\nDo you want parking? (Y/N): ");
      parking = in.next().charAt(0);

      System.out.print("\nEnter your phone number (no spaces): ");
      phoneNumber = in.next();

      System.out.print("\nEnter your total lugage weight (in kg): ");
      lugageWeight = in.nextDouble();
      
      System.out.print("\nHow many days are you staying (decimal value if needed): ");
      lengthOfStay = in.nextDouble();

      // Cost of the room chosen
      if (roomType == "Suite") subtotal = 200;
      else if (roomType == "Deluxe") subtotal = 150;
      else if (roomType == "Double") subtotal = 100;
      else subtotal = 50;

      // Accounts for the number of guests and length of the stay
      subtotal *= numOfGuests * lengthOfStay;
      subtotal += lugageWeight * 10;

      // Checks for room service, parking, and if a senior discount is applicable
      if (roomService == 'Y') subtotal += 50;
      if (parking == 'Y') subtotal += 20;
      if (age >= 60) { subtotal *= 0.8; message = "Senior Discount!"; }

      // Finds total cost with tax
      total = subtotal * 1.13;

      // A divider between the input and output
      System.out.println("\n\n");
      for (int i = 0; i < 75; i++) System.out.print("_");
      System.out.println("\n\n\n");

      // Outputs the banner
      for (int i = 0; i < 15; i++) System.out.print("*-");
      System.out.println("*");
      System.out.println("|\t    Sai's Hotel\t      |");
      System.out.println("|\t 321 Real Avenue      |");
      System.out.println("|\t     Ajax, ON\t      |");
      System.out.println("|\t     L1Z 7H2\t      |");
      for (int i = 0; i < 15; i++) System.out.print("*-");
      System.out.println("*\n");

      // Outputs the 10 pieces of information
      System.out.println("\n Customer Information:");
      System.out.println("\n   Customer Fullname: " + fullName);
      System.out.println("\n   Age: " + age);
      System.out.println("\n   Number of Guests: " + numOfGuests);
      System.out.println("\n   Room Type: " + roomType);
      System.out.println("\n   Payment Method: " + paymentMethod);
      System.out.println("\n   Room Service: " + roomService);
      System.out.println("\n   Parking: " + parking);
      System.out.println("\n   Phone Number: " + phoneNumber);
      System.out.println("\n   Lugage Weight: " + lugageWeight + " kg");
      System.out.println("\n   Length of Stay: " + lengthOfStay + " days\n");

      // Tells the user if they have a senior discount
      if (message == "Senior Discount!") System.out.println("\n  (" + message + ")\n");

      // Outputs the billing information
      System.out.println("\n Billing:");
      System.out.println("\n   Subtotal: $" + subtotal);
      System.out.println("\n   Tax Rate: 13%");
      System.out.println("\n   Total: $" + total);

      // Thank you message
      System.out.println("\n\n********** Thank You! **********");
        
    }
}