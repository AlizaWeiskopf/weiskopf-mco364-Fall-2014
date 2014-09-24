package weiskopf.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatWindow extends JFrame {

	private JTextArea chatHistory;
	private JTextField chatText;

	public ChatWindow() throws IOException {
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
					new ChatClient(chat);
				} catch (IOException ex) {

					ex.printStackTrace();
				}

				chatText.setText("");

			}
			

		});

		add(chatHistory, BorderLayout.CENTER);
		add(chatText, BorderLayout.SOUTH);

		ChatServer server = new ChatServer(this);
		server.start();
	}

	public String getChatHistoryText() {
		return chatHistory.getText();
	}

	public void setChatHistoryText(String text) {
		chatHistory.setForeground(Color.RED);
		chatHistory.append("\n" + text);
	}

	public static void main(String[] args) throws IOException {
		ChatWindow window = new ChatWindow();
		window.setVisible(true);
	}

}
