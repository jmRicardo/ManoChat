import javax.swing.*;

public class Login extends JFrame{
    private JPanel login;
    private JTextField textName;
    private JTextField textIp;
    private JTextField textPort;
    private JLabel labelName;
    private JLabel LabelPort;
    private JLabel labelIP;
    private JLabel LabelExample1;

    public Login() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        add(login);

        setResizable(false);
        setSize(300,380);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("ManoChat");

        setVisible(true);
    }
}
