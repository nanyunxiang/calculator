package wk.cal.module.listener;

import wk.cal.builder.CalBuilder;
import wk.cal.common.constant.Constant;

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
public class BtnListenter implements ActionListener {
    private static Logger logger = Logger.getLogger(BtnListenter.class.getName());

    private ScriptEngine js = new ScriptEngineManager().getEngineByName("JavaScript");

    private StringBuffer input = new StringBuffer("0");

    private JLabel showLabel;

    private String lastBtnName; //上一次按钮

    public BtnListenter() {
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

        if (this.input.toString().equals("0")) { // 第一次输入时候
            // 如果按的为运算符则不清除 否则清除
            if (!Constant.OPERATION_SYMBOL.contains(actionCommand)) {
                this.input.setLength(0);
            }
        }

        // 如果上一个操作符为= 则清除式子
        if (this.lastBtnName != null && this.lastBtnName.equals("=")){
            this.input.setLength(0);
        }


        if (actionCommand.equals("=")) {
            try {
                Object eval = js.eval(this.input.toString());
                logger.info(this.input.toString() + "=" + eval.toString());
                this.input.setLength(0);
                this.input.append(eval.toString());
            } catch (ScriptException e1) {
                JOptionPane.showMessageDialog(showLabel, "计算式子有误", "警告", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            this.input.append(actionCommand);
        }
        this.lastBtnName = actionCommand;
        this.showLabel.setText(this.input.toString());
    }
}
