package wk.cal.module.view.component;

import wk.cal.common.config.FontConfig;
import wk.cal.module.view.in.BaseView;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/22  上午 10:35
 * Description: 显示器视图
 */
public class MonitorView extends BaseView {

    private static final LineBorder border = new LineBorder(Color.BLACK);

    private JLabel showLabel;

    public MonitorView() {
        JLabel showLabel = this.buildShowLabel();
        this.showLabel = showLabel;
        this.setPreferredSize(new Dimension(viwConfig.getWidth()-10, viwConfig.getHeight() / 8));
        this.setBorder(border);
        this.add(showLabel);
    }

    private JLabel buildShowLabel() {
        JLabel jLabel = new JLabel();
        jLabel.setText("0");
        jLabel.setFont(FontConfig.BOLD_18);
        jLabel.setPreferredSize(new Dimension(viwConfig.getWidth()-20, viwConfig.getHeight() / 8));
        return jLabel;
    }

    public JLabel getShowLabel() {
        return showLabel;
    }
}
