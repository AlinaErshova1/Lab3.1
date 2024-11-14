import java.io.PrintStream;
import java.util.Scanner;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;

    public static void main(String[] args) {
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        double[][][] a = new double[z][x][y];
        //создание массива из введенных элементов
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < x; j++) {
                for (int k = 0; k < y; k++) {
                    a[i][j][k] = in.nextDouble();
                }
            }
        }
        //сортировка по Х
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                double[] m = new double[x]; //создание вспомогательного массива м
                for (int k = 0; k < x; k++) {
                    m[k] = a[i][k][j];
                }
                //здесь у нас новый массив м (столбец х). Отсортируем его и вставим вместо столбца в массив а
                for (int p = 0; p < x; p++) {
                    for (int p1 = p + 1; p1 < x; p1++) {
                        double peremen = 0; //вспомогательная переменная для перезаписи элементов массива
                        if ((m[p] - (int) m[p]) < (m[p1] - (int) m[p1])) { //сравнение дробных частей чисел
                            peremen = m[p];
                            m[p] = m[p1];
                            m[p1] = peremen;
                        }
                        else {
                            if ((m[p] - (int) m[p]) == (m[p1] - (int) m[p1])) {//если дробные части равны...
                                if (((int) m[p]) > ((int) m[p1])) { //сортируем по целой части
                                    peremen = m[p];
                                    m[p] = m[p1];
                                    m[p1] = peremen;
                                }

                            }
                        }
                    }
                }
                //здесь у нас отсортированный массив м
                for (int k = 0; k < x; k++) { //"обновляем" стоблец массива а
                    a[i][k][j] = m[k];
                }
            }
        }
        out.println("Среднее геом.:");
        for (int i = 0; i<z; i++) {
            double product = 1;
            for (int j = 0; j < x; j++) {
                for (int k = 0; k < y; k++) {
                    product *= a[i][j][k]; //находим произведение всех элементов слоя
                }
            }
            out.printf("%.4f", (Math.pow(product, ((double)1/(x*y))))); //выводим сред. геом.
            out.println();
        }

        out.println("Вывод массива в виде x, y, z: значение");
        for (int i = 0; i<z; i++) {
            for (int j = 0; j < x; j++) {
                for (int k = 0; k < y; k++) {
                    out.println(j+", "+k+", "+i+": "+a[i][j][k]);
                }
            }
        }
        out.println("Массив с округленными эл.:");
        for (int i = 0; i<z; i++) {
            for (int j = 0; j < x; j++) {
                for (int k = 0; k < y; k++) {
                    a[i][j][k] = Math.round(a[i][j][k] * 100.0) / 100.0; //округляю эл. до 2-х знаков после запятой
                    out.print(a[i][j][k]+" "); //вывожу массив с округленными элементами
                }
                out.println();
            }
            out.println("===");
        }
    }
}