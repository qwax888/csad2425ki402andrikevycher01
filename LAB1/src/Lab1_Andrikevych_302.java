import java.io.*;
import java.util.*;

public class Lab1_Andrikevych_302 {
    public static void main(String[] args) throws FileNotFoundException {
        int nRows;
        char[][] arr;
        String filler;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the size of the square matrix: ");
        nRows = in.nextInt();
        in.nextLine();
        
        arr = new char[nRows][];
        for (int i = 0; i < nRows; i++) {
            arr[i] = new char[nRows]; // Create a square matrix
        }

        System.out.print("\nEnter the filling character: ");
        filler = in.nextLine();

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nRows - i - 1; j++) {
                arr[i][j] = ' '; // Fill with spaces to create the upper triangular effect on the right side
            }
            for (int j = nRows - i - 1; j < nRows; j++) {
                if (filler.length() == 1) {
                    arr[i][j] = filler.charAt(0);
                } else {
                    System.out.println("\nInvalid filling character.");
                    System.exit(1);
                }
            }
        }

        System.out.println("Upper Triangular Matrix:");

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nRows; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // Save the upper triangular matrix to a file (MyFile.txt)
        try (PrintWriter fout = new PrintWriter("MyFile.txt")) {
            for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < nRows; j++) {
                    fout.print(arr[i][j] + " ");
                }
                fout.println();
            }
            fout.flush();
        } catch (FileNotFoundException e) {
            System.err.println("Error writing to the file.");
        }
    }
}











