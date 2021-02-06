package pl.coderslab.Controllers;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.App.MemoryBookService;
import pl.coderslab.Entity.Book;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private MemoryBookService memoryBookService;

    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @GetMapping
    public List<Book> allBooks() {
        return memoryBookService.bookList();
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {memoryBookService.addBook(book);}

    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id) {
        return memoryBookService.getBook(id);
    }

    @PutMapping
    public void editBook(@RequestBody Book book) {
        memoryBookService.editBook(book.getId(), book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id){
        memoryBookService.delBook(id);
    }

}
