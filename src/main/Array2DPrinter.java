package utils;
 
public class Array2DPrinter {
    public static void print2DArray(IPrintable[][] array) {
        for (IPrintable[] row : array) {
            for (IPrintable item : row) {
                System.out.print((item != null ? item.getPrintableText() : ".") + " ");
            }
            System.out.println();
        }
    }
}