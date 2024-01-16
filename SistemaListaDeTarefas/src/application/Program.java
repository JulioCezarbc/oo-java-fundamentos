package application;

import Controller.TaskController;
import View.TaskView;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        TaskController taskController = new TaskController();
        TaskView taskView = new TaskView(taskController, new Scanner(System.in));

        taskController.setTaskView(taskView);

        taskController.iniciar();
    }
}
