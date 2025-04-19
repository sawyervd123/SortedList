import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortedListGUI extends JFrame {
    private final SortedList sortedList;
    private final JTextField inputField;
    private final JTextArea displayArea;

    public SortedListGUI() {
        sortedList = new SortedList();

        setTitle("Sorted List GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        inputField = new JTextField(15);
        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");

        topPanel.add(new JLabel("Enter String:"));
        topPanel.add(inputField);
        topPanel.add(addButton);
        topPanel.add(searchButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText().trim();
                if (!input.isEmpty()) {
                    sortedList.add(input);
                    inputField.setText("");
                    updateDisplay("Added: " + input);
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText().trim();
                if (!input.isEmpty()) {
                    int result = sortedList.search(input);
                    if (result >= 0) {
                        updateDisplay("Found '" + input + "' at index: " + result);
                    } else {
                        int insertPos = -result - 1;
                        updateDisplay("Not found. '" + input + "' would be at index: " + insertPos);
                    }
                }
            }
        });
    }

    private void updateDisplay(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(message).append("\nCurrent List: ").append(sortedList.getList()).append("\n\n");
        displayArea.append(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SortedListGUI().setVisible(true);
        });
    }
}