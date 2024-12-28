// EMPLOYEE PAYROLL SYSTEM BASED ON OOPS CONCEPT :

/*✅ Designing an Employee Payroll System using OOP principles.
✅ Creating abstract classes, concrete subclasses, and implementing inheritance.
✅ Understanding encapsulation, abstraction, polymorphism, and method overriding.
✅ Implementing a terminal-based user interface for interaction.
✅ Calculating salaries for both Full-Time and Part-Time employees with abstract methods.
✅ Managing employee records, salary updates, and removal using a Payroll System.
*/

import java.util.ArrayList;
import java.util.List;

 abstract class Employee{
    private String Name;
    private int Id;

    public Employee(String Name , int Id){
        this.Name = Name;
        this.Id = Id;
    }

    public String getName(){
        return Name;
    }

    public int getId(){
        return Id;
    }

    public abstract double CalculateSalary();
    @Override
    public String toString(){
        return "Employee [name=" + Name + ", id=" + Id + ", salary=" + CalculateSalary() + "]";
    }
}
class FulltimeEmployee extends Employee {
    private double Monthlysalary;

    public FulltimeEmployee(String Name , int Id , double Monthlysalary){
        super(Name,Id);
        this.Monthlysalary = Monthlysalary;
    }
    @Override
    public double CalculateSalary(){
        return Monthlysalary;
    }
}

class ParttimeEmployee extends Employee{
     private int hoursworked;
     private double hourlyrate;

     public ParttimeEmployee(String Name,int Id,int hoursworked,double hourlyrate){
         super(Name,Id);
         this.hoursworked = hoursworked;
         this.hourlyrate= hourlyrate;
     }

     public double CalculateSalary(){
         return hoursworked*hourlyrate;
     }
}

class PayRollSystem{
     private ArrayList<Employee>Employeelist;

     public PayRollSystem(){
         Employeelist = new ArrayList<>();
     }

     public void addEmployee(Employee employee){
         Employeelist.add(employee);
     }

     public void RemoveEmployee(int Id){
         Employee employeetoRemove = null;
         for (Employee employee:Employeelist){
             if (employee.getId()==Id){
                 employeetoRemove=employee;
                 break;
             }
         }
         if (employeetoRemove!=null){
             Employeelist.remove(employeetoRemove);
         }
     }
    public void DisplayEmployees(){
        for (Employee employee:Employeelist){
            System.out.println(employee);
        }
    }
 }


public class Employee_Payroll_system {
    public static void main(String[] args) {

       PayRollSystem payRollSystem = new PayRollSystem();
       FulltimeEmployee Emp1 = new FulltimeEmployee("Shreyas",101,50000.00);
        FulltimeEmployee Emp2 = new FulltimeEmployee("Shambhavi",102,40000.00);
        ParttimeEmployee Emp3 = new ParttimeEmployee("Aditi",103,10,4000.00);

       payRollSystem.addEmployee(Emp1);
       payRollSystem.addEmployee(Emp2);
       payRollSystem.addEmployee(Emp3);

       System.out.println("Initial Employee Details : ");
       payRollSystem.DisplayEmployees();

       System.out.println("Removing Employees : ");
       payRollSystem.RemoveEmployee(101);
        System.out.println("Remaining Employees Details");
       payRollSystem.DisplayEmployees();

    }
 }


