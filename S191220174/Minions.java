package S191220174;

import S191220174.Line.Position;

public class Minions implements Linable{
    public int r;
    public int g;
    public int b;

    private Position position;

    public Minions(int r){
        this.r=r;
        this.g=(r*111)%256;
        this.b=(r*79)%256;
    }
    public static Minions getMinionByRank(int rank) {

        return null;

    }
    public int rank() {
        return this.r;
    }
    @Override
    public String toString() {
        return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " + this.rank() + "  \033[0m";
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }
    public void swapPosition(Minions another) {
        Position p = another.position;
        this.position.setLinable(another);
        p.setLinable(this);
    }

    @Override
    public int getValue() {
        return this.rank();
    }
}