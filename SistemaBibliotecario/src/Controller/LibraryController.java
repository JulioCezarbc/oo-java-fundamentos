package Controller;
import java.util.ArrayList;
import java.util.List;

import Model.Book;
import Model.Library;
import View.LibraryView;

public class LibraryController {
    private Library library;
    public LibraryController(Library library) {
        this.library = library;
    }

    public void adicionarBook(String titulo, String autor){
        Book book = new Book(titulo,autor);
        library.adicionarBook(book);

    }
    public static boolean validarApenasLetras(String opcao) {
        return opcao.matches("[a-zA-Z ]+");
    }

    public List<Book> listarBook() {
        return library.listarBook();
    }
    public static void main(String[] args) {
        LibraryController controlador = new LibraryController(new Library(new ArrayList<>()));
        LibraryView view = new LibraryView(controlador);
        view.exec();
    }
}
