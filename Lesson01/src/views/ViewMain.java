package views;

import controllers.BookController;
import dtos.BookWithAuthorName;
import entities.Book;

import java.util.List;
import java.util.Scanner;

public class ViewMain {
    Scanner sc = new Scanner(System.in);

    public ViewMain() {
        while (true) {
            System.out.println("1.Show all books");
            System.out.println("2.Add book");
            System.out.println("3.Update book");
            System.out.println("4.Delete book");
            System.out.println("5.test");

            int input = sc.nextInt();
            if (input == 1) {
                // show all books
                List<BookWithAuthorName> response = BookController.getInstance().getAllBooks();
                for (int i = 0; i < response.size(); i++) {
                    System.out.println(response.get(i));
                }
            } else if (input == 2) {
                System.out.println("Nhap thong tin sach ");
                System.out.println(" Nhap id: ");
                int id = sc.nextInt();
                System.out.println("Nhap ten sach");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.println(" Nhap authorID: ");
                int authorId = sc.nextInt();
                BookController.getInstance().addBook(new Book(id, name, authorId));
            } else if (input == 3) {
                System.out.println("Sua sach");
                System.out.println("Nhap id");
                int id = sc.nextInt();
                System.out.println("Nhap ten sach moi");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.println("Nhap authorId moi : ");
                int authorId = sc.nextInt();
                BookController.getInstance().updateBook(new Book(id, name, authorId));
            } else if (input == 4) {
                System.out.println("Nhap id :");
                int id = sc.nextInt();
                boolean rs = BookController.getInstance().deleteBook(id);
                System.out.println(rs);
            }
        }
    }
}
