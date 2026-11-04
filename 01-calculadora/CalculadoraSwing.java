
import javax.swing.*;
import java.awt.*;

public class CalculadoraSwing extends JFrame {

    private JTextField campo1;
    private JTextField campo2;
    private JLabel resultado;

    public CalculadoraSwing() {

        setTitle("Calculadora Java");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(7, 1, 5, 5));

        campo1 = new JTextField();
        campo2 = new JTextField();

        resultado = new JLabel("Resultado: ", JLabel.CENTER);

        add(new JLabel("Primer número:", JLabel.CENTER));
        add(campo1);

        add(new JLabel("Segundo número:", JLabel.CENTER));
        add(campo2);

        JPanel botones = new JPanel(new GridLayout(1, 4, 5, 5));

        agregarBoton(botones, "+", "sumar");
        agregarBoton(botones, "-", "restar");
        agregarBoton(botones, "*", "multiplicar");
        agregarBoton(botones, "/", "dividir");

        add(botones);
        add(resultado);

        JButton limpiar = new JButton("Limpiar");

        limpiar.addActionListener(e -> {
            campo1.setText("");
            campo2.setText("");
            resultado.setText("Resultado:");
        });

        add(limpiar);

        setVisible(true);
    }

    private void agregarBoton(JPanel panel, String texto, String operacion) {

        JButton boton = new JButton(texto);

        boton.addActionListener(e -> calcular(operacion));

        panel.add(boton);
    }

    private void calcular(String operacion) {

        try {

            double num1 = Double.parseDouble(campo1.getText());
            double num2 = Double.parseDouble(campo2.getText());

            double total = 0;

            switch (operacion) {

                case "sumar":
                    total = num1 + num2;
                    break;

                case "restar":
                    total = num1 - num2;
                    break;

                case "multiplicar":
                    total = num1 * num2;
                    break;

                case "dividir":

                    if (num2 == 0) {
                        throw new ArithmeticException(
                            "No se puede dividir por cero."
                        );
                    }

                    total = num1 / num2;
                    break;
            }

            resultado.setText("Resultado: " + total);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                this,
                "Ingresa solamente números.",
                "Error de entrada",
                JOptionPane.ERROR_MESSAGE
            );

        } catch (ArithmeticException e) {

            JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                "Error matemático",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new CalculadoraSwing();
        });
    }
}

