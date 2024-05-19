import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MenuExample extends JFrame {
    private JTextArea textArea;
    private JPanel panel;
    private Color initialGreenShade;

    public MenuExample() {
        // Set up the frame
        setTitle("Menu Example");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create a menu bar and add it to the frame
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create a menu
        JMenu menu = new JMenu("Options");
        menuBar.add(menu);

        // Menu item 1: Display Date and Time
        JMenuItem menuItem1 = new JMenuItem("Show Date and Time");
        menuItem1.addActionListener(e -> showDateTime());
        menu.add(menuItem1);

        // Menu item 2: Save to log.txt
        JMenuItem menuItem2 = new JMenuItem("Save to Log");
        menuItem2.addActionListener(e -> saveToLog());
        menu.add(menuItem2);

        // Menu item 3: Change background color
        JMenuItem menuItem3 = new JMenuItem("Change Background Color");
        menuItem3.addActionListener(e -> changeBackgroundColor());
        menu.add(menuItem3);

        // Menu item 4: Exit
        JMenuItem menuItem4 = new JMenuItem("Exit");
        menuItem4.addActionListener(e -> System.exit(0));
        menu.add(menuItem4);

        // Text area
        textArea = new JTextArea();
        textArea.setEditable(false);

        // Panel to change background color
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(panel);

        // Generate an initial random green shade
        Random random = new Random();
        int greenValue = random.nextInt(256);
        initialGreenShade = new Color(0, greenValue, 0);
    }

    private void showDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        textArea.setText("Current Date and Time: " + formatter.format(new Date()));
    }

    private void saveToLog() {
        try (FileWriter writer = new FileWriter("log.txt")) {
            writer.write(textArea.getText());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to write to file.");
        }
    }

    private void changeBackgroundColor() {
        panel.setBackground(initialGreenShade);
        textArea.setText("Background color changed to a green hue: RGB(0," + initialGreenShade.getGreen() + ",0)");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MenuExample ex = new MenuExample();
            ex.setVisible(true);
        });
    }
}
