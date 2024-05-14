public class BST {
    TreeNode root;

    public BST() {
        this.root = null;
    }

    // Метод додавання вузла за ключем - ім'ям зі збалансуванням
    public void insert(Student student) {
        root = insertRec(root, student);

    }

    private TreeNode insertRec(TreeNode root, Student student) {
        if (root == null) {
            return new TreeNode(student);
        }

        if (student.firstName.compareTo(root.student.firstName) < 0) {
            root.left = insertRec(root.left, student);
            root.left.parent = root; // Встановлення зв'язку з батьком для лівого нащадка
        } else if (student.firstName.compareTo(root.student.firstName) > 0) {
            root.right = insertRec(root.right, student);
            root.right.parent = root; // Встановлення зв'язку з батьком для правого нащадка
        } else {
            // Вузол з таким ключем вже існує
            return root;
        }

        // Після вставки вузла, перебалансуємо дерево
        return balance(root);
    }


    // Метод балансування дерева
    private TreeNode balance(TreeNode root) {
        // Розрахунок балансу піддерева
        int balance = getBalance(root);

        // Якщо дерево нерівномірно збалансоване, виконуємо ротації
        if (balance > 1) {
            if (getBalance(root.left) < 0) {
                root.left = rotateLeft(root.left);
            }
            return rotateRight(root);
        }
        if (balance < -1) {
            if (getBalance(root.right) > 0) {
                root.right = rotateRight(root.right);
            }
            return rotateLeft(root);
        }

        // Якщо дерево збалансоване, просто повертаємо корінь
        return root;
    }

    // Метод реалізації операції "ротація-вліво"
    private TreeNode rotateLeft(TreeNode x) {
        TreeNode y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    // Метод реалізації операції "ротація-вправо"
    private TreeNode rotateRight(TreeNode y) {
        TreeNode x = y.left;
        y.left = x.right;
        x.right = y;
        return x;
    }

    // Отримання балансу піддерева
    private int getBalance(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    // Метод пошуку за ключем - ім'ям
    public Student search(String key) {
        TreeNode result = searchRec(root, key);
        if (result != null) {
            return result.student;
        } else {
            return null;
        }
    }

    private TreeNode searchRec(TreeNode root, String key) {
        if (root == null || root.student.firstName.equals(key)) {
            return root;
        }

        if (key.compareTo(root.student.firstName) < 0) {
            return searchRec(root.left, key);
        }

        return searchRec(root.right, key);
    }

    // Метод обходу BST у ширину для виведення вмісту дерева
    public void printBFS() {
        int height = height(root);
        for (int i = 1; i <= height; i++) {
            printGivenLevel(root, i);
        }
        System.out.println();
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }
    }

    private void printGivenLevel(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            String position = (root.parent != null && root.parent.left == root) ? "Лівий" : "Правий";
            String parentName = (root.parent != null) ? root.parent.student.firstName : "Немає";

            System.out.print("Прізвище: " + root.student.lastName +
                    ", Ім'я: " + root.student.firstName +
                    ", По батькові: " + root.student.middleName +
                    ", Номер залікової книжки: " + root.student.id +
                    ", Військова підготовка: " + (root.student.militaryTraining ? "Так" : "Ні") +
                    ", Позиція: " + position +
                    ", Батько: " + parentName + "\n");
        } else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }


}
