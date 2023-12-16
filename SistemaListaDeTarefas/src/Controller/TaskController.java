package Controller;
import Model.TaskList;
import View.TaskView;
import java.util.Scanner;

public class TaskController {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskList taskList = new TaskList();
        TaskView taskView = new TaskView(scanner, taskList);
        taskView.listaTarefas();
    }
}