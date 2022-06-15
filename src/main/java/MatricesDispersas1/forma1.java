package matricesDispersas1;

public class forma1 {
    
    Nodo head;
    
    public void forma1()
    {
        this.head=null;
    }
    
    public Nodo getForma1()
    {
        return this.head;
    }
    
    public void setForma1(Nodo punta)
    {
        this.head=punta;
    }
    
    public Nodo convertirForma1(int mat[][], int n, int m)//FALTA PROBAR POR COLUMNA
    {
        
        int i=0, j=0,cont=0, aux=0;
        Nodo primero=new Nodo(),registro, p, q,a;
        head=primero;
        p=head;
        head.setFila(n);
        head.setCol(m);
        
        if(n<=m)
        {
            while(i<m)
            {
                Nodo x = new Nodo();
                p.setLiga(x);
                x.setFila(i);
                x.setCol(j);
                p=x;
                i++;
                j++;
            }
        }
        else
        {
            while(i<n)
            {
                Nodo x = new Nodo();
                p.setLiga(x);
                x.setFila(i);
                x.setCol(j);
                p=x;
            }
        }
        p.setLiga(head);
        //liga por fila
        p=head.getLiga();
        while(p!=head)
        {
                if(p.getFila()== cont)
                {
                    if(cont<n && cont<m)
                    {
                        i=cont;
                        registro=p;
                        j=0;
                        while(j<m)
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
                        p.setLf(registro);
                        p=registro;
                    }
                }
                p=p.getLiga();
                cont++;
        }
        //liga por columna
        registro = head.getLiga();
        cont=0;
        while(registro!=head)
        {
            p=head.getLiga();
            a=registro;
            q=p.getLf();
            while(p!=head)
            {
                while(q!=p)
                {
                    if(registro.getCol()== q.getCol())
                    {
                        a.setLc(q);
                        a=q;
                    }
                    q=q.getLf();
                }
                p=p.getLiga();
                q=p.getLf();
                if(p.getLf()== null)
                {
                    p.setLf(p);
                }
            }
            a.setLc(registro);
            registro = registro.getLiga();
            //cont++;
        }
        return head;
    }
    public void sumaColumnas(Nodo head)
    {
        Nodo p=head.getLiga(), registro;
        int cont=0,sum=0;
        
        while(p!=head)
        {
            registro=p;
            p=p.getLc();
            sum=0;
            while(p!=registro)
            {
                sum=sum+p.getDato();
                p=p.getLc();
            }
            System.out.println("La suma de la columna "+cont+" es:"+ sum);
            cont++;
            p=registro.getLiga();
        }
    }
    
    public void sumaFilas(Nodo head) //BUENO
    {
        Nodo p = head.getLiga(), registro;
        int cont=0, sum=0;
        
        while(p!=head)
        {
            registro=p;
            p=p.getLf();
            sum=0;
            while(p!=registro)
            {
                sum=sum+p.getDato();
                p=p.getLf();
            }
            System.out.println("La suma de la fila " + cont +" es:" + sum );
            cont++;
            p=registro.getLiga();
        }
    }
}

