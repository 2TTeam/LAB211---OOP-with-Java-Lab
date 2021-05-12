/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0074;

/**
 *
 * @author SAKURA
 */
public class CalculatorProgram {
    
    public void Menu(){
        int choice;
        do
        {
            System.out.println("=======Calculator program=======");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            choice=Utility.GetInt("Your choice:",1,4);
            int rowA, colA, rowB, colB;
            Matrix A=new Matrix(), B=new Matrix();
            switch(choice)
            {
                case 1:
                    System.out.println("=======Addition=======");
                    /// Input
                    
                    rowA=Utility.GetInt("Enter Row Matrix 1:",1,Integer.MAX_VALUE);
                    colA=Utility.GetInt("Enter Column Matrix 1:",1,Integer.MAX_VALUE);
                    A.inputMatrix(1,rowA,colA);
                    
                    do
                    {      
                        rowB=Utility.GetInt("Enter Row Matrix 2:",1,Integer.MAX_VALUE);
                        colB=Utility.GetInt("Enter Column Matrix 2:",1,Integer.MAX_VALUE);  
                        if( rowA!=rowB || colA!=colB )
                            System.out.println("Invalid matrix size for operator! Please re-enter!");
                        else
                        {
                            B.inputMatrix(2,rowB,colB);
                            break;
                        }
                    }
                    while(true);
                    
                    ///Calc
                    
                    System.out.println("=======Result=======");
                    A.traverse();
                    System.out.println("+");
                    B.traverse();
                    System.out.println("=");
                    Matrix.matrixAddition(A, B).traverse();
                    break;
                    
                case 2:
                    System.out.println("=======Subtraction=======");
                    /// Input
                    
                    rowA=Utility.GetInt("Enter Row Matrix 1:",1,Integer.MAX_VALUE);
                    colA=Utility.GetInt("Enter Column Matrix 1:",1,Integer.MAX_VALUE);
                    A.inputMatrix(1,rowA,colA);
                    
                    do
                    {   
                        rowB=Utility.GetInt("Enter Row Matrix 2:",1,Integer.MAX_VALUE);
                        colB=Utility.GetInt("Enter Column Matrix 2:",1,Integer.MAX_VALUE);  
                        if( rowA!=rowB || colA!=colB )
                            System.out.println("Invalid matrix size for operator! Please re-enter!");
                        else
                        {
                            B.inputMatrix(2,rowB,colB);
                            break;
                        }
                    }
                    while(true);
                    
                    ///Calc
                    System.out.println("=======Result=======");
                    A.traverse();
                    System.out.println("-");
                    B.traverse();
                    System.out.println("=");
                    Matrix.matrixSubtraction(A, B).traverse();
                    break;
                case 3:
                    System.out.println("=======Multiplication=======");
                    /// Input
                    
                    rowA=Utility.GetInt("Enter Row Matrix 1:",1,Integer.MAX_VALUE);
                    colA=Utility.GetInt("Enter Column Matrix 1:",1,Integer.MAX_VALUE);
                    A.inputMatrix(1,rowA,colA);
                    
                    colB=Utility.GetInt("Enter Column Matrix 2:",1,Integer.MAX_VALUE);  
                    do
                    {      
                        rowB=Utility.GetInt("Enter Row Matrix 2:",1,Integer.MAX_VALUE);                      
                        if( colA!=rowB )
                            System.out.println("Invalid matrix size for operator! Please re-enter!");
                        else
                        {
                            B.inputMatrix(2,rowB,colB);
                            break;
                        }
                    }
                    while(true);
                    
                    ///Calc
                    System.out.println("=======Result=======");
                    A.traverse();
                    System.out.println("*");
                    B.traverse();
                    System.out.println("=");
                    Matrix.matrixMultiplication(A, B).traverse();
                    break;
            }
        }
        while(choice!=4);
    }
}
