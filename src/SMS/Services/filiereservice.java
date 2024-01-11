package SMS.Services;

import SMS.models.Departement;
import SMS.models.Enseignant;
import SMS.models.Filiere;

import java.util.ArrayList;

public class filiereservice {
    public static Filiere addFiliere(String intitule, Enseignant responsable, Departement departement
           /* ,Module module*/
    ) {
       Filiere filiere=new Filiere();
       filiere.setIntitule(intitule);
       filiere.setResponsable(responsable);
       filiere.setDepartement(departement);
        filiere.setId(DB.getModId());

        DB.filieres.add(filiere);
        return filiere;

    }

    public static Filiere updateFiliere(int id , String intitule, Enseignant responsable, Departement departement){
        for (Filiere filiere :DB.filieres){
            if(filiere.getId()==id){
               filiere.setIntitule(intitule);

                filiere.setResponsable(responsable);
                filiere.setDepartement(departement);

                return filiere;
            }
        }




        return  new Filiere();
    }
    public static ArrayList<Filiere> deleteFiliereById(int id){
        DB.filieres.remove(getFiliereById(id));
        return  DB.filieres;
    }

    public static Filiere getFiliereById(int id){
        for (Filiere filiere:DB.filieres){
            if(filiere.getId()==id)
                return filiere;
        }

        return  new Filiere();
    }

    public static ArrayList<Filiere> getAllFiliere(){
        return  DB.filieres;
    }
}
