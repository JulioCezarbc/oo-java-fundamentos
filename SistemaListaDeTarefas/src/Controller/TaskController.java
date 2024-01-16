package Controller;

import Model.TaskList;
import View.TaskView;

public class TaskController {

    private TaskList taskList;
    private TaskView taskView;

    public TaskController(TaskList taskList, TaskView taskView) {
        this.taskList = taskList;
        this.taskView = taskView;
    }
    public TaskController() {
        this.taskList = new TaskList();
        this.taskView = null;  // TaskView será configurado posteriormente com setTaskView
    }
    public void setTaskView(TaskView taskView) {
        this.taskView = taskView;
    }
    public void iniciar(){
        this.taskView = taskView;
        taskView.start();
    }
    public void adicionarTarefa(){
        taskList.adicionarTarefa();
    }
    public void listaDeTarefas(){
        taskList.listaDeTarefas();
    }
    public void tarefaConcluida(){
        taskList.tarefaConcluida();
    }

}