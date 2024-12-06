package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;

public class Aims {

    private static Store store = new Store();  // Store instance
    private static Cart currentCart = new Cart();  // Current cart instance
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int option = getUserInput(0, 3);
            switch (option) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    return; // Exit the program
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void viewStore() {
        while (true) {
            storeMenu();
            int option = getUserInput(0, 4);
            switch (option) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    return;  // Back to main menu
            }
        }
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            System.out.println(media);
            mediaDetailsMenu();
            int option = getUserInput(0, 2);
            switch (option) {
                case 1:
                    addMediaToCart(title);
                    break;
                case 2:
                    playMedia(title);
                    break;
                case 0:
                    return;  // Back to store menu
            }
        } else {
            System.out.println("Media not found!");
        }
    }

    public static void addMediaToCart(String title) {
        Media media = store.searchByTitle(title);
        if (media != null) {
            currentCart.addMedia(media);
            System.out.println("Media added to cart.");
            System.out.println("Total DVDs in cart: " + currentCart.getNumberOfMedia("DVD"));
        } else {
            System.out.println("Invalid media title!");
        }
    }

    public static void addMediaToCart() {
        System.out.print("Enter the title of the media to add to the cart: ");
        String title = scanner.nextLine();
        addMediaToCart(title);
    }

    public static void playMedia(String title) {
        Media media = store.searchByTitle(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    public static void playMedia() {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        playMedia(title);
    }

    public static void updateStore() {
        System.out.println("Update store: ");
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        System.out.print("Please choose a number: 1-2: ");
        int option = getUserInput(1, 2);
        switch (option) {
            case 1:
                addMediaToStore();
                break;
            case 2:
                removeMediaFromStore();
                break;
        }
    }

    public static void addMediaToStore() {
        System.out.println("Enter media details to add:");
        // Collect the media details from user and add it to store
       
    }

    public static void removeMediaFromStore() {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        store.removeMedia(title);
        System.out.println("Media removed from store.");
    }

    public static void seeCurrentCart() {
        while (true) {
            cartMenu();
            int option = getUserInput(0, 5);
            switch (option) {
                case 1:
                    filterMediaInCart();
                    break;
                case 2:
                    sortMediaInCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMediaFromCart();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    return;  
            }
        }
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void filterMediaInCart() {
        System.out.println("Filter by: ");
        System.out.println("1. By ID");
        System.out.println("2. By Title");
        int option = getUserInput(1, 2);
    }

    public static void sortMediaInCart() {
        System.out.println("Sort by: ");
        System.out.println("1. By Title");
        System.out.println("2. By Cost");
        int option = getUserInput(1, 2);
    }

    public static void removeMediaFromCart() {
        System.out.print("Enter the title of the media to remove from cart: ");
        String title = scanner.nextLine();
        
        currentCart.removeMedia(title);
        System.out.println("Media removed from cart.");
    }

    public static void playMediaFromCart() {
        System.out.print("Enter the title of the media to play from cart: ");
        String title = scanner.nextLine();
        playMedia(title);
    }

    public static void placeOrder() {
        System.out.println("Order placed successfully!");
        currentCart.clearCart();
        System.out.println("Cart is now empty.");
    }

    public static int getUserInput(int min, int max) {
        int input = -1;
        while (input < min || input > max) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input < min || input > max) {
                    System.out.print("Invalid choice. Please choose a number between " + min + " and " + max + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please choose a number between " + min + " and " + max + ": ");
            }
        }
        return input;
    }
}
