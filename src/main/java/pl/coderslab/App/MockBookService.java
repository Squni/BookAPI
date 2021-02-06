package pl.coderslab.App;

import org.springframework.stereotype.Component;
import pl.coderslab.Entity.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class MockBookService {
    private List<Book> list;

    public MockBookService() {
        this.list = new ArrayList<>();
        this.list.add(new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming"));
        this.list.add(new Book(2L, "9827401230123", "Trele morele",
                "Jackson Patty", "Ompalopma", "kids"));
        this.list.add(new Book(3L, "0752138121023", "Babla babla",
                "Donald Pmurt", "The White House", "fiction"));
    }

    public List<Book> getList() {
        list.sort(Comparator.comparing(Book::getId));
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }
}
