import javax.swing.*;

public class DialerExample {
    private static final String VALID_NUMBER = "998001111";

    private JTextField display;
    private JLabel correspondenceLabel;
    private JPanel keypadPanel;;
    private JButton ligarButton;
    private String mode = "Ligar";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DialerExample().createAndShowGui());
    }

    public void createAndShowGui() {
        JFrame frame = new JFrame("Dah");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(360, 560);
        frame.setLocationRelativeTo(null);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        content.add(createTopPanel());
        content.add(Box.createVerticalStrut(10));
        content.add(createCenterPanel());
        content.add(Box.createVerticalStrut(10));
        content.add(createBottomPanel());

        frame.setContentPane(content);
        frame.setVisible(true);

        updateMode("Ligar");
    }

    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        topPanel.setBackground(new javax.swing.plaf.ColorUIResource(0, 0, 0));

        JPanel togglePanel = new JPanel();
        togglePanel.setLayout(new BoxLayout(togglePanel, BoxLayout.X_AXIS));
        togglePanel.setOpaque(false);

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new javax.swing.plaf.FontUIResource("01", javax.swing.plaf.FontUIResource.BOLD, 36));
        display.setForeground(new javax.swing.plaf.ColorUIResource(255, 165, 0));
        display.setBackground(new javax.swing.plaf.ColorUIResource(40, 40, 40));
        display.setHorizontalAlignment(JTextField.CENTER);
        display.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        display.setMaximumSize(new javax.swing.plaf.DimensionUIResource(Short.MAX_VALUE, 80));
        display.setAlignmentX(0.5f);

        correspondenceLabel = new JLabel(" ");
        correspondenceLabel.setFont(new javax.swing.plaf.FontUIResource("01", javax.swing.plaf.FontUIResource.PLAIN, 14));
        correspondenceLabel.setForeground(new javax.swing.plaf.ColorUIResource(255, 165, 0));
        correspondenceLabel.setAlignmentX(0.5f);
        correspondenceLabel.setVisible(false);

        topPanel.add(togglePanel);
        topPanel.add(Box.createVerticalStrut(10));
        topPanel.add(display);
        topPanel.add(Box.createVerticalStrut(6));
        topPanel.add(correspondenceLabel);

        return topPanel;
    }

    private JPanel createCenterPanel() {
        keypadPanel = new JPanel();
        keypadPanel.setLayout(new BoxLayout(keypadPanel, BoxLayout.Y_AXIS));
        keypadPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        keypadPanel.setBackground(new javax.swing.plaf.ColorUIResource(0, 0, 0));

        String[] keys = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#"};
        for (int row = 0; row < 4; row++) {
            JPanel rowPanel = new JPanel();
            rowPanel.setLayout(new BoxLayout(rowPanel, BoxLayout.X_AXIS));
            rowPanel.setOpaque(false);
            for (int col = 0; col < 3; col++) {
                int index = row * 3 + col;
                if (index < keys.length) {
                    rowPanel.add(createKeyButton(keys[index]));
                }
                if (col < 2) {
                    rowPanel.add(Box.createHorizontalStrut(10));
                }
            }
            keypadPanel.add(rowPanel);
            if (row < 3) {
                keypadPanel.add(Box.createVerticalStrut(10));
            }
        }

        return keypadPanel;
    }

    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottomPanel.setBackground(new javax.swing.plaf.ColorUIResource(0, 0, 0));

        JButton callButton = new JButton("Ligar");
        callButton.setOpaque(true);
        callButton.setBackground(new javax.swing.plaf.ColorUIResource(0, 0, 0));
        callButton.setForeground(new javax.swing.plaf.ColorUIResource(0, 0, 0));
        callButton.setFont(new javax.swing.plaf.FontUIResource("SansSerif", javax.swing.plaf.FontUIResource.BOLD, 18));
        callButton.addActionListener(e -> performCall());

        JButton deleteButton = new JButton("Apagar");
        deleteButton.setOpaque(true);
        deleteButton.setBackground(new javax.swing.plaf.ColorUIResource(0, 0, 0));
        deleteButton.setForeground(new javax.swing.plaf.ColorUIResource(0, 0, 0));
        deleteButton.setFont(new javax.swing.plaf.FontUIResource("SansSerif", javax.swing.plaf.FontUIResource.BOLD, 18));
        deleteButton.addActionListener(e -> deleteLastCharacter());

        bottomPanel.add(callButton);
        bottomPanel.add(Box.createHorizontalStrut(10));
        bottomPanel.add(deleteButton);

        return bottomPanel;
    }

   
    private JButton createKeyButton(String label) {
        JButton button = new JButton(label);
        button.setOpaque(true);
        button.setFocusPainted(false);
        button.setFont(new javax.swing.plaf.FontUIResource("01", javax.swing.plaf.FontUIResource.BOLD, 24));
        button.setBackground(new javax.swing.plaf.ColorUIResource(0, 0, 0));
        button.setForeground(new javax.swing.plaf.ColorUIResource(0, 0, 0));
        button.setMaximumSize(new javax.swing.plaf.DimensionUIResource(80, 80));
        button.addActionListener(e -> appendDigit(label));
        return button;
    }

    private void updateMode(String newMode) {
        mode = newMode;
        boolean ligarSelected = "Ligar".equals(newMode);
        keypadPanel.setVisible(ligarSelected);
   
        ligarButton.setBackground(ligarSelected
                ? new javax.swing.plaf.ColorUIResource(255, 165, 0)
                : new javax.swing.plaf.ColorUIResource(66, 66, 66));
        updateCorrespondence();
        keypadPanel.revalidate();
        keypadPanel.repaint();
    }

    private void appendDigit(String digit) {
        if (!"Ligar".equals(mode)) {
            return;
        }
        display.setText(display.getText() + digit);
        updateCorrespondence();
    }

    private void deleteLastCharacter() {
        if (!"Ligar".equals(mode)) {
            return;
        }
        String text = display.getText();
        if (!text.isEmpty()) {
            display.setText(text.substring(0, text.length() - 1));
            updateCorrespondence();
        }
    }

    private void updateCorrespondence() {
        String text = display.getText();
        if ("Ligar".equals(mode) && VALID_NUMBER.equals(text)) {
            correspondenceLabel.setText("correspondencia");
            correspondenceLabel.setVisible(true);
        } else {
            correspondenceLabel.setText(" ");
            correspondenceLabel.setVisible(false);
        }
    }

    private void performCall() {
        if (!"Ligar".equals(mode)) {
            JOptionPane.showMessageDialog(null,
                    "Vá para a aba ligar para discar.",
                    "Erro",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        String text = display.getText();
        String message = VALID_NUMBER.equals(text)
                ? "Ligação Feita Com Sucesso"
                : "Ligação Feita. Ninguém atendeu";

        JOptionPane.showMessageDialog(null,
                message,
                "Chamada",
                JOptionPane.INFORMATION_MESSAGE);
    }
}