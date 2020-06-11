package com.company;

import java.text.DecimalFormat;

public class Cafe {
    void cafe(){
        System.out.println("HUIDIGE LOCATIE: Cafe Qien\n");

        Persoon kassa1 = new Persoon();
        kassa1.bestellen();

    }
}

class Persoon{
    boolean vertrekken;

    void bestellen(){

        //userinput
        UserInterface inputCafe = new UserInterface();
        String bestelling;

        //laat menukaart zien
        MenuKaart menuKaart1 = new MenuKaart();
        menuKaart1.menu();

        Kassa kassabalans = new Kassa(200.00);
        DecimalFormat dec2 = new DecimalFormat("#.##");


        do{
            System.out.println("Huidige kassa inhoud: "+dec2.format(kassabalans.balans)+"\n");

            bestelling = inputCafe.userInput();
            switch(bestelling){
            case "1": case "Cola":
                System.out.println("Hier is je "+menuKaart1.drankPrijs[0].naam+" dat kost "+menuKaart1.drankPrijs[0].prijs+".");
                kassabalans.balans = kassabalans.balans + menuKaart1.drankPrijs[0].prijs;
                break;
            case "2": case "Koffie":
                System.out.println("Hier is je "+menuKaart1.drankPrijs[1].naam+" dat kost "+menuKaart1.drankPrijs[1].prijs+".");
                    kassabalans.balans = kassabalans.balans + menuKaart1.drankPrijs[1].prijs;
                break;
            case "3": case "Pils":
                System.out.println("Hier is je "+menuKaart1.drankPrijs[2].naam+" dat kost "+menuKaart1.drankPrijs[2].prijs+".");
                    kassabalans.balans = kassabalans.balans + menuKaart1.drankPrijs[2].prijs;
                break;
            case "4": case "Chocolade melk":
                System.out.println("Hier is je "+menuKaart1.drankPrijs[3].naam+" dat kost "+menuKaart1.drankPrijs[3].prijs+".");
                    kassabalans.balans = kassabalans.balans + menuKaart1.drankPrijs[3].prijs;
                break;
            case "5": case "Jus d'orange":
                System.out.println("Hier is je "+menuKaart1.drankPrijs[4].naam+" dat kost "+menuKaart1.drankPrijs[4].prijs+".");
                    kassabalans.balans = kassabalans.balans + menuKaart1.drankPrijs[4].prijs;
                break;
            case "m": case "menu":
                menuKaart1.menu();
                break;
            case "q":
            vertrekken = true;
            }
        }
        while(!vertrekken);
            System.out.println("Bedankt en tot ziens!");
    }

}

class Kassa{
    double balans;
    Kassa(double balans){
        this.balans = balans;
    }
}

class MenuKaart{
    Drank[] drankPrijs = new Drank[5];
    void menu(){
        drankjes();
        System.out.println("MENUKAART:\n"+
                "1. "+ drankPrijs[0].naam+" kost "+drankPrijs[0].prijs+"\n"+
                "2. "+ drankPrijs[1].naam+" kost "+drankPrijs[1].prijs+"\n"+
                "3. "+ drankPrijs[2].naam+" kost "+drankPrijs[2].prijs+"\n"+
                "4. "+ drankPrijs[3].naam+" kost "+drankPrijs[3].prijs+"\n"+
                "5. "+ drankPrijs[4].naam+" kost "+drankPrijs[4].prijs+"\n"+
                        "m. voor menukaart\n"+
                        "[Ga weg door q in te voeren]\n");
    }

    void drankjes(){
        drankPrijs[0] = new Drank("Cola", 2.00);
        drankPrijs[1] = new Drank("Koffie", 1.55);
        drankPrijs[2] = new Drank("Pils", 1.20);
        drankPrijs[3] = new Drank("Chocolade melk",2.20);
        drankPrijs[4] = new Drank("Jus d'orange", 2.50);
    }
}

class Drank{
    double prijs;
    String naam;
    Drank(String naam, double prijs){
        this.naam = naam;
        this. prijs = prijs;
    }
}
