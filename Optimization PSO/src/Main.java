import java.util.Scanner;
import java.io.File;
import java.lang.Exception;
import java.lang.String;



public class Main {

    public static void main(String[] args) throws Exception {

        File file = new File("//Users//myekkeh//Desktop//Social_Network_Ads.txt");
        Scanner scan = new Scanner(file);
        String a[][] = new String[500][5];
        Integer b[][] = new Integer[500][5];
        double[][] d1 = new double[3][3];
        double F_x[] = new double[500];
        double c[] = new double[500];

//--------------------

        String s = scan.nextLine();
        for (int i = 0; i < 280; i++) {
            s = scan.nextLine();
            String[] l = s.split(",");
            for (int j = 0; j < 5; j++) {
                a[i][j] = l[j];
            }
            if (!scan.hasNext())
                break;
        }

//--------------------

        for (int i = 0; i < 280; i++) {
            for (int j = 0; j < 5; j++) {
                if (a[i][j].equals("Female"))
                    b[i][j] = 1;
                else if (a[i][j].equals("Male"))
                    b[i][j] = 0;
                else
                    b[i][j] = Integer.parseInt(a[i][j]);

            }

        }


//--------------------
            RealFunction f = x -> {

                double sigma = 0 ;
                double E = 0 ;



                    for (int i = 0; i < 280; i++) {
                        double temp = ((b[i][1] * (x[0])) + (b[i][2] * (x[1])) + ((b[i][3]) * (x[2]))) + x[3];
                        F_x[i] = temp;
                        c[i] = Math.pow((F_x[i] - b[i][4]), 2);
                        sigma += c[i];
                    }

                    E = sigma / 280;
//
//                Myselectionsort.doit(E);


//-------------
                return E;

            };

        d1 = Optimization.findMin(f, 4);
                

//
            for (int i = 0; i < 4; i++) {
                System.out.print(d1[0][i] + ", ");
            }
            System.out.println();
            System.out.println(d1[1][0]);
            System.out.println("===========");

 //      }
//-------------

            System.out.print("w1 = ");
            System.out.println(d1[0][0]);
            System.out.print("w2 = ");
            System.out.println(d1[0][1]);
            System.out.print("w3 = ");
            System.out.println(d1[0][2]);
            System.out.print("B = ");
            System.out.println(d1[0][3]);

            double[] info = new double[3];
            for (int i = 280; i < 400; i++) {
                s = scan.nextLine();
                String[] t = s.split(",");
                for (int j = 0; j < 5; j++) {
                    a[i][j] = t[j];
                }
                if (!scan.hasNext())
                    break;

            }
            scan.close();
//--------------------

            for (int i = 280; i < 400; i++) {
                for (int j = 0; j < 5; j++) {
                    if (a[i][j].equals("Female"))
                        b[i][j] = 1;
                    else if (a[i][j].equals("Male"))
                        b[i][j] = 0;
                    else
                        b[i][j] = Integer.parseInt(a[i][j]);

                }

            }
        System.out.println("Machine Learning Completed");
        for (int i = 280; i < 400 ; i++) {
            double finish = (b[i][1]* d1[0][0] + b[i][2]*d1[0][1] + b[i][3]*d1[0][2]) + d1[0][3] ;
        System.out.println(finish);
        }


        }
    }



