package wk.cal.module.view;

import wk.cal.common.config.ViewConfig;
import wk.cal.common.constant.Constant;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/22  上午 09:00
 * Description: 主界面
 */
public class MainView extends JFrame {
   private final ViewConfig viewConfig = ViewConfig.getInstance();

    private final JMenuBar jMenuBar = new JMenuBar();

    public MainView(String title) {
        super(title);
        // 设置位置及大小
        this.setBounds(viewConfig.getLocationX(), viewConfig.getLocationY(), viewConfig.getWidth(), viewConfig.getHeight());
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        this.setLayout(flowLayout);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(Constant.ALWAYS_ON_TOP);
        this.setResizable(Constant.RESIZABLE);
        this.add(jMenuBar,BorderLayout.SOUTH);
        this.setJMenuBar(jMenuBar);
    }

    public void run() {
        this.setVisible(true);
    }

    /**
     * 添加菜单
     *
     * @param menu
     */
    public void addMenus(JMenu menu) {
        this.jMenuBar.add(menu);
    }
}
