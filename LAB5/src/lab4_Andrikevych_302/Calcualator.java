/**
 * 
 */
package lab4_Andrikevych_302;

/**
 * 
 */
import java.io.*;

import java.util.Scanner;

public class Calcualator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введіть значення кута x в градусах: ");
        double xDegrees = scanner.nextDouble();
        
        try {
            double tangent = calculateTangent(xDegrees);
            
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

    public static double calculateTangent(double xDegrees) {
        if (xDegrees < 0 || xDegrees >= 360) {
            throw new IllegalArgumentException("Недопустиме значення кута. Кут повинен бути в діапазоні від 0 до 359 градусів.");
        }

        double xRadians = Math.toRadians(xDegrees); // Перетворення в радіани
        double tangent = Math.tan(xRadians);
        
        if (Double.isInfinite(tangent) || Double.isNaN(tangent)) {
            throw new ArithmeticException("Помилка обчислення. Ділення на нуль або недопустима операція.");
        }

        return tangent;
    }
}

