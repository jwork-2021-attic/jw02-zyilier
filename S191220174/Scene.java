package S191220174;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Scene {
    public static boolean existed(int num, int[] array, int index) {
		for(int i=0; i<index; i++) {
			if(num == array[i]) {
				return true;
			}
		}
		return false;
	}

    public static void main(String[] args) throws IOException {
        int l =256;
        Matrix matrix = new Matrix(16,16);
//        Line line = new Line(l);
        Minions m[]=new Minions[l];
        for(int i=0;i<l;i++){
            m[i]=new Minions(i+1);
        }
        int[] order = new int[l];
        Random R = new Random();
        for(int i=0;i<l;i++){
            int randomNum = R.nextInt(l);
            while(existed(randomNum, order, i)) {
                randomNum = R.nextInt(l);
            }
            order[i]=randomNum;
        }


        for(int i=0;i<l;i++){
            matrix.put(m[i],order[i]);
//            line.put(m[i],order[i]);
        }
        Snake theSnake = Snake.getTheSnake();
        Sorter sorter = new MonsterSorter();
        theSnake.setSorter(sorter);
        theSnake.m=m;
        String log = theSnake.lineUp(matrix);
        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result2.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }
}