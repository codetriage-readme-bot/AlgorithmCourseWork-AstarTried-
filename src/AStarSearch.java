import javafx.util.*;

import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;
/**
 * Created by sivaraj on 3/30/2017.
 */
public class AStarSearch {
    Map<Vertex,Vertex> cameFrom=new HashMap<>();
    Map<Vertex,Double> costfar=new HashMap<>();
    public double heuristic(Vertex strt,Vertex end){
        return Math.abs(strt.getX()-end.getX())+Math.abs(strt.getY()-end.getY());

    }

    public  AStarSearch(Vertex start,Vertex end,WeightedGraph<Vertex> graph){
        MyOwnPriorityQueue<Vertex> unvisited= new MyOwnPriorityQueue<>();
         unvisited.Enqueue(start,0.00);
         cameFrom.put(start,start);
         costfar.put(start,0.00);
        while(unvisited.getCount()>0){
            Pair<Vertex,Double> current=unvisited.Dequeue();
             if(current.getKey().equals(end)){
                // System.out.println("path finded");
                 break;
              }
            for(Vertex v:graph.Neightbours(current.getKey())) {
                double new_cost = costfar.get(current.getKey())
                        + graph.cost(current.getKey(), v);
                //System.out.println(new_cost);
                if(!costfar.containsKey(v) || new_cost<costfar.get(v)){
                      costfar.put(v,new_cost);
                      double priority=new_cost+heuristic(v,end);
                      unvisited.Enqueue(v,priority);
                      cameFrom.put(v,current.getKey());
                  //    System.out.println("///////////");
                }
            }
            }
        }
    }


