import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by sivaraj on 3/30/2017.
 */
public class SquarGrid implements WeightedGraph {
    public HashSet<Vertex> bleockedselles=new HashSet<Vertex>();
    public HashSet<Vertex> opencells=new HashSet<Vertex>();
    private int height;
    private int width;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public SquarGrid(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public boolean InBounds(Vertex id)
    {
        return 0 <= id.getX() && id.getX() < width
                && 0 <= id.getY() && id.getY() < height;
    }

    public boolean Passable(Vertex id)
    {
        return !bleockedselles.contains(id);
    }
//    public double Cost(Vertex a, Vertex b)
//    {
//
//    }
    @Override
    public double cost(Vertex a, Vertex b) {
        return opencells.contains(b) ? 5 : 1;
    }
    public static  Vertex[] DIRS = new Vertex[]
    {
        new Vertex(1, 0),
                new Vertex(0, -1),
                new Vertex(-1, 0),
                new Vertex(0, 1)
    };
    public static SquarGrid generateSquareGrid(boolean[][] given_array){
        int N=given_array.length;
        SquarGrid grid=new SquarGrid(N,N);
       // boolean[][] open=PathFindingOnSquaredGrid.flow(given_array);
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if (given_array[i][j]==false){        // not an open cell
                    grid.bleockedselles.add(new Vertex(i,j));
                //System.out.println("blocked");
                    }
                else{
                    grid.opencells.add(new Vertex(i,j));
                  //  System.out.println("open");
                }
            }
        }
        return grid;
    }
    @Override
    public ArrayList<Vertex> Neightbours(Vertex id) {
        ArrayList<Vertex> nei=new ArrayList<Vertex>();
        for (Vertex v:DIRS
             ) {
            Vertex next=new Vertex(id.getX()+v.getX(),id.getY()+v.getX());
            if(Passable(id) || InBounds(id)){
               nei.add(next);
             //  System.out.println("successfully added");
            }
        }
        return nei;
    }
}
