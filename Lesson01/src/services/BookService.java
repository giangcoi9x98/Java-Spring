package services;

import dtos.BookWithAuthorName;
import entities.Book;
import repositories.BookRepository;

import java.util.List;

public class BookService {
    BookRepository bookRepository = new BookRepository();

    public List<BookWithAuthorName> getAllBooks() {
        // xu ly nghiep vu
        // call repository
        try {
            return bookRepository.getAllBooks();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean deleteBook(int bookId) {
        boolean isBookExist = bookRepository.checkExist(bookId);
        if (isBookExist) {
            bookRepository.deleteBook(bookId);
            System.out.println("Xoa  thanh cong ! " + bookId);
            return true;
        } else {
            return false;
        }
    }

    public void addBook(Book book) {
        if (bookRepository.checkAuthorId(book.authorId) && bookRepository.checkBookId(book.id)) {
            bookRepository.addBook(book);
            System.out.println(book.toString());
        } else {
            System.out.println("Failed!");
        }
    }

    public void updateBook(Book book) {
        if (bookRepository.checkAuthorId(book.authorId) && !bookRepository.checkBookId(book.id)) {
            bookRepository.updateBook(book);
            System.out.println(book.toString());
        } else {
            System.out.println("Update failed !");
        }

    }

}
