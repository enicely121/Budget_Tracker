package Budget;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.*;

public class GUI extends JFrame implements ActionListener {

    /**
     * Class for the GUI of the Budget App
     */
    public GUI() {

        // create the frame
        JFrame frame = new JFrame();

        // create the panel
        JPanel panel = new JPanel();

        // create the button
        JButton button = new JButton("Click me");

        // set the border and the panel of the layout
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout());

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Budget App");
        frame.pack();
        frame.setVisible(true);

        // add the button to the panel and set the action listener for when button is clicked
        button.addActionListener(this);
        panel.add(button);
    }

    // method for button click
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!");
    }

    // main method to run the GUI
    public static void main(String[] args) {
        new GUI();
    }
}
