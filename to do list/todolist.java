import java.util.ArrayList;
import java.util.Scanner;

class ToDoList {
    private ArrayList<String> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    public void removeTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            tasks.remove(taskIndex);
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Invalid task index!");
        }
    }

    public void viewTasks() {
        if (!tasks.isEmpty()) {
            System.out.println("Your To-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        } else {
            System.out.println("Your To-Do List is empty.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the task: ");
                    String task = scanner.nextLine();
                    todoList.addTask(task);
                    break;
                case 2:
                    System.out.print("Enter the index of the task to remove: ");
                    int taskIndex = scanner.nextInt() - 1;
                    todoList.removeTask(taskIndex);
                    break;
                case 3:
                    todoList.viewTasks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}
