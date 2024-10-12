import serial
import time

def test_uart_communication():
    try:
        print("Starting UART communication test.")
        uart_client = serial.Serial('COM4', 9600, timeout=1)
        
        # Відправлення команди
        message = "LED_ON\n"
        uart_client.write(message.encode())
        print("Sent command: LED_ON")

        # Отримання відповіді
        time.sleep(1)
        response = uart_client.readline().decode('utf-8').strip()
        print(f"Received response: {response}")

        # Перевірка відповіді
        assert response == "LED is ON", f"Unexpected response: {response}"

        # Відправлення другої команди
        message = "LED_OFF\n"
        uart_client.write(message.encode())
        print("Sent command: LED_OFF")
        
        # Отримання другої відповіді
        time.sleep(1)
        response = uart_client.readline().decode('utf-8').strip()
        print(f"Received response: {response}")

        # Перевірка відповіді
        assert response == "LED is OFF", f"Unexpected response: {response}"

        uart_client.close()
    except Exception as e:
        print(f"Error occurred: {e}")
