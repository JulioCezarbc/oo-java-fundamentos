package Model;

public class Task {
    private String name;
    private boolean completa;

    public Task(String name) {
        this.name = name;
        this.completa = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleta() {
        return completa;
    }

    public void taskCompletada(){
        this.completa = true;
    }
    public void taskIncompleta(){
        this.completa = false;
    }
}
