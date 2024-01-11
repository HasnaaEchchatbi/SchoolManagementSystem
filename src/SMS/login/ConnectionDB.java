package SMS.login;

import SMS.control.*;
import SMS.models.Enseignant;
import SMS.models.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static SMS.Services.DB.enseignants;

public class ConnectionDB {
               static Connection cnx;
               static Statement st;
               static ResultSet rst;

    public ConnectionDB() throws SQLException {}

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

    public static void main(String[] args) {
getEtdById();





               }
               public static Connection  connecterDB(){
                   try{
                     /*  Class.forName("com.mysql.jdbc.Driver");*/
                       String url="jdbc:mysql://localhost:3306/jdbc-connecttt";
                       String user="root";
                       String password="";
                       Connection cnx=DriverManager.getConnection(url,user,password);
                       /*System.out.println("Connexion bien établié");*/
                       return cnx;
                   }catch(Exception e){
                       e.printStackTrace();
                       return null;
                   }
               }
 /////////////////////////////////////////////etudiant/////////////////////////////////////////////////////////////////////////////////////////
               public static void addEtd() {

                   String nom =getStringInput("entrez le nom :");
                   String prenom =getStringInput("entrez le prenom :");
                   String email =getStringInput("entrez l'email:");
                   int apogee =getIntInput("entrez le code apogee:");
                   int id_fil=getIntInput("entrez un id du filiere:");

                  /* filierecontrol.showFiliere();*/


                   try{
                       String query="INSERT INTO students (nom,prenom,email,apogee,id_filiere) VALUES('"+nom+"','"
                               +prenom+"','"+email+"','"+apogee+"','"+id_fil+"')";
                       cnx=connecterDB();
                       st=cnx.createStatement();
                       st.executeUpdate(query);
                       System.out.println("student well added");

                   }catch(SQLException e){
                       System.out.println(e.getMessage());
                   }
               }
               public static void updateEtd(){
                   int id=getIntInput("entrez un id:");
                   String nom =getStringInput("entrez le nom :");
                   String prenom =getStringInput("entrez le prenom :");
                   String email =getStringInput("entrez l'email:");
                   int apogee =getIntInput("entrez le code apogee:");
                   int id_fil=getIntInput("entrez un id du filiere:");
                   try{
                String query="UPDATE students SET nom='"+nom
                    +"', prenom='"+prenom
                    +"', email='"+email
                    +"', apogee='"+apogee
                        +"', id_filiere='"+id_fil
                    +"' WHERE id="+id;
                    cnx=connecterDB();
                   st=cnx.createStatement();
                   st.executeUpdate(query);
                   System.out.println("well-modified student");

                 }catch(SQLException e){
                 System.out.println(e.getMessage());
                 }
                }

