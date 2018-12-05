
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Principal;

public class Servidor {

	JFrame ventana_chat = null;
	JButton btn_enviar = null;
	JTextField txt_mensaje = null;
	JTextArea area_chat = null;
	JPanel cont_areachat = null;
	JPanel cont_btntxt = null;
	JScrollPane scroll = null;
	ServerSocket servidor = null;
	Socket socket = null;
	BufferedReader lector = null;
	PrintWriter escritor = null;

	public Servidor() {
		hacerinterfaz();
	}

	public void hacerinterfaz() {
		ventana_chat = new JFrame("Servidor");
		btn_enviar = new JButton("Enviar");
		txt_mensaje = new JTextField(4);
		area_chat = new JTextArea(10, 12);
		scroll = new JScrollPane(area_chat);
		cont_areachat = new JPanel();
		cont_areachat.setLayout(new GridLayout(1, 1));
		cont_areachat.add(scroll);
		cont_btntxt = new JPanel();
		cont_btntxt.setLayout(new GridLayout(1, 2));
		cont_btntxt.add(txt_mensaje);
		cont_btntxt.add(btn_enviar);
		ventana_chat.setLayout(new BorderLayout());
		ventana_chat.add(cont_areachat, BorderLayout.NORTH);
		ventana_chat.add(cont_btntxt, BorderLayout.SOUTH);
		ventana_chat.setVisible(true);
		ventana_chat.setSize(300, 250);
		ventana_chat.setResizable(false);
		ventana_chat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Thread principal = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					servidor = new ServerSocket(9000);
					while(true) {
					socket = servidor.accept();
					leer();
					escribir();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		principal.start();

	}

	public void leer() {
		Thread leerhilos = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					// Leer lo que se envia en el socket
					lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					while (true) {
						String mensaje_recibido = lector.readLine();
						area_chat.append("Cliente Dice: " + mensaje_recibido);
					}

				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		});
		leerhilos.start();

	}

	public void escribir() {
		Thread escribirhilo = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					escritor = new PrintWriter(socket.getOutputStream(), true);
					btn_enviar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String enviarmensaje = txt_mensaje.getText();
							escritor.println(enviarmensaje);
						}
					});
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		escribirhilo.start();

	}

	public static void main(String[] args) {

		new Servidor();

	}

}
