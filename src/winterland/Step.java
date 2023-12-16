package winterland;

public class Step {
    public static final int COLOR_RED = 1;
    public static final int COLOR_WHITE = 2;
    public static final int COLOR_GREEN = 3;

    public static final int TYPE_NEUTRAL = 1;
    public static final int TYPE_EVENT = 2;
    public static final int TYPE_MINIGAME = 3;

    private int x;
    private int y;
    private int color;
    private int type;

    // Convert string "29,952,red,neutral" into fields
    public Step(String line){
        String[] elements = line.split(",");
        x = Integer.parseInt(elements[0]);
        y = Integer.parseInt(elements[1]);

        if (elements[2].equals("red")){
            color = COLOR_RED;
        } else if (elements[2].equals("white")) {
            color = COLOR_WHITE;
        } else {
            color = COLOR_GREEN;
        }

        if (elements[3].equals("neutral")){
            type = TYPE_NEUTRAL;
        } else if (elements[3].equals("event")) {
            type = TYPE_EVENT;
        } else {
            type = TYPE_MINIGAME;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getColor() {
        return color;
    }

    public int getType() {
        return type;
    }
}
