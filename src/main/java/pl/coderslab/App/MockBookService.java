package pl.coderslab.App;

import org.springframework.stereotype.Component;
import pl.coderslab.Entity.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MockBookService {
    private List<Book> list;
    private long uniqId = 1L;

    public MockBookService() {
        this.list = new ArrayList<>();
    }

    public List<Book> getList() {
        list.sort(Comparator.comparing(Book::getId));
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public List<Book> bookList() {
        return getList();
    }

    public void addBook(Book book) {
        List<Book> list = getList();
        if (book.getId() == null) {
            book.setId(uniqId++);
        }
        list.add(book);
        setList(list);
    }

    public Book getBook(long id) {
        return getList().stream()
                .filter(it -> it.getId() == id)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Book not found"));
    }

    public void editBook(long id, Book book) {
        delBook(id);
        book.setId(id);
        addBook(book);
    }

    public void delBook(long id) {
        List<Book> list = getList();
        list = list.stream()
                .filter(it -> it.getId() != id)
                .collect(Collectors.toList());
        setList(list);
    }
}
