import java.util.Arrays;

class App {

    public static void main(String[] args) {

        /* instancie les var */ 
        String[] list = { "coco", "pedro", "herve", "coco", };
        String[] list2 = { "", "", "", "", };
        String test = "";

        /* boule de la list 1 (nbr de bouble = nbr de noms) */
        for (int count = 0; count < list.length; count++) {
            /* boule de la list 2 (nbr de bouble = nbr de noms) */
            for (int countBeta = 0; countBeta < list2.length; countBeta++) {
                /* si on retrouve le même nom */
                if (list[count] == list2[countBeta]) {
                    test = "erreur";
                }
            }

            if (test != "erreur") {
                list2[count] = list[count];
            }

            /* reset du test */
            test = "";
        }

        /* ordre alphabétique */ 
        Arrays.sort(list2);

        System.out.print(Arrays.toString(list2));
    }

}