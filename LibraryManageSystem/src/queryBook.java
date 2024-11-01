import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class queryBook extends JFrame {
    //查询图书信息界面
    public queryBook() {

        setTitle("图书信息显示");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // 居中显示
        Font font = new Font("默认",Font.PLAIN,20);

        // 创建文本区域
        JTextArea textArea = new JTextArea(20, 30); // 20行，30列
        textArea.setFont(font);
        textArea.setEditable(false); // 设置为不可编辑

        // 读取文件内容并添加到文本区域
        try (BufferedReader reader = new BufferedReader(new FileReader("bookFile"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n"); // 逐行读取并追加到文本区域
            }
        } catch (IOException e) {
            textArea.append("无法读取文件: " + e.getMessage() + "\n");
            e.printStackTrace();
        }

        // 滚动面板，确保文本区域可以滚动
        JScrollPane scrollPane = new JScrollPane(textArea);

        // 将滚动面板添加到窗口
        add(scrollPane, BorderLayout.CENTER);

        // 显示窗口
        setVisible(true);
    }
}
