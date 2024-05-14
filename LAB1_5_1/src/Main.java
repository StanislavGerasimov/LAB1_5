public class Main {
    public static void main(String[] args) {
        // Ініціалізація масиву студентів
        Student[] students = {
                new Student("Петров", "Іван", "Олександрович", 12345, true),
                new Student("Сидорова", "Олена", "Петрівна", 23456, false),
                new Student("Іванов", "Петро", "Ігорович", 34567, true),
                new Student("Коваленко", "Марія", "Василівна", 45678, false),
                new Student("Гармаш", "Денис", "Олександрович", 23562, false),
                new Student("Сидорчук", "Марина", "Олегівна", 93721, false),
                new Student("Циганков", "Олександр", "Данилович", 67894, true),
                new Student("Бовкуш", "Антон", "Петрович", 12348, true),
                new Student("Равлик", "Олена", "Миронівна", 45632, true),
                new Student("Хрищев", "Віталій", "Богданович", 87654, false),
                new Student("Клопотенко", "Андрій", "Миколайович", 87231, false),
                new Student("Сергієнко", "Марія", "Віталіївна", 83295, false),
                new Student("Горобець", "Максим", "Антонович", 73456, true),
                new Student("Залізко", "Микола", "Олексійович", 34598, true),
                new Student("Килимник", "Олексій", "Миколайович", 12874, true),
                new Student("Куць", "Олена", "Ігорівна", 34174, false),
                new Student("Воронін", "Андрій", "Петрович", 72914, true),
                new Student("Лелека", "Ірина", "Станіславівна", 43729, false),
                new Student("Корнієнко", "Ольга", "Василівна", 24513, false),
                new Student("Судакова", "Аліна", "Андріївна", 23914, false)
        };

        // Сортування масиву студентів за ознакою проходження військової підготовки
        sortByMilitaryTraining(students);

        // Виведення вмісту масиву
        System.out.println("Масив студентів:");
        printStudents(students);

        // Заданий номер залікової книжки для пошуку
        int targetID = 34567;

        // Пошук студентів із заданим номером залікової книжки серед тих, хто проходив військову підготовку
        Student[] result = searchByStudentIDAndMilitaryTraining(students, targetID, true);

        // Виведення результатів пошуку
        if (result.length > 0) {
            System.out.println("\nРезультати пошуку:");
            printStudents(result);
        } else {
            System.out.println("\nСтудент із заданим номером залікової книжки та проходженням військової підготовки не знайдений.");
        }
    }

    // Метод для сортування масиву студентів за ознакою проходження військової підготовки
    private static void sortByMilitaryTraining(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                if (students[j].hasMilitaryTraining() && !students[j + 1].hasMilitaryTraining()) {
                    // Переставляємо студентів із військовою підготовкою на початок масиву
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    // Метод для пошуку студентів за номером залікової книжки та ознакою проходження військової підготовки
    private static Student[] searchByStudentIDAndMilitaryTraining(Student[] students, int targetID, boolean hasMilitaryTraining) {
        int count = 0;
        for (Student student : students) {
            if (student.getStudentID() == targetID && student.hasMilitaryTraining() == hasMilitaryTraining) {
                count++;
            }
        }

        if (count == 0) {
            return new Student[0];
        }

        Student[] result = new Student[count];
        int index = 0;
        for (Student student : students) {
            if (student.getStudentID() == targetID && student.hasMilitaryTraining() == hasMilitaryTraining) {
                result[index++] = student;
            }
        }
        return result;
    }

    // Метод для виведення масиву студентів на екран
    private static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}