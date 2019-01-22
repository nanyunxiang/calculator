package wk.cal.module.view;

import wk.cal.common.config.ViewConfig;
import wk.cal.common.constant.Constant;
import wk.cal.module.view.in.BaseView;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/22  上午 09:00
 * Description: 主界面
 */
public class MainView extends JFrame{

    public MainView(String title) {
        super(title);
        // 设置位置及大小
        ViewConfig viewConfig = ViewConfig.getInstance();
        this.setBounds(viewConfig.getLocationX(), viewConfig.getLocationY(), viewConfig.getWidth(), viewConfig.getHeight());
        BorderLayout borderLayout = new BorderLayout();
//        this.setLayout(borderLayout);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(Constant.ALWAYS_ON_TOP);
        this.setResizable(Constant.RESIZABLE);
    }

    public void run(){
        this.setVisible(true);
    }
}
