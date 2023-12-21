package Model;

public class Book {
    private String tituloBook;
    private String nomeAutor;
   // private boolean emprestimo = false;

    public Book(String tituloBook, String nomeAutor /*, boolean emprestimo*/) {
        this.tituloBook = tituloBook;
        this.nomeAutor = nomeAutor;
       // this.emprestimo = emprestimo;
    }

    public String getTituloBook() {
        return tituloBook;
    }

    public void setTituloBook(String tituloBook) {
        this.tituloBook = tituloBook;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    /*public boolean isEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(boolean emprestimo) {
        this.emprestimo = emprestimo;
    }*/

}
