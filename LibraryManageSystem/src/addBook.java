import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class addBook extends JFrame{
    private JTextField typeTextField;
    private JTextField bookNameTextField;
    private JTextField authorNameTextField;
    private JTextField isbnTextField;
    private JButton confirmButton;

    public addBook() {
        setTitle("图书入库");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2,1));
        Font font = new Font("默认",Font.PLAIN,20);

        JPanel panel1 = new JPanel(new GridLayout(4,2));
        typeTextField = new JTextField(20);
        typeTextField.setFont(font);
        JLabel label1 = new JLabel("类别:");
        label1.setFont(font);
        panel1.add(label1);
        panel1.add(typeTextField);

        bookNameTextField = new JTextField(20);
        bookNameTextField.setFont(font);
        JLabel label2 = new JLabel("书名:");
        label2.setFont(font);
        panel1.add(label2);
        panel1.add(bookNameTextField);

        authorNameTextField = new JTextField(20);
        authorNameTextField.setFont(font);
        JLabel label3 = new JLabel("作者:");
        label3.setFont(font);
        panel1.add(label3);
        panel1.add(authorNameTextField);

        isbnTextField = new JTextField(20);
        isbnTextField.setFont(font);
        JLabel label4 = new JLabel("ISBN:");
        label4.setFont(font);
        panel1.add(label4);
        panel1.add(isbnTextField);
        add(panel1);

        JPanel panel2 = new JPanel();
        confirmButton = new JButton("确认入库");
        confirmButton.setFont(font);
        panel2.add(confirmButton);
        add(panel2);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String type = typeTextField.getText();
                String bookName = bookNameTextField.getText();
                String authorName = authorNameTextField.getText();
                String isbn = isbnTextField.getText();
                String filePath = "bookFile";

                // 写入文件
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                    writer.write("\n"+type+" 《"+bookName + "》 " + authorName + " " + isbn );
                    JOptionPane.showMessageDialog(null, "图书已成功入库！");
                    typeTextField.setText("");
                    bookNameTextField.setText("");
                    authorNameTextField.setText("");
                    isbnTextField.setText("");

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "写入文件失败：" + ex.getMessage());
                }
            }
        });
        pack();
        setLocationRelativeTo(null);//设置窗口居中显示
        setVisible(true);
    }
}
