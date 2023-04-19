package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    public void testAdd() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1,"The Great Gatsby", 300, "Francis Scott Fitzgerald");
        Book book2 = new Book(2,"Island", 400, "Aldous Huxley");
        Book book3 = new Book(3,"Lord of the Flies", 500, "William Golding");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("The Great Gatsby");
        Product[] expected = {book1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testComparison() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1,"The Great Gatsby", 300, "Francis Scott Fitzgerald");
        Book book2 = new Book(2,"Island", 400, "Aldous Huxley");
        Book book3 = new Book(3,"Lord of the Flies", 500, "William Golding");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenSomeProductsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1,"The Great Gatsby", 300, "Francis Scott Fitzgerald");
        Book book2 = new Book(2,"Island", 400, "Aldous Huxley");
        Book book3 = new Book(3,"Lord of the Flies", 500, "William Golding");
        Book book4 = new Book(4,"The Great Gatsby", 300, "Francis Scott Fitzgerald");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product[] actual = manager.searchBy("The Great Gatsby");
        Product[] expected = {book1, book4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenAnyProductsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1,"The Great Gatsby", 300, "Francis Scott Fitzgerald");
        Book book2 = new Book(2,"Island", 400, "Aldous Huxley");
        Book book3 = new Book(3,"Lord of the Flies", 500, "William Golding");
        Book book4 = new Book(4,"The Great Gatsby", 300, "Francis Scott Fitzgerald");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product[] actual = manager.searchBy("Doctor");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

}