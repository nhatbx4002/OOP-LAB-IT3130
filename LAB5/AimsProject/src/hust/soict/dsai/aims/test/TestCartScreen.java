package hust.soict.dsai.aims.test;

import javax.swing.*;

import hust.soict.dsai.aims.cart.CartScreen;
import hust.soict.dsai.aims.media.*;

public class TestCartScreen {
    public static void main(String[] args) {
        Cart cart = new Cart();

        //Media m1 = new DVDTungNM("Doraemon", "Anime", "Fujio",15,  15f);
        Media m1 = new DVD("Doraemon", "Anime", 15f);
        Media m2 = new Book(0, "Why we sleep", "Scientific", 9f);
        Media m3 = new CompactDisc(1, "Gao ranger", "Super sentai", 20f, 2, "Tasdsad");
        Media m4 = new Disc(1, "Conan", "Anime", 50f, 10, "asd");

        cart.addMedia(m1);
        cart.addMedia(m2);
        cart.addMedia(m3);
        cart.addMedia(m4);

        CartScreen cartScreen = new CartScreen(cart);

        cartScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
