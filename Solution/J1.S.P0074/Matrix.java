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
public class Matrix {
    //Basic
    private int row,col,m[][];
    public Matrix() {
    }

    public Matrix(int row, int col, int[][] m) {
        this.row = row;
        this.col = col;
        this.m = m;
    }
    
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int[][] getM() {
        return m;
    }

    public void setM(int[][] m) {
        this.m = m;
    }
    // I/O
    public void inputMatrix(int ID,int r,int c)
    {
        this.row=r;
        this.col=c;
        this.m=new int[row][col];
        
        for(int i=1 ; i<=row ; i++ )
            for(int j=1 ; j<=col ; j++ )
                this.m[i-1][j-1]=Utility.GetInt("Enter Matrix "+ID+"["+i+"]["+j+"]:",Integer.MIN_VALUE,Integer.MAX_VALUE);        
    }
    public void traverse()
    {
        for(int i=0 ; i<this.row ; i++ )
        {
            for(int j=0 ; j<this.col ; j++ )
                System.out.print("["+this.m[i][j]+"]");
            System.out.print("\n");
        }
    }
    /// Operator
    public static Matrix matrixAddition(Matrix a,Matrix b)
    {
        int n=a.getRow(), m=a.getCol();
        int[][] tmp=new int[n][m], mA=a.getM(), mB=b.getM();
        
        for(int i=0 ; i<n ; i++ )
            for(int j=0 ; j<m ; j++ )
                tmp[i][j]=mA[i][j]+mB[i][j];
        
        Matrix res=new Matrix(n,m,tmp);
        return res;
    }
    
    public static Matrix matrixSubtraction(Matrix a,Matrix b)
    {
        int n=a.getRow(), m=a.getCol();
        int[][] tmp=new int[n][m], mA=a.getM(), mB=b.getM();
        
        for(int i=0 ; i<n ; i++ )
            for(int j=0 ; j<m ; j++ )
                tmp[i][j]=mA[i][j]-mB[i][j];
        
        Matrix res=new Matrix(n,m,tmp);
        return res;
    }
    
    public static Matrix matrixMultiplication(Matrix a,Matrix b)
    {
        int n=a.getRow(), m=b.getCol(), o=a.getCol();
        int[][] tmp=new int[n][m], mA=a.getM(), mB=b.getM();
        
        for(int i=0; i<n ; i++ )
            for(int j=0 ; j<m ; j++ )
            {
                tmp[i][j]=0;
                for(int z=0 ; z<o ; z++ )
                    tmp[i][j]+=mA[i][z]*mB[z][j];
            }
        
        Matrix res=new Matrix(n,m,tmp);
        return res;
        
        /**
         *                B [0][1000]    
         *                  [0][100]
         *                  [0][10]
         *                  [0][10]
         * A
         * [2][3][4][5]     [0][]    2    3    4   5   
         * [1][1][1][5]     [0][]    1000 100  10  10
         * [1][1][1][5]     [0][]    2000+
         * 
         */
    }
}


/**
 * 
 * 
 *         if(a.getCol()!=b.getCol() || a.getRow()!=b.getRow())
        {
            System.out.println("Invalid matrix size for operator!");
            return null;
        }
        *if(a.getCol()!=b.getRow())
        {
            System.out.println(a.getCol());
            System.out.println(b.getRow());
            System.out.println("Invalid matrix size for operator!");
            return null;
        }
 */