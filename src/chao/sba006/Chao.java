package chao.sba006;

import java.util.Arrays;
import java.util.Random;


/** This class creates Chao objects with variables to represent their genes, phenotypes, etc.
 *
 * @author Samuel Allan
 */
public class Chao {
    private String colorAllele1;
    private String colorAllele2;
    private String colorPhenotype;

    private String toneAllele1;
    private String toneAllele2;
    private String tonePhenotype;

    private String shineAllele1;
    private String shineAllele2;
    private String shinePhenotype;

    private String jewelAllele1;
    private String jewelAllele2;
    private String jewelPhenotype;

    private String appearance;


    /** Constructs a completely random Chao.
     * Note: incredibly high chance (~99.3%) to receive some sort of Jewel Chao.
     */
    Chao() {
        String[] colorList = {"Normal", "White", "Blue", "Red", "Yellow", "Orange", "Pink", "Purple", "Sky Blue", "Green", "Brown", "Grey", "Lime Green", "Black"};
        String[] toneList = {"Two-Tone", "Mono-Tone"};
        String[] shineList = {"Non-Shiny", "Shiny"};
        String[] jewelList = {"Non-Jewel", "Silver", "Gold", "Ruby", "Sapphire", "Amethyst", "Emerald", "Garnet", "Aquamarine", "Peridot", "Topaz", "Onyx"};


        Random rand = new Random();


        colorAllele1 = colorList[rand.nextInt(colorList.length)];
        colorAllele2 = colorList[rand.nextInt(colorList.length)];
        //
        if (!colorAllele1.equals("Normal") && !colorAllele2.equals("Normal")) {
            String[] colorPhenotypePossibilities = {colorAllele1, colorAllele2};
            colorPhenotype = colorPhenotypePossibilities[rand.nextInt(colorPhenotypePossibilities.length)];
        } else if (!colorAllele1.equals("Normal")) {
            colorPhenotype = colorAllele1;
        } else if (!colorAllele2.equals("Normal")) {
            colorPhenotype = colorAllele2;
        } else {
            colorPhenotype = "Normal";
        }


        toneAllele1 = toneList[rand.nextInt(toneList.length)];
        toneAllele2 = toneList[rand.nextInt(toneList.length)];
        //
        String[] tonePhenotypePossibilities = {toneAllele1, toneAllele2};
        tonePhenotype = tonePhenotypePossibilities[rand.nextInt(tonePhenotypePossibilities.length)];


        shineAllele1 = shineList[rand.nextInt(shineList.length)];
        shineAllele2 = shineList[rand.nextInt(shineList.length)];
        //
        String[] shinePhenotypePossibilities = {shineAllele1, shineAllele2};
        shinePhenotype = shinePhenotypePossibilities[rand.nextInt(shinePhenotypePossibilities.length)];


        jewelAllele1 = jewelList[rand.nextInt(jewelList.length)];
        jewelAllele2 = jewelList[rand.nextInt(jewelList.length)];
        //
        if (!jewelAllele1.equals("Non-Jewel") && !jewelAllele2.equals("Non-Jewel")) {
            String[] jewelPhenotypePossibilities = {jewelAllele1, jewelAllele2};
            jewelPhenotype = jewelPhenotypePossibilities[rand.nextInt(jewelPhenotypePossibilities.length)];
        } else if (!jewelAllele1.equals("Non-Jewel")) {
            jewelPhenotype = jewelAllele1;
        } else if (!jewelAllele2.equals("Non-Jewel")) {
            jewelPhenotype = jewelAllele2;
        } else {
            jewelPhenotype = "Non-Jewel";
        }


        if (shinePhenotype.equals("Shiny") && !jewelPhenotype.equals("Non-Jewel")) {
            appearance = "Shiny Jewel " + colorPhenotype;
        } else if (!jewelPhenotype.equals("Non-Jewel")) {
            appearance = jewelPhenotype;
        } else if (shinePhenotype.equals("Shiny")) {
            appearance = "Shiny " + tonePhenotype + " " + colorPhenotype;
        } else {
            appearance = tonePhenotype + " " + colorPhenotype;
        }
    }


