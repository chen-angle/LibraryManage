import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class commonView extends JFrame {
    //普通用户登录界面
    public  commonView(){
        setTitle("感谢使用");
        setSize(300,300);
        setLayout(new GridLayout(4,1));
        Font font = new Font("默认",Font.PLAIN,20);
        JButton borrowBook = new JButton("借阅图书");
        JButton returnBook = new JButton("归还图书");
        JButton queryBook = new JButton("查询图书");
        JButton useRecord = new JButton("借阅记录");
        borrowBook.setFont(font);
        returnBook.setFont(font);
        queryBook.setFont(font);
        useRecord.setFont(font);
        add(borrowBook);
        add(returnBook);
        add(queryBook);
        add(useRecord);
        setLocationRelativeTo(null);//设置窗口居中显示
        setVisible(true);

        borrowBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new borrowBook();
            }
        });

        returnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new returnBook();
            }
        });

        queryBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new queryBook();
            }
        });

        useRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new useRecord();
            }
        });
    }

}
