import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JPanel {
    // Параметри чотирикутника
    private double sideA, sideB, sideC, sideD;
    private double angleAB, angleBC, angleCD, angleDA;
    private String shapeType = "";
    private Color shapeColor = Color.BLUE;

    public Main() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 4, 10, 10));
        // Створюємо кнопки для вибору типу чотирикутника
        String[] shapes = {"Квадрат", "Прямокутник", "Ромб", "Паралелограм", "Трапеція", "Неправильний чотирикутник"};
        for (int i = 0; i < shapes.length; i++) {
            JButton button = new JButton(shapes[i]);
            final int choice = i + 1;  // Відповідний номер чотирикутника
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setQuadrilateralParameters(choice);
                    repaint(); // Перемальовуємо фігуру
                }
            });
            buttonPanel.add(button);
        }

        // Додаємо панель з кнопками на вікно
        add(buttonPanel, BorderLayout.NORTH);
    }

    private void setQuadrilateralParameters(int choice) {
        switch (choice) {
            case 1: // Квадрат
                sideA = sideB = sideC = sideD = 100;
                angleAB = angleBC = angleCD = angleDA = 90;
                shapeType = "Квадрат";
                shapeColor = Color.BLUE;
                break;
            case 2: // Прямокутник
                sideA = sideC = 150;
                sideB = sideD = 100;
                angleAB = angleBC = angleCD = angleDA = 90;
                shapeType = "Прямокутник";
                shapeColor = Color.RED;
                break;
            case 3: // Ромб
                sideA = sideB = sideC = sideD = 100;
                angleAB = angleCD = 60;
                angleBC = angleDA = 120;
                shapeType = "Ромб";
                shapeColor = Color.GREEN;
                break;
            case 4: // Паралелограм
                sideA = sideC = 150;
                sideB = sideD = 100;
                angleAB = angleCD = 60;
                angleBC = angleDA = 120;
                shapeType = "Паралелограм";
                shapeColor = Color.ORANGE;
                break;
            case 5: // Трапеція
                sideA = 150;
                sideB = 100;
                sideC = 80;
                sideD = 100;
                angleAB = 90;
                angleBC = 70;
                angleCD = 110;
                angleDA = 90;
                shapeType = "Трапеція";
                shapeColor = Color.MAGENTA;
                break;
            case 6: // Неправильний чотирикутник
                sideA = 130;
                sideB = 90;
                sideC = 110;
                sideD = 80;
                angleAB = 85;
                angleBC = 95;
                angleCD = 100;
                angleDA = 80;
                shapeType = "Неправильний чотирикутник";
                shapeColor = Color.PINK;
                break;
            default:
                shapeType = "Невідомий";
                shapeColor = Color.BLACK;
                break;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Малюємо осі координат
        g2d.setColor(Color.BLACK);
        g2d.drawLine(200, 100, 200, 400); // Вертикальна вісь
        g2d.drawLine(100, 200, 400, 200); // Горизонтальна вісь

        // Малюємо текст завдання
        g2d.drawString("Лабораторна робота №7: Графіка", 10, 20);
        g2d.drawString("Мета: придбання навичок креслення фігур та застосування кольорів.", 10, 40);
        g2d.drawString("Тип чотирикутника: " + shapeType, 10, 60);

        // Встановлюємо колір фігур
        g2d.setColor(shapeColor);

        // Малюємо чотирикутник
        int[] xPoints;
        int[] yPoints;

        switch (shapeType) {
            case "Квадрат":
                xPoints = new int[]{150, 250, 250, 150};
                yPoints = new int[]{150, 150, 250, 250};
                break;
            case "Прямокутник":
                xPoints = new int[]{125, 275, 275, 125};
                yPoints = new int[]{150, 150, 250, 250};
                break;
            case "Ромб":
                xPoints = new int[]{200, 250, 200, 150};
                yPoints = new int[]{150, 200, 250, 200};
                break;
            case "Паралелограм":
                xPoints = new int[]{125, 225, 275, 175};
                yPoints = new int[]{150, 150, 250, 250};
                break;
            case "Трапеція":
                xPoints = new int[]{150, 250, 230, 170};
                yPoints = new int[]{150, 150, 250, 250};
                break;
            case "Неправильний чотирикутник":
                xPoints = new int[]{150, 250, 230, 170};
                yPoints = new int[]{150, 130, 250, 230};
                break;
            default:
                xPoints = new int[]{};
                yPoints = new int[]{};
                break;
        }

        if (xPoints.length > 0 && yPoints.length > 0) {
            g2d.drawPolygon(xPoints, yPoints, 4);
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab 7: Графіка");

        Main panel = new Main();
        frame.add(panel);
        frame.setSize(1800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
