package wk.cal.module.view.in;

import wk.cal.module.listener.MenuListener;

import javax.swing.*;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/22  下午 04:51
 * Description:
 */
public abstract class BaseMenu extends JMenu{

    private MenuListener menuListener = new MenuListener();

    {
        this.addMenuListener(menuListener);
    }
}
