import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class borrowBook extends JFrame {
    private JTextField bookNameTextField;
    private JButton searchButton;
    //借阅图书界面
    public borrowBook() {
        setTitle("借阅图书");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Font font = new Font("默认",Font.PLAIN,20);

        bookNameTextField = new JTextField(20);
        bookNameTextField.setFont(font);
        JLabel name = new JLabel("书名：");
        name.setFont(font);
        searchButton = new JButton("确定借阅");
        searchButton.setFont(font);
        JPanel p1 = new JPanel();
        p1.add(name);
        p1.add(bookNameTextField);
        p1.add(searchButton);
        add(p1);
        pack();//自动根据组件调整窗口大小
        setLocationRelativeTo(null);//设置窗口居中显示
        setVisible(true);

        //实现借阅功能
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookName = bookNameTextField.getText().trim();
                boolean result = checkBookAvailability(bookName);
                String category = bookNameTextField.getText();
                if(!category.isEmpty()) {
                    if (result) {
                        writeFile(category); //将输入的图书写入借阅记录
                        JOptionPane.showMessageDialog(null, "借阅成功！");
                        bookNameTextField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "图书馆内未保存该书籍！");
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "请输入书名！");
            }
        });
    }

    // 检查书籍是否可用
    private boolean checkBookAvailability(String bookName) {
        String filePath = "bookFile"; // 假设图书信息文件名为bookFile.txt
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] books = line.split("\\s+"); // 使用一个或多个空格作为分隔符
                for (String book : books) {
                    if (book.equals(bookName)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    private void writeFile(String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("useFile", true))) {
            //true表示追加模式表示打开文件
            writer.write("借阅 "+text + " \n");
            writer.flush();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "写入文件时发生了错误：" + e.getMessage());
        }
    }
}
