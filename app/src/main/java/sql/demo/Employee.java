package sql.demo;

public class Employee {
    private int id;
    private Department department;
    private String fname;
    private String surname;
    private String email;
    private double salary;

    public Employee(int id, Department department, String fname, String surname, String email, double salary) {
        this.id = id;
        this.department = department;
        this.fname = fname;
        this.surname = surname;
        this.email = email;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee [department=" + department + ", email=" + email + ", fname=" + fname + ", id=" + id
                + ", salary=" + salary + ", surname=" + surname + "]";
    }

}
