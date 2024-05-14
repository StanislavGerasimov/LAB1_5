public class Main {
    public static void main(String[] args) {
        BST bst = new BST();

        // Додавання студентів
        bst.insert(new Student("Сидорчук", "Марина", "Олегівна", 93721, false));
        bst.insert(new Student("Сидорова", "Олена", "Петрівна", 23456, false));
        bst.printBFS();
        bst.insert(new Student("Іванов", "Петро", "Ігорович", 34567, true));
        bst.insert(new Student("Коваленко", "Марія", "Василівна", 45678, false));
        bst.printBFS();
        bst.insert(new Student("Гармаш", "Денис", "Олександрович", 23562, false));
        bst.insert(new Student("Петров", "Олег", "Іванович", 12345, true));
        bst.insert(new Student("Циганков", "Олександр", "Данилович", 67894, true));
        bst.insert( new Student("Бовкуш", "Антон", "Петрович", 12348, true));
        bst.insert(new Student("Равлик", "Олена", "Миронівна", 45632, true));
        bst.insert(new Student("Хрищев", "Віталій", "Богданович", 87654, false));
        bst.insert(new Student("Клопотенко", "Андрій", "Миколайович", 87231, false));
        bst.insert(new Student("Сергієнко", "Марія", "Віталіївна", 83295, false));
        bst.insert(new Student("Горобець", "Максим", "Антонович", 73456, true));
        bst.insert(new Student("Залізко", "Микола", "Олексійович", 34598, true));
        bst.insert(new Student("Килимник", "Олексій", "Миколайович", 12874, true));
        bst.insert(new Student("Куць", "Олена", "Ігорівна", 34174, false));
        bst.insert(new Student("Воронін", "Андрій", "Петрович", 72914, true));
        bst.insert(new Student("Лелека", "Ірина", "Станіславівна", 43729, false));
        bst.insert(new Student("Корнієнко", "Ольга", "Василівна", 24513, false));
        bst.insert(new Student("Судакова", "Аліна", "Андріївна", 23914, false));
        bst.printBFS();
         //new Student("Петров", "Олег", "Іванович", 12345, true)
        // Пошук студента за ключем - ім'ям
        System.out.println("Пошук за ключем 'Олег': " + bst.search("Олег"));
    }
}