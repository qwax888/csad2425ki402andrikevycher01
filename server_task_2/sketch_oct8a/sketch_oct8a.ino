void setup() {
  Serial.begin(9600);
  pinMode(13, OUTPUT);  
}

void loop() {
  if (Serial.available()) {
    String command = Serial.readStringUntil('\n');  
    Serial.println("Received: " + command);         

    
    if (command == "LED_ON") {
      digitalWrite(13, HIGH);  
      Serial.println("LED is ON");
    } else if (command == "LED_OFF") {
      digitalWrite(13, LOW);  
      Serial.println("LED is OFF");
    } else {
      Serial.println("Unknown command");
    }
  }
}
