package S191220174;

public class Snake {

    public Minions[] m;
    private static Snake theSnake;

    public static Snake getTheSnake(){
        if(theSnake == null){
            theSnake = new Snake();
        }
        return theSnake;
    }
    
    private Snake(){

    }
    private Sorter sorter;

    public void setSorter(Sorter sorter){
        this.sorter = sorter;
    }

    public String lineUp(Matrix line){
        String log = new String();

        if(sorter == null){
            return null;
        }
        Linable[] linables = line.toArray();
        int[] ranks = new int[linables.length];

        for(int i=0;i<linables.length;i++){
            ranks[i]=linables[i].getValue();
        }
        sorter.load(ranks);
        sorter.sort2();
        String[] sortSteps = this.parsePlan(sorter.getPlan());

        for (String step : sortSteps) {
            this.execute(step);
            System.out.println(line.toString());
            log += line.toString();
            log += "\n[frame]\n";
        }
        return log;

    }
    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }
    private void execute(String step) {
        String[] couple = step.split("<->");
        m[Integer.parseInt(couple[0])-1]
                .swapPosition(m[Integer.parseInt(couple[1])-1]);
    }
}