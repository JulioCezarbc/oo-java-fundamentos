package View;
import Controller.TaskController;
import Model.TaskList;
import java.util.Scanner;

public class TaskView {
    private final TaskController taskController;
    private final Scanner entrada;

    public TaskView(TaskController taskController, Scanner entrada) {
        this.taskController = taskController;
        this.entrada = entrada;
    }

    public void menu(){
        System.out.println("--- Menu ---");
        System.out.println("1 - Adicionar tarefa ");
        System.out.println("2 - Lista de tarefas ");
        System.out.println("3 - Marcar tarefa como concluida");
        System.out.println("4 - Sair ");
        System.out.print("Opção: ");
    }


    public void start(){
        int escolha;

        do {
            menu();
            escolha = getChoiceFromUser();

            switch (escolha) {
                case 1 -> taskController.adicionarTarefa();
                case 2 -> taskController.listaDeTarefas();
                case 3 -> taskController.tarefaConcluida();
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
            return entrada.nextInt();
        } catch (Exception e) {
            // Em caso de entrada inválida, limpe a memória temporaria e retorne um valor inválido
            entrada.nextLine();
            return -1; // ou outro valor padrão, dependendo do que fizer sentido para o seu programa
        }
    }
}
