
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Huffman {
    int n = 6;
    char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
    int[] charfreq = { 5, 9, 12, 13, 16, 45 }; 
    PriorityQueue<Node> q;
    Node root;
    HashMap<Character, String> deCode;
    

    void setData(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        
        HashMap<Character, Integer> frequencyChar = new HashMap<>();
        
        
        int numOfLine = 0;
        
        while(sc.hasNextLine()){
            ++numOfLine;
            String line = sc.nextLine();
            for(int i = 0; i < line.length(); ++i) {
//                if(Character.isAlphabetic( line.charAt(i)) ) 
                    frequencyChar.put( line.charAt(i), frequencyChar.getOrDefault( line.charAt(i), 0 ) + 1);
            }
        }
        
        
        
        if(numOfLine>1)
            frequencyChar.put( (char) 10, numOfLine - 1);
        
        n = frequencyChar.size();
        charArray = new char[n];
        charfreq  = new int[n];
        
        int k = 0;
        
        for (Map.Entry<Character, Integer> entry : frequencyChar.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("'" +key + "': " +value);
            charArray[k] = key;
            charfreq[k] = value;
            ++k;
        }     
        
    }
    
    
    void Build() {
        q = new PriorityQueue<>(n);
        deCode = new HashMap<>();
        root = null;
        
        for( int i = 0; i < n; ++i) {
            Node hn = new Node();
            hn.c = charArray[i];
            hn.data = charfreq[i];
            
            hn.left = null;
            hn.right = null;
            
            q.add(hn);
        }
        
        System.out.println("Priority Queue: ");
        PriorityQueue<Node> temp = new PriorityQueue<Node>(q);
        
        while(temp.size() > 0) {
            Node t = temp.poll();
            System.out.println("'" + t.c + "': " + t.data);
        } 
        
        
        
        
        while( q.size() > 1) {
            Node x = q.poll();
            Node y = q.poll();
            
            Node f = new Node();
            f.data = x.data + y.data;
            f.c = '#';
            
            f.left  = x;
            f.right = y;
        
            root = f;
            
            q.add(f);
        }
    }
    
    
    
    
    
    public void printCode(Node root, String s) {
        if(root.left == null && root.right == null ) {
            System.out.println("'" + root.c + "': "  + s);
            deCode.put(root.c, s);
            return;
        }else {
            printCode(root.left, s + "1");
            printCode(root.right, s + "0");
        }
    }
    
    public double f() {
        double res = 0;
        for(int i = 0; i < this.charArray.length; ++i) {
            res += deCode.get(charArray[i]).length() * charfreq[i];
        }
        return res;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Huffman hm = new Huffman();

        hm.setData("testHuffman.txt");
        
        hm.Build();
        System.out.println("Encode: ");
        hm.printCode(hm.root, "");
        
        System.out.println(hm.f() / 100);
    }
}
