/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author danil
 */
public class ChatFrame extends chatAsesor {

    private JTextArea txtAreaChat;
    private JTextField txtMensaje;
    private JButton btnEnviar;

    public ChatFrame() {
        setTitle("Chat con Asesor");
        setSize(400, 500);
        setLocationRelativeTo(null); // Centrar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Área de chat
        txtAreaChat = new JTextArea();
        txtAreaChat.setEditable(false);
        txtAreaChat.setLineWrap(true);
        txtAreaChat.setWrapStyleWord(true);
        txtAreaChat.setFont(new Font("Monserrat", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(txtAreaChat);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Panel inferior con campo y botón
        JPanel panelInferior = new JPanel(new BorderLayout(5, 5));
        txtMensaje = new JTextField();
        btnEnviar = new JButton("Enviar");

        panelInferior.add(txtMensaje, BorderLayout.CENTER);
        panelInferior.add(btnEnviar, BorderLayout.EAST);
        panel.add(panelInferior, BorderLayout.SOUTH);

        // Agregar panel a la ventana
        add(panel);

        // Acción al enviar mensaje
        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enviarMensaje();
            }
        });

        // Enviar al presionar ENTER
        txtMensaje.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enviarMensaje();
            }
        });
    }

    // Método para manejar el envío de mensajes
    private void enviarMensaje() {
        String mensaje = txtMensaje.getText().trim();
        if (!mensaje.isEmpty()) {
            txtAreaChat.append("Tú: " + mensaje + "\n");
            txtMensaje.setText("");

            // Respuesta simulada del bot
            txtAreaChat.append("Bot: Bienvenido al soporte técnoco de SelfMove\n");
        }
    }

    // Método main para ejecutar la app
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChatFrame chat = new ChatFrame();
            chat.setVisible(true);
        });
    }
}

