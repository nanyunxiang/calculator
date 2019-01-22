package wk.cal.module.view.component;

import wk.cal.common.config.ViewConfig;
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
    private static final ViewConfig viwConfig = ViewConfig.getInstance();

    private static final LineBorder border = new LineBorder(Color.BLACK);
    private static final Font font = new Font("黑体", Font.BOLD, 18);

    private JLabel showLabel;

    public MonitorView() {
        JLabel showLabel = this.buildShowLabel();
        this.showLabel = showLabel;
        this.add(showLabel);
    }

    /**
     * 容器位置
     *
     * @return
     */
    @Override
    public String getPosition() {
        return BorderLayout.NORTH;
    }

    private JLabel buildShowLabel() {
        JLabel jLabel = new JLabel();
        jLabel.setText("0");
        jLabel.setBorder(border);
        jLabel.setFont(font);
        jLabel.setPreferredSize(new Dimension(viwConfig.getWidth()-10, viwConfig.getHeight() / 8));
        jLabel.setLocation(0, 0);
        return jLabel;
    }

    public JLabel getShowLabel() {
        return showLabel;
    }
}
