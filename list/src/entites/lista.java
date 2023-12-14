package entites;

public class lista {
    public String name;
    private Integer id;
    public Double salary;


    public lista(Integer id,String name,  Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
    public void setId(){
        this.id = id;
    }


    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void AddSalary(double percentage){
        salary+= salary * percentage / 100.0;
    }
    public String toString() {
        return "ID: " + id + ", " +
                "Nome: " + name + ", " +
                String.format("Salario: %.2f", salary);
    }



}
