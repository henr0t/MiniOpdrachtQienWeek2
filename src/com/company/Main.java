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
         System.out.println("1. Cafe\n2. Bar \n3. Groepsreis\n4. Fietsen");

         switch (userInput()) {
             case "1":
                 Cafe cafe1 = new Cafe();
                 cafe1.cafe();
                 break;
             case "2":
                 Bar bar1 = new Bar();
             case "3":
                 Groepsreis reis1 = new Groepsreis();
             case "4":
                 Fietsen fietsen1 = new Fietsen();
             case "q":
                 exit = true;
         }
     }while(!exit);

    }
    String userInput(){
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        return userInput;
    }
}
