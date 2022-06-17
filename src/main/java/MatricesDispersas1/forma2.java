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
    
    public Nodo sumaForma2(Nodo head, Nodo head2)
    {
        Nodo p=head.getLf(), q=head2.getLf(),a;
        Nodo primero=new Nodo();
        
        a=primero;

        while(p!=head && q!=head2)
        {
            Nodo x = new Nodo();
            head=x;
            if(p.getFila()==q.getFila() && p.getCol()==q.getCol())
            {
                a.setLf(x);
                a=x;
                x.setDato(p.getDato()+q.getDato());
                x.setFila(p.getFila());
                x.setCol(p.getCol());
                p=p.getLf();
                q=q.getLf();
            }
            else
            {
                if(p.getFila()<=q.getFila())
                {
                    if (p.getFila()==q.getFila()&& p.getCol()<=q.getCol()) {
                        a.setLf(x);
                        a=x;
                        x.setDato(p.getDato());
                        p=p.getLf();
                    }
                    else
                    {
                        if(p.getFila()<q.getFila())
                        {
                            a.setLf(x);
                            a=x;
                            x.setDato(p.getDato());
                            p=p.getLf();
                        }
                    }//Fin else                  
                }//Fin if
                else
                {
                    a.setLf(x);
                    a=x;
                    x.setDato(q.getDato()); 
                    q=q.getLf();
                }//Fin else
            }//Fin else         
        }
//        if(p!=head)
//        {
//            while(p!=head)
//            {
//                a.setLf(x);
//                a=x;
//                p=p.getLf();
//            }
//        }
//        else
//        {
//            if(q!=head2)
//            {
//                //pasar los datos a la nueva
//            }
//        }
        head.setLf(primero);
        //ligar por columnas
        return primero;
    }//fin
    public void borrarDato(int dato)
    {
        int encontro=0;
        Nodo p= new Nodo(), af=null, ac=null;
        p=this.getHead();
        af=getHead();
        ac=getHead();
        p=p.getLf();
        do
        {
            if(p.getDato()==dato)
            {
                af.setLf(p.getLf());
                ac.setLc(p.getLc());
                p=af;
                encontro=1;
            }
            af=af.getLf();
            ac=ac.getLc();
            p=p.getLf();
        }while(p!=this.getHead());
        if(encontro ==1)
        {
            System.out.println("El dato fue eliminado correctamente");
        }
        else
        {
            System.out.println("No se encontro el dato");
        }
    }//FIn borrar
    
    public void borrarDato(int f,int c)
    {
        int encontro=0;
        Nodo p= new Nodo(), af=null, ac=null;
        p=this.getHead();
        af=getHead();
        ac=getHead();
        p=p.getLf();
        do
        {
            if(p.getFila()==f && p.getCol()==c)
            {
                af.setLf(p.getLf());
                ac.setLc(p.getLc());
                p=af;
                encontro=1;
            }
            af=af.getLf();
            ac=ac.getLc();
            p=p.getLf();
        }while(p!=this.getHead());
        if(encontro ==1)
        {
            System.out.println("El dato fue eliminado correctamente");
        }
        else
        {
            System.out.println("No se encontro el dato");
        }
    }//Fin borrar
    //Fin borradores
    public void mostrar()
    {
        Nodo p = new Nodo();
        p=this.getHead();
        System.out.print("Rc:");
        do
        {
            //System.out.print("La liga fila: "+p.getLf());
            System.out.print("|"+p.getDato()+"|->");
            p=p.getLf();
        }while(p!=this.getHead());
        System.out.println("");
    }
}//Fin class
