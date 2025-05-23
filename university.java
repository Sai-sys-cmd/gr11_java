/*
Names: Sai Srinivas Khandavilli & Ethan Luong
Date: May 21, 2025
Purpose: To create a program for a university that collects students information and calculates their admission status, scholarships, & residence.
*/

// Imports
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {

      //Scanner
      Scanner in = new Scanner (System.in);

      // Variables
      String firstName = "", lastName = "", email = "", fullName = "", employment = "", extracurriculars = "", accepted = "CONGRATULATIONS fullName! Your hard work paid off and we are pleased to invite you to Java University.", 
             pass = "", residence = "", roomType = "", bathroomType = "", kitchenType = "", residenceName = "";
      final String EMPLOYMENT, EXTRACURRICULARS, PASSWORD;
      int quit = 0, choice = -1, numOfExtracurriculars = 0, courses = 0, studentProfile = 1, admissionDecision = 0, scholarshipOffer = 0, residenceApplication = 0, acceptance = 0;
      double average = 0, grade = 0, scholarshipAverage = 0, scholarshipEmployment = 0, scholarshipExtra = 0, scholarshipFull = 0, residencePrice = 0;

      // Formats
      DecimalFormat df = new DecimalFormat("0.00");
      DecimalFormat whole = new DecimalFormat("0");
      NumberFormat money = NumberFormat.getCurrencyInstance();

      //while loop, so user can input more than 1 selection and quit whenever they want 
      while (quit != 1) {
      // Selection:
        System.out.println("\n\n-JAVA UNIVERSITY-");
        System.out.println("1. Student Profile");
        System.out.println("2. Admission Decision");
        System.out.println("3. Scholarship Offer");
        System.out.println("4. Residence Application");
        System.out.println("5. Quit");

        //if input is invalid, ask user to input a valid input
        do {
          System.out.print("Enter your choice (#): ");
          choice = in.nextInt();
          if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) System.out.println("\nEnter a valid input!\n");
        } while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5);
  
        // Student Profile
        
        if (choice == 1) {
          if (studentProfile == 1) {
            System.out.print("\nEnter your first name: ");
            firstName = in.next(); 
            System.out.print("\nEnter your last name: ");
            lastName = in.next(); 
            System.out.print("\nEnter the number of courses you took: ");
            courses = in.nextInt();

            fullName = firstName + " " + lastName;
            
            //user enters the grades for each course, for loop used as the program does not explicitly know how many courses user has completed.
            for (int i = 1; i <= courses; i++) {
              System.out.print("\nEnter grade for course " + i  + ": ");
              grade = in.nextDouble();
              average += grade;
            }
            average /= courses;
  
            //user enters their email address, do while loop used to ensure that email is valid
            do {
              System.out.print("\nEnter your email address: ");
              email = in.next();
              if (!email.contains("@") || (!email.endsWith(".com") && !email.endsWith(".ca"))) System.out.println("Enter a valid email!");
            } while (!email.contains("@") || (!email.endsWith(".com") && !email.endsWith(".ca")));
  
            //user enters employment status, loops if input is not valid, do while loop used to make sure user inputs valid input
            do {
              System.out.print("\nAre you employed? (Yes/No): ");
              employment = in.next();
              if (!employment.equalsIgnoreCase("YES") && !employment.equalsIgnoreCase("NO")) System.out.println("Enter a valid input!");
            } while(!employment.equalsIgnoreCase("YES") && !employment.equalsIgnoreCase("NO"));
            
            //asks user if they have done any extracurriculars, do while loop used to ensure valid input
            do {
              System.out.print("\nAre you involved with extracurricular activities? (Yes/No): ");
              extracurriculars = in.next();
              if (!extracurriculars.equalsIgnoreCase("YES") && !extracurriculars.equalsIgnoreCase("NO")) System.out.println("Enter a valid input!");
            } while(!extracurriculars.equalsIgnoreCase("YES") && !extracurriculars.equalsIgnoreCase("NO"));
            
  
            //has user input the number of extracurricular activites
            if (extracurriculars.equalsIgnoreCase("YES")) {
              System.out.print("\nEnter the number of extracurricular activities you do: ");
              numOfExtracurriculars = in.nextInt();
            }
  
            //student profile output
            System.out.println("\n\nYour student profile:");
            System.out.println("\nName: " + fullName);
            System.out.println("\nAverage: " + df.format(average) + "%");
            System.out.println("\nEmail: " + email);
            System.out.println("\nEmployment Status: " + employment.toUpperCase());
            if (extracurriculars.equalsIgnoreCase("YES")) System.out.println("\nNumber of Extracurricular Activities: " + numOfExtracurriculars);
            studentProfile = 0;
          }

          else { 
            System.out.println("\n\nStudent profile has already been filled!\n\n");
            System.out.println("\n\nYour student profile:");
            System.out.println("\nName: " + fullName);
            System.out.println("\nAverage: " + df.format(average) + "%");
            System.out.println("\nEmail: " + email);
            System.out.println("\nEmployment Status: " + employment.toUpperCase());
            if (extracurriculars.equalsIgnoreCase("YES")) System.out.println("\nNumber of Extracurricular Activities: " + numOfExtracurriculars);
          }
          
        }// END OF CHOICE 1


        // Admission Decision

        if (choice == 2) {
          
          if (studentProfile == 0 && admissionDecision == 0) {
            //checks for each case of being accepted, and if one of the cases are valid accepts user
            if (average >= 90) acceptance++;
            else if (average >= 80 && (employment.equalsIgnoreCase("Yes") || numOfExtracurriculars >= 1)) acceptance++;
            else if (average >= 70 && (employment.equalsIgnoreCase("Yes") && numOfExtracurriculars >= 2)) acceptance++;
            else System.out.println("\n\nSorry, but we have decided to proceed without your application at this time.\n\n");

            //checks if acceptance is greater or equal to 1, and prints out student's password and acceptance printout
            if (acceptance >= 1) {
              System.out.println("\n\n" + accepted.replaceAll("fullName", fullName) + "\n\n");
              pass = (firstName.toUpperCase().substring(0,3)) + (lastName.toUpperCase().substring(2)) + ((int)(901 * Math.random()) + 100);
              System.out.println("\nYour passwod for the university website is: " + pass + "\n\n");
              admissionDecision = 1;
            }
          
          }

          //if user is already admitted, print out the users password and the acceptance printout
          else if (admissionDecision == 1) {
            System.out.println("\n\n" + accepted.replaceAll("fullName", fullName) + "\n\n");
            System.out.println("\nYour password is: " + pass);
          }

          //tells user to do the user profile if it isnt done
          else System.out.println("\n\nYou haven't filled out the student profile!\n\n");

          
        }// END OF CHOICE 2
  
  
        // Scholarship Offer
        
        if (choice == 3){
          
          if (admissionDecision == 1){
          //student average scholarship
            if (average >= 90) scholarshipAverage = average*50;
            else if (average >= 80) scholarshipAverage = average*25;
            
          //employment scholarship
            if (employment.equalsIgnoreCase("YES")) scholarshipEmployment = 250;
            
          //extracirricular scholarship
            if (numOfExtracurriculars >= 4) scholarshipExtra = 500;
            scholarshipFull = scholarshipAverage + scholarshipEmployment + scholarshipExtra;
            
            //if theres somehow no scholarship at all
            if (scholarshipFull == 0) System.out.println("\n\nNo scholarship has been awarded to you.\n\n");

            else {
              //outputs total scholarship earned and breakdown of individual components earned
              System.out.println("\n\nYou have earned $" + whole.format(scholarshipFull) + " in scholarships!\nYou have earned them via:");
              if (scholarshipAverage>0) System.out.println("\n- Performance ($" + whole.format(scholarshipAverage) + ")");
              if (scholarshipEmployment>0) System.out.println("\n- Employment ($250)");
              if (scholarshipExtra>0) System.out.println("\n- Extracurriculars ($500)");
            }
            
          }

          else System.out.println("\n\nYou haven't been admitted yet!\n\n");
          
        }// END OF CHOICE 3
  
         
        // Residence Application
        
        if (choice == 4){
          if (admissionDecision == 1 && residenceApplication == 0){
            //Asks user if they want a Single or Shared room, do while loop used to make sure user inputs a valid input
            do {
              System.out.print("\nWhat type of room do you want? (Single/Shared, single rooms are $1500 extra): ");
              roomType = in.next();
              if (!roomType.equalsIgnoreCase("Single") && (!roomType.equalsIgnoreCase("Shared"))) System.out.println("\n\nEnter a valid choice!\n\n");
            } while(!roomType.equalsIgnoreCase("Single") && (!roomType.equalsIgnoreCase("Shared")));
            //Asks user if they want a private or shared bathroom, do while loop used to make sure user inputs a valid input
            do {
              System.out.print("\nWhat type of bathroom do you want? (Private/Shared, private bathrooms are $1000 extra): ");
              bathroomType = in.next();
              if (!bathroomType.equalsIgnoreCase("Private") && (!bathroomType.equalsIgnoreCase("Shared"))) System.out.println("\n\nEnter a valid choice!\n\n");
            } while(!bathroomType.equalsIgnoreCase("Private") && (!bathroomType.equalsIgnoreCase("Shared")));
            //Asks user if they want a residence with a kitchen, do while loop used to make sure user inputs a valid input
            do {
              System.out.print("\nDo you want a residence with a kitchen? (Yes/No): ");
              kitchenType = in.next();
              if (!kitchenType.equalsIgnoreCase("YES") && (!kitchenType.equalsIgnoreCase("NO"))) System.out.println("\n\nEnter a valid choice!\n\n");
            } while(!kitchenType.equalsIgnoreCase("YES") && (!kitchenType.equalsIgnoreCase("NO")));

            //Output the options user has available for residences, do while loop used to ensure correct input
            do {
                //kaeid castle, available if user likes kitchens
                if (kitchenType.equalsIgnoreCase("Yes")) {
                  System.out.println("\n\n1. Kaeid Castle:\n- $8000 base price\n- Single and Double rooms\n- Private and Shared bathrooms\n- All rooms have access to a shared kitchen");
                }
                
                //mcdonald mansion, available if user does not mind sharing a bathroom
                if (bathroomType.equalsIgnoreCase("Shared") && kitchenType.equalsIgnoreCase("Yes")){
                  System.out.println("\n\n2. McDonald Mansion:\n- $7500 base price\n- Single and Shared rooms\n- Shared washrooms, no private washrooms\n- All rooms have access to a shared kitchen\n\n");
                }
    
                //chan vicker's commons, avaialble if user does not mind having no kitchen
                if (kitchenType.equalsIgnoreCase("No")){
                  System.out.println("\n\n3. Chan Vicker's Commons:\n- $6000 base price\n- Single and Shared rooms\n- Private and Shared bathrooms\n- No kitchen\n\n");
                }
    
                //shink's shack, available if user wouldn't mind having no privacy and no kitchen
                if (roomType.equalsIgnoreCase("Shared") && kitchenType.equalsIgnoreCase("No") && bathroomType.equalsIgnoreCase("Shared")){
                  System.out.println("\n\n4. Shink's Shack:\n- $3000 base price\n- Shared rooms only\n- Shared bathrooms only\n- No kitchen\n\n");
                }
    
                System.out.print("Enter your choice (#) or input \"Q\" to exit out of residence selection and select later: ");
                residence = in.next();

                //if the input is not valid, tells user to input a valid input
                if (!residence.equalsIgnoreCase("Q") && !residence.equalsIgnoreCase("1") && !residence.equalsIgnoreCase("2") && !residence.equalsIgnoreCase("3") && !residence.equalsIgnoreCase("4")) System.out.println("\n\nEnter a valid option!\n\n");

            }while(!residence.equalsIgnoreCase("Q") && !residence.equalsIgnoreCase("1") && !residence.equalsIgnoreCase("2") && !residence.equalsIgnoreCase("3") && !residence.equalsIgnoreCase("4"));

            
            //set price of residence based on name selected
            switch(residence){
              case "1":
                residencePrice = 8000;
                residenceApplication = 1;
                residenceName = "Kaeid Castle";
                break;
                
              case "2":
               residencePrice = 7500; 
                residenceApplication = 1;
                residenceName = "Mcdonald Mansion";
                break;
                
              case "3":
                residencePrice = 6000;
                residenceApplication = 1;
                residenceName = "Chan Vicker's Commons";
                break;
                
              case "4":
                residencePrice = 3000;
                residenceApplication = 1;
                residenceName = "Shink's Shack";
                break;
                
              default:
                System.out.println("\nQuitting residence selection, you can select later!\n");
            }
            
            //if single room, add $1500. if private bathroom, add $1000 (assume user chooses single/private if they say they want it in the first place)
            if (roomType.equalsIgnoreCase("Single")) residencePrice += 1500;
            if (bathroomType.equalsIgnoreCase("Private")) residencePrice += 1000;

            if (!residence.equalsIgnoreCase("Q")) {
              residenceApplication = 1;
              System.out.println("\nYou chose: " + residenceName);
              System.out.println("\nTotal price of residence a year: " + money.format(residencePrice));
            }

          }
            
          //If residence was already selected, tells the user that they already have selected a residence.
          else if(residenceApplication == 1) {
            System.out.println("\n\nYou have selected a residence alerady. You need to contact the housing office to change your residence.\n\n");

            //This tells user what residence they chose and the price of the residence per year if they select the option after completing the residence application.
            System.out.println("You chose: " + residenceName);
            System.out.println("\nTotal price of residence a year: " + money.format(residencePrice));
          }

          //Tells user that they haven't been admitted if they haven't unlocked the residence application yet.
          else System.out.println("\n\nYou haven't been admitted yet!\n\n");
          
        }// END OF CHOICE 4

      
        // Exits the program
        if (choice == 5) {
          System.out.println("\n\nExiting...\n\n");
          quit = 1;
        }// END OF CHOICE 5   


        
    }//LOOP BRACKET!   
  }//DND
}//DND
