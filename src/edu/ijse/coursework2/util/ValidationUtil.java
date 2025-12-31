/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.coursework2.util;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class ValidationUtil {

    // Regex Patterns
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    // Simple Phone: Allow 10 digits (e.g., 0771234567)
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");
    // Double (Price): Allow numbers like 100, 100.50
    private static final Pattern DOUBLE_PATTERN = Pattern.compile("^[0-9]+(\\.[0-9]{1,2})?$");
    // Integer: Allow only whole numbers
    private static final Pattern INT_PATTERN = Pattern.compile("^\\d+$");

    /**
     * Checks if a field is empty.
     * @param field The text field to check
     * @param fieldName Name to show in the error message
     * @return true if valid (not empty), false if invalid
     */
    public static boolean validateEmpty(JTextField field, String fieldName) {
        if (field.getText() == null || field.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, fieldName + " cannot be empty.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            field.requestFocus(); // Set focus back to the bad field
            return false;
        }
        return true;
    }

    public static boolean validateEmail(JTextField field) {
        String text = field.getText().trim();
        if (!text.isEmpty() && !EMAIL_PATTERN.matcher(text).matches()) {
            JOptionPane.showMessageDialog(null, "Invalid Email Format (example@domain.com)", "Validation Error", JOptionPane.ERROR_MESSAGE);
            field.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean validatePhone(JTextField field) {
        String text = field.getText().trim();
        // Check if length is correct and contains only digits
        if (!text.isEmpty() && !PHONE_PATTERN.matcher(text).matches()) {
            JOptionPane.showMessageDialog(null, "Invalid Phone Number. Must be 10 digits.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            field.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean validateDouble(JTextField field, String fieldName) {
        String text = field.getText().trim();
        if (!text.isEmpty() && !DOUBLE_PATTERN.matcher(text).matches()) {
            JOptionPane.showMessageDialog(null, fieldName + " must be a valid number (e.g., 1500.00).", "Validation Error", JOptionPane.ERROR_MESSAGE);
            field.requestFocus();
            return false;
        }
        return true;
    }
}