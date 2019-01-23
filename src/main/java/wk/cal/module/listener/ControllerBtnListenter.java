package wk.cal.module.listener;

import wk.cal.builder.CalBuilder;
import wk.cal.module.model.Depot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/22  下午 12:15
 * Description: 按钮监听事件
 */
public class ControllerBtnListenter implements ActionListener {
    private static Logger logger = Logger.getLogger(ControllerBtnListenter.class.getName());

    private JLabel showLabel;

    public ControllerBtnListenter() {
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (showLabel == null) {
            showLabel = CalBuilder.getInstance().getShowLabel();
        }
        logger.info(e.getActionCommand());
        switch (e.getActionCommand()) {
            case "ac":
                Depot.setLength(0);
                break;
            case "del":
                Depot.delLast();
                break;
        }
        showLabel.setText(Depot.getFormula());
    }
}
