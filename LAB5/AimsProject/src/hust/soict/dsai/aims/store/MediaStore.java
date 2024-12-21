package hust.soict.dsai.aims.store;

import javax.swing.*;

import hust.soict.dsai.aims.media.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Add "Add to Cart" Button
        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(e -> {
            boolean success = cart.addMedia(media);
            if (success) {
                JOptionPane.showMessageDialog(
                    MediaStore.this,
                    "Added " + media.getTitle() + " to the cart successfully!", 
                    "Add to Cart", 
                    JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                    MediaStore.this,
                    "Failed to add " + media.getTitle() + " to cart", 
                    "Add to Cart", 
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });
        container.add(addToCartButton);

        // Add "Play" Button if the media is playable
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Show play message
                    JOptionPane.showMessageDialog(
                        MediaStore.this,
                        "Playing " + media.getTitle(), 
                        "Play Media", 
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }
            });
            container.add(playButton);
        }
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

}
