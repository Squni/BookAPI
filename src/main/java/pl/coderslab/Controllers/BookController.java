package pl.coderslab.Controllers;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.App.MockBookService;
import pl.coderslab.Entity.Book;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private MockBookService mockBookService;

    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @GetMapping
    public List<Book> allBooks() {
        return mockBookService.bookList();
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {mockBookService.addBook(book);}

    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id) {
        return mockBookService.getBook(id);
    }

    @PutMapping
    public void editBook(@RequestBody Book book) {
        mockBookService.editBook(book.getId(), book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id){
        mockBookService.delBook(id);
    }

}
