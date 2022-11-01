public class Employee {
    private final Person person;
    private int department;
    private double salary;
    public static int numberEmployees = 0;
    public int id;

    public Employee(Person person, int department, double salary) {
        this.person = person;
        if (department < 0 || department > 5) {
            throw new IllegalArgumentException("Такого отдела нет");
        }
        this.department = department;
        if (salary < 0) {
            throw new IllegalArgumentException("Заработная плата не может быть отрицательной");
        }
        this.salary = salary;
        id = numberEmployees;
        numberEmployees++;
    }
    public Person getPerson() {
        return person;
    }
    public  int getDepartment(){
        return department;
    }
    public double getSalary() {
        return this.salary;
    }
    public void setDepartment(int department) {
        if (department < 0 || department > 5) {
            throw new IllegalArgumentException("Такого отдела нет");
        }
        this.department = department;
    }
    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Заработная плата не может быть отрицательной");
        }
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee (" +
                "person - " + person +
                ", department - " + department +
                ", salary - " + salary +
                ')';
    }
}
