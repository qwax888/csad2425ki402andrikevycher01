import pytest
import serial
import time
from unittest import mock

@mock.patch('serial.Serial')
def test_uart_communication(mock_serial):
    mock_uart = mock_serial.return_value
    mock_uart.readline.side_effect = [
        b"LED is ON\n",  # Відповідь на першу команду
        b"LED is OFF\n"  # Відповідь на другу команду
    ]
    
    uart_client = serial.Serial('COM4', 9600, timeout=1)
    
    message = "LED_ON\n"
    uart_client.write(message.encode())
    time.sleep(1)
    response = uart_client.readline().decode('utf-8').strip()
    assert response == "LED is ON", f"Unexpected response: {response}"

    message = "LED_OFF\n"
    uart_client.write(message.encode())
    time.sleep(1)
    response = uart_client.readline().decode('utf-8').strip()
    assert response == "LED is OFF", f"Unexpected response: {response}"

    mock_uart.write.assert_called()
    mock_uart.readline.assert_called()
    uart_client.close()
