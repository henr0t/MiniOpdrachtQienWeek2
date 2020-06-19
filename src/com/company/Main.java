package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UserInterface UI = new UserInterface();
        UI.menu();

    }
}

class UserInterface{
    boolean exit;

    void menu()
    {
     do {
         System.out.println("Wat wil je doen vandaag?");
         System.out.println("1. Cafe (interactief)\n2. Bar \n3. Groepsreis\n4. Fietsen (interactief)\n\n[q om het programma af te sluiten]");

         switch (userInput()) {
             case "1":
                 Cafe cafe1 = new Cafe();
                 cafe1.cafe();
                 break;
                 case "2":
                 Bar bar1 = new Bar();
                 bar1.bar();
                 break;
             case "3":
                 Groepsreis reis1 = new Groepsreis();
                 reis1.groepsReis();
                 break;
             case "4":
                 Fietsen fietsen1 = new Fietsen();
                 fietsen1.fietsen();
                 break;
             case "q":
                 exit = true;
                 break;
         }
     }while(!exit);

    }
    String userInput(){
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        return userInput;
    }
}