package SMS;

import SMS.Services.DB;
import SMS.control.*;
import SMS.models.Enseignant;

import java.util.Scanner;



import static SMS.login.ConnectionDB.addTeach;

public class Main {


   public static <object> boolean isNull(object ob) {

        return ob == null;
    }

    public static int getIntInput(String... msg) {
        Scanner sc = new Scanner(System.in);
        String message = "entrez un nombre entier:";
        if (msg.length > 0)
            message = msg[0];
        System.out.println(message);
        int num = sc.nextInt();
        return num;
    }

    public static String getStringInput(String... msg) {
        Scanner sc = new Scanner(System.in);
        String message = "Entrez un texte : ";
        if (msg.length > 0)
            message = msg[0];
        System.out.println(message);
        String str = sc.nextLine();
        return str;

    }

    public static void showPrincipalMenu() {
        System.out.println("   Welcome        ");
        System.out.println("1:pour gérer les departements");
        System.out.println("2:pour gérer les enseignats");
        System.out.println("3:pour gérer les modules");
        System.out.println("4:pour gérer les etudiant");
        System.out.println("5:pour gérer les filieres");
        System.out.println("0:pour sortir");
        int option = getIntInput("selectionnez une option :");
        switch (option) {
            case 1:
                departementcontrol.showMenu();
                break;
            case 2:
                enseignantcontrol.showMenu();
                break;
            case 3:
                modulecontrol.showMenu();
                break;
            case 4:
                etudiantcontrol.showMenu();
                break;
            case 5:
                filierecontrol.showMenu();
                break;
            default:
        }

    }

    public static void main(String[] args) {

        showPrincipalMenu();

    }
     }