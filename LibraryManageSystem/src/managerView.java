import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class managerView extends  JFrame {
    public  managerView() {
        setTitle("图书馆管理员");
        setSize(300,300);
        setLayout(new GridLayout(2,1));
        Font font = new Font("默认",Font.PLAIN,20);
        JButton addType = new JButton("新增图书类别");
        addType.setFont(font);
        JButton newBook = new JButton("图书入库");
        newBook.setFont(font);
        add(addType);
        add(newBook);
        setLocationRelativeTo(null);//设置窗口居中显示
        setVisible(true);

        addType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new newType();
            }
        });
        newBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addBook();
            }
        });
    }
}
