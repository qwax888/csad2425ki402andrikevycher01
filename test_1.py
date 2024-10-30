import time
from unittest.mock import patch

@patch('serial.Serial')
def test_uart_communication(mock_serial):
    # Налаштування мок об'єкта
    mock_instance = mock_serial.return_value
    mock_instance.readline.side_effect = [b'LED is ON\n', b'LED is OFF\n']  # Симулюємо відповіді

    # Відправлення команди
    message = "LED_ON\n"
    mock_instance.write(message.encode())
    print("Sent command: LED_ON")

    time.sleep(1)
    response = mock_instance.readline().decode('utf-8').strip()
    print(f"Received response: {response}")

    # Перевірка відповіді
    assert response == "LED is ON", f"Unexpected response: {response}"

    # Відправлення другої команди
    message = "LED_OFF\n"
    mock_instance.write(message.encode())
    print("Sent command: LED_OFF")

    time.sleep(1)
    response = mock_instance.readline().decode('utf-8').strip()
    print(f"Received response: {response}")

    # Перевірка відповіді
    assert response == "LED is OFF", f"Unexpected response: {response}"

