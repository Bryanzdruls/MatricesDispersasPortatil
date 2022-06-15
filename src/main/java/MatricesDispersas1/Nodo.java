package matricesDispersas1;

public class Nodo {
   
    //atributos
    private int f, c, dato;
    private Nodo lc, lf, liga;
   
    //constructor
    public void nodo ()
    {
        dato=0;
        f=0;c=0;
        lc=null; lf=null;
    }
   
    //metodos
    public int getDato()
    {
        return this.dato;
    }
    
    public int getFila()
    {
        return this.f;
    }
    public void setFila(int fila)
    {
        this.f=fila;
    }
    
    public int getCol()
    {
        return this.c;
    }
    public void setCol(int col)
    {
        this.c=col;
    }
   
    public void setDato(int d)
    {
        this.dato=d;
    }
   
    public Nodo getLf()
    {
        return this.lf;
    }
    public void setLf(Nodo l)
    {
        this.lf=l;
    }
   
    public Nodo getLc()
    {
        return this.lc;
    }
   
    public void setLc(Nodo l)
    {
        this.lc=l;  
    }
    public Nodo getLiga()
    {
        return this.liga;
    }
   
    public void setLiga(Nodo l)
    {
        this.liga=l;
    }
}