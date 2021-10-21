
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class myComparator implements Comparator<Node>{

    @Override
    public int compare(Node o1, Node o2) {
        return o1.data - o2.data;
    }
    
}
