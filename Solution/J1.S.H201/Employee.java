/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H201;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Employee {
    private String name;
    private String Eid;
    
    
    public Employee() {
    }

    public Employee(String name, String Eid) {
        this.name = name;
        this.Eid = Eid;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return Eid;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
    
}
