package wk.cal.builder;

import wk.cal.common.constant.Constant;
import wk.cal.module.view.MainView;
import wk.cal.module.view.component.ControllerView;
import wk.cal.module.view.component.HistoryMenu;
import wk.cal.module.view.component.MonitorView;
import wk.cal.module.view.component.OperationalView;
import wk.cal.module.view.in.BaseMenu;
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

    private static List<BaseView> viewComponents; // 视图容器组件
    private static List<BaseMenu> menuComponents; // 菜单容器组件

    private CalBuilder() {
        initViewComponent();
        initMenuComponent();
    }

    /**
     * 初始化菜单组件
     */
    private void initMenuComponent() {
        menuComponents = new LinkedList<>();
        menuComponents.add(new HistoryMenu());
    }

    /**
     * 初始化视图组件
     */
    private void initViewComponent() {
        viewComponents = new LinkedList<>();
        viewComponents.add(new MonitorView());
        viewComponents.add(new OperationalView());
        viewComponents.add(new ControllerView());
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
        addViewComponents();
        addMenuComponents();
        return mainView;
    }

    /**
     * 添加菜单组件
     */
    private void addMenuComponents() {
        if (menuComponents == null || menuComponents.isEmpty()) {
            return;
        }

        for (BaseMenu view : menuComponents) {
            mainView.addMenus(view);
        }
    }

    /**
     * 给计算器添加组件
     */
    private void addViewComponents() {
        if (viewComponents == null || viewComponents.isEmpty()) {
            return;
        }

        for (BaseView view : viewComponents) {
            mainView.add(view);
        }
    }

    /**
     * 获取显示器屏幕
     *
     * @return
     */
    public JLabel getShowLabel() {
        for (BaseView view : viewComponents) {
            if (view instanceof MonitorView) {
                return ((MonitorView) view).getShowLabel();
            }
        }
        return null;
    }

}
