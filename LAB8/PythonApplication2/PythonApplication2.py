import math
import struct

def calculate_tangent(x_degrees):
    x_radians = math.radians(x_degrees)
    
    try:
        tangent = math.tan(x_radians)
        return tangent
    except ZeroDivisionError:
        return "Тангенс не визначений: ділення на нуль"

def read_input_value(filename, binary=False):
    try:
        mode = "rb" if binary else "r"
        with open(filename, mode) as file:
            if binary:
                x_degrees, tangent_result = struct.unpack("df", file.read())
            else:
                x_degrees = float(file.readline().strip())
            return x_degrees
    except FileNotFoundError:
        print(f"Помилка: Файл '{filename}' не знайдено.")
        return None
    except ValueError:
        print("Помилка: В файлі введено недопустиме значення.")
        return None

def write_text_result(filename, x_degrees, tangent_result):
    with open(filename, "w") as file:
        file.write(f"Тангенс кута {x_degrees} градусів: {tangent_result}")

def write_binary_result(filename, x_degrees, tangent_result):
    with open(filename, "wb") as file:
        packed_data = struct.pack("df", x_degrees, tangent_result)
        file.write(packed_data)

def main():
    input_choice = input("Виберіть формат читання (t - текстовий, b - бінарний): ")
    
    if input_choice == "t":
        x_degrees = read_input_value("input.txt", binary=False)
    elif input_choice == "b":
        x_degrees = read_input_value("input.bin", binary=True)
    else:
        print("Невірний вибір формату.")
        return

    if x_degrees is not None:
        tangent_result = calculate_tangent(x_degrees)
        write_text_result("text_result.txt", x_degrees, tangent_result)
        write_binary_result("binary_result.bin", x_degrees, tangent_result)
        print("Результати обчислення записано у файли 'text_result.txt' та 'binary_result.bin'.")

if __name__ == "__main__":
    main()
