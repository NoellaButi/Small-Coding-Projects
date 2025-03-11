const int numLEDs = 6;

// PWM pins for LEDs
const int ledPins[numLEDs] = {3, 5, 6, 9, 10, 11};

// Analog input pin for potentiometer
const int potPin = A0;

void setup() {
  Serial.begin(9600);
}

void loop() {
  // Read potentiometer value to control LED brightness
  int potValue = analogRead(potPin);
  
  // Turn off all LEDs initially
  for (int i = 0; i < numLEDs; i++) {
    analogWrite(ledPins[i], 0);
  }
  
  // Calculate the brightness step size for each LED
  int brightnessStep = map(potValue, 0, 1023, 255 / numLEDs, 0);

  // Fade LEDs progressively from bright to dim
  for (int i = 0; i < numLEDs; i++) {
    
    // Set brightness level for each LED with decreasing brightness
    int brightness = i * brightnessStep;
    analogWrite(ledPins[numLEDs - i - 1], brightness);
    Serial.print("LED ");

    // LED numbering starts from 6
    Serial.print(numLEDs - i); 
    Serial.print(" brightness: ");

    // Print brightness value to serial monitor
    Serial.println(brightness);

    // Delay time
    delay(500);
  }
}
