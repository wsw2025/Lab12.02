import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StoreTester {
    @org.junit.jupiter.api.Test
    void addBookTest(){
        Store store = new Store();
        Book book = new Book();
        store.addBook(book);
        assertTrue(store.getItems().size() == 1);
    }

    @org.junit.jupiter.api.Test
    void addBookAndPhone(){
        Store store = new Store();
        Book book = new Book();
        store.addBook(book);
        Phone phone = new Phone();
        store.addPhone(phone);
        assertTrue(store.getItems().size()==2);
    }

    @org.junit.jupiter.api.Test
    void updatePhoneTest(){
        Store store = new Store();
        Phone phone1 = new Phone();
        Book book = new Book();
        store.addBook(book);
        Phone phone2 = new Phone();
        Phone phone3 = new Phone();
        store.addPhone(phone1);
        store.addPhone(phone2);
        store.addPhone(phone3);
        store.updatePhonesLocation("Room 514");
        ArrayList<Phone> phones = store.getAllPhones();
        assertTrue(phones.size()==3 && phones.get(0).getLocation().equals("Room 514") && phones.get(1).getLocation().equals("Room 514") && phones.get(2).getLocation().equals("Room 514"));
    }

    @org.junit.jupiter.api.Test
    void getAllItemsTest(){
        Store store = new Store();
        Book book = new Book();
        store.addBook(book);
        Phone phone = new Phone();
        store.addPhone(phone);
        ArrayList<CISItem> items = store.getItems("Book");
        assertTrue(items.size()==1);
    }

    @org.junit.jupiter.api.Test
    void updateAll(){
        Store store = new Store();
        Phone phone1 = new Phone();
        Book book = new Book();
        store.addBook(book);
        Phone phone2 = new Phone();
        Phone phone3 = new Phone();
        store.addPhone(phone1);
        store.addPhone(phone2);
        store.addPhone(phone3);
        store.updateItems("phone", "Location", "Room 514");
        ArrayList<Phone> phones = store.getAllPhones();
        assertTrue(phones.size()==3 && phones.get(0).getLocation().equals("Room 514") && phones.get(1).getLocation().equals("Room 514") && phones.get(2).getLocation().equals("Room 514"));

        Store store1 = new Store();
        Book book2 = new Book();
        Book book3 = new Book();
        store.addBook(book);
        Phone phone4 = new Phone();
        store.addBook(book2);
        store.addBook(book3);
        store.addPhone(phone4);
        store.updateItems("book", "Location", "Room 514");
        ArrayList<CISItem> books = store.getItems("Book");
        assertTrue( books.get(0).getLocation().equals("Room 514") && books.get(1).getLocation().equals("Room 514") && books.get(2).getLocation().equals("Room 514"));
    }

    @org.junit.jupiter.api.Test
    void showAll() {
        Store store = new Store();
        Phone phone1 = new Phone();
        Book book = new Book();
        store.addBook(book);
        Phone phone2 = new Phone();
        Phone phone3 = new Phone();
        store.addPhone(phone1);
        store.addPhone(phone2);
        store.addPhone(phone3);
        store.updateItems("phone", "Location", "Room 514");
        store.showAllInfo();
    }
}