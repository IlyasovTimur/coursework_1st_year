public class Employee {
    private String fullName; // Ф.И.О
    private int department; // отдел
    private double salary; // зарплата
    public static int countEmployees = 0; // счетчик
    public int id; // id - сотрудника

    public Employee(String person, int department, double salary) {
        this.fullName = person;
        if (department < 0 || department > 5) {
            throw new IllegalArgumentException("Такого отдела нет");
        }
        this.department = department;
        if (salary < 0) {
            throw new IllegalArgumentException("Заработная плата не может быть отрицательной");
        }
        this.salary = salary;
        id = countEmployees;
        countEmployees++;
    }
    public String getFullName() {
        return fullName;
    }
    public  int getDepartment(){
        return department;
    }
    public double getSalary() {
        return this.salary;
    }
    public int getId() {
        return id;
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
        return String.format("Сотрудник: ID - %d, Ф.И.О - %s, отдел № - %d, заработная плата - %.2f руб.",id,fullName,department,salary);
    }
}
