
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
public class CompareByMark implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getMark() - o2.getMark();
    }
    
}
