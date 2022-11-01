public class Main {

    public static void main(String[] args) {
        Person person1 = new Person("Денисов ", "Тимофей ", "Владиславович");
        Person person2 = new Person("Руднева ", "Анастасия ", "Максимовна");
        Person person3 = new Person("Некрасова ", "Алиса ", "Никитична");
        Person person4 = new Person("Царев ", "Роман ", "Максимович");
        Person person5 = new Person("Новиков ", "Дмитрий ", "Сергеевич");
        Person person6 = new Person("Шишкина ", "Дарья ", "Тимофеевна");
        Person person7 = new Person("Соколов ", "Александр ", "Федорович");
        Person person8 = new Person("Ковригин ", "Сергей", "Валерьевич");
        Person person9 = new Person("Неверов ", "Александр", "Александрович");
        Person person10 = new Person("Козловский  ", "Кирилл", "Егорович");

        Employee[] employees = new Employee[10];
        employees[0] = new Employee(person1, 1, 38800.7);
        employees[1] = new Employee(person2, 4, 37677.3);
        employees[2] = new Employee(person3, 2, 37677.3);
        employees[3] = new Employee(person4, 3, 40100.4);
        employees[4] = new Employee(person5, 4, 33600.4);
        employees[5] = new Employee(person6, 5, 38800.7);
        employees[6] = new Employee(person7, 5, 40100.4);
        employees[7] = new Employee(person8, 1, 37677.3);
        employees[8] = new Employee(person9, 2, 38800.7);
        employees[9] = new Employee(person10, 3, 33600.4);


        displaysListEmployees(employees); // список сотрудников

        calculatingSalaryExpenses(employees); // расходы на ЗП

        calculationMinSalary(employees); // минимальная ЗП

        calculationMaxSalary(employees); // максимальная ЗП

        calculationAverageSalary(calculatingSalaryExpenses(employees),Employee.numberEmployees); // средняя ЗП

        outputFullNameEmployees(employees); // Ф.И.О сотрудников

    }

    public static void outputFullNameEmployees(Employee[] arrayEmployee) {
        for (int i = 0; i < arrayEmployee.length; i++) {
            System.out.println(arrayEmployee[i].getPerson());
        }
    }

    public static void calculationAverageSalary(double calculatingSalaryExpenses, int numberEmployees) {
        double averageSalary = calculatingSalaryExpenses / numberEmployees;
        System.out.printf("Средняя заработная плата = %.2f \n", averageSalary);

    }

    public static double calculationMaxSalary(Employee[] arrayEmployee) {
        double maxSalary = 0;
        for (Employee employee : arrayEmployee) {
            if (maxSalary < employee.getSalary()) {
                maxSalary = employee.getSalary();
            }
        }
        System.out.println("Максимальная заработная плата " + maxSalary);
        return maxSalary;
    }
    public static double calculationMinSalary(Employee[] arrayEmployee) {
        double minSalary = 99999999;
        for (Employee employee : arrayEmployee) {
            if (minSalary > employee.getSalary()) {
                minSalary = employee.getSalary();
            }
        }
        System.out.println("Минимальная заработная плата " + minSalary);
        return minSalary;
    }

    public static double calculatingSalaryExpenses(Employee[] arrayEmployee) {
        double sum = 0;
        for (Employee array : arrayEmployee) {
            sum += array.getSalary();
        }
        System.out.printf("Сумма расходов на всех сотрудников %.2f \n",sum);
        return sum;
    }

    public static void displaysListEmployees(Employee[] arrayEmployees) {
        for (Employee employee : arrayEmployees) {
            System.out.println(employee);
        }
    }
}
