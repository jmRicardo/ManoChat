import javax.swing.*;

public class ChatWindow extends JFrame{
    private JTextArea textChat;
    private JPanel rootWindow;
    private JTextField textInput;
    private JButton ButtonSend;

    public ChatWindow(){

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        add(rootWindow);

        setSize(800,640);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("ManoChat");

        setVisible(true);
        textInput.requestFocus();


    }

}
