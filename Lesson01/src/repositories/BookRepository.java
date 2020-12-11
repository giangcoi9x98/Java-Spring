package repositories;

import dtos.BookWithAuthorName;
import entities.Author;
import entities.Book;


import java.util.ArrayList;
import java.util.List;


public class BookRepository {


    List<BookWithAuthorName> listBooks;
    List<Book> books = new ArrayList<Book>() {{
        add(new Book(0, "sach1", 0));
        add(new Book(1, "sach2", 1));
    }};
    List<Author> authors = new ArrayList<Author>() {{
        add(new Author(0, "Giang"));
        add(new Author(1, "Thien"));
        add(new Author(2, "Thang"));
    }};

    public List<BookWithAuthorName> getAllBooks() {
        listBooks = new ArrayList<>();
        for (Book b : books) {
            BookWithAuthorName book = new BookWithAuthorName();
            book.id = b.id;
            book.name = b.name;
            book.authorId = b.authorId;
            for (Author a : authors) {
                if (b.authorId == a.id) {
                    book.authorName = a.name;
                }
            }
            listBooks.add(book);
        }
        return listBooks;
    }

    public boolean checkExist(int id) {
        List<BookWithAuthorName> list = getAllBooks();
        boolean check = false;
        for (BookWithAuthorName b : list) {
            if (b.id == id) {
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean checkAuthorId(int id) {
        boolean check = false;
        for (Author b : authors) {
            if (b.id == id) {
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean checkBookId(int id) {
        boolean check = true;
        for (Book b : books) {
            if (b.id == id) {
                check = false;
                break;
            }
        }
        return check;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void deleteBook(int id) {
        books.removeIf(obj -> obj.getId() == id);
    }

    public void updateBook(Book book) {
        for (Book b : books) {
            if (b.getId() == book.id) {
                b.setName(book.getName());
                b.setAuthorId(book.getAuthorId());
            }
        }

    }
}
