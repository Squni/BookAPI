package pl.coderslab.App;

import org.springframework.stereotype.Component;
import pl.coderslab.Entity.Book;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemoryBookService {
    private MockBookService mockBookService;

    public MemoryBookService(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    public List<Book> bookList() {
        return mockBookService.getList();
    }

    public void addBook(Book book) {
        List<Book> list = mockBookService.getList();
        if (book.getId() == null) {
            book.setId(list.stream()
                    .mapToLong(it -> it.getId()).max().orElse(0L) + 1);
        }
        list.add(book);
        mockBookService.setList(list);
    }

    public Book getBook(long id) {
        return mockBookService.getList().stream()
                .filter(it -> it.getId() == id)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Book not found"));
    }

    public void editBook(long id, Book book) {
        delBook(id);
        book.setId(id);
        addBook(book);
    }

    public void delBook(long id) {
        List<Book> list = mockBookService.getList();
        list = list.stream()
                .filter(it -> it.getId() != id)
                .collect(Collectors.toList());
        mockBookService.setList(list);
    }
}
