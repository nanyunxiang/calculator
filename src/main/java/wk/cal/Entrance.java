package wk.cal;

import wk.cal.builder.CalBuilder;

import java.util.logging.Logger;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/22  上午 08:59
 * Description: 程序入口
 */
public class Entrance {

    private static Logger logger = Logger.getGlobal();

    public static void main(String[] args) {
        logger.info("begin.");
        CalBuilder.getInstance().build().run();
    }
}
