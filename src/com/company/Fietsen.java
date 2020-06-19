package com.company;

import java.text.DecimalFormat;
import java.util.Random;

public class Fietsen {
    void fietsen(){
        System.out.println("HUIDIGE LOCATIE: Fietsroute Qien\n");


       Fietser fietser1 = new Fietser("Sean",100,15.0);

      fietser1.fietsen();
    }
}

class Fiets {
    String merk;
    String kleur;
    String modelsoort;
    boolean lekkeband;


    Fiets(String merk, String kleur, String modelsoort){
        this.merk = merk;
        this.kleur = kleur;
        this.modelsoort = modelsoort;
    }
    int lekkeband(){
        Random rnd = new Random();
        int kans = rnd.nextInt(100);
        System.out.println(kans);
        return kans;
    }
}

class Fietser {
    String naam;
    int conditie;
    double portemonnee;
    boolean flauwte;
    boolean stop;

    Fietser (String naam, int conditie, double portemonnee){
        this.naam = naam;
        this.conditie = conditie;
        this.portemonnee = portemonnee;
    }

    void fietsen(){
        Fiets fiets1 = new Fiets("Batavus", "rood","racefiets");
     do{

         DecimalFormat dec2 = new DecimalFormat("#.##");
         System.out.println(naam+ " heeft een conditie van "+conditie+"% en heeft nog €"+dec2.format(portemonnee)+" op zak.\n" +
         "Hoeveel km fietst "+naam+"? \nm. om een Mars bar eten (+20% conditie, -€1,20)\n\n[Ga weg door q in te voeren]\n");

        UserInterface inputFietsen = new UserInterface();
        String actie = inputFietsen.userInput();

        if(actie.equals("m") && portemonnee > 0){
            System.out.println("Eet Mars Bar\n");
            conditie = conditie +20;
            portemonnee = portemonnee - 1.20;
            if(conditie>=200){
                flauwte = true;
                System.out.println("Te veel energie!");
            }
            if(portemonnee < 0){
                System.out.println(naam+" Heeft geen geld meer!");
            }
        }
        else if(actie.equals("m")){
            System.out.println("Geen geld meer om een Mars Bar te kopen.\n");
        }
        else if(actie.equals("q")){
            stop = true;
            break;
        }

        else {

            int actieInt = Integer.parseInt(actie);

            if (actieInt >= 100) {
                System.out.println("Je kan niet zoveel fietsen!\n");
            } else {
                conditie = conditie - actieInt;
            }

            if (conditie > 5 && conditie <= 10) {
                System.out.println("Pas op! Je hebt bijna geen energie meer, als het minder is dan 5% val je om.");
            } else if (conditie <= 5) {
                flauwte = true;
            }
        }

        if (fiets1.lekkeband() > 90){
            System.out.println("Band is lek!");
            fiets1.lekkeband = true;
            do {
                String repareer = inputFietsen.userInput();
                System.out.println("1. Laat fiets repareren (kost €10)\n2. Fiets zelf repareren (kost 20% conditie)");
                switch (repareer){
                    case "1":
                        if(portemonnee<10){
                            System.out.println("\nNiet genoeg geld!");
                            break;
                        }
                        else{
                            portemonnee = portemonnee-10;
                            fiets1.lekkeband = false;
                            break;
                        }

                    case "2":
                        conditie = conditie-20;
                        fiets1.lekkeband = false;
                        break;
                }

            }
            while(fiets1.lekkeband);
            System.out.println("Band is geplakt, je kan weer door!\n");
        }
     }
     while(!flauwte || !stop);
        System.out.println(naam+" is van zijn fiets gevallen en naar het ziekenhuis gebracht.");

    }
}