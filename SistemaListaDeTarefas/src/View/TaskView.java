package View;
import Model.Task;
import Model.TaskList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskView {
    private final Scanner entrada;
    private final TaskList taskList;

    public TaskView(Scanner entrada, TaskList taskList) {
        this.entrada = entrada;
        this.taskList = taskList;

    }

    public void listaTarefas(){
        int escolha;

        do {
            System.out.println("--- Menu ---");
            System.out.println("1 - Adicionar tarefa ");
            System.out.println("2 - Lista de tarefas ");
            System.out.println("3 - Marcar tarefa como concluida");
            System.out.println("4 - Sair ");
            System.out.print("Opção: ");
            escolha = entrada.nextInt();

            switch (escolha) {
                case 1 -> taskList.adicionarTarefa();
                case 2 -> taskList.listaDeTarefas();
                case 3 -> taskList.tarefaConcluida();
                case 4 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida");
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (escolha != 4);
    }

}
