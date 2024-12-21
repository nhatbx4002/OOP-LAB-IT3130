package hust.soict.dsai.aims.test;

import javax.swing.*;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.*;

public class TestStoreScreen {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        Media m1 = new DVD("Doraemon", "DVD", 20.99f, 15, "Fijio");
        Media m2 = new Book(0, "Why we sleep", "Book", 9f);
        Media m3 = new CompactDisc(1, "Gao ranger", "CD", 20f, 2, "Tadadasd");
        Media m4 = new CompactDisc(1, "Conan", "CD", 15.99f, 10, "adadads");

        store.addMedia(m1);
        store.addMedia(m2);
        store.addMedia(m3);
        store.addMedia(m4);

        StoreScreen storeScreen = new StoreScreen(store, cart);

        store.setCart(cart);

        storeScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
