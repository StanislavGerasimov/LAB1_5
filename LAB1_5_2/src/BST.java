public class BST {
    TreeNode root;

    public BST() {
        this.root = null;
    }

    // Метод додавання вузла за ключем - ім'ям
    public void insert(Student student) {
        root = insertRec(root, student);
        //System.out.println("Додано студента: " + student);
        //printBFS();
    }

    private TreeNode insertRec(TreeNode root, Student student) {
        if (root == null) {
            return new TreeNode(student);
        }

        if (student.firstName.compareTo(root.student.firstName) < 0) {
            root.left = insertRec(root.left, student);
        } else if (student.firstName.compareTo(root.student.firstName) > 0) {
            root.right = insertRec(root.right, student);
        }

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
            System.out.print("Прізвище: " + root.student.lastName +
                    ", Ім'я: " + root.student.firstName +
                    ", По батькові: " + root.student.middleName +
                    ", Номер залікової книжки: " + root.student.id +
                    ", Військова підготовка: " + (root.student.militaryTraining ? "Так" : "Ні") + "\n");
        } else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }
}
