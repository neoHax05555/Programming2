package com.alec.bankbalance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class defines a generic window that can be reused. It contains a {@link JTextField} to display user instructions,
 * a {@link JTextField} to accept user input, and a {@link JButton} for user to press to acknowledge. There is an
 * abstract method for the user to define a custom action to do when button is pressed by user.
 */
public abstract class GenericWindow extends JFrame {
    /*
     * Constants begin.
     */
    public static final String WINDOW_TITLE = "Bank Balance Pro";
    public static final double INVALID_INPUT = -1;
    /*
     * Member variables begin.
     */
    Panel panel;
    private JLabel label;
    private JTextField jTextField;
    // TODO: make the buttons dynamic so that we can store an array of buttons or labels and actions.
    // TODO: Beautify the way button and text fields are displayed to be more visually appearing.
    private JButton jButton;
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    /**
     * An action listener to invoke an abstract method for user of this class to define action to perform when pressed.
     */
    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            onButtonPressed();
        }
    };


    /**
     * Default constructor disabled.
     */
    private GenericWindow() {
    }

    /**
     * Constructor to initialize the widow with the GenericWindowBuilder inner builder class.
     *
     * @param builder A {@link GenericWindowBuilder} to init this class.
     */
    GenericWindow(GenericWindowBuilder builder) {
        // Init JFrame
        super(WINDOW_TITLE);
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;

        this.setSize(builder.WIDTH , builder.HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new Panel(layout);

        this.label = new JLabel(builder.labelText);;
        layout.setConstraints(label, constraints);
        panel.add(label);

        this.jTextField = new JTextField();
        layout.setConstraints(this.jTextField, constraints);
        panel.add(this.jTextField);

        this.jButton = new JButton(builder.buttonText);
        this.jButton.addActionListener(this.actionListener);
        layout.setConstraints(this.jButton, constraints);
        panel.add(this.jButton);


        this.add(this.panel);
    }

    /**
     * Set the text in the label to describe to user what input is expected.
     *
     * @param label A String to describe expected user input.
     */
    public void setLabel(String label) {
        this.label.setText(label);
    }

    /**
     * Get input from jTextField.
     *
     * @return The String value of what is present in the JTextFiend.
     */
    public String getUserInput() {
        return this.jTextField.getText();
    }

    /**
     * Returns the {@link GridBagLayout} to use in a child class.
     *
     * @return {@link GridBagLayout} Object used for the {@link Panel} layout for this window.
     */
    public GridBagLayout getGridbagLayout() {
        return this.layout;
    }

    /**
     * Returns the {@link GridBagConstraints} to use in a child class.
     *
     * @return {@link GridBagConstraints} Object used for the {@link Panel} layout for this window.
     */
    public GridBagConstraints getGridbagConstraints() {
        return this.constraints;
    }

    /**
     * Convert a string to positive Double
     *
     * @param rawText A String value to attempt to cast to a non negative double value.
     *
     * @return -1      -> if non-numeric String or negative value.
     *         +double -> if positive double value.
     */
    public static double convertStringToDouble(String rawText) {
        double amount = INVALID_INPUT;

        try {
            // Attempt to cast to a double value, if non-numeric will throw a NumberFormatException.
            amount = Double.parseDouble(rawText);
            if (amount < 0) {
                // Set invalid if negative value.)
                amount = INVALID_INPUT;
                System.out.println("Invalid value, must be a positive double value.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error parsing user input." + e);
        }

        return amount;
    }

    /**
     * Abstract method to define in a child class if button is pressed.
     */
    public abstract void onButtonPressed();

    /**
     * Builder class to init the {@link GenericWindow} Object.
     */
    public static class GenericWindowBuilder {
        private final int WIDTH;
        private final int HEIGHT;
        private String labelText;
        private String buttonText;

        /**
         * Constructor that requires the user to minimally define a width and height for this window.
         *
         * @param width The width of the window to create.
         * @param height The height of the window to create.
         */
        GenericWindowBuilder(int width, int height) {
            this.WIDTH = width;
            this.HEIGHT = height;
        }

        /**
         * String that is displayed to the user.
         *
         * @param text Text to displayed to the user
         *
         * @return this Object to conform to builder pattern.
         */
        public GenericWindowBuilder setLabel(String text) {
            this.labelText = text;
            return this;
        }

        /**
         * String that is set to the GUI button.
         *
         * @param text Text to set to the GUI button.
         *
         * @return this Object to conform to builder pattern.
         */
        public GenericWindowBuilder setButtonText(String text) {
            this.buttonText = text;
            return this;
        }

        /**
         * Returns this Object to pass to the {@link GenericWindow} class.
         *
         * @return This Object.
         */
        public GenericWindowBuilder build() {
            return this;
        }
    }
}
