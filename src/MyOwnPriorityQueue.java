import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.function.Function;

/**
 * Created by sivaraj on 3/30/2017.
 */
public class MyOwnPriorityQueue<T> {


    private ArrayList<Pair<Vertex,Double>
                > elements = new ArrayList<Pair<Vertex,Double>>();

    public final int getCount()
    {
        return elements.size();
    }

    public final void Enqueue(Vertex item, double priority)
    {
        elements.add(new Pair<>(item,priority));
    }

    public final Pair<Vertex,Double> Dequeue()
    {
        int bestIndex = 0;

        for (int i = 0; i < elements.size(); i++)
        {
            Pair<Vertex,Double> current=new Pair<>(elements.get(i).getKey(),
                    elements.get(i).getValue());
            Pair<Vertex,Double> best=new Pair<>(elements.get(bestIndex).getKey(),
                    elements.get(bestIndex).getValue());
           if((current.getKey().getX()<best.getKey().getX() &&
                   current.getKey().getY()<best.getKey().getY())||current.getValue()<best.getValue()){
               bestIndex=i;
           }


        }

        Pair<Vertex,Double> bestItem=elements.get(bestIndex);
        elements.remove(bestIndex);
        return bestItem;
    }
}
