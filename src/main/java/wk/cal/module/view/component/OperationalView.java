package wk.cal.module.view.component;

import wk.cal.module.listener.BtnListenter;
import wk.cal.module.view.in.BaseView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/22  下午 12:04
 * Description: 操作视图
 */
public class OperationalView extends BaseView {

    private final String[][] btns = {
            {"7", "8", "9", "/"},
            {"4", "5", "6", "*"},
            {"1", "2", "3", "-"},
            {".", "0", "=", "+"},
    };

    private static final Font font = new Font("黑体", Font.BOLD, 18);

    private  BtnListenter btnListenter;

    public OperationalView() {
        GridLayout gridLayout = new GridLayout(4, 4);
        this.btnListenter = new BtnListenter();
        this.addBtn();
        this.setLayout(gridLayout);
    }

    /**
     * 获取容器位置
     *
     * @return
     */
    @Override
    public String getPosition() {
        return BorderLayout.CENTER;
    }

    private void addBtn() {
        for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns[i].length; j++) {
                this.add(this.createBtn(btns[i][j], btnListenter));
            }
        }
    }

    private JButton createBtn(String name, ActionListener listener) {
        JButton jButton = new JButton(name);
        jButton.setFont(font);
        jButton.addActionListener(listener);
        return jButton;
    }
}
