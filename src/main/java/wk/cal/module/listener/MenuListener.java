package wk.cal.module.listener;

import wk.cal.module.model.History;
import wk.cal.module.model.HistoryEntity;
import wk.cal.module.view.component.HistoryDialog;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/22  下午 04:02
 * Description:
 */
public class MenuListener implements javax.swing.event.MenuListener {

    private static Logger logger = Logger.getLogger(MenuListener.class.getName());

    /**
     * Invoked when a menu is selected.
     *
     * @param e a MenuEvent object
     */
    @Override
    public void menuSelected(MenuEvent e) {
        logger.info("e");
        JMenu source = (JMenu) e.getSource();
        logger.info(source.getText());
        if (source.getName().equals("history")) {
            List<HistoryEntity> historyEntityList = History.getInstance().getHistoryEntityList();
            System.out.println(historyEntityList);
            HistoryDialog.display();
        }
    }

    /**
     * Invoked when the menu is deselected.
     *
     * @param e a MenuEvent object
     */
    @Override
    public void menuDeselected(MenuEvent e) {

    }

    /**
     * Invoked when the menu is canceled.
     *
     * @param e a MenuEvent object
     */
    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
