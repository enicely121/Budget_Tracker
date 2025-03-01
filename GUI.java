package Budget;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import Functionality;

public class GUI implements ActionListener {

    JFrame frame;
    JPanel panel;
    JButton button;
    JTextField inputField;
    Functionality functionality;

    /**
     * Class for the GUI of the Budget App
     */
    public GUI() {

        // create the frame
        frame = new JFrame();

        // create the panel
        panel = new JPanel();

        // create the button
        button = new JButton("Submit");

        // create the text field for user input
        inputField = new JTextField(20);

        // initialize functionality
        functionality = new Functionality();

        // set the border and the panel of the layout
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(3, 1)); // Adjust layout to accommodate the input field and button

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Budget App");
        frame.pack();
        frame.setVisible(true);

        // Add the input field and button to the panel
        panel.add(new JLabel("Enter week and value (e.g., Week1 100):"));
        panel.add(inputField);
        panel.add(button);

        // Set the action listener for the button
        button.addActionListener(this);
    }

    // method for button click
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the input from the text field
        String input = inputField.getText();
        String[] parts = input.split(" ");
        if (parts.length == 2) {
            String week = parts[0];
            int value;
            try {
                value = Integer.parseInt(parts[1]);
                // Add the value to the specified week using the functionality
                functionality.addValue(week, value);
                // Display the weekly values
                functionality.displayWeeklyValues(week);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid value entered. Please enter a valid number.");
            }
        } else {
            System.out.println("Invalid input format. Please enter in the format 'Week1 100'.");
        }
    }

    // main method to run the GUI
    public static void main(String[] args) {
        new GUI();
    }
}
