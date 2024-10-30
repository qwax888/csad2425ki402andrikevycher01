
import serial
import time

# Клієнт підключається до COM-порту, зв'язаного з сервером (наприклад, COM3)
uart_client = serial.Serial('COM4', 9600, timeout=1)

# Відправлення команди
message = "LED_ON\n"
uart_client.write(message.encode())
print(f"Send to server: {message.strip()}")

# Отримання відповіді від сервера
time.sleep(1)
response = uart_client.readline().decode('utf-8').strip()
print(f"Receive from server: {response}")

# Відправлення іншої команди
message = "LED_OFF\n"
uart_client.write(message.encode())
print(f"Send to server: {message.strip()}")

# Отримання другої відповіді
time.sleep(1)
response = uart_client.readline().decode('utf-8').strip()
print(f"Receive from server: {response}")

uart_client.close()
