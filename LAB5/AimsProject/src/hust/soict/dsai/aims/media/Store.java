package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class Store {
    public static final int MAX_MEDIA_IN_STORE = 50;
    private ArrayList<Media> itemsInNmtStore = new ArrayList<Media>();
    private Cart cart = new Cart();

    public void setCart(Cart cart) {
        if (cart != null) {
            this.cart = cart;
        }
    }

    public Cart getCart() {
        return cart;
    }

    public boolean addMedia(Media media) {
        if(itemsInNmtStore.size() == MAX_MEDIA_IN_STORE) {
            System.out.println("Your store is full, can't add new item");
            return false;
        } else {
            itemsInNmtStore.add(media);
            System.out.println("New item has been added");
            return true;
        }
    }

    public boolean removeMedia(Media media) {
        if(!itemsInNmtStore.contains(media)) {
            System.out.println("Item not found");
            return false;
        } else {
            itemsInNmtStore.remove(media);
            System.out.println("New item has been removed");
            return true;
        }
    }


    public boolean removeMedia(String title) {
        for(Media item: itemsInNmtStore) {
            if(item.getTitle().equals(title)) {
                itemsInNmtStore.remove(item);
                System.out.println("Item has been removed");
                return true;
            }
        }
        System.out.println("Item not found");
        return false;
    }

    public void printItemsInStore() {
        System.out.println("***********************STORE***********************");
        System.out.println("Available Items:");
        for(int i=0; i<itemsInNmtStore.size(); i++) {
            Media media = itemsInNmtStore.get(i);
            System.out.printf("%d. Media %s - %s: %.2f$ \n",
                            i+1, media.getTitle(), media.getCategory(), media.getCost() );
        }
        System.out.println("***************************************************");
    }

    // Search by title 
    public Media searchByTitle(String title) {
        int n = itemsInNmtStore.size();
        for (int i = 0; i < n; i++) {
            if (itemsInNmtStore.get(i).isMatchNmt(title)) {
//                System.out.println(title + " - " + itemsInStore.get(i).getCost());
                return itemsInNmtStore.get(i); // Return the matching media
            }
        }
        return null; // Return null if no match is found
    }
    
     public ArrayList<Media> getItemsInStore() {
		return itemsInNmtStore;
	}
}
