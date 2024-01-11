
package SMS.control;

import SMS.Services.DB;
import SMS.Services.departementservice;
import SMS.Services.enseignantservice;

import SMS.models.Departement;

import java.util.Scanner;

import static SMS.Main.*;
import static SMS.login.ConnectionDB.*;
import static java.util.Objects.isNull;

public class departementcontrol {



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

    public static void showMenu(){
        System.out.println("[ Départements ]");
        System.out.println("1: Pour ajouter un département");
        System.out.println("2: Pour afficher les départements");
        System.out.println("3: Pour modifier un département");
        System.out.println("4: Pour supprimer un département");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                addDept();
                break;
            case 2:
                getDeptById();
                break;
            case 3:
                updateDpt();
                break;
            case 4:
                deleteDptById();
                break;
            default:
                showPrincipalMenu();
        }}
public static void showDepartements(){
    for(Departement departement : DB.departements){
        System.out.println("Id :" +departement.getId());
        System.out.println("Intitule :"+departement.getIntitule());
        if(!isNull(departement.getResponsable())){
            System.out.println(" responsable :"+departement.getResponsable().getNom()+" "+
                    departement.getResponsable().getPrenom());
        }
        System.out.println(" ");
    }

    }
    public static void createDepartement(){
        String intitule =getStringInput("entrez l'intitule :");
        enseignantcontrol.showEnseignant();
        int id=getIntInput("selectionnez un enseignant par id:");
        departementservice.addDept(intitule, enseignantservice.getEnsById(id));
        showDepartements();
        showMenu();
    }
    public static void editDepartement(){
        showDepartements();
        int id = getIntInput("selectionnez un departement par id :");
        String intitule=getStringInput("entrez l'intitule :");
        enseignantcontrol.showEnseignant();
        int idEns=getIntInput("selectionnez un enseignant par id:");
        departementservice.updateDept(id,intitule,enseignantservice.getEnsById(idEns));

        showDepartements();
        showMenu();
    }
    public static void destroyDepartement(){
        showDepartements();
        int id=getIntInput("Sélecionnez un departement par id :");
        departementservice.deleteDeptById(id);
        showDepartements();
    }
}
