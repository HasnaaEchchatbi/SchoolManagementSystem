package SMS.Services;

import SMS.models.Departement;
import SMS.models.Enseignant;
import SMS.models.Filiere;
import SMS.models.Module;

import java.util.ArrayList;

public class moduleservice {

        public static Module addModule(String intitule, Enseignant professeur,  Filiere filiere) {
            Module module =new Module();
            module.setIntitule(intitule);
            module.setProfesseur(professeur);
            module.setFiliere(filiere);
            module.setId(DB.getModId());
            DB.modules.add(module);
            return module;

        }


        public static Module updateModule(int id , String intitule, Enseignant responsable,  Filiere filiere){

            for (Module module :DB.modules){
                if(module.getId()==id){
                module.setIntitule(intitule);

                    return module;
                }
            }


            return  new Module();
        }
        public static ArrayList<Module> deleteModuleById(int id){
            DB.modules.remove(getModuleById(id));
            return  DB.modules;
        }

        public static Module getModuleById(int id) {
            for (Module module:DB.modules){
                if(module.getId()==id)
                    return module;
            }
            return  new Module();
        }

        public static ArrayList<Module> getAllModule(){

            return  DB.modules;
        }
    }

