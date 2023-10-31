/**
 * 
 */
package lab4_Andrikevych_302;

/**
 * 
 */
import java.io.*;
import java.util.Scanner;

public class File {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть значення кута x в градусах: ");
        double xDegrees = scanner.nextDouble();

        try {
            double tangent = Calcualator.calculateTangent(xDegrees);

            // Вивід результату на консоль
            System.out.println("Тангенс кута " + xDegrees + " градусів: " + tangent);

            // Запис результату у текстовий файл
            writeTextResultToFile("result.txt", "Тангенс кута " + xDegrees + " градусів: " + tangent);
            System.out.println("Результати записані у текстовий файл 'result.txt'");

            // Запис результату у бінарний файл
            writeBinaryResultToFile("result.bin", tangent);
            System.out.println("Результати записані у бінарний файл 'result.bin'");

            // Читання результату з текстового файлу
            String textResult = readTextResultFromFile("text.txt");
            System.out.println("Результати з текстового файлу 'text.txt':");
            System.out.println(textResult);

            // Читання результату з бінарного файлу
            double binaryResult = readBinaryResultFromFile("binary.bin");
            System.out.println("Результати з бінарного файлу 'binary.bin': " + binaryResult);
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: Недопустиме значення кута. Введіть дійсний кут в градусах.");
        } catch (ArithmeticException e) {
            System.err.println("Помилка обчислення. Ділення на нуль.");
        } catch (IOException e) {
            System.err.println("Помилка запису або читання з файлу.");
        }
    }

    public static void writeTextResultToFile(String fileName, String text) throws IOException {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.println(text);
        }
    }

    public static void writeBinaryResultToFile(String fileName, double value) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(fileName))) {
            dataOutputStream.writeDouble(value);
        }
    }

    public static String readTextResultFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
            return result.toString();
        }
    }

    public static double readBinaryResultFromFile(String fileName) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(fileName))) {
            return dataInputStream.readDouble();
        }
    }
}

