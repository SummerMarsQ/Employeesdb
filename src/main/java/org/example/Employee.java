package org.example;

public class Employee {
    private int id;
    private String nume;
    private String departament;
    private double salariu;

    public int getId(){
        return this.id;
    }
    public String getNume(){
        return this.nume;
    }
    public String getDepartament(){
        return this.departament;
    }
    public double getSalariu(){
        return this.salariu;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNume(String nume){
        this.nume=nume;
    }
    public void setDepartament(String departament){
        this.departament = departament;
    }
    public void setSalariu(double salariu){
        this.salariu = salariu;
    }

    Employee(int id , String nume,String departament,double salariu)
    {
        this.id = id;
        this.nume=nume;
        this.departament = departament;
        this.salariu = salariu;
    }

}
