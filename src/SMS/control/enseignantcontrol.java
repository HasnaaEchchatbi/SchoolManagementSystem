package SMS.control;

import SMS.Services.DB;
import SMS.Services.departementservice;
import SMS.Services.enseignantservice;
import SMS.models.Enseignant;

import SMS.models.Departement;


import java.util.Scanner;

import static SMS.Main.*;
import static SMS.login.ConnectionDB.*;
import static java.util.Objects.isNull;

public class enseignantcontrol {


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
            System.out.println("[ Enseignants ]");
            System.out.println("1: Pour ajouter un enseignant");
            System.out.println("2: Pour afficher les enseignants");
            System.out.println("3: Pour modifier un enseignant");
            System.out.println("4: Pour supprimer un enseignant");
            System.out.println("0: Pour retourner au menu principal");

            //"Veuillez sélectionner une option : ")
            int option = getIntInput("Veuillez sélectionner une option : ");
            switch(option) {
                case 1:

                    addTeach();
                    break;
                case 2:
                    getTeachById();
                    break;
                case 3:
                    updateteach();
                    break;
                case 4:
                    deleteTeachById();
                    break;
                default:
                   showPrincipalMenu();
            }}



    public static void showEnseignant(){
            for(Enseignant enseignant : DB.enseignants){
                System.out.println("Id :" +enseignant.getId());
                System.out.println("Nom :"+enseignant.getNom());
                System.out.println("Prenom :"+enseignant.getPrenom());
                System.out.println("grade :"+enseignant.getGrade());
                System.out.println("email :"+enseignant.getEmail());
                if(!isNull (enseignant.getDepartement())){
                    System.out.println(" departement:"+enseignant.getDepartement().getIntitule()+" "
                            +enseignant.getDepartement().getId());
                }
                System.out.println(" ");
            }

        }
        public static void createEnseignant(){
            String nom =getStringInput("entrez le nom :");
            String prenom =getStringInput("entrez le prenom :");
            String grade =getStringInput("entrez la grade:");
            String email =getStringInput("entrez l'email:");
            departementcontrol.showDepartements();
            int id=getIntInput("selectionnez un departement par id:");
            enseignantservice.addEns(nom,prenom,grade,email, departementservice.getDeptById(id));
           enseignantcontrol.showEnseignant();
            showMenu();
        }
        public static void editEnseignant(){
            enseignantcontrol.showEnseignant();
            int id=getIntInput("selectionnez un enseignant par id :");
            String nom =getStringInput("entrez le nom:");
            String prenom =getStringInput("entrez le prenom :");
            String grade =getStringInput("entrez la grade:");
            String email =getStringInput("entrez l'email:");
            departementcontrol.showDepartements();
            int idDpt=getIntInput("selectionnez un departement par id:");
            enseignantservice.updateEns(id,nom,prenom,grade,email,departementservice.getDeptById(idDpt));

            enseignantcontrol.showEnseignant();
            showMenu();
        }
        public static void destroyEnseignant(){
            enseignantcontrol.showEnseignant();
            int id=getIntInput("Sélecionnez un enseignantt par id :");
            enseignantservice.deleteEnsById(id);
            enseignantcontrol.showEnseignant();
        }
    }



