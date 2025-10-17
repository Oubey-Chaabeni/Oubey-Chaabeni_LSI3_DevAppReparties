package shared;

import java.io.Serializable;

public class Op implements Serializable {
    private static final long serialVersionUID = 1L;

    private int x;
    private int y;
    private String op;

    public Op(int x, int y, String op) {
        this.x = x;
        this.y = y;
        this.op = op;
    }

    public int getx() { return x; }
    public int gety() { return y; }
    public String getop() { return op; }
}
