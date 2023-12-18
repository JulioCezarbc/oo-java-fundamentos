package Controller;
import Model.TaskList;
import View.TaskView;
import java.util.Scanner;

public class TaskController {
    private final Scanner scanner;
    private final TaskList taskList;
    private final TaskView taskView;

    public TaskController() {
        this.scanner = new Scanner(System.in);
        this.taskList = new TaskList();
        this.taskView = new TaskView(taskList);
    }

    public void start(){
        int escolha;

        do {
            taskView.menu();
            escolha = getChoiceFromUser();

            switch (escolha) {
                case 1 -> taskList.adicionarTarefa();
                case 2 -> taskList.listaDeTarefas();
                case 3 -> taskList.tarefaConcluida();
                case 4 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida");
            }
            try {
                Thread.sleep(1800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (escolha != 4);
    }

    public int getChoiceFromUser() {

        try {
            return scanner.nextInt();
        } catch (Exception e) {
            // Em caso de entrada inválida, limpe a memória temporaria e retorne um valor inválido
            scanner.nextLine();
            return -1; // ou outro valor padrão, dependendo do que fizer sentido para o seu programa
        }
    }

    public static void main(String[] args) {
        TaskController taskController = new TaskController();
        taskController.start();
    }
}