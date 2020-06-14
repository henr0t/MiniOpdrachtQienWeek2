package com.company;

import java.util.Random;

public class Groepsreis {
    void groepsReis(){
        System.out.println("HUIDIGE LOCATIE: Vakantie locatie Qien\n");

        Toerist[] persoon = new Toerist[3];
        persoon[0] = new Toerist("Jan","Nederland",200.00,"Bus");
        persoon[1] = new Toerist("Emmanuel","Frankrijk",300.00,"Auto");
        persoon[2] = new Toerist("Elizabeth","Verenigd Koningkrijk",250.00,"Bus");

        System.out.println("De groep is "+persoon.length+" groot.\n");
        for(int i=0;i<persoon.length; i++) {
            System.out.println(persoon[i].naam+" uit "+persoon[i].land+" reist met "+persoon[i].vervoersMiddel+" en heeft een budget van €"+persoon[i].budget+".");
        }
        System.out.println("\nDe groepsreis duurt 3 dagen.");

        Souvenir souvenir1 = new Souvenir("munten",2,7);
        Souvenir souvenir2 = new Souvenir("posters",5,5);
        Souvenir souvenir3 = new Souvenir("bloemen",3,2);

        Locatie [] locaties = new Locatie[3];
        locaties[0] = new Locatie("monument", 12,souvenir1.naam);
        locaties[1] = new Locatie("museum",15,souvenir2.naam);
        locaties[2] = new Locatie("park", 2,souvenir3.naam);

        //souvenir aankoop randomizer:
        Randomizer random = new Randomizer();
        int rnd1 = random.randomnumber();
        int rnd2 = random.randomnumber();
        int rnd3 = random.randomnumber();


        System.out.println("\nOp dag 1 van de reis gaat de groep naar een "+locaties[0].categorie+":");
        System.out.println(persoon[0].naam+" gaat met de "+persoon[0].vervoersMiddel+" naar "+locaties[0].categorie+" ,als souvenir koopt hij "+rnd1 +" "+locaties[0].souvenir+".");
        persoon[0].budget= persoon[0].budget-locaties[0].entreeprijs-souvenir1.prijs*rnd1;
        System.out.println(persoon[1].naam+" gaat met de "+persoon[1].vervoersMiddel+" naar "+locaties[0].categorie+" ,als souvenir koopt hij "+rnd2 +" "+locaties[0].souvenir+".");
        persoon[1].budget= persoon[1].budget-locaties[0].entreeprijs-souvenir1.prijs*rnd2;
        System.out.println(persoon[2].naam+" gaat met de "+persoon[2].vervoersMiddel+" naar "+locaties[0].categorie+" ,als souvenir koopt zij "+rnd3 +" "+locaties[0].souvenir+".");
        persoon[2].budget= persoon[2].budget-locaties[0].entreeprijs-souvenir1.prijs*rnd3;

        System.out.println("\nOp dag 2 van de reis gaat de groep naar een "+locaties[1].categorie+":");
        System.out.println(persoon[0].naam+" gaat met de "+persoon[0].vervoersMiddel+" naar "+locaties[1].categorie+" ,als souvenir koopt hij "+rnd3 +" "+locaties[1].souvenir+".");
        persoon[0].budget= persoon[0].budget-locaties[1].entreeprijs-souvenir2.prijs*rnd3;
        System.out.println(persoon[1].naam+" gaat met de "+persoon[1].vervoersMiddel+" naar "+locaties[1].categorie+" ,als souvenir koopt hij "+rnd1 +" "+locaties[1].souvenir+".");
        persoon[1].budget= persoon[1].budget-locaties[1].entreeprijs-souvenir2.prijs*rnd1;
        System.out.println(persoon[2].naam+" gaat met de "+persoon[2].vervoersMiddel+" naar "+locaties[1].categorie+" ,als souvenir koopt zij "+rnd2 +" "+locaties[1].souvenir+".");
        persoon[2].budget= persoon[2].budget-locaties[1].entreeprijs-souvenir2.prijs*rnd2;

        System.out.println("\nOp dag 3 van de reis gaat de groep naar een "+locaties[2].categorie+":");
        System.out.println(persoon[0].naam+" gaat met de "+persoon[0].vervoersMiddel+" naar "+locaties[2].categorie+" ,als souvenir koopt hij "+rnd3 +" "+locaties[2].souvenir+".");
        persoon[0].budget= persoon[0].budget-locaties[2].entreeprijs-souvenir1.prijs*rnd3;
        System.out.println(persoon[1].naam+" gaat met de "+persoon[1].vervoersMiddel+" naar "+locaties[2].categorie+" ,als souvenir koopt hij "+rnd2 +" "+locaties[2].souvenir+".");
        persoon[1].budget= persoon[1].budget-locaties[2].entreeprijs-souvenir1.prijs*rnd2;
        System.out.println(persoon[2].naam+" gaat met de "+persoon[2].vervoersMiddel+" naar "+locaties[2].categorie+" ,als souvenir koopt zij "+rnd1 +" "+locaties[2].souvenir+".");
        persoon[2].budget= persoon[2].budget-locaties[2].entreeprijs-souvenir1.prijs*rnd3;




        System.out.println("\nAan het einde van de reis heeft:");
        System.out.println(persoon[0].naam+" €"+persoon[0].budget+" over." );
        System.out.println(persoon[1].naam+" €"+persoon[1].budget+" over." );
        System.out.println(persoon[2].naam+" €"+persoon[2].budget+" over." );


        System.out.println("\nTerug naar huis.\n---------------");
    }


}


class Toerist{
String naam;
String land;
double budget;
String vervoersMiddel;

    Toerist(String naam, String land, double budget, String vervoersMiddel){
    this.naam = naam;
    this.land = land;
    this.budget = budget;
    this.vervoersMiddel = vervoersMiddel;
    }

}

class Souvenir{
    String naam;
    double prijs;
    int houdbaarheidsdatum;
    Souvenir [] souvenirs = new Souvenir[3];

    Souvenir(String naam, double prijs, int houdbaarheidsdatum){
        this.naam = naam;
        this.prijs = prijs;
        this.houdbaarheidsdatum = houdbaarheidsdatum;
    }



}


class Locatie{
    String categorie;
    int entreeprijs;
    String souvenir;

    Locatie (String categorie, int entreeprijs, String souvenir){
        this.categorie = categorie;
        this.entreeprijs = entreeprijs;
        this.souvenir = souvenir;

    }
}

class Randomizer{
    int randomnumber(){
        Random rnd = new Random();
        int x = rnd.nextInt(5);
        return x;
    }
}