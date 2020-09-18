import java.util.Scanner;
import java.util.regex.Pattern;

class Calculatrice {

    public static void main(String[] args) {

    }

    // Initialisation
    Scanner sc = new Scanner(System.in);
    String data;
    String[] tabData;
    int nbr1, nbr2, resultat;
    Boolean error = false;
    String userResponse = "";

    // GETTER --> Lire la propriété
    public void getResult() {

        // MAIN CODE
        while (!userResponse.equals("non")) {
            System.out.println(Util.APP_TITLE);
            try {
                System.out.print("Tape ton opération: ");
                data = sc.nextLine();

                if (Pattern.matches("([0-9]+)(\\s{1})([*+/-]{1})(\\s{1})([0-9]+)", data)) {
                    tabData = data.split("\\s");
                    nbr1 = Integer.parseInt(tabData[0]);
                    String coeff = tabData[1];
                    nbr2 = Integer.parseInt(tabData[2]);
                    if (coeff.equals("+")) {
                        resultat = nbr1 + nbr2;
                    } else if (coeff.equals("-")) {
                        resultat = nbr1 - nbr2;
                    } else if (coeff.equals("*")) {
                        resultat = nbr1 * nbr2;
                    } else {
                        resultat = nbr1 / nbr2;
                    }
                    System.out.print(data + "=> Le résultat est " + resultat);
                } else if (Pattern.matches("(.*)([a-zA-Z])(.*)", data)) {
                    System.out.print(data + "=> Ceci n'est pas logique, vous ne pouvez pas mettre de texte");
                } else if (Pattern.matches(
                        "([0-9]+)([*+/-]{1})([0-9]+)|([0-9]+)(\\s?)([*+/-]{1})([0-9]+)|([0-9]+)([*+/-]{1})(\\s?)([0-9]+)",
                        data)) {
                    System.out.print(data + "=> Vous devez mettre des espaces pour pouvoir calculer cette opération");
                } else if (Pattern.matches(
                        "([0-9]+)(\\s?)([*+/-]{1})(\\s?)([0-9]+)(((\\s?)([*+/-]{1})(\\s?)([0-9]+)){1,})", data)) {
                    System.out.print(data + "=> Il ne faut que 2 numéros");
                } else {
                    System.out.print("default " + data);
                }

                System.out.println(Util.QUESTION);
                userResponse = sc.nextLine();
            } catch (Exception exception) {
                if (sc.hasNextLine()) {
                    sc.nextLine();
                }
            }
        }

        // FINAL CODE
        System.out.println(Util.END_MESSAGE);
        sc.close();

    }
}
