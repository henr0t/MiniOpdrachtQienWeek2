package com.company;

import java.text.DecimalFormat;

class Bar {
    void bar() {
        System.out.println("HUIDIGE LOCATIE: Bar Qien\n");
        double bon1 = 0;

        MenuKaartBar menuKaart2 = new MenuKaartBar();
        menuKaart2.drankjes();

        //Bezoeker
        Bezoeker bezoeker1 = new Bezoeker("Henry", 20.0, 5, 6, 3, 1,0);
        System.out.println(bezoeker1.naam + " heeft " + bezoeker1.geld + " euro op zak.\n");
        int alcoholPunten = bezoeker1.dronken;


        //Bestelling
        System.out.println(bezoeker1.naam + " besteld " + bezoeker1.besteld[0] + " " + menuKaart2.drankVoorraad[0].naam + ",\n" +
                bezoeker1.besteld[1] + " " + menuKaart2.drankVoorraad[1].naam + ",\n" +
                bezoeker1.besteld[2] + " " + menuKaart2.drankVoorraad[2].naam + ",\n"+
                bezoeker1.besteld[3] + " " + menuKaart2.drankVoorraad[3].naam + ".\n");

        //voorraad check
        for(int i = 0;i<menuKaart2.drankVoorraad.length;i++) {
            if (menuKaart2.drankVoorraad[i].voorraad < bezoeker1.besteld[i]) {
                System.out.println("niet genoeg " + menuKaart2.drankVoorraad[i].naam + " op voorraad!\n");
            }
            else {
                menuKaart2.drankVoorraad[i].voorraad = menuKaart2.drankVoorraad[i].voorraad - bezoeker1.besteld[i];
                bon1 = bon1 + (bezoeker1.besteld[i] * menuKaart2.drankVoorraad[i].prijs);
                alcoholPunten = alcoholPunten + (menuKaart2.drankVoorraad[i].alcohol*bezoeker1.besteld[i]);
            }
        }

        if(alcoholPunten>=10){
            System.out.println(bezoeker1.naam+" is dronken!");
        }

        //bon
        DecimalFormat dec2 = new DecimalFormat("#.##");
        System.out.println("totale kosten van " + bezoeker1.naam + ": " + "€" + dec2.format(bon1));

        //Betalen
        if (bon1 > bezoeker1.geld) {
            System.out.println("Niet genoeg geld op zak!\n");
        } else {
            bezoeker1.geld = bezoeker1.geld - bon1;
            System.out.println(bezoeker1.naam + " heeft nog €" + dec2.format(bezoeker1.geld) + " op zak.\n");
        }

        System.out.println("Terug naar huis.\n---------------");
    }

}

class MenuKaartBar {
    BarDrank[] drankVoorraad = new BarDrank[4];
    void drankjes() {
        drankVoorraad[0] = new BarDrank("Bier", 1.50, 5, 1);
        drankVoorraad[1] = new BarDrank("Wijn", 1.60, 10,1);
        drankVoorraad[2] = new BarDrank("Whiskey", 2.10, 2,1);
        drankVoorraad[3] = new BarDrank("Koffie", 1.40, 10,-1);

    }
}


class BarDrank{
    double prijs;
    String naam;
    int voorraad;
    int alcohol;

    BarDrank(String naam, double prijs, int voorraad, int alcohol){
        this.naam = naam;
        this.prijs = prijs;
        this.voorraad = voorraad;
        this.alcohol = alcohol;
    }
}

class Bezoeker {
    String naam;
    double geld;
    int dronken;
    int[] besteld = new int[4];


    Bezoeker(String naam, double geld, int bier, int wijn, int whiskey, int koffie, int dronken) {
        this.naam = naam;
        this.geld = geld;

        this.besteld[0] = bier;
        this.besteld[1] = wijn;
        this.besteld[2] = whiskey;
        this.besteld[3] = koffie;

        this.dronken = dronken;

    }
}



