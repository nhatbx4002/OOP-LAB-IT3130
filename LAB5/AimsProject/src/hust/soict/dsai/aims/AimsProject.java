package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.StoreScreen;

import javax.swing.*;

public class AimsProject {
    public static Scanner scanner = new Scanner(System.in);
    public static Store store = new Store();
    public static Cart cart = new Cart();

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

    public static void showMenu() {
        while (true) {
            System.out.println("Nguyen manh Tung 20225682");
            System.out.println("------------------------------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("------------------------------------------------------");

            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    break;
                case 1: 
                    storeMenu();
                    continue;
                case 2:
                    updateStoreMenu();
                    continue;
                case 3: 
                    cartMenu();
                    continue;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
            break;
        }
    }

    public static void updateStoreMenu() {
        while (true) {
            System.out.println("Options:");
            System.out.println("------------------------------------------------------");
            System.out.println("1. Add a media");
            System.out.println("2. Remove a media");
            System.out.println("0. Back");
            System.out.println("------------------------------------------------------");
            System.out.println("---> ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    Media newItem = createNewMedia();
                    store.addMedia(newItem);
                    continue;
                case 2:
                    System.out.println("Enter the media title: ");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    store.removeMedia(title);
                    continue;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
            break;
        }
    }

    public static Media createNewMedia() {
        Media item = null;
        System.out.println("Enter the Media info");
        System.out.println("Title: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        System.out.println("Cost: ");
        float cost = scanner.nextFloat();

        while (true) {
            System.out.println("Chosse a media type: ");
            System.out.println("1. Book");
            System.out.println("2. DVD");
            System.out.println("3. CD");
            System.out.println("0. Back");

            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    break;
                case 1: 
                    item = new Book(title, cost);
                    break;
                case 2: 
                    item = new DVD(title, cost);
                    break;
                case 3: 
                    item = new CompactDisc(title, cost);
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
            break;
        }
        return item;
    }

    public static void storeMenu() {
        while (true) {
                store.printItemsInStore();
                System.out.println("Options: ");
                System.out.println("------------------------------------------------------");
                System.out.println("1. See a media's details");
                System.out.println("2. Add a media to cart");
                System.out.println("3. Play media");
                System.out.println("4. See current cart");
                System.out.println("0. Exit");
                System.out.println("------------------------------------------------------");
                System.out.println("Please choose a number: 0, 1, 2, 3, 4");
                System.out.println("--->");

                String title;
                Media item;
                int choice = scanner.nextInt();
                switch (choice) {
                    case 0:
                        break;
                    case 1:
                        System.out.println("Enter the media title: ");
                        scanner.nextLine();
                        title = scanner.nextLine();
                        item = store.searchByTitle(title);
                        if(item != null) {
                            mediaDetailMenu(item);
                        }
                        continue;
                    case 2:
                        System.out.println("Enter the media title: ");
                        scanner.nextLine();
                        title = scanner.nextLine();
                        item = store.searchByTitle(title);
                        if(item != null) {
                            cart.addMedia(item);
                        }
                        continue;
                    case 3:
                        System.out.println("Enter the media title: ");
                        scanner.nextLine();
                        title = scanner.nextLine();
                        item = store.searchByTitle(title);
                        if(item instanceof Playable) {
                            ((Playable) item).play();
                        } else if (item != null) {
                            System.out.println("This item is not playable");
                        }
                        continue;
                    case 4:
                        cart.printItemsInCartNMT();
                        continue;
                    default:
                        System.out.println("Invalid choise, please try again");
                        continue;
                }
                break;
            }
        }
       

    public static void mediaDetailMenu(Media item) {
        while (true) {
            System.out.println(item.toString());
            System.out.println("Options: ");
            System.out.println("------------------------------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("------------------------------------------------------");
            System.out.println("Please chosse a number: 0, 1, 2");
            System.out.println("--->");

            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    cart.addMedia(item);
                    continue;
                case 2:
                    if(item instanceof Book) {
                        System.out.println("Books are not playable");
                    } else if (item instanceof Playable) {
                        ((Playable) item).play();
                    }
                    continue;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
            break;
        }
    }

    public static void cartMenu() {
        cart.printItemsInCartNMT();
        while (true) {
            System.out.println("Options: ");
            System.out.println("------------------------------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("Please choose a number: 0, 1, 2, 3, 4, 5");
            System.out.println("--->");

            int choice = scanner.nextInt();
            scanner.nextLine();
            String title = null;
            int id;
            Media item = null;
            switch (choice) {
                case 0:
                    break;
                case 1:
                    System.out.println("1. Filter by ID");
                    System.out.println("2. Filter by title");
                    System.out.print("Choose an option: ");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine(); // Xử lý ký tự xuống dòng
                    switch (filterChoice) {
                        case 1:
                            System.out.print("Enter the ID: ");
                            id = scanner.nextInt();
                            scanner.nextLine(); // Xử lý ký tự xuống dòng
                            System.out.println(cart.searchByIdNmt(id));
                            break;
                        case 2:
                            System.out.print("Enter the title: ");
                            title = scanner.nextLine();
                            System.out.println(cart.searchByTitleNmt(title));
                            break;
                        default:
                            System.out.println("Invalid filter option");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1. Sort by cost");
                    System.out.println("2. Sourt by title");
                    System.out.println("Choose an option: ");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (sortChoice) {
                        case 1:
                            cart.sortByCost();
                            cart.printItemsInCartNMT();
                            break;
                        case 2: 
                            cart.sortByTitle();
                            cart.printItemsInCartNMT();
                            break;
                        default:
                            System.out.println("Invalid sort option");
                            break;
                    }   
                case 3:
                    System.out.println("Enter the title: ");
                    title = scanner.nextLine();
                    item  = cart.searchByTitleNmt(title);
                    if(item != null) {
                        cart.removeMedia(item);
                    }
                    cart.printItemsInCartNMT();
                    continue;
                case 4:
                    System.out.print("Enter a title: ");
                    title = scanner.nextLine();
                    item = cart.searchByTitleNmt(title);
                
                    if (item == null) {
                        System.out.println("Item not found.");
                        continue;
                    }
                
                    if (item instanceof Playable) {
                        ((Playable) item).play();
                    } else {
                        System.out.println("Item not playable.");
                    }
                    continue;
                case 5:
                    System.out.println("Order info:");
                    System.out.println("Total cost: " + cart.totalPrice());
                    System.out.println("1. Continue\t2. Back");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            cart.emptyCart();;
                            System.out.println("Order placed successfully");
                            break;
                        case 2:
                            break;
                    }
                    continue;
                default:
                System.out.println("Invalid choice, please try again");
                    break;
            }
            break;
        }
    }

}
