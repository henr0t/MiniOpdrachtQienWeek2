package com.company;

import java.text.DecimalFormat;

class Cafe {
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
        MenuKaartCafe menuKaart1 = new MenuKaartCafe();
        menuKaart1.menu();

        Kassa kassabalans = new Kassa(50.00);
        DecimalFormat dec2 = new DecimalFormat("#.##");


        do{
            System.out.println("Huidige kassa inhoud: "+dec2.format(kassabalans.balans)+"\n");

            bestelling = inputCafe.userInput();
            switch(bestelling){
            case "1": case "cola":
                System.out.println("Hier is je "+menuKaart1.drankPrijs[0].naam+" dat kost "+menuKaart1.drankPrijs[0].prijs+".");
                kassabalans.balans = kassabalans.balans + menuKaart1.drankPrijs[0].prijs;
                break;
            case "2": case "koffie":
                System.out.println("Hier is je "+menuKaart1.drankPrijs[1].naam+" dat kost "+menuKaart1.drankPrijs[1].prijs+".");
                    kassabalans.balans = kassabalans.balans + menuKaart1.drankPrijs[1].prijs;
                break;
            case "3": case "pils":
                System.out.println("Hier is je "+menuKaart1.drankPrijs[2].naam+" dat kost "+menuKaart1.drankPrijs[2].prijs+".");
                    kassabalans.balans = kassabalans.balans + menuKaart1.drankPrijs[2].prijs;
                break;
            case "4": case "chocolade melk":
                System.out.println("Hier is je "+menuKaart1.drankPrijs[3].naam+" dat kost "+menuKaart1.drankPrijs[3].prijs+".");
                    kassabalans.balans = kassabalans.balans + menuKaart1.drankPrijs[3].prijs;
                break;
            case "5": case "jus d'orange":
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
            System.out.println("Bedankt en tot ziens!\n---------------");
    }

}

class Kassa{
    double balans;
    Kassa(double balans){
        this.balans = balans;
    }
}

class MenuKaartCafe{
    CafeDrank[] drankPrijs = new CafeDrank[5];
    void menu(){
        drankjes();
        System.out.println("MENUKAART:\n"+
                "1. "+ drankPrijs[0].naam+" kost "+drankPrijs[0].prijs+"\n"+
                "2. "+ drankPrijs[1].naam+" kost "+drankPrijs[1].prijs+"\n"+
                "3. "+ drankPrijs[2].naam+" kost "+drankPrijs[2].prijs+"\n"+
                "4. "+ drankPrijs[3].naam+" kost "+drankPrijs[3].prijs+"\n"+
                "5. "+ drankPrijs[4].naam+" kost "+drankPrijs[4].prijs+"\n"+
                        "m. voor menukaart\n\n"+
                        "[Ga weg door q in te voeren]\n");
    }

    void drankjes(){
        drankPrijs[0] = new CafeDrank("Cola", 2.00);
        drankPrijs[1] = new CafeDrank("Koffie", 1.55);
        drankPrijs[2] = new CafeDrank("Pils", 1.20);
        drankPrijs[3] = new CafeDrank("Chocolade melk",2.20);
        drankPrijs[4] = new CafeDrank("Jus d'orange", 2.50);
    }
}

class CafeDrank{
    double prijs;
    String naam;
    CafeDrank(String naam, double prijs){
        this.naam = naam;
        this. prijs = prijs;
    }
}
