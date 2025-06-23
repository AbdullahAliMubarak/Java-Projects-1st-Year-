/* Student ID: MNDSIB016
 * Name: Sibahle Ntando
 * Surname: Mndebele
 * 28 September 2024
 * A GUI that allows the user to draw digital shapes (Circle, Rectangle or Triangle)... still to be updated
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShapeMaker extends JFrame {
    // All of our instance variables
    private JComboBox<String> shapeSelector;
    private JTextField dimensionField1, dimensionField2, dimensionField3;
    private JCheckBox fillCheckBox;
    private JComboBox<String> colorSelector;
    private JButton drawButton;
    private JPanel drawingPanel;
    private JLabel infoLabel;

    // Constructor (The usual)
    public ShapeMaker() {
        super("Shape Maker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        layoutComponents();
        addListeners();
        pack();
        setVisible(true);
    }

    // initialization for dropdown buttons UwU
    private void initComponents() {
        shapeSelector = new JComboBox<>(new String[]{"Circle", "Rectangle", "Triangle"});
        dimensionField1 = new JTextField(5);
        dimensionField2 = new JTextField(5);
        dimensionField3 = new JTextField(5);
        fillCheckBox = new JCheckBox("Fill");
        colorSelector = new JComboBox<>(new String[]{"Black", "Red", "Blue", "Green"});
        drawButton = new JButton("Draw");
        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawShape(g);
            }
        };
        drawingPanel.setPreferredSize(new Dimension(400, 400));
        infoLabel = new JLabel("Shape Info");
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0;
        controlPanel.add(new JLabel("Shape:"), gbc);
        gbc.gridx = 1;
        controlPanel.add(shapeSelector, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        controlPanel.add(new JLabel("Dimensions:"), gbc);
        gbc.gridx = 1;
        JPanel dimensionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dimensionPanel.add(dimensionField1);
        dimensionPanel.add(dimensionField2);
        dimensionPanel.add(dimensionField3);
        controlPanel.add(dimensionPanel, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        controlPanel.add(new JLabel("Color:"), gbc);
        gbc.gridx = 1;
        controlPanel.add(colorSelector, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        controlPanel.add(fillCheckBox, gbc);

        gbc.gridx = 1; gbc.gridy = 4;
        controlPanel.add(drawButton, gbc);

        add(controlPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);
        add(infoLabel, BorderLayout.SOUTH);
    }

    private void addListeners() {
        drawButton.addActionListener(e -> drawingPanel.repaint());
        shapeSelector.addActionListener(e -> updateDimensionFields());
    }

    private void drawShape(Graphics g) {
        String selectedShape = (String) shapeSelector.getSelectedItem();
        Color selectedColor = getSelectedColor();
        boolean isFilled = fillCheckBox.isSelected();

        g.setColor(selectedColor);

        int x = 50;
        int y = 50;

        switch (selectedShape) {
            case "Circle":
                int radius = Integer.parseInt(dimensionField1.getText());
                if (isFilled) {
                    g.fillOval(x, y, radius * 2, radius * 2);
                } else {
                    g.drawOval(x, y, radius * 2, radius * 2);
                }
                updateInfoLabel("Circle", Math.PI * radius * radius, 2 * Math.PI * radius);
                break;
            case "Rectangle":
                int width = Integer.parseInt(dimensionField1.getText());
                int height = Integer.parseInt(dimensionField2.getText());
                if (isFilled) {
                    g.fillRect(x, y, width, height);
                } else {
                    g.drawRect(x, y, width, height);
                }
                updateInfoLabel("Rectangle", width * height, 2 * (width + height));
                break;
            case "Triangle":
                int side1 = Integer.parseInt(dimensionField1.getText());
                int side2 = Integer.parseInt(dimensionField2.getText());
                int side3 = Integer.parseInt(dimensionField3.getText());
                int[] xPoints = {x, x + side1, x + side2};
                int[] yPoints = {y + side3, y, y + side3};
                if (isFilled) {
                    g.fillPolygon(xPoints, yPoints, 3);
                } else {
                    g.drawPolygon(xPoints, yPoints, 3);
                }
                double s = (side1 + side2 + side3) / 2.0;
                double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
                updateInfoLabel("Triangle", area, side1 + side2 + side3);
                break;
        }
    }

    private void updateInfoLabel(String shapeName, double area, double perimeter) {
        infoLabel.setText(String.format("%s - Area: %.2f, Perimeter: %.2f", shapeName, area, perimeter));
    }

    private Color getSelectedColor() {
        switch ((String) colorSelector.getSelectedItem()) {
            case "Red": return Color.RED;
            case "Blue": return Color.BLUE;
            case "Green": return Color.GREEN;
            default: return Color.BLACK;
        }
    }

    private void updateDimensionFields() {
        String selectedShape = (String) shapeSelector.getSelectedItem();
        dimensionField1.setVisible(true);
        dimensionField2.setVisible(selectedShape.equals("Rectangle") || selectedShape.equals("Triangle"));
        dimensionField3.setVisible(selectedShape.equals("Triangle"));

        dimensionField1.setText("");
        dimensionField2.setText("");
        dimensionField3.setText("");

        switch (selectedShape) {
            case "Circle":
                dimensionField1.setToolTipText("Radius");
                break;
            case "Rectangle":
                dimensionField1.setToolTipText("Width");
                dimensionField2.setToolTipText("Height");
                break;
            case "Triangle":
                dimensionField1.setToolTipText("Side 1");
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ShapeMaker::new);
    }
}
