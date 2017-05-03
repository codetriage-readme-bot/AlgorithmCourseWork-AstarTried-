import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Created by sivaraj on 3/30/2017.
 */
public interface WeightedGraph<L>{
    double cost(Vertex a,Vertex b);
    ArrayList<Vertex> Neightbours(Vertex id);
}
