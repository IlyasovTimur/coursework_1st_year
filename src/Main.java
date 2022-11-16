
public class Main {
    public static Employee[] employees;
    public static void main(String[] args) {
        employees = new Employee[10];
        employees[0] = new Employee("Тарасова Ульяна Матвеевна", 1, 35890.7);
        employees[1] = new Employee("Панков Макар Юрьевич", 3, 33643.5);
        employees[2] = new Employee("Дегтярев Илья Эминович", 2, 34677.4);
        employees[3] = new Employee("Кузнецова Маргарита Демидовна", 3, 45154.3);
        employees[4] = new Employee("Васильев Алексей Валерьевич", 4, 34676.6);
        employees[5] = new Employee("Авдеев Семён Львович", 5, 39865.7);
        // employees[6] = new Employee("Попова Аделина Никитична", 5, 41134.4);
        employees[7] = new Employee("Шевелев Николай Глебович", 1, 36677.3);
        employees[8] = new Employee("Анисимов Степан Русланович", 2, 31873.2);
        employees[9] = new Employee("Степанова Анна Глебовна", 3, 35665.4);



        basicDifficulty(); //Базовая сложность
        increasedComplexity(); //Повышенная сложность

    }
    private static void increasedComplexity(){
        separator();
        System.out.println("Повышенная сложность");
        indexSalary(employees, 0.05);

        int neededDepartment = 3;
        minimumSalaryByDepartment(neededDepartment); // минимальная ЗП в отделе
        maximumSalaryByDepartment(neededDepartment); // максимальная ЗП в отделе
        separator();
        System.out.printf("Сумма расходов на всех сотрудников по отделу %d составила %.2f руб. \n",neededDepartment,sumSalaryByDepartment(neededDepartment));
        System.out.printf("Средняя зарплата по отделу равна %.2f \n", calculationAverageSalaryByDepartment(neededDepartment));
        indexSalaryByDepartment(neededDepartment,0.1); // индексация ЗП по отделу
        separator();
        printListEmployeesByDepartment(neededDepartment); // печатаем сотрудников отдела (без отдела)
        double setValue = 38970.65;
        salaryBelowTheSetValue(setValue); // сотрудники с ЗП ниже числа
        salaryHigherTheSetValue(setValue); //  сотрудники с ЗП выше или равной числа
    }
    private static void salaryHigherTheSetValue(double setValue) {
        separator();
        System.out.println("Сотрудники с заработной платой выше или равной " + setValue + " руб.");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= setValue) {
                System.out.printf("Сотрудник: ID - %d, Ф.И.О - %s, заработная плата - %.2f руб. \n", employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }
    private static void salaryBelowTheSetValue(double setValue) {
        separator();
        System.out.println("Сотрудники с заработной платой ниже " + setValue + " руб.");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < setValue) {
                System.out.printf("Сотрудник: ID - %d, Ф.И.О - %s, заработная плата - %.2f руб. \n", employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }


    private static void printListEmployeesByDepartment(int department) {
        Employee[] arrayDepartment = arrayDepartment(department);
        for (Employee employee : arrayDepartment) {
            System.out.printf("Сотрудник: ID - %d, Ф.И.О - %s, заработная плата - %.2f руб. \n", employee.getId(), employee.getFullName(), employee.getSalary());
        }
    }
    private static void indexSalaryByDepartment(int department, double indexationPercentage) {
        Employee[] arrayDepartment = arrayDepartment(department);
        separator();
        indexSalary(arrayDepartment,indexationPercentage);
    }

    private static double calculationAverageSalaryByDepartment(int department) {
        Employee[] arrayDepartment = arrayDepartment(department);
        double fullSum = sumSalaryByDepartment(department);
        int count = 0;
        double averageSalary = 0;
        for (int i = 0; i < arrayDepartment.length; i++) {
            count++;
        }
        averageSalary = fullSum / count;
        separator();
        return averageSalary;
    }


    private static double sumSalaryByDepartment(int department) {
        Employee[] arrayDepartment = arrayDepartment(department);
        double sum = 0;
        for (Employee employee : arrayDepartment) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee[] arrayDepartment(int department) {
        int counter = 0;
        for (Employee value : employees) {
            if (value != null && value.getDepartment() == department) {
                counter++;
            }
        }
        Employee[] result = new Employee[counter];
        int index = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                result[index] = employee;
                index++;
            }
        }
        return result;
    }
    private static void maximumSalaryByDepartment(int department) {
        System.out.println(calculationMaxSalary(arrayDepartment(department)) + " - имеет максимальную заработную плату в отделе.");
    }

    private static void minimumSalaryByDepartment(int department) {
        System.out.println(calculationMinSalaryEmployee(arrayDepartment(department)) + " - имеет минимальную заработную плату в отделе.");
    }

    private static void indexSalary(Employee[] array, double indexationPercentage) {
        for (Employee employee : array) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * indexationPercentage);
                System.out.printf("Заработная плата сотрудника " + employee.getFullName() + " из отдела %d" + " после повышения на %.2f составила %.2f руб.\n", employee.getDepartment(), indexationPercentage, employee.getSalary());
            }
        }
    }

    private static void basicDifficulty() {
        System.out.println("Базовая сложность");

        printListEmployees(); // вывод списка сотрудников

        System.out.printf("Сумма расходов на всех сотрудников %.2f \n", calculatingSalaryExpenses()); // расходы на ЗП

        System.out.println(calculationMinSalaryEmployee(employees) + " - имеет минимальную заработную плату."); // минимальная ЗП

        System.out.println(calculationMaxSalary(employees) + " - имеет максимальную заработную плату."); // максимальная ЗП

        calculationAverageSalary(calculatingSalaryExpenses(),Employee.countEmployees); // средняя ЗП

        printFullNameEmployees(); // Ф.И.О сотрудников
    }
    public static void printFullNameEmployees() {
        System.out.println("Ф.И.О сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    public static void calculationAverageSalary(double calculatingSalaryExpenses, int countEmployees) {
        double averageSalary = calculatingSalaryExpenses / countEmployees;
        separator();
        System.out.printf("Средняя заработная плата = %.2f \n", averageSalary);
        separator();
    }

    public static Employee calculationMaxSalary(Employee[] arrayEmployees) {
        Employee result = null;
        double maxSalary = Integer.MIN_VALUE;
        for (Employee arrayEmployee : arrayEmployees) {
            if (arrayEmployee != null && arrayEmployee.getSalary() > maxSalary) {
                maxSalary = arrayEmployee.getSalary();
                result = arrayEmployee;
            }
        }
        separator();
        return result;
    }
    public static Employee calculationMinSalaryEmployee( Employee[] arrayEmployees) {
        Employee result = null;
        double minSalary = Integer.MAX_VALUE;
        for (Employee arrayEmployee : arrayEmployees) {
            if (arrayEmployee != null && arrayEmployee.getSalary() < minSalary) {
                minSalary = arrayEmployee.getSalary();
                result = arrayEmployee;
            }
        }
        separator();
        return result;
    }

    public static double calculatingSalaryExpenses() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public static void printListEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.toString());
            }
        }
        separator();
    }

    public static void separator() {
        System.out.println("--------------------------");
    }
}
