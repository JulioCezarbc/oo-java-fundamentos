package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public void adicionarBook(Book book){
        books.add(book);
    }

    public List<Book> listarBook() {
        List<Book> listar = new ArrayList<>();
        for (Book book : books) {
            listar.add(book);
        }
        return listar;
    }

    public List<Book> getBooks() {
        return books;
    }
}
