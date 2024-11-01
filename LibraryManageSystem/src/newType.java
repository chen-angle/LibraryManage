import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class newType extends JFrame {
    private JTextField categoryTextField;
    private JButton addButton;
    private JLabel messageLabel;
   public newType(){

       setTitle("图书类别管理");
       setSize(300, 200);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       setLocationRelativeTo(null); // 居中显示
       Font font = new Font("默认",Font.PLAIN,20);

       setLayout(new FlowLayout());

       // 文本输入框
       categoryTextField = new JTextField(20);
       categoryTextField.setFont(font);
       JLabel label = new JLabel("输入图书类别:");
       label.setFont(font);
       add(label);
       add(categoryTextField);

       // 按钮
       addButton = new JButton("添加类别");
       addButton.setFont(font);
       add(addButton);


       // 添加按钮点击事件
       addButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String category = categoryTextField.getText().trim();
               if (!category.isEmpty()) {
                   if (checkCategoryExists(category)) {
                       JOptionPane.showMessageDialog(null, "该类别已存在！");
                       categoryTextField.setText("");
                   } else {
                       addCategoryToFile(category);
                       JOptionPane.showMessageDialog(null, "添加成功！");
                       categoryTextField.setText("");
                   }
               } else {
                   JOptionPane.showMessageDialog(null, "请输入图书类别！");
               }
           }
       });
       pack();//自动根据组件调整窗口大小
       setVisible(true);
   }

    // 检查类别是否已存在
    private boolean checkCategoryExists(String category) {
        Set<String> categories = readCategoriesFromFile();
        return categories.contains(category);
    }

    // 从文件中读取所有类别
    private Set<String> readCategoriesFromFile() {
        Set<String> categories = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("typeFile"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                categories.add(line.trim());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return categories;
    }

    // 将新类别添加到文件中
    private void addCategoryToFile(String category) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("typeFile", true))) {
            writer.newLine(); // 添加新行
            writer.write(category);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
   }
}
