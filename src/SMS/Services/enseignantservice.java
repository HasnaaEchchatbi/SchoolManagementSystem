package SMS.Services;

import SMS.models.Enseignant;
import SMS.models.Departement;

import java.sql.SQLException;
import java.util.ArrayList;

public class enseignantservice {
    public static Enseignant addEns(String nom, String prenom, String grade, String email,
                                    Departement departement){

       Enseignant enseignant=new Enseignant();
       enseignant.setNom(nom);
       enseignant.setEmail(email);
       enseignant.setGrade(grade);
       enseignant.setId(DB.getEnsId());
       enseignant.setPrenom(prenom);
       enseignant.setDepartement(departement);
        DB.enseignants.add(enseignant);

        return enseignant;
    }

    public static Enseignant updateEns(int id,String nom,String prenom,String grade,
                                       String email,Departement departement){

        for (Enseignant enseignant :DB.enseignants){
            if(enseignant.getId()==id){
                enseignant.setNom(nom);
                enseignant.setPrenom(prenom);
                enseignant.setEmail(email);
                enseignant.setGrade(grade);
                enseignant.setDepartement(departement);
            }
                return enseignant;
            }

        return new Enseignant();
    }
    public static ArrayList<Enseignant> deleteEnsById(int id){
        DB.enseignants.remove(getEnsById(id));
        return DB.enseignants;
    }
    public static Enseignant getEnsById(int id){
        for (Enseignant enseignant:DB.enseignants){
            if(enseignant.getId()==id)
                return enseignant;
        }
        return new Enseignant();
    }
    public static ArrayList<Enseignant> getAllEns(){
        return DB.enseignants;
    }
}
