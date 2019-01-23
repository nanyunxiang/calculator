package wk.cal.module.listener;

import wk.cal.builder.CalBuilder;
import wk.cal.common.constant.Constant;
import wk.cal.module.model.Depot;
import wk.cal.module.model.History;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
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
public class OperationalBtnListenter implements ActionListener {
    private static Logger logger = Logger.getLogger(OperationalBtnListenter.class.getName());

    private JLabel showLabel;

    private String lastBtnName; //上一次按钮

    public OperationalBtnListenter() {
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
        String actionCommand = e.getActionCommand();

        if (Depot.getFormula().equals("0")) { // 第一次输入时候
            // 如果按的为运算符则不清除 否则清除
            if (!Constant.OPERATION_SYMBOL.contains(actionCommand) || actionCommand.equals("0")) {
                Depot.clear();
            }
        }

        // 如果上一个操作符为= 则清除式子
        if (this.lastBtnName != null && this.lastBtnName.equals("=")) {
            Depot.setLength(0);
        }

        if (actionCommand.equals("=")) {
            try {
                String formula = Depot.getFormula();
                String result = Depot.getResult();
                this.showLabel.setText(result);
                History.getInstance().add(formula, result);
            } catch (ScriptException e1) {
                JOptionPane.showMessageDialog(showLabel, "计算式子有误", "警告", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            if (Constant.OPERATION_SYMBOL.contains(actionCommand) && Constant.OPERATION_SYMBOL.contains(this.lastBtnName)) {
                Depot.delLast();
            }
            Depot.append(actionCommand);
        }

        this.lastBtnName = actionCommand;

        this.showLabel.setText(Depot.getFormula());
    }
}
