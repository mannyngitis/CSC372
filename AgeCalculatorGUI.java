import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculatorGUI extends JFrame implements ActionListener {
    private final JTextField birthDateField;
    private final JButton calculateButton;
    private final JLabel ageLabel;

    public AgeCalculatorGUI() {
        setTitle("Age Calculator");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initialize components
        JPanel mainPanel = new JPanel();
        JLabel birthDateLabel = new JLabel("Enter Birth Date (YYYY-MM-DD):");
        birthDateField = new JTextField(10);
        calculateButton = new JButton("Calculate Age");
        ageLabel = new JLabel();

        // Add ActionListener to the button
        calculateButton.addActionListener(this);

        // Add components to the panel
        mainPanel.add(birthDateLabel);
        mainPanel.add(birthDateField);
        mainPanel.add(calculateButton);
        mainPanel.add(ageLabel);

        // Add panel to the frame
        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            // Get the birthdate from the text field
            String birthDateStr = birthDateField.getText();

            // Parse the birthdate string into a LocalDate object
            LocalDate birthDate = LocalDate.parse(birthDateStr);

            // Calculate age
            LocalDate currentDate = LocalDate.now();
            Period age = Period.between(birthDate, currentDate);

            // Display age
            ageLabel.setText("Age: " + age.getYears() + " years, " +
                    age.getMonths() + " months, " + age.getDays() + " days");
        }
    }

    public static void main(String[] args) {
        // Create and display the GUI
        SwingUtilities.invokeLater(() -> {
            AgeCalculatorGUI calculator = new AgeCalculatorGUI();
            calculator.setVisible(true);
        });
    }
}