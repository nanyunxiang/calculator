package wk.cal.common.config;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/23  上午 09:32
 * Description:
 */
public final class DialogConfig {

    private volatile static DialogConfig config;

    private int width;

    private int height;

    private int locationX;

    private int locationY;

    private DialogConfig() {
        this.width = 400;
        this.height = 400;
        this.locationX = ViewConfig.getInstance().getLocationX()+ ViewConfig.getInstance().getWidth();
        this.locationY = ViewConfig.getInstance().getLocationY();
    }

    public static DialogConfig getInstance() {
        if (config == null) {
            synchronized (DialogConfig.class) {
                if (config == null) {
                    config = new DialogConfig();
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
}
