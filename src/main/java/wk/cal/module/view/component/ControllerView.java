package wk.cal.module.view.component;

import wk.cal.module.listener.ControllerBtnListenter;
import wk.cal.module.view.in.BaseView;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/22  下午 05:28
 * Description: 控制视图
 */
public class ControllerView extends BaseView {

    private final String[] btns = {"ac", "del"};

    private final ControllerBtnListenter controllerBtnListenter = new ControllerBtnListenter();

    public ControllerView() {
        this.init();
    }

    private void init() {
        this.setPreferredSize(new Dimension(viwConfig.getWidth() - 10, viwConfig.getHeight() / 8));
        this.setLayout(new GridLayout(1, 2));
        this.addBtns();
    }

    private void addBtns() {

        for (int i = 0; i< btns.length; i++){
            JButton jButton = new JButton(btns[i]);
            jButton.addActionListener(controllerBtnListenter);
            this.add(jButton);
        }
    }

}
