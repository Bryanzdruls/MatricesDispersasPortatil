package matricesDispersas1;

import java.util.Random;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args)
    {
        //Instancias de objetos
        tripleta t1;
        tripleta t2;
        tripleta t3;
        forma1 matForma1;
        forma2 matForma2;
        forma2 matForma2_1;
        int opc= 0, opt=0;//Variable de opcion       
        int mat[][]=new int[3][3], sw=0,Dif0=0, swTri=0;//Matriz definida, tamaño y otros
        int n = mat.length, m = mat[0].length; //NxM se definen
        int fila, columna, dato;
        Dif0=Matriz(mat,n,m, sw,Dif0);//Llamado al metodo de la matriz dispersa
        t1= new tripleta(Dif0+1);
        matForma2=new forma2();
        matForma1=new forma1();
        do {
            opc= menu();
            switch (opc) {
                case 1://tripleta
                    opc=menuT();
                    if(swTri==0)
                    {                      
                        t1.Crear(n,m,Dif0,mat);//Funciona  
                        swTri=1;
                        Dif0=0;
                    }            
                    switch (opt) {
                        case 1://Suma de filas.
                            System.out.println("Suma de filas:");
                            t1.sumaFilas();//Funciona
                            break;
                        case 2://Suma de columnas.
                            System.out.println("Suma de columnas: ");
                            t1.sumaColumnas();
                            break;
                        case 3://Insertar Dato
                            t1 = t1.insertarDato();
                            break;
                        case 4://Eliminar Dato
                            t1 = t1.eliminarDato();
                            break;
                        case 5://Mostrar mayor impar F
                            t1.Impar();
                            break;
                        case 6://Mayor promedio col
                            t1.mayorPromCol();
                            break;
                        case 7:
                            
                            break;
                        case 8:
                            
                            break;
                        case 9://Mostrar
                            if(t1.getTri(0,2)!= 0)
                            {
                                System.out.println("Tripleta: ");
                                t1.mostrar();//Funciona
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "La tripleta esta vacia");
                            }
                            break;
                        case 10:
                            
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,"La opcion ingresada es incorrecta, por favor ingrese otra opcion");
                            break;
                    }                    
                    opc=0;
                    break;
                    
                case 2://forma1
                    matForma1.head=matForma1.convertirForma1(mat, n, m);
                    matForma1.sumaFilas(matForma1.head);
                    matForma1.sumaColumnas(matForma1.head);
                    break;
                case 3://forma2
                    matForma2.convertirForma2(mat, n, m, m);
                    matForma2.sumaFilas(matForma2.head);
                    matForma2.sumaColumnas(matForma2.head);
                    fila=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Fila: "));
                    columna=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Columna: "));
                    dato=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato: "));
                    matForma2.head=matForma2.insertar(fila, columna, dato);
                    opc=menu();
                    break;
                case 4:
                    System.out.println("MATRIZ REHECHA");
                    Dif0=Matriz(mat,n,m, sw, Dif0);
                    t1= new tripleta(Dif0+1);
                    swTri=0;
                    break;
                case 5:
                    
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"La opcion ingresada es incorrecta, por favor ingrese otra opcion");
                    break;
            }        
        } while (opc!=5);      
    }//Fin main
    
    public static int menu()
    {
        return Integer.parseInt(JOptionPane.showInputDialog("---MENU MATRICES DISPERSAS---\n"
        +"1. Ingresar Tripleta\n"
        +"2. Ingresar Forma 1\n"
        +"3. Ingresar Forma 2 \n"
        +"4. Reiniciar matriz base\n"
        +"5. Salir\n"
        +"Ingrese una opcion: "));
    }
    public static int menuT()
    {
        return Integer.parseInt(JOptionPane.showInputDialog("---MENU TRIPLETA---\n"
        +"1. Suma de filas\n"
        +"2. Suma de Columnas\n"
        +"3. Insertar Dato \n"
        +"4. Eliminar dato\n"
        +"5. Mostrar mayor dato impar (Fila)\n"
        +"6. Mostrar la columna con mayor promedio\n"
        +"7. Suma de diagonal Principal\n"
        +"8. Suma Diagonal secundaria\n"
        +"9. Mostrar tripleta\n"
        +"10.Volver\n"
        +"Ingrese una opcion: "));
    }
    public static int menuF1()
    {
        return Integer.parseInt(JOptionPane.showInputDialog("---MENU TRIPLETA---\n"
        +"1. Suma de filas\n"
        +"2. Suma de Columnas\n"
        +"3. Insertar Dato \n"
        +"4. Eliminar dato\n"
        +"5. Mostrar mayor dato impar (Fila)\n"
        +"6. Mostrar la columna con mayor promedio\n"
        +"7. Suma de diagonal Principal\n"
        +"8. Suma Diagonal secundaria\n"
        +"9. Mostrar tripleta\n"
        +"10.Volver\n"
        +"Ingrese una opcion: "));
    }//Fin menu f1
    public static int menuF2()
    {
        return Integer.parseInt(JOptionPane.showInputDialog("---MENU TRIPLETA---\n"
        +"1. Suma de filas\n"
        +"2. Suma de Columnas\n"
        +"3. Insertar Dato \n"
        +"4. Eliminar dato\n"
        +"5. Mostrar mayor dato impar (Fila)\n"
        +"6. Mostrar la columna con mayor promedio\n"
        +"7. Suma de diagonal Principal\n"
        +"8. Suma Diagonal secundaria\n"
        +"9. Mostrar tripleta\n"
        +"10.Volver\n"
        +"Ingrese una opcion: "));
    }//Fin menu F2
    public static int Matriz(int [][]mat,int n, int m, int sw, int dif0)
    {
        dif0=0;
        Random aleatorio=new Random();//Random god
        for (int i = 0; i < mat.length; i++)//Llenar de 0.
        {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j]= 0;
            }
        }//fin de llenar de 0.
        System.out.println("Matriz con 0: \n");
        for (int i = 0; i < mat.length; i++)//Mostrar 0
        {
            for (int j = 0; j <mat[0].length; j++) {
                System.out.print("|"+mat[i][j]+"|");
            }
            System.out.println("");
        }//Fin Mostrar 0
        System.out.println("Matriz Dispersa: ");
        for (int i = 0; i < n*m; i++)//Generador de numeros aleatorios
        {
            if (sw==0)
            {
                mat[aleatorio.nextInt(4-1)][aleatorio.nextInt(4-1)]=aleatorio.nextInt(99);
                sw=1;
            }
            else
            {
                if (i<(n*m)/2)
                {
                    sw=0;
                }
            }
        }//Fin de generador de numeros aleatorios     
        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j <mat[0].length; j++) {
                if(mat[i][j] !=0)
                {                                    
                    dif0= dif0+1;
                }
                System.out.print("|"+mat[i][j]+"|");
            }
            System.out.println("");
        }// Mostrar
        return dif0;
    }//Fin matriz
}//Fin main