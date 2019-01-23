package wk.cal.module.model;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/22  下午 05:45
 * Description:
 */
public final class Depot {

    private volatile static Depot depot;

    private static final ScriptEngine js = new ScriptEngineManager().getEngineByName("JavaScript");

    private StringBuffer sb;

    private Depot() {
        sb = new StringBuffer("0");
    }

    private static Depot getInstance() {
        if (depot == null) {
            synchronized (Depot.class) {
                if (depot == null) {
                    depot = new Depot();
                }
            }
        }
        return depot;
    }

    /**
     * 获取算式
     *
     * @return
     */
    public static String getFormula() {
        return getInstance().sb.toString();
    }

    /**
     * 获取结果
     *
     * @return
     */
    public static String getResult() throws ScriptException {
        Depot instance = getInstance();
        Object eval = js.eval(instance.sb.toString());
        instance.sb.setLength(0);
        instance.sb.append(eval.toString());
        return eval.toString();
    }

    /**
     * 追加字符
     *
     * @param v
     */
    public static void append(String v) {
        getInstance().sb.append(v);
    }

    public static void setLength(int length) {
        getInstance().sb.setLength(length);
        append("0");
    }

    /**
     * 清空
     */
    public static void clear() {
        getInstance().sb.setLength(0);
    }

    /**
     * 删除最后一位
     */
    public static void delLast() {
        StringBuffer sb = getInstance().sb;
        if (sb.length() == 1) {
            setLength(0);
            return;
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}
