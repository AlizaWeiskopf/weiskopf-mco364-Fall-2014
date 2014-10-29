package weiskopf.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatBox extends JFrame {

	private JTextArea chatHistory;
	private JTextField chatText;
	private JButton button;
	private ChatClient client;
	private JScrollPane scrollBar;

	public ChatBox() {
		setSize(500, 600);
		setLocationRelativeTo(null);
		setTitle("Chat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		chatHistory = new JTextArea();
		chatHistory.setEditable(false);

		chatText = new JTextField(500);
		chatText.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String chat = chatText.getText();
				chatHistory.setForeground(Color.BLACK);
				chatHistory.append("\n" + chat);
				try {
					new ChatClient();
				} catch (IOException ex) {

					ex.printStackTrace();
				}

				chatText.setText("");

			}

		});

		add(chatHistory, BorderLayout.CENTER);
		add(chatText, BorderLayout.SOUTH);

		// ChatServer server = new ChatServer(this);
		// server.start();
	}

	public String getChatHistoryText() {
		return chatHistory.getText();
	}

	public void addClientText(String text) {
		chatHistory.setForeground(Color.RED);
		chatHistory.append("\n" + text);
	}

	public Socket getClientSocket() {
		return client.getSocket();
	}

}
