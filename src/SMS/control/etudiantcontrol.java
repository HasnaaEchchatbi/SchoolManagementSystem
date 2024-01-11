package SMS.control;

import SMS.Services.*;
import SMS.models.Etudiant;
import SMS.models.Filiere;


import java.util.Scanner;

import static SMS.Main.*;
import static SMS.control.departementcontrol.showDepartements;
import static SMS.login.ConnectionDB.*;

public class etudiantcontrol {


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
        System.out.println("[ Etudiants ]");
        System.out.println("1: Pour ajouter un etudiant");
        System.out.println("2: Pour afficher les etudiants");
        System.out.println("3: Pour modifier un etudiant");
        System.out.println("4: Pour supprimer un etudiant");
        System.out.println("0: Pour retourner au menu principal");

        int option = getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                addEtd();
                break;
            case 2:
                getEtdById();

                break;
            case 3:
                updateEtd();
                break;
            case 4:
                deleteEtdById();
                break;
            default:
                showPrincipalMenu();
        }}
    /*public static void showEtudiant(){
        for(Etudiant etudiant : DB.etudiants){
            System.out.println("Id :" +etudiant.getId());
            System.out.println("Nom :"+etudiant.getNom());
            System.out.println("Prenom :"+etudiant.getPrenom());
            System.out.println("email:"+etudiant.getEmail());
            System.out.println("apogee :"+etudiant.getApogee());
            if(!isNull(etudiant.getFiliere())){
                System.out.println(" filiere:"+etudiant.getFiliere().getIntitule()+" "
                        +etudiant.getFiliere().getResponsable()+" "+etudiant.getFiliere().getDepartement()+" "+
                        etudiant.getFiliere().getId()+" "+
                        etudiant.getFiliere().getModules());
            }
            System.out.println(" ");
        }

    }
    public static void createEtudiant(){
        String nom =getStringInput("entrez le nom :");
        String prenom =getStringInput("entrez le prenom :");
        int apogee =getIntInput("entrez le code apogee:");
        String email =getStringInput("entrez l'email:");
        filierecontrol.showFiliere();
        int id=getIntInput("selectionnez une filiere  par id:");

        etudiantservice.addEtd( nom,prenom,email,apogee,filiereservice.getFiliereById(id));
        showEtudiant();
        showMenu();
    }
    public static void editEtudiant(){
        showEtudiant();
        int id=getIntInput("selectionnez un etudiant par id :");
        String nom =getStringInput("entrez le nom :");
        String prenom =getStringInput("entrez le prenom :");
        int apogee =getIntInput("entrez le code apogee:");
        String email =getStringInput("entrez l'email:");
       filierecontrol.showFiliere();
        int idFil=getIntInput("selectionnez une filiere par id:");
        etudiantservice.updateEtd(id, nom,prenom,email,apogee, filiereservice.getFiliereById(idFil));

        showEtudiant();
        showMenu();
    }
    public static void destroyEtudiant(){
        showEtudiant();
        int id=getIntInput("Sélecionnez un etudiant par id :");
        etudiantservice.deleteEtdById(id);
        showEtudiant();
    }*/
}

