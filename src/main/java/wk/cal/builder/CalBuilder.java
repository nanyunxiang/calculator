package wk.cal.builder;

import sun.applet.Main;
import wk.cal.common.constant.Constant;
import wk.cal.module.view.MainView;
import wk.cal.module.view.component.MonitorView;
import wk.cal.module.view.component.OperationalView;
import wk.cal.module.view.in.BaseView;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/22  上午 10:39
 * Description:
 */
public class CalBuilder {

    private static CalBuilder calBuilder;

    private static MainView mainView; // 主容器

    private static List<BaseView> components; // 容器组件

    private CalBuilder() {
        components = new LinkedList<>();
        components.add(new MonitorView());
        components.add(new OperationalView());
    }

    public static CalBuilder getInstance() {
        if (calBuilder == null) {
            synchronized (CalBuilder.class) {
                if (calBuilder == null) {
                    calBuilder = new CalBuilder();
                }
            }
        }
        return calBuilder;
    }


    /**
     * 构建计算器
     *
     * @return
     */
    public MainView build() {
        if (mainView == null) {
            mainView = new MainView(Constant.SYS_TITLE);
        }
        addComponents();
        return mainView;
    }

    /**
     * 给计算器添加组件
     */
    private void addComponents() {
        if (components == null || components.isEmpty()) {
            return;
        }

        for (BaseView view : components) {
            mainView.add(view, view.getPosition());
        }
    }

    /**
     * 获取显示器屏幕
     *
     * @return
     */
    public JLabel getShowLabel() {
        for (BaseView view : components) {
            if (view instanceof MonitorView) {
                return ((MonitorView) view).getShowLabel();
            }
        }
        return null;
    }

}
