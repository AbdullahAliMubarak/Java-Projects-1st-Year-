/*Program to use the shape classes creted to make a shape maker gui for the user
*Abdullah Ali Mubarak
*Almabd030
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeMaker{
   public static void main(String[] args){
   
      // Creating the frame
      JFrame frame = new JFrame("Shape Maker");
      frame.setSize(500, 500);
      frame.setResizable(false); // size of frame cannot be changed
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // using the x icon exits the program
      frame.setLayout(new GridLayout(3, 1)); // Dividing the frame into 3 equal parts
      
      //---------------------------------------------------------------------------------------------------  
      // Create panel for the intro text (first part)
      JPanel introPanel = new JPanel(new GridBagLayout()); // Use GridBagLayout for centering
      introPanel.setBackground(new Color(0x15B392));
      
      // Using JTextArea for the intro text to allow wrapping, set width for better text spread
      JTextArea introText = new JTextArea("Welcome to the shape maker! "
              + "Choose which shape you would like to create by selecting from the dropdown menu. Then click on confirm.");
      introText.setFont(new Font("Kristen ITC", Font.BOLD, 16));
      introText.setLineWrap(true); // Enable text wrapping
      introText.setWrapStyleWord(true); // Wrap at word boundaries
      introText.setEditable(false); // Make it non-editable
      introText.setOpaque(false); // Make the background transparent
      introText.setPreferredSize(new Dimension(450, 100)); // Set preferred size to spread text

      // GridBagConstraints for centering the intro text
      GridBagConstraints gbcIntro = new GridBagConstraints();
      gbcIntro.gridx = 0;
      gbcIntro.gridy = 0;
      gbcIntro.weightx = 1;
      gbcIntro.weighty = 1; // Allow vertical centering
      gbcIntro.anchor = GridBagConstraints.CENTER; // Center both vertically and horizontally
        
      introPanel.add(introText, gbcIntro);
      
      //---------------------------------------------------------------------------------------------------  
      
      // Create panel for the shape selection dropdown (second part)
      JPanel selectionPanel = new JPanel(new GridBagLayout()); // Using GridBagLayout for vertical and horizontal centering
      selectionPanel.setBackground(new Color(0x54C392)); 
      GridBagConstraints gbcSelection = new GridBagConstraints();
      gbcSelection.gridx = 0;
      gbcSelection.gridy = 0;
      gbcSelection.anchor = GridBagConstraints.CENTER; // Center both vertically and horizontally
      
      String[] shapes = { "Circle", "Rectangle", "Triangle" };
      JComboBox shapeDropdown = new JComboBox(shapes);
      // Set the font for the JComboBox
      shapeDropdown.setFont(new Font("Kristen ITC", Font.BOLD, 14));
      // Set size of the JComboBox
      shapeDropdown.setPreferredSize(new Dimension(150, 50)); // Dropdown size
      selectionPanel.add(shapeDropdown, gbcSelection);
      
      //---------------------------------------------------------------------------------------------------  
      
      // Create panel for the confirm button (third part)
      JPanel confirmPanel = new JPanel(new GridBagLayout()); // Using GridBagLayout for centering
      confirmPanel.setBackground(Color.GREEN); // Change background to green
      JButton confirmButton = new JButton("CONFIRM");
      // Change the font of the button
      confirmButton.setFont(new Font("Kristen ITC", Font.BOLD, 16));
      
      GridBagConstraints gbcConfirm = new GridBagConstraints();
      gbcConfirm.gridx = 0;
      gbcConfirm.gridy = 0;
      gbcConfirm.anchor = GridBagConstraints.CENTER; // Center both vertically and horizontally
        
      confirmPanel.add(confirmButton, gbcConfirm);
      
      //confirm button opens new window
      // Action listener for the confirm button
      confirmButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          String selectedShape = (String) shapeDropdown.getSelectedItem();
          if ("Circle".equals(selectedShape)) {
              // Open a new window for Circle inputs
              createCircleWindow();
          } else if ("Rectangle".equals(selectedShape)) {
              // Open a new window for Rectangle inputs
              createRectangleWindow();
          } else if ("Triangle".equals(selectedShape)) {
              // Open a new window for Rectangle inputs
              createTriangleWindow();
          }
          }
      });

      //---------------------------------------------------------------------------------------------------  
      
      // Add panels to the frame
      frame.add(introPanel);    // First part: Intro text
      frame.add(selectionPanel); // Second part: Dropdown
      frame.add(confirmPanel);   // Third part: Confirm button
        
      // Make the frame visible
      frame.setVisible(true);
   }
   //------------------------------------------------------------------------------------------------------
   
    // Method to create a new window for Circle inputs
    private static void createCircleWindow() {
        JFrame circleFrame = new JFrame("Circle");
        circleFrame.setSize(500, 500);
        circleFrame.setResizable(false);
        circleFrame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding

        // Add label and textbox for radius
        JLabel radiusLabel = new JLabel("Radius:");
        JTextField radiusField = new JTextField(10);
        circleFrame.add(radiusLabel, gbc);
        
        gbc.gridx = 1;
        circleFrame.add(radiusField, gbc);

        // Add radio button for "filled"
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel filledLabel = new JLabel("Filled:");
        JRadioButton filledRadio = new JRadioButton();
        circleFrame.add(filledLabel, gbc);
        
        gbc.gridx = 1;
        circleFrame.add(filledRadio, gbc);

        // Add dropdown for color selection
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel colorLabel = new JLabel("Color:");
        String[] colors = {"Red", "Blue", "Green", "Black"};
        JComboBox<String> colorDropdown = new JComboBox<>(colors);
        circleFrame.add(colorLabel, gbc);

        gbc.gridx = 1;
        circleFrame.add(colorDropdown, gbc);

        // Add create button
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        JButton createButton = new JButton("Create Circle");
        circleFrame.add(createButton, gbc);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Parse radius
                double radius = Double.parseDouble(radiusField.getText());
                // Check if filled
                boolean filled = filledRadio.isSelected();
                // Get selected color
                String color = (String) colorDropdown.getSelectedItem();

                // Create a Circle object using the radius, filled, and color
                Circle circle = new Circle(radius, color, filled);

                // Open a new window to draw the circle
                drawCircleWindow(circle);
            }
        });

        circleFrame.setVisible(true);
    }
    //--------------------------------------------------------------------------------------------------
    
    
    // Method to open a new window and draw the circle
    private static void drawCircleWindow(Circle circle) {
        JFrame drawFrame = new JFrame("Draw Circle");
        drawFrame.setSize(1000, 1000);
        drawFrame.setResizable(true);
        drawFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel drawPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Set color
                switch (circle.getColor()) {
                    case "Red": g2d.setColor(Color.RED); break;
                    case "Blue": g2d.setColor(Color.BLUE); break;
                    case "Green": g2d.setColor(Color.GREEN); break;
                    case "Black": g2d.setColor(Color.BLACK); break;
                }

                // Draw filled or unfilled circle
                int diameter = (int) (circle.getRadius() * 2);
                int x = (getWidth() - diameter) / 2;
                int y = (getHeight() - diameter) / 2;
                if (circle.isFilled()) {
                    g2d.fillOval(x, y, diameter, diameter);
                } else {
                    g2d.drawOval(x, y, diameter, diameter);
                }

                // Display area
                g2d.setColor(Color.BLACK);
                g2d.setFont(new Font("Arial", Font.BOLD, 16));
                String areaText = String.format("Area: %.2f units²", circle.getArea());
                int textWidth = g2d.getFontMetrics().stringWidth(areaText);
                g2d.drawString(areaText, (getWidth() - textWidth) / 2, y - 20);
            }
        };

        drawFrame.add(drawPanel);
        drawFrame.setVisible(true);
    }
    
    //------------------------------------------------------------------------------------------------

    // Method to create a new window for Rectangle inputs
    private static void createRectangleWindow() {
        JFrame rectangleFrame = new JFrame("Rectangle");
        rectangleFrame.setSize(500, 500);
        rectangleFrame.setResizable(false);
        rectangleFrame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding

        // Add label and textbox for width
        JLabel widthLabel = new JLabel("Width:");
        JTextField widthField = new JTextField(10);
        rectangleFrame.add(widthLabel, gbc);
        
        gbc.gridx = 1;
        rectangleFrame.add(widthField, gbc);

        // Add label and textbox for height
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel heightLabel = new JLabel("Height:");
        JTextField heightField = new JTextField(10);
        rectangleFrame.add(heightLabel, gbc);
        
        gbc.gridx = 1;
        rectangleFrame.add(heightField, gbc);

        // Add radio button for "filled"
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel filledLabel = new JLabel("Filled:");
        JRadioButton filledRadio = new JRadioButton();
        rectangleFrame.add(filledLabel, gbc);
        
        gbc.gridx = 1;
        rectangleFrame.add(filledRadio, gbc);

        // Add dropdown for color selection
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel colorLabel = new JLabel("Color:");
        String[] colors = {"Red", "Blue", "Green", "Black"};
        JComboBox<String> colorDropdown = new JComboBox<>(colors);
        rectangleFrame.add(colorLabel, gbc);

        gbc.gridx = 1;
        rectangleFrame.add(colorDropdown, gbc);

        // Add create button
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JButton createButton = new JButton("Create Rectangle");
        rectangleFrame.add(createButton, gbc);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Parse width and height
                double width = Double.parseDouble(widthField.getText());
                double height = Double.parseDouble(heightField.getText());
                // Check if filled
                boolean filled = filledRadio.isSelected();
                // Get selected color
                String color = (String) colorDropdown.getSelectedItem();

                // Create a Rectangle object
                Rectangle rectangle = new Rectangle(width, height, color, filled);

                // Open a new window to draw the rectangle
                drawRectangleWindow(rectangle);
            }
        });

        rectangleFrame.setVisible(true);
    }
    
    //------------------------------------------------------------------------------------------------

    // Method to open a new window and draw the rectangle
    private static void drawRectangleWindow(Rectangle rectangle) {
        JFrame drawFrame = new JFrame("Draw Rectangle");
        drawFrame.setSize(1000, 1000);
        drawFrame.setResizable(true);
        drawFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel drawPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Set color
                switch (rectangle.getColor()) {
                    case "Red": g2d.setColor(Color.RED); break;
                    case "Blue": g2d.setColor(Color.BLUE); break;
                    case "Green": g2d.setColor(Color.GREEN); break;
                    case "Black": g2d.setColor(Color.BLACK); break;
                }

                // Draw filled or unfilled rectangle
                int width = (int) rectangle.getWidth();
                int height = (int) rectangle.getHeight();
                int x = (getWidth() - width) / 2;
                int y = (getHeight() - height) / 2;
                if (rectangle.isFilled()) {
                    g2d.fillRect(x, y, width, height);
                } else {
                    g2d.drawRect(x, y, width, height);
                }

                // Display area
                g2d.setColor(Color.BLACK);
                g2d.setFont(new Font("Arial", Font.BOLD, 16));
                String areaText = String.format("Area: %.2f units²", rectangle.getArea());
                int textWidth = g2d.getFontMetrics().stringWidth(areaText);
                g2d.drawString(areaText, (getWidth() - textWidth) / 2, y - 20);
            }
        };

        drawFrame.add(drawPanel);
        drawFrame.setVisible(true);
    }
    
    //------------------------------------------------------------------------------------------------
    
    // Method to create a new window for Triangle inputs
    private static void createTriangleWindow() {
        JFrame triangleFrame = new JFrame("Triangle");
        triangleFrame.setSize(500, 500);
        triangleFrame.setResizable(false);
        triangleFrame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding

        // Add label and textbox for side1
        JLabel side1Label = new JLabel("Side 1:");
        JTextField side1Field = new JTextField(10);
        triangleFrame.add(side1Label, gbc);
        
        gbc.gridx = 1;
        triangleFrame.add(side1Field, gbc);

        // Add label and textbox for side2
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel side2Label = new JLabel("Side 2:");
        JTextField side2Field = new JTextField(10);
        triangleFrame.add(side2Label, gbc);
        
        gbc.gridx = 1;
        triangleFrame.add(side2Field, gbc);

        // Add label and textbox for side3
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel side3Label = new JLabel("Side 3:");
        JTextField side3Field = new JTextField(10);
        triangleFrame.add(side3Label, gbc);
        
        gbc.gridx = 1;
        triangleFrame.add(side3Field, gbc);

        // Add radio button for "filled"
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel filledLabel = new JLabel("Filled:");
        JRadioButton filledRadio = new JRadioButton();
        triangleFrame.add(filledLabel, gbc);
        
        gbc.gridx = 1;
        triangleFrame.add(filledRadio, gbc);

        // Add dropdown for color selection
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel colorLabel = new JLabel("Color:");
        String[] colors = {"Red", "Blue", "Green", "Black"};
        JComboBox<String> colorDropdown = new JComboBox<>(colors);
        triangleFrame.add(colorLabel, gbc);

        gbc.gridx = 1;
        triangleFrame.add(colorDropdown, gbc);

        // Add create button
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        JButton createButton = new JButton("Create Triangle");
        triangleFrame.add(createButton, gbc);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Parse side lengths
                double side1 = Double.parseDouble(side1Field.getText());
                double side2 = Double.parseDouble(side2Field.getText());
                double side3 = Double.parseDouble(side3Field.getText());
                // Check if filled
                boolean filled = filledRadio.isSelected();
                // Get selected color
                String color = (String) colorDropdown.getSelectedItem();

                // Create a Triangle object
                Triangle triangle = new Triangle(side1, side2, side3, color, filled);

                // Open a new window to draw the triangle
                drawTriangleWindow(triangle);
            }
        });

        triangleFrame.setVisible(true);
    }
    
    //------------------------------------------------------------------------------------------------

    // Method to open a new window and draw the triangle
    private static void drawTriangleWindow(Triangle triangle) {
        JFrame drawFrame = new JFrame("Draw Triangle");
        drawFrame.setSize(1000, 1000);
        drawFrame.setResizable(true);
        drawFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel drawPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Set color
                switch (triangle.getColor()) {
                    case "Red": g2d.setColor(Color.RED); break;
                    case "Blue": g2d.setColor(Color.BLUE); break;
                    case "Green": g2d.setColor(Color.GREEN); break;
                    case "Black": g2d.setColor(Color.BLACK); break;
                }

                // Calculate the coordinates of the triangle
                double a = triangle.getSide1();
                double b = triangle.getSide2();
                double c = triangle.getSide3();

                // Calculate the angle opposite to side c using the law of cosines
                double angleC = Math.acos((a*a + b*b - c*c) / (2*a*b));

                // Calculate the coordinates
                int[] xPoints = new int[3];
                int[] yPoints = new int[3];

                // Scale factor to make the triangle visible
                double scale = Math.min(getWidth(), getHeight()) / (Math.max(a, Math.max(b, c)) * 2);

                // Calculate the center of the triangle
                double centerX = (a + b * Math.cos(angleC)) / 3;
                double centerY = (b * Math.sin(angleC)) / 3;

                // Translate all points so that the center of the triangle is at the center of the panel
                xPoints[0] = getWidth() / 2 - (int)((centerX - 0) * scale);
                yPoints[0] = getHeight() / 2 + (int)((centerY - 0) * scale);

                xPoints[1] = getWidth() / 2 - (int)((centerX - a) * scale);
                yPoints[1] = getHeight() / 2 + (int)((centerY - 0) * scale);

                xPoints[2] = getWidth() / 2 - (int)((centerX - b * Math.cos(angleC)) * scale);
                yPoints[2] = getHeight() / 2 + (int)((centerY - b * Math.sin(angleC)) * scale);

                // Draw filled or unfilled triangle
                if (triangle.isFilled()) {
                    g2d.fillPolygon(xPoints, yPoints, 3);
                } else {
                    g2d.drawPolygon(xPoints, yPoints, 3);
                }

                // Display area
                g2d.setColor(Color.BLACK);
                g2d.setFont(new Font("Arial", Font.BOLD, 16));
                String areaText = String.format("Area: %.2f units²", triangle.getArea());
                int textWidth = g2d.getFontMetrics().stringWidth(areaText);
                g2d.drawString(areaText, (getWidth() - textWidth) / 2, Math.min(yPoints[0], Math.min(yPoints[1], yPoints[2])) - 20);
            }
        };

        drawFrame.add(drawPanel);
        drawFrame.setVisible(true);
    }
}
