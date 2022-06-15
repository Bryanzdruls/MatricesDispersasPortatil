package matricesDispersas1;

public class forma2 {

    //atributos
    Nodo head;
    
    //metodos
    public void forma2()
    {
        head=null;
    }
    
    public void setHead(Nodo head) {
        this.head = head;
    }

    public Nodo getHead() {
        return this.head;
    }
    
    public void convertirForma2(int mat[][], int n, int m, int d)
    {
        int  i=0, j, cont=0;
        Nodo primero = new Nodo(), p,anterior;
        primero.setFila(n);
        primero.setCol(m);
        head=primero;
        p=head;
        
        while(i<mat.length)
        {
            j=0;
            while(j<mat[0].length)
            {
                if(mat[i][j] != 0)
                {
                    Nodo x = new Nodo();
                    x.setFila(i); 
                    x.setCol(j);
                    x.setDato(mat[i][j]);
                    p.setLf(x);
                    p=x;
                }
                j++;
            }
            i++;
        }
        p.setLf(head);
        anterior=head;
        while(cont < head.getCol())
        {
            p=head.getLf();
            while(p!=head)
            {
                if(p.getCol()==cont)
                {
                    anterior.setLc(p);
                    anterior=p;
                }
                p=p.getLf();
            }
            cont++;
        }
        anterior.setLc(head);
    }
    
    public void sumaFilas(Nodo head)
    {
        Nodo p=this.head.getLf();
        int aux=0, sum=0;
        
        while(aux < this.head.getFila())
        {
            p=this.head.getLf();
            while(p!=head)
            {
                if(aux==p.getFila())
                {
                    sum=sum+p.getDato();
                }
                p=p.getLf();
            }
            System.out.println("Suma de la fila " + aux + " es: " + sum);
            sum=0;
            aux++;
        }
    }
    
    public void sumaColumnas(Nodo head)
    {
        Nodo p=this.head.getLc();
        int aux=0, sum=0;
        
        while(aux < this.head.getCol())
        {
            p=this.head.getLc();
            while(p!=head)
            {
                if(p.getCol() == aux)
                {
                    sum=sum+p.getDato();
                }
                p=p.getLc();
            }
            System.out.println("Suma de la columna " + aux + " es: " + sum);
            sum=0;
            aux++;
        }
    }
    
    public Nodo insertar(int f, int c, int d)
    {
        int aux=0;
        Nodo p=this.head.getLf();
        
        while(p!=head)
        {
            if(p.getFila()==f && p.getCol()==c)
            {
                p.setDato(p.getDato()+d);
            }
            p=p.getLf();
        }
        return this.head;
    }
}
