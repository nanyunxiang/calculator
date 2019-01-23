package wk.cal.module.view.component;

import wk.cal.common.config.FontConfig;
import wk.cal.module.view.in.BaseMenu;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/22  下午 03:58
 * Description: 菜单视图
 */
public class HistoryMenu extends BaseMenu {

    public HistoryMenu() {
        init();
    }

    private void init() {
        this.setText("History");
        this.setName("history");
        this.setFont(FontConfig.BOLD_10);
        this.setVisible(true);
    }

}