    /** Constructs a Chao that would be obtainable from a Generation 0 egg.
     * I.e. Eggs purchasable from the Black Market and Tiny Chao Garden, and eggs found in the Chao Gardens upon entering them for the first time.
     * Prints an error message if the egg is invalid.
     *
     * @param egg - the name of the egg from which the Chao would hatch (must be title-case).
     */
    Chao(String egg) {


        String[] nonshinyList = {"White Egg", "Blue Egg", "Red Egg", "Yellow Egg", "Orange Egg", "Pink Egg", "Purple Egg", "Sky Blue Egg", "Green Egg", "Brown Egg", "Grey Egg", "Lime Green Egg ", "Black Egg"};
        String[] shinyList = {"Shiny White Egg", "Shiny Blue Egg", "Shiny Red Egg", "Shiny Yellow Egg", "Shiny Orange Egg", "Shiny Pink Egg", "Shiny Purple Egg", "Shiny Sky Blue Egg", "Shiny Green Egg", "Shiny Brown Egg", "Shiny Grey Egg", "Shiny Lime Green Egg", "Shiny Black Egg"};
        String[] jewelList = {"Silver Egg", "Gold Egg", "Ruby Egg", "Sapphire Egg", "Amethyst Egg", "Emerald Egg", "Garnet Egg", "Aquamarine Egg", "Peridot Egg", "Topaz Egg", "Onyx Egg"};
        String[] defaultList = {"Normal Egg", "Default Egg", "Two-Tone Egg", "Egg"}; //All possible different names for the same thing, no real canon name.

        if (Arrays.asList(nonshinyList).contains(egg) || Arrays.asList(shinyList).contains(egg)) {
            colorAllele1 = egg.replace(" Egg", "").replace("Shiny ", "");
            colorAllele2 = colorAllele1;
            colorPhenotype = colorAllele1;

            toneAllele1 = "Mono-Tone";
            toneAllele2 = toneAllele1;
            tonePhenotype = toneAllele1;

            if (Arrays.asList(nonshinyList).contains(egg)) {
                shineAllele1 = "Non-Shiny";
                shineAllele2 = shineAllele1;
                shinePhenotype = shineAllele1;
            } else {
                shineAllele1 = "Shiny";
                shineAllele2 = shineAllele1;
                shinePhenotype = shineAllele1;
            }

            jewelAllele1 = "Non-Jewel";
            jewelAllele2 = jewelAllele1;
            jewelPhenotype = jewelAllele1;

            if (shinePhenotype.equals("Shiny")) {
                appearance = "Shiny " + tonePhenotype + " " + colorPhenotype;
            } else {
                appearance = tonePhenotype + " " + colorPhenotype;
            }
        } else if (Arrays.asList(jewelList).contains(egg)) {
            colorAllele1 = "Normal";
            colorAllele2 = colorAllele1;
            colorPhenotype = colorAllele1;

            toneAllele1 = "Two-Tone";
            toneAllele2 = toneAllele1;
            tonePhenotype = toneAllele1;

            shineAllele1 = "Non-Shiny";
            shineAllele2 = shineAllele1;
            shinePhenotype = shineAllele1;

            jewelAllele1 = egg.replace(" Egg", "");
            jewelAllele2 = jewelAllele1;
            jewelPhenotype = jewelAllele1;

            appearance = jewelPhenotype;
        } else if (Arrays.asList(defaultList).contains(egg)) {
            colorAllele1 = "Normal";
            colorAllele2 = colorAllele1;
            colorPhenotype = colorAllele1;

            toneAllele1 = "Two-Tone";
            toneAllele2 = toneAllele1;
            tonePhenotype = toneAllele1;

            shineAllele1 = "Non-Shiny";
            shineAllele2 = shineAllele1;
            shinePhenotype = shineAllele1;

            jewelAllele1 = "Non-Jewel";
            jewelAllele2 = jewelAllele1;
            jewelPhenotype = jewelAllele1;

            appearance = tonePhenotype + " " + colorPhenotype;
        } else {
            System.out.println("ERROR: Invalid egg type.");
        }
    }


