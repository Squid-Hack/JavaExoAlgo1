import java.util.Scanner;

class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Calculator calc = new Calculator(sc);
    calc.run();

    sc.close();
  }
}


class Calculator {
  private final String APP_TITLE =  "------------\n" +
                            "CALCULATRICE" +
                            "\n------------";
  private final String QUESTION = "\nVoulez-vous recommencer ?";
  private final String WHAT_OPERATION = "Type d'opération [+-/*%]: ";
  private final String END_MESSAGE = "Au revoir ! :)";
    
  private Scanner sc;
  private int nb1 = 0, nb2 = 0;
  private String operation = "";
  private String userResponse = "";

  Calculator(Scanner pScanner) {
    this.sc = pScanner;
  }

  public void run() {
    mainLoop: while (!userResponse.equals("non")) {
      System.out.println(APP_TITLE);
  
      try {
        System.out.print("1er nombre: ");
        nb1 = sc.nextInt();
        sc.nextLine();

        System.out.print(WHAT_OPERATION);
        operation = sc.next();
        sc.nextLine();
        
        System.out.print("2ème nombre: ");
        nb2 = sc.nextInt();
        sc.nextLine();

        int result = 0;
        switch (operation) {
          case "+":
            result = nb1 + nb2;
            break;
          case "-":
            result = nb1 - nb2;
            break;
          case "/":
            result = nb1 / nb2;
            break;
          case "*":
            result = nb1 * nb2;
            break;
          case "%":
            result = nb1 % nb2;
            break;
          default:
            System.out.println("Calcul imposssible !");
            continue mainLoop;
        }
        
        System.out.println("Résultat de l'opération: " + result);
        
        System.out.println(QUESTION);
        userResponse = sc.nextLine();
      }
      catch (Exception exception) {
        if (sc.hasNextLine()) {
          sc.nextLine();
        }
      }
    }

    // FINAL CODE
    System.out.println(END_MESSAGE);
    sc.close();
  }
}