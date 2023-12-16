package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskList {
    private List<Task> listaTask;
    private final Scanner entrada;
    public TaskList(List<Task> listaTask,Scanner entrada) {
        this.listaTask = listaTask;
        this.entrada = entrada;
    }
    public TaskList(){
        this.listaTask = new ArrayList<>();
        this.entrada = new Scanner(System.in);

    }

    public void adicionarTarefa(){
        try {
            System.out.print("Informe a tarefa: ");
            String tarefa = entrada.nextLine();
            if (!validarApenasLetras(tarefa)) {
                throw new RuntimeException("Erro: O nome da tarefa deve conter apenas letras!");
            }
            Task task = new Task(tarefa);
            listaTask.add(task);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public void listaDeTarefas() {
        System.out.println("------ Lista de Tarefas ------");
        int contador = 1;
        for (Task task : listaTask) {
            System.out.println("Tarefa "+ contador +": " + task.getName() + " | Completa: " + task.isCompleta());
            contador++;
        }
        System.out.println("----------------------");
    }
    public void tarefaConcluida() {
        System.out.print("Informe o índice da tarefa a ser marcada como concluída: ");
        int indice = entrada.nextInt();
        indice--;
        if (indice >= 0 && indice < listaTask.size()) {
            listaTask.get(indice).taskCompletada();
            System.out.println("Tarefa marcada como concluída com sucesso!");
        } else {
            System.out.println("Índice de tarefa inválido!");
        }
    }
    private boolean validarApenasLetras(String input) {
        return input.matches("[a-zA-Z ]+");
    }
}