                public static void deleteEtdById(){
                    int id=getIntInput("entrez un id:");
                   try{
                String query="DELETE FROM students WHERE id="+id;
                   cnx=connecterDB();
                 st=cnx.createStatement();
                st.executeUpdate(query);
                 System.out.println("well deleted student");

                  }catch(SQLException e){
                   System.out.println(e.getMessage());
                   }
                     }
                 public static void getEtdById() {
                     int id=getIntInput("entrez un id:");
                    try{
                String query="SELECT * FROM students WHERE id='"+id+"'";
                      cnx=connecterDB();
                      st=cnx.createStatement();
                    rst= st.executeQuery(query);
                        rst.next();
                      int nbrRow = rst.getRow();
                    if(nbrRow!=0){
                      System.out.println("student well found");
                           System.out.print(rst.getString("nom")+"\t");
                           System.out.print(rst.getString("prenom")+"\t");
                           System.out.print(rst.getString("email")+"\t");
                           System.out.print(rst.getInt("apogee")+"\t");
                           System.out.print(rst.getInt("id_filiere")+"\t");
                           System.out.println();
                       }else{
                     System.out.println("student not found");

                       }
                    }catch(SQLException e){
                    System.out.println(e.getMessage());
                  }
                    }
/////////////////////////////////////////////Filiere/////////////////////////////////////////////////////////////////////////////////////////
    public static void addFiliere(){
        int id=getIntInput("entrez l'id du filiere:");
        String intitule =getStringInput("entrez l'intitule du filiere :");
        int id_teach=getIntInput("entrez l'id du responsable sur la filiere:");

        try{
            String query="INSERT INTO filiere (intitule,id_teach) VALUES('"+intitule+"','"+id_teach+"')";
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("filiere well added");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }


    }
    public static void getFiliereById() {
        int id=getIntInput("entrez l'id du filiere que vous voulez afficher:");
        try{
            String query="SELECT * FROM filiere WHERE id='"+id+"'";
            cnx=connecterDB();
            st=cnx.createStatement();
            rst= st.executeQuery(query);
            rst.next();
            int nbrRow = rst.getRow();
            if(nbrRow!=0){
                System.out.println("filiere well found");
                 System.out.print(rst.getInt("id_teach") + "\t");
                System.out.print(rst.getString("intitule") + "\t");
            }else{
                System.out.println("filiere not found");

            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void updateFiliere(){
        int id=getIntInput("entrez l'id du filiere:");
        String intitule =getStringInput("entrez l'intitule du filiere :");
        int id_teach=getIntInput("entrez l'id du responsable sur la filiere:");

        try{
            String query="UPDATE filiere SET intitule='"+intitule
                    +"', id='"+id_teach
                    +"' WHERE id="+id;
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("well-modified filiere");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void deleteFiliereById(){
        int id=getIntInput("entrez l'id du departement que vous voulez supprimer:");
        try{
            String query="DELETE FROM filiere WHERE id="+id;
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("well deleted filiere");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    /////////////////////////////////////////////departement/////////////////////////////////////////////////////////////////////////////////////////
    public static void addDept(){

        String intitule =getStringInput("entrez l'intitule du departement :");
        int id_teach=getIntInput("entrez l'id du responsable sur le departement:");

        try{
            String query="INSERT INTO departements (intitule,id) VALUES('"+intitule+"','"+id_teach+"')";
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("departement well added");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }


    }
    public static void getDeptById() {
        int id=getIntInput("entrez l'id du departement que vous voulez afficher:");
        try{
            String query="SELECT * FROM departement WHERE id_dept='"+id+"'";
            cnx=connecterDB();
            st=cnx.createStatement();
            rst= st.executeQuery(query);
            rst.next();
            int nbrRow = rst.getRow();
            if(nbrRow!=0){
                System.out.println("departement well found");
                System.out.print(rst.getInt("id") + "\t");
                System.out.print(rst.getString("intitule") + "\t");
            }else{
                System.out.println("departement not found");

            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void updateDpt(){
        int id=getIntInput("entrez l'id du departement:");
        String intitule =getStringInput("entrez l'intitule du departement :");
        int id_teach=getIntInput("entrez l'id du responsable sur le departement:");

        try{
            String query="UPDATE departements SET intitule='"+intitule
                    +"', id='"+id_teach
                    +"' WHERE id_dept="+id;
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("well-modified departement");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void deleteDptById(){
        int id=getIntInput("entrez l'id du departement que vous voulez supprimer:");
        try{
            String query="DELETE FROM departements WHERE id_dept="+id;
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("well deleted departement");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
/////////////////////////////////////////////////////teachers///////////////////////////////////////////////////////////////////////////////////////////
    public static void getTeachById() {
        int id = getIntInput("entrez l'id du teacher:");
        try {
            String query = "SELECT * FROM teachers WHERE id='" + id + "'";
            cnx = connecterDB();
            st = cnx.createStatement();
            rst = st.executeQuery(query);
            rst.next();
            int nbrRow = rst.getRow();
            if (nbrRow != 0) {
                System.out.println("teacher well found");
                System.out.print(rst.getString("nom") + "\t");
                System.out.print(rst.getString("prenom") + "\t");
                System.out.print(rst.getString("email") + "\t");
                System.out.print(rst.getString("grade") + "\t");
                System.out.println();
            } else {
                System.out.println("teacher not found");

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void updateteach(){
        int id=getIntInput("entrez l'id du teacher:");
        String nom =getStringInput("entrez le nom du teacher :");
        String prenom =getStringInput("entrez le prenom du teacher:");
        String email =getStringInput("entrez l'email du teacher:");
        String grade =getStringInput("entrez la grade du teacher:");
        try{
            String query="UPDATE teachers SET nom='"+nom
                    +"', prenom='"+prenom

                    +"', email='"+email
                    +"', grade='"+grade
                    +"' WHERE id="+id;
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("well-modified teacher");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void addTeach() {
        String nom =getStringInput("entrez le nom du teacher :");
        String prenom =getStringInput("entrez le prenom du teacher:");
        String email =getStringInput("entrez l'email du teacher:");
        String grade =getStringInput("entrez la grade du teacher:");
        try{
            String query="INSERT INTO teachers (nom,prenom,email,grade) VALUES('"+nom+"','"
                    +prenom+"','"+email+"','"+grade+"')";
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("well added teacher");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void deleteTeachById(){
        int id=getIntInput("entrez un id du teacher:");
        try{
            String query="DELETE FROM teachers WHERE id="+id;
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("well deleted teacher");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
////////////////////////////////////////////module//////////////////////////////////////////////////////////////////////////////////////////////////
    public static void addmod() {
        int id_mod =getIntInput("enter id du module:");
        String intitule =getStringInput("enter intitule du module:");
        int id_fil=getIntInput("entrez l'id du filiere du module:");
        int id_teach=getIntInput("entrez l'id d'enseignant du module:");

        try{
            String query="INSERT INTO module (intitule,id_fil,id_teach) VALUES('"+intitule+"','"+id_fil+"','"+id_teach+"')";
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("well added module ");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        }
    public static void updatemod(){
        int id_mod=getIntInput("selectionnez un module par id :");
        String intitule=getStringInput("entrez l'intitule :");
        int id_fil=getIntInput("entrez l'id du filiere du module:");
        int id_teach=getIntInput("entrez l'id d'enseignant du module:");
        try{
            String query="UPDATE module  SET intitule='"+intitule
                    +"', id_fil='"+id_fil
                    +"',id_teach'"+id_teach
                    +"' WHERE id="+id_mod;
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("well-modified module");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void deleteMODById(){
        int id_mod=getIntInput("entrez l'id du module que vous voulez supprimer:");
        try{
            String query="DELETE FROM module WHERE id="+id_mod;
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("well deleted module");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void getModById() {
        int id_mod=getIntInput("entrez l'id du module:");
        try{
            String query="SELECT * FROM teachers WHERE id='"+id_mod+"'";
            cnx=connecterDB();
            st=cnx.createStatement();
            rst= st.executeQuery(query);
            rst.next();
            int nbrRow = rst.getRow();
            if(nbrRow!=0){
                System.out.println("module well found");
                System.out.print(rst.getString("intitule") + "\t");
                System.out.print(rst.getInt("id_fil") + "\t");
                System.out.print(rst.getInt("id_teach") + "\t");

            }else{
                System.out.println("module not found");

            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

}



