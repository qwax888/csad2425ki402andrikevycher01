

package lab4_Andrikevych_302;

import java.io.*;
import java.util.Scanner;

public class CalculatorDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введіть значення кута x в градусах: ");
        double xDegrees = scanner.nextDouble();
        
        try {
            double tangent = Calcualator.calculateTangent(xDegrees);
            
            // Вивід результату на консоль
            System.out.println("Тангенс кута " + xDegrees + " градусів: " + tangent);
            
            // Запис результату у файл
            PrintWriter writer = new PrintWriter("result.txt");
            writer.println("Тангенс кута " + xDegrees + " градусів: " + tangent);
            writer.close();
            
            System.out.println("Результати записані у файл 'result.txt'");
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: Недопустиме значення кута. Введіть дійсний кут в градусах.");
        } catch (ArithmeticException e) {
            System.err.println("Помилка обчислення. Ділення на нуль.");
        } catch (IOException e) {
            System.err.println("Помилка запису до файлу.");
        }
    }
}