/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Node implements Comparable<Node>{
    int data;
    char c;
    
    Node left;
    Node right;

    @Override
    public int compareTo(Node o) {
        if(this.data != o.data) {
            return this.data - o.data;
        } else {
            return (this.c+"").compareTo("" + o.c);
        }
    }
}
