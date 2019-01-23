package wk.cal.module.model;

import java.util.Date;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/23  上午 09:11
 * Description:
 */
public class HistoryEntity {

    private String formula;

    private String result;

    private Date date;

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "HistoryEntity{"+ formula + '\'' +
                "=" + result + ", date=" + date +
                '}';
    }
}
