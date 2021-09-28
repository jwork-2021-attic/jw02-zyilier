package S191220174;

import S191220174.Line.Position;

public class Matrix {
    public Matrix(int high,int wide){
        this.wide = wide;
        this.high = high;
        this.positions = new Position[high][wide];

    }
    public int wide;
    public int high;
    public Position[][] positions;

    public void put(Linable linable, int i) {
        int w = i%wide;
        int h = (i-w)/wide;
        if (this.positions[h][w] == null) {
            this.positions[h][w] = new Position(null);
        }
        this.positions[h][w].setLinable(linable);
    }

    public Linable get(int i) {
        int w = i%wide;
        int h = (i-w)/wide;
        if ((i < 0) || (i > positions.length)) {
            return null;
        } else {
            return positions[h][w].linable;
        }
    }

    @Override
    public String toString() {
        String lineString = "\t";
        for (int count=0;count<wide*high;count++) {
            int w = count%wide;
            int h = (count-w)/wide;
            Position p= positions[h][w];
            lineString += p.linable.toString();
            if(w==wide-1){
                lineString +="\n";
                lineString +="\t";
            }
        }
        return lineString;
    }
    public Linable[] toArray() {
        Linable[] linables = new Linable[high*wide];
        for (int i = 0; i < linables.length; i++) {
            int w = i%wide;
            int h = (i-w)/wide;
            linables[i] = positions[h][w].linable;
        }

        return linables;

    }


}