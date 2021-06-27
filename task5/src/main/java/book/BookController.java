package book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    BookStorage storage;

    @GetMapping(value = "/book")
    public String BookForm(Model model) {
        model.addAttribute("books", storage.get());
        return "book";
    }

    @GetMapping("/book/addBook")
    public String BookAdd(Model model) {
        model.addAttribute("book", new Book("","","",0));
        return "addBook";
    }

    @PostMapping("/book/addBook")
    public String BookAdd(@ModelAttribute Book books, Model model) {
        model.addAttribute("book", books);
        if (!((books.getName().equals("")) && (books.getAuthor().equals("")) && (books.getYear().equals("")))) {
            storage.add(books.getName(), books.getAuthor(), books.getYear());
            model.addAttribute("books", storage.get());
            return "book";
        }
        return "addBook";
    }

    @RequestMapping("/book/deleteBook")
    public String BookDelete(@RequestParam(value = "id", required = false, defaultValue = "0") int id, Model model) {
        model.addAttribute("books", storage.get());
        storage.removeId(id);
        return "deleteBook";
    }
}