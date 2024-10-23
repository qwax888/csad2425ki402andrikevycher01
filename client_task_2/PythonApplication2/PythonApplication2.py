
import serial
import time

# �볺�� ����������� �� COM-�����, ��'������� � �������� (���������, COM3)
uart_client = serial.Serial('COM4', 9600, timeout=1)

# ³���������� �������
message = "LED_ON\n"
uart_client.write(message.encode())
print(f"Send to server: {message.strip()}")

# ��������� ������ �� �������
time.sleep(1)
response = uart_client.readline().decode('utf-8').strip()
print(f"Receive from server: {response}")

# ³���������� ���� �������
message = "LED_OFF\n"
uart_client.write(message.encode())
print(f"Send to server: {message.strip()}")

# ��������� ����� ������
time.sleep(1)
response = uart_client.readline().decode('utf-8').strip()
print(f"Receive from server: {response}")

uart_client.close()
