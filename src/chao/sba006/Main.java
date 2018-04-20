package chao.sba006;

/** A program meant to simulate and manipulate the 'Chao' creatures found in Sonic Adventure 2: Battle.
 * Run exampleRun() for a taste of what the program can do.
 *
 * @author Samuel Allan
 */

public class Main {
    public static void exampleRun() {
        System.out.println("\n-- GENERATION 0 --");


        Chao joseph = new Chao(); //Joseph is a fully random Chao.

        System.out.println("\nJoseph");
        joseph.showChao();
        joseph.getGenotype();


        Chao hilda = new Chao("Shiny Black Egg"); //Hilda is a Chao that would be obtained from a Shiny Black Egg, bought from the Black Market.

        System.out.println("\nHilda");
        hilda.showChao();
        hilda.getGenotype();


        Chao cody = new Chao("Normal Egg"); //Cody is a Chao that would be obtained from a default egg, found upon entering a new Chao Garden.

        System.out.println("\nCody");
        cody.showChao();
        cody.getGenotype();


        String[] isabelleColors = {"Normal", "Normal", "Normal"};
        String[] isabelleTones = {"Two-Tone", "Mono-Tone", "Two-Tone"};
        String[] isabelleShines = {"Non-Shiny", "Shiny", "Shiny"};
        String[] isabelleJewels = {"Amethyst", "Non-Jewel", "Amethyst"};
        Chao isabelle = new Chao(isabelleColors, isabelleTones, isabelleShines, isabelleJewels); //Isabelle is a Chao with genes completely specified above.

        System.out.println("\nIsabelle");
        isabelle.showChao();
        isabelle.getGenotype();


        //////

        System.out.println("\n-- GENERATION 1 --");


        Chao gerard = new Chao(joseph, hilda); //Gerard is a Chao with parents Joseph and Hilda.

        System.out.println("\nGerard");
        gerard.showChao();
        gerard.getGenotype();


        Chao monica = new Chao(cody, isabelle); //Monica is a Chao with parents Cody and Isabelle.

        System.out.println("\nMonica");
        monica.showChao();
        monica.getGenotype();


        //////

        System.out.println("\n-- GENERATION 2 --");


        Chao finn = new Chao(gerard, monica); //Finn is a Chao with parents Gerard and Monica.

        System.out.println("\nFinn");
        finn.showChao();
        finn.getGenotype();
    }

    public static void main(String[] args) {
        exampleRun();
    }
}
