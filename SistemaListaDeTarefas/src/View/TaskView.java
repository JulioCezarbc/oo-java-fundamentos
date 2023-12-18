package View;
import Model.TaskList;
import java.util.Scanner;

public class TaskView {
    private final TaskList taskList;

    public TaskView(TaskList taskList) {

        this.taskList = taskList;

    }

    public void menu(){
        System.out.println("--- Menu ---");
        System.out.println("1 - Adicionar tarefa ");
        System.out.println("2 - Lista de tarefas ");
        System.out.println("3 - Marcar tarefa como concluida");
        System.out.println("4 - Sair ");
        System.out.print("Opção: ");
    }

}
