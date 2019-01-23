package wk.cal.module.view.component;

import wk.cal.common.config.DialogConfig;
import wk.cal.module.model.History;
import wk.cal.module.model.HistoryEntity;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/23  上午 09:36
 * Description:
 */
public class HistoryDialog extends JDialog {

    private volatile static HistoryDialog historyDialog;

    private List<JLabel> jLabelList = new LinkedList<>();

    private HistoryDialog() {
        init();
    }

    private static HistoryDialog getInstance() {
        if (historyDialog == null) {
            synchronized (HistoryDialog.class) {
                if (historyDialog == null) {
                    historyDialog = new HistoryDialog();
                }
            }
        }
        return historyDialog;
    }

    private void init() {
        this.setBounds(DialogConfig.getInstance().getLocationX(), DialogConfig.getInstance().getLocationY(), DialogConfig.getInstance().getWidth(), DialogConfig.getInstance().getHeight());
        this.setAlwaysOnTop(true);
        this.setTitle("History");
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    private void initData() {
        for (JLabel jLabel: jLabelList){
            this.remove(jLabel);
        }
        List<HistoryEntity> historyEntityList = History.getInstance().getHistoryEntityList();
        for (HistoryEntity entity: historyEntityList){
            JLabel jLabel = new JLabel();
            jLabel.setPreferredSize(new Dimension(DialogConfig.getInstance().getWidth()-20, 15));

            jLabel.setText(entity.toString());
            this.add(jLabel);
            jLabelList.add(jLabel);
        }
    }

    /**
     * 显示
     */
    public static void display() {
        getInstance().initData();
        getInstance().setVisible(true);
    }

    /**
     * 隐藏
     */
    public static void mask() {
        getInstance().setVisible(true);
    }
}