    /** Constructs a possible child Chao of two parent Chao. Inheritance is still left to random chance.
     *
     * @param parent1 - the first parent Chao
     * @param parent2 - the second parent Chao
     */
    Chao(Chao parent1, Chao parent2) {
        String[] colorList = {"Normal", "White", "Blue", "Red", "Yellow", "Orange", "Pink", "Purple", "Sky Blue", "Green", "Brown", "Grey", "Lime Green", "Black"};
        String[] toneList = {"Two-Tone", "Mono-Tone"};
        String[] shineList = {"Non-Shiny", "Shiny"};
        String[] jewelList = {"Non-Jewel", "Silver", "Gold", "Ruby", "Sapphire", "Amethyst", "Emerald", "Garnet", "Aquamarine", "Peridot", "Topaz", "Onyx"};


        Random rand = new Random();


        colorAllele1 = parent1.getAlleleList("Color")[rand.nextInt(parent1.getAlleleList("Color").length)];
        colorAllele2 = parent2.getAlleleList("Color")[rand.nextInt(parent2.getAlleleList("Color").length)];
        //
        if (!colorAllele1.equals("Normal") && !colorAllele2.equals("Normal")) {
            String[] colorPhenotypePossibilities = {colorAllele1, colorAllele2};
            colorPhenotype = colorPhenotypePossibilities[rand.nextInt(colorPhenotypePossibilities.length)];
        } else if (!colorAllele1.equals("Normal")) {
            colorPhenotype = colorAllele1;
        } else if (!colorAllele2.equals("Normal")) {
            colorPhenotype = colorAllele2;
        } else {
            colorPhenotype = "Normal";
        }


        toneAllele1 = parent1.getAlleleList("Tone")[rand.nextInt(parent1.getAlleleList("Tone").length)];
        toneAllele2 = parent2.getAlleleList("Tone")[rand.nextInt(parent2.getAlleleList("Tone").length)];
        //
        String[] tonePhenotypePossibilities = {toneAllele1, toneAllele2};
        tonePhenotype = tonePhenotypePossibilities[rand.nextInt(tonePhenotypePossibilities.length)];


        shineAllele1 = parent1.getAlleleList("Shine")[rand.nextInt(parent1.getAlleleList("Shine").length)];
        shineAllele2 = parent2.getAlleleList("Shine")[rand.nextInt(parent2.getAlleleList("Shine").length)];
        //
        String[] shinePhenotypePossibilities = {shineAllele1, shineAllele2};
        shinePhenotype = shinePhenotypePossibilities[rand.nextInt(shinePhenotypePossibilities.length)];


        jewelAllele1 = parent1.getAlleleList("Jewel")[rand.nextInt(parent1.getAlleleList("Jewel").length)];
        jewelAllele2 = parent2.getAlleleList("Jewel")[rand.nextInt(parent2.getAlleleList("Jewel").length)];
        //
        if (!jewelAllele1.equals("Non-Jewel") && !jewelAllele2.equals("Non-Jewel")) {
            String[] jewelPhenotypePossibilities = {jewelAllele1, jewelAllele2};
            jewelPhenotype = jewelPhenotypePossibilities[rand.nextInt(jewelPhenotypePossibilities.length)];
        } else if (!jewelAllele1.equals("Non-Jewel")) {
            jewelPhenotype = jewelAllele1;
        } else if (!jewelAllele2.equals("Non-Jewel")) {
            jewelPhenotype = jewelAllele2;
        } else {
            jewelPhenotype = "Non-Jewel";
        }


        if (shinePhenotype.equals("Shiny") && !jewelPhenotype.equals("Non-Jewel")) {
            appearance = "Shiny Jewel " + colorPhenotype;
        } else if (!jewelPhenotype.equals("Non-Jewel")) {
            appearance = jewelPhenotype;
        } else if (shinePhenotype.equals("Shiny")) {
            appearance = "Shiny " + tonePhenotype + " " + colorPhenotype;
        } else {
            appearance = tonePhenotype + " " + colorPhenotype;
        }
    }


