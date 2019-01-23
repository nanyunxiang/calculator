package wk.cal.module.view.component;

import wk.cal.module.listener.OperationalBtnListenter;
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

    private OperationalBtnListenter operationalBtnListenter;

    public OperationalView() {
        GridLayout gridLayout = new GridLayout(4, 4);
        this.operationalBtnListenter = new OperationalBtnListenter();
        this.addBtn();
        this.setPreferredSize(new Dimension(viwConfig.getWidth() - 10, viwConfig.getHeight() / 2 + 30));
        this.setLayout(gridLayout);
    }

    private void addBtn() {
        for (int i = 0; i < btns.length; i++) {
            for (int j = 0; j < btns[i].length; j++) {
                this.add(this.createBtn(btns[i][j], operationalBtnListenter));
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
