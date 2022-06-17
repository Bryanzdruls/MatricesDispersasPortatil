package matricesDispersas1;

public class forma1 {

    Nodo head;

    public void forma1() {
        this.head = null;
    }

    public Nodo getHead() {
        return this.head;
    }

    public void sethead(Nodo punta) {
        this.head = punta;
    }

    public Nodo convertirForma1(int mat[][], int n, int m)//FALTA PROBAR POR COLUMNA
    {

        int i = 0, j = 0, cont = 0, aux = 0;
        Nodo primero = new Nodo(), registro, p, q, a;
        head = primero;
        p = head;
        head.setFila(n);
        head.setCol(m);

        if (n <= m) {
            while (i < m) {
                Nodo x = new Nodo();
                p.setLiga(x);
                x.setFila(i);
                x.setCol(j);
                p = x;
                i++;
                j++;
            }
        } else {
            while (i < n) {
                Nodo x = new Nodo();
                p.setLiga(x);
                x.setFila(i);
                x.setCol(j);
                p = x;
            }
        }
        p.setLiga(head);
        //liga por fila
        p = head.getLiga();
        while (p != head) {
            if (p.getFila() == cont) {
                if (cont < n && cont < m) {
                    i = cont;
                    registro = p;
                    j = 0;
                    while (j < m) {
                        if (mat[i][j] != 0) {
                            Nodo x = new Nodo();
                            x.setFila(i);
                            x.setCol(j);
                            x.setDato(mat[i][j]);
                            p.setLf(x);
                            p = x;
                        }
                        j++;
                    }
                    p.setLf(registro);
                    p = registro;
                }
            }
            p = p.getLiga();
            cont++;
        }
        //liga por columna
        registro = head.getLiga();
        cont = 0;
        while (registro != head) {
            p = head.getLiga();
            a = registro;
            q = p.getLf();
            while (p != head) {
                while (q != p) {
                    if (registro.getCol() == q.getCol()) {
                        a.setLc(q);
                        a = q;
                    }
                    q = q.getLf();
                }
                p = p.getLiga();
                q = p.getLf();
                if (p.getLf() == null) {
                    p.setLf(p);
                }
            }
            a.setLc(registro);
            registro = registro.getLiga();
            //cont++;
        }
        return head;
    }

    public void sumaFilas(Nodo head) //BUENO
    {
        Nodo p = head.getLiga(), registro;
        int cont = 0, sum = 0;

        while (p != head) {
            registro = p;
            p = p.getLf();
            sum = 0;
            while (p != registro) {
                sum = sum + p.getDato();
                p = p.getLf();
            }
            System.out.println("La suma de la fila " + cont + " es:" + sum);
            cont++;
            p = registro.getLiga();
        }
    }

    public void sumaColumnas(Nodo head) {
        Nodo p = head.getLiga(), registro;
        int cont = 0, sum = 0;

        while (p != head) {
            registro = p;
            p = p.getLc();
            sum = 0;
            while (p != registro) {
                sum = sum + p.getDato();
                p = p.getLf();
            }
            System.out.println("La suma de la columna " + cont + " es:" + sum);
            cont++;
            p = registro.getLiga();
        }
    }//Fin suma columnas   
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
    }
    public void mostrar() {
        /*Nodo p = new Nodo();
        p=this.head;
        System.out.print("Rc:");
        while(p!=this.head)
        {
            System.out.print("|"+p.getDato()+"|->");
            p=p.getLf();
        }*/
        
        Nodo x,x1;
        System.out.println("\tPor filas:  ");
        System.out.println("head:");

        x = this.getHead().getLiga();
        System.out.println("|" + getHead().getFila()+ "|" + getHead().getCol() + "-->" + getHead().getDato());
        do {
            x1 = x.getLf();
            System.out.print("|" + x.getFila()+ "|" + x.getCol() + "-->" + x.getDato());
            do {
                System.out.print("\t|" + x1.getFila()+ "|" + x1.getCol() + "-->" + x1.getDato());
                
                x1 = x1.getLf();
            } while (x1 != x);
            System.out.println(" ");
            x = x.getLiga();
            
        }while (x != this.getHead());
          
         
    }
}//Fin class

