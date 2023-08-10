package org.example;
import java.util.Scanner;
public class App
{
    public static void setMenu(){
        System.out.println("Select a choice");
        System.out.println("1 for create employee");
        System.out.println("2 for get employee by id");
        System.out.println("3 for update employee by id");
        System.out.println("4 for delete employee by id");
        System.out.println("0 for exit");

    }

    public static void create(EmployeeDAO db ) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nume");
        String nume = sc.nextLine();
        System.out.println("Enter departament");
        String departament = sc.nextLine();
        System.out.println("Enter salariu");
        double salariu = sc.nextDouble();

        db.createEmployee(nume,departament,salariu);
    }

    public static void getById(EmployeeDAO db){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id");
        int id = sc.nextInt();

        db.getEmployeeById(id);
    }

    public static void updateById(EmployeeDAO db){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id");
        int id = sc.nextInt();
        System.out.println("Enter nume");
        String nume = sc.nextLine();
        System.out.println("Enter departament");
        String departament = sc.nextLine();
        System.out.println("Enter salariu");
        double salariu = sc.nextDouble();

        db.updateEmployee(id,nume,departament,salariu);
    }

    public static void delete(EmployeeDAO db){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id");
        int id = sc.nextInt();

        db.deleteEmployee(id);
    }
    public static void main( String[] args )
    {
            EmployeeDAO db = new EmployeeDAO();
            Scanner sc = new Scanner(System.in);
            int choice;
            setMenu();
            choice = sc.nextInt();
            while(choice != 0 ){
                switch(choice) {

                    case 1:
                        create(db);
                        break;
                    case 2:
                        getById(db);
                        break;
                    case 3:
                        updateById(db);
                        break;
                    case 4:
                        delete(db);
                        break;
                }
                setMenu();
                choice = sc.nextInt();
            }

    }
}
