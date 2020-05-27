package Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JPanel rootWindow;
    private JTextField textName;
    private JTextField textIp;
    private JTextField textPort;
    private JLabel labelName;
    private JLabel LabelPort;
    private JLabel labelIP;
    private JLabel LabelExample1;
    private JButton ButtonEnter;

    public Login() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        add(rootWindow);
        setResizable(false);
        setSize(300,380);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("ManoChat");
        setLocationRelativeTo(null);
        setVisible(true);




        ButtonEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String name = textName.getText();
                    String address = textIp.getText();
                    int port = Integer.parseInt(textPort.getText());
                    if (!name.isEmpty() || !address.isEmpty() || checkPort(port))
                    {
                        dispose();
                        new ChatWindow(name,address,port);
                    }
                }catch(NumberFormatException e)
                {
                    System.out.println("Numero de puerto erroneo o fuera de los limites");
                }

            }
        });
    }

    private boolean checkPort(int port)
    {
        return port > 0 && port < 10000;
    }
}
