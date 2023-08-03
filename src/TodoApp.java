import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {
    private static ArrayList<String> todoList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice !=4){
            printMainMenu();
            System.out.print("Введите команду: ");
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    addTodo();
                    break;
                case 2:
                    viewTodoList();
                    break;
                case 3:
                    markTodoAsCompleted();
                    break;
                case 4:
                    System.out.println("Выход из программы");
                    break;
                default:
                    System.out.println("Некорректная команда. Попробуйте снова");
                    break;
            }

        }
    }

    private static void printMainMenu(){
        System.out.println("Меню:");
        System.out.println("1. Добавить дело в список");
        System.out.println("2. Просмотрел список дел");
        System.out.println("3. Отметить дело как выполненное");
        System.out.println("4. Выход");
    }

    private static void addTodo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите новое дело: ");
        String todo = scanner.nextLine();
        todoList.add(todo);
        System.out.println("Дело успешно добавлено");
    }

    private static void viewTodoList(){
        if (todoList.size() > 0){
            System.out.println("Список дел: ");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i+1) + ". " + todoList.get(i));
            }
        } else {
            System.out.println("Список дел пуст");
        }
    }

    private static void markTodoAsCompleted(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер дела, которое хотите отметить как выполненое: ");
        int todoIndex = scanner.nextInt();

        if (todoIndex <= todoList.size() && todoIndex > 0){
            String todo = todoList.get(todoIndex - 1);
            todoList.remove(todoIndex - 1);
            System.out.println("Дело " + todo + " отмечено как выполненое");
        } else {
            System.out.println("Некорректный номер дела. Попробуйте снова");
        }
    }
}
