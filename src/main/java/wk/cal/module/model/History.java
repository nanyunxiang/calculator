package wk.cal.module.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/23  上午 09:10
 * Description:
 */
public class History {

    private volatile static History history;

    private List<HistoryEntity> historyEntityList;

    private History() {
        historyEntityList = new LinkedList<>();
    }

    public static History getInstance() {
        if (history == null) {
            synchronized (History.class) {
                if (history == null) {
                    history = new History();
                }
            }
        }
        return history;
    }

    public List<HistoryEntity> getHistoryEntityList() {
        return historyEntityList;
    }

    public void add(HistoryEntity entity) {
        historyEntityList.add(entity);
    }

    public void add(String formula, String result) {
        HistoryEntity historyEntity = new HistoryEntity();
        historyEntity.setDate(new Date());
        historyEntity.setFormula(formula);
        historyEntity.setResult(result);
        this.add(historyEntity);
    }
}
