package SMS.models;

import java.util.ArrayList;

public class Enseignant {
    private  int id;
    private String nom;
    private String prenom;
    private String grade;
    private String email;
    private Departement departement;
    ArrayList<Module> modules = new ArrayList<Module>();
    public Enseignant(){}
    public Enseignant(int id,String nom,String prenom,String grade,String email){
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.grade=grade;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }
    public boolean equals(Enseignant obj) {
        if (obj == null) {
            return false;
        }



        if (obj.getId() != this.id) {
            return false;
        }

        return true;
    }
}
