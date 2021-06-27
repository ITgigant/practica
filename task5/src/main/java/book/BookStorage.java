package book;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

class Book {
    private String Name;
    private String Author;
    private String Year;
    private int id;

    public Book(String Name, String Author, String Year, int id) {
        this.id = id;
        this.Name = Name;
        this.Author = Author;
        this.Year = Year;
    }
    public Book() {

    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }

    public String getAuthor() {
        return Author;
    }
    public void setAuthor(String author){
        this.Author = author;
    }

    public String getYear(){
        return Year;
    }
    public void setYear(String Year){
        this.Year = Year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

@Component
class BookStorage {
    ArrayList<Book> booksArray;
    int id = 1;
    public BookStorage() {
        booksArray = new ArrayList<>();
    }

    public ArrayList<Book> testList() {
        return booksArray;
    }

    public boolean isEmpty() {
        if (booksArray.isEmpty()) {
            return true;
        }
        return false;
    }

    public void add(String Name, String Author, String Year) {
        booksArray.add(new Book(Name, Author, Year, id++));
    }

    public ArrayList<Book> get() {
        return booksArray;
    }

    public void removeId(int id) {
        booksArray.removeIf(p -> p.getId() == id);
    }
}