    /** Constructs a Chao with specific traits.
     * Phenotypes must be legal.
     *
     * @param colors - an array of length 3 that satisfies {colorAllele1, colorAllele2, colorPhenotype}
     * @param tones - an array of length 3 that satisfies {toneAllele1, toneAllele2, tonePhenotype}
     * @param shines - an array of length 3 that satisfies {shineAllele1, shineAllele2, shinePhenotype}
     * @param jewels - an array of length 3 that satisfies {jewelAllele1, jewelAllele2, jewelPhenotype}
     */
    Chao(String[] colors, String[] tones, String[] shines, String[] jewels) {
        String[] colorList = {"Normal", "White", "Blue", "Red", "Yellow", "Orange", "Pink", "Purple", "Sky Blue", "Green", "Brown", "Grey", "Lime Green", "Black"};
        String[] toneList = {"Two-Tone", "Mono-Tone"};
        String[] shineList = {"Non-Shiny", "Shiny"};
        String[] jewelList = {"Non-Jewel", "Silver", "Gold", "Ruby", "Sapphire", "Amethyst", "Emerald", "Garnet", "Aquamarine", "Peridot", "Topaz", "Onyx"};


        if (!(colors.length == 3 && tones.length == 3 && shines.length == 3 && jewels.length == 3)) { //If one of the input arrays is not of length 3
            System.out.println("ERROR: Invalid length of one or more inputs, arrays must all be of length 3.");
        } else if (!(Arrays.asList(colorList).contains(colors[0]) && Arrays.asList(colorList).contains(colors[1]))) { //If one of the colorAlleles is an invalid input
            System.out.println("ERROR: At least one specified color does not exist.");
        } else if (!(Arrays.asList(toneList).contains(tones[0]) && Arrays.asList(toneList).contains(tones[1]))) { //If one of the toneAlleles is an invalid input
            System.out.println("ERROR: At least one specified tone does not exist.");
        } else if (!(Arrays.asList(shineList).contains(shines[0]) && Arrays.asList(shineList).contains(shines[1]))) { //If one of the shineAlleles is an invalid input
            System.out.println("ERROR: At least one specified shine does not exist.");
        } else if (!(Arrays.asList(jewelList).contains(jewels[0]) && Arrays.asList(jewelList).contains(jewels[1]))) { //If one of the jewelAlleles is an invalid input
            System.out.println("ERROR: At least one specified jewel does not exist.");
        } else if (!colors[2].equals(colors[0]) && !colors[2].equals(colors[1])) { //If colorPhenotype is not one of the colorAlleles
            System.out.println("ERROR: Invalid color phenotype, not included as an allele.");
        } else if (colors[2].equals("Normal") && !(colors[0].equals("Normal") && colors[1].equals("Normal"))) { //If colorPhenotype is the recessive "Normal" when it should be the other, dominant color
            System.out.println("ERROR: Invalid color phenotype, 'Normal' is recessive.");
        } else if (!tones[2].equals(tones[0]) && !tones[2].equals(tones[1])) {  //If tonePhenotype is not one of the toneAlleles
            System.out.println("ERROR: Invalid tone phenotype, not included as an allele.");
        } else if (!shines[2].equals(shines[0]) && !shines[2].equals(shines[1])) {  //If shinePhenotype is not one of the shineAlleles
            System.out.println("ERROR: Invalid shine phenotype, not included as an allele.");
        } else if (!jewels[2].equals(jewels[0]) && !jewels[2].equals(jewels[1])) {  //If jewelPhenotype is not one of the jewelAlleles
            System.out.println("ERROR: Invalid jewel phenotype, not included as an allele.");
        } else if (jewels[2].equals("Non-Jewel") && !(jewels[0].equals("Non-Jewel") && jewels[1].equals("Non-Jewel"))) { //If jewelPhenotype is the recessive "Non-Jewel" when it should be the other, dominant jewel
            System.out.println("ERROR: Invalid jewel phenotype, 'Non-Jewel' is recessive.");
        } else {
            colorAllele1 = colors[0];
            colorAllele2 = colors[1];
            colorPhenotype = colors[2];

            toneAllele1 = tones[0];
            toneAllele2 = tones[1];
            tonePhenotype = tones[2];

            shineAllele1 = shines[0];
            shineAllele2 = shines[1];
            shinePhenotype = shines[2];

            jewelAllele1 = jewels[0];
            jewelAllele2 = jewels[1];
            jewelPhenotype = jewels[2];

            if (shinePhenotype.equals("Shiny") && !jewelPhenotype.equals("Non-Jewel")) {
                appearance = "Shiny Jewel " + colorPhenotype;
            } else if (!jewelPhenotype.equals("Non-Jewel")) {
                appearance = jewelPhenotype;
            } else if (shinePhenotype.equals("Shiny")) {
                appearance = "Shiny " + tonePhenotype + " " + colorPhenotype;
            } else {
                appearance = tonePhenotype + " " + colorPhenotype;
            }
        }
    }


    /** Prints the breed phenotype (not alignment/evolution) of the Chao, using normal naming convention. */
    public void showChao() {
        System.out.println(appearance + "\n");
    }


    /** Obtains a list containing the two alleles the Chao has for a given trait.
     *
     * @param alleleType - the type of allele being parsed (can only be "Color", "Tone", "Shine" or "Jewel" - other inputs print an error and return a null list)
     */
    public String[] getAlleleList(String alleleType) {
        if (alleleType.equals("Color")) {
            String[] alleleList = {colorAllele1, colorAllele2};
            return alleleList;
        } else if (alleleType.equals("Tone")) {
            String[] alleleList = {toneAllele1, toneAllele2};
            return alleleList;
        } else if (alleleType.equals("Shine")) {
            String[] alleleList = {shineAllele1, shineAllele2};
            return alleleList;
        } else if (alleleType.equals("Jewel")) {
            String[] alleleList = {jewelAllele1, jewelAllele2};
            return alleleList;
        } else {
            System.out.println("ERROR: Invalid alleleType input.");
            //
            String[] alleleList = null;
            return alleleList;
        }
    }


    /** Prints out a detailed list of the Chao's genotype (not alignment/evolution). */
    public void getGenotype() {
        System.out.println("Color Alleles: " + colorAllele1 + ", " + colorAllele2 + " (Phenotype: " + colorPhenotype + ")");
        System.out.println("Tone Alleles: " + toneAllele1 + ", " + toneAllele2 + " (Phenotype: " + tonePhenotype + ")");
        System.out.println("Shine Alleles: " + shineAllele1 + ", " + shineAllele2 + " (Phenotype: " + shinePhenotype + ")");
        System.out.println("Jewel Alleles: " + jewelAllele1 + ", " + jewelAllele2 + " (Phenotype: " + jewelPhenotype + ")\n");
    }
}
