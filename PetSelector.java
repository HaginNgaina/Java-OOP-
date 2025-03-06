/*
 * In this Code I used BufferedImage and ImageIO To load , hold and use the images.
 */
package javaapplication1;

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.io.File;  
import java.io.IOException;  
import javax.imageio.ImageIO;  
import java.awt.image.BufferedImage;  

public class PetSelector extends JFrame implements ActionListener {  
    // Declare radio buttons and an image label  
    private JRadioButton birdButton;  
    private JRadioButton catButton;  
    private JRadioButton dogButton;  
    private JRadioButton rabbitButton;  
    private JRadioButton pigButton;  
    private JLabel petImageLabel;  

    // BufferedImages to hold the loaded images  
    private BufferedImage birdImage;  
    private BufferedImage catImage;  
    private BufferedImage dogImage;  
    private BufferedImage rabbitImage;  
    private BufferedImage pigImage;  

    public PetSelector() {  
        // Set up the frame  
        setTitle("RadioButtonDemo");  
        setSize(300, 300);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(new FlowLayout());  

        // Load Images  
        try {  
            birdImage = ImageIO.read(new File("C:\Users\PC-User 430 G3\OneDrive\Documents\NetBeansProjects\JavaApplication1\src\javaapplication1\bird.jpg"));  
            catImage = ImageIO.read(new File("C:\Users\PC-User 430 G3\OneDrive\Documents\NetBeansProjects\JavaApplication1\src\javaapplication1\cat.jpg"));  
            dogImage = ImageIO.read(new File("C:\Users\PC-User 430 G3\OneDrive\Documents\NetBeansProjects\JavaApplication1\src\javaapplication1\dog.jpg"));  
            rabbitImage = ImageIO.read(new File("C:\Users\PC-User 430 G3\OneDrive\Documents\NetBeansProjects\JavaApplication1\src\javaapplication1\rabbit.jpg"));  
            pigImage = ImageIO.read(new File("C:\Users\PC-User 430 G3\OneDrive\Documents\NetBeansProjects\JavaApplication1\src\javaapplication1\pig.jpg"));  
        } catch (IOException e) {  
            System.err.println("Error loading image: " + e.getMessage());  
            // Load a default error image if the original fails  
            try {  
                BufferedImage errorImage = ImageIO.read(new File("error.png")); // Create an error image and name it to 'error.png'  
                petImageLabel.setIcon(new ImageIcon(errorImage));  
            } catch (IOException ex) {  
                System.err.println("Error loading error image: " + ex.getMessage());  
                petImageLabel.setText("Image not found"); // If even the error image fails, display text  
            }  
        }  

        // Create radio buttons  
        birdButton = new JRadioButton("Bird");  
        catButton = new JRadioButton("Cat");  
        dogButton = new JRadioButton("Dog");  
        rabbitButton = new JRadioButton("Rabbit");  
        pigButton = new JRadioButton("Pig");  

        // Group the radio buttons  
        ButtonGroup group = new ButtonGroup();  
        group.add(birdButton);  
        group.add(catButton);  
        group.add(dogButton);  
        group.add(rabbitButton);  
        group.add(pigButton);  

        // Add action listener to radio buttons  
        birdButton.addActionListener(this);  
        catButton.addActionListener(this);  
        dogButton.addActionListener(this);  
        rabbitButton.addActionListener(this);  
        pigButton.addActionListener(this);  

        // Create a label to display the pet image  
        petImageLabel = new JLabel();  
        petImageLabel.setPreferredSize(new Dimension(150, 150));  

        // Add components to the frame  
        add(birdButton);  
        add(catButton);  
        add(dogButton);  
        add(rabbitButton);  
        add(pigButton);  
        add(petImageLabel);  

        setVisible(true); // Ensure frame is visible after adding components  
    }  

    // Action event handler  
    @Override  
    public void actionPerformed(ActionEvent e) {  
        ImageIcon icon = null; // Declare icon outside the switch  

        // Check if images were loaded successfully before using them  
        if (birdImage == null || catImage == null || dogImage == null || rabbitImage == null || pigImage == null) {  
            System.err.println("One or more images failed to load.  Check file paths.");  
            return; // Exit the method to prevent NullPointerException  
        }  

        switch (e.getActionCommand()) {  
            case "Bird":  
                icon = new ImageIcon(birdImage);  
                break;  
            case "Cat":  
                icon = new ImageIcon(catImage);  
                break;  
            case "Dog":  
                icon = new ImageIcon(dogImage);  
                break;  
            case "Rabbit":  
                icon = new ImageIcon(rabbitImage);  
                break;  
            case "Pig":  
                icon = new ImageIcon(pigImage);  
                break;  
        }  

        petImageLabel.setIcon(icon); // Set the icon after the switch  
    }  

    public static void main(String[] args) {  
        // Create and show the application  
        PetSelector app = new PetSelector();  
        app.setVisible(true);  
    }  
}  