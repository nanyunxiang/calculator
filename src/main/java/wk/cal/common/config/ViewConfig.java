package wk.cal.common.config;

import java.awt.*;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/22  上午 09:08
 * Description:
 */
public final class ViewConfig {

    private volatile static ViewConfig config;

    private int width;

    private int height;

    private int locationX;

    private int locationY;

    private ViewConfig() {
        this.width = 400;
        this.height = 400;
        int screenWidth = this.getScreenWidth();
        int screenHeight = this.getScreenHeight();
        this.locationX = (screenWidth - this.width) / 2;
        this.locationY = (screenHeight - this.width) / 2;
    }

    public static ViewConfig getInstance() {
        if (config == null) {
            synchronized (ViewConfig.class) {
                if (config == null) {
                    config = new ViewConfig();
                }
            }
        }
        return config;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLocationX() {
        return locationX;
    }


    public int getLocationY() {
        return locationY;
    }

    private int getScreenWidth() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) screenSize.getWidth();
    }

    private int getScreenHeight() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) screenSize.getHeight();
    }
}
