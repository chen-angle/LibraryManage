import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class enrollView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    public enrollView()  {
        setTitle("GXNU图书馆");
        setSize(500, 400);
        background();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
        Font font = new Font("默认",Font.PLAIN,20);

        JPanel panel1 = new JPanel();
        panel1.setOpaque(false);
        JLabel usernameLabel = new JLabel("用户名:");
        usernameLabel.setFont(font);
        usernameField = new JTextField(20);
        usernameField.setFont(font);
        panel1.add(usernameLabel);
        panel1.add(usernameField);

        JPanel panel2 = new JPanel();
        panel2.setOpaque(false);
        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setFont(font);
        passwordField = new JPasswordField(20);
        passwordField.setFont(font);
        panel2.add(passwordLabel);
        panel2.add(passwordField);
        add(panel1);
        add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setOpaque(false);
        loginButton = new JButton("登录");
        panel3.add(loginButton);
        loginButton.setFont(font);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if ("manager".equals(username) && "123".equals(password)) {
                    JOptionPane.showMessageDialog(enrollView.this, "登录成功！您是管理员");
                    new managerView(); // 跳转到管理员界面的代码
                } else if ("user".equals(username) && "456".equals(password)) {
                    JOptionPane.showMessageDialog(enrollView.this, "登录成功！您是普通用户");
                   new commonView(); // 跳转到普通用户界面的代码
                } else {
                    JOptionPane.showMessageDialog(enrollView.this, "用户名或密码错误！");
                }
            }
        });
        add(panel3);
        pack();
        setLocationRelativeTo(null);//设置窗口居中显示
        setVisible(true);
    }

    public void background(){
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("1.jpg"); //添加图片
        JLabel background = new  JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }
}


