// Pin configuration
const int segmentPins[] = {2, 3, 4, 5, 6, 7, 8, 9};
const int commonPin = 10;

// Function to display a digit on the 7-segment display
void displayDigit(int digit) {
  const int digits[][8] = {
    {1, 1, 1, 1, 1, 1, 0, 0},  // 0
    {0, 1, 1, 0, 0, 0, 0, 0},  // 1
    // ... Add patterns for digits 2 to 9
  };

  for (int i = 0; i < 8; i++) {
    digitalWrite(segmentPins[i], digits[digit][i]);
  }

  digitalWrite(commonPin, HIGH);
  delay(5); // Adjust delay as needed
  digitalWrite(commonPin, LOW);
}

void setup() {
  // Set up segment and common pins as outputs
  for (int i = 0; i < 8; i++) {
    pinMode(segmentPins[i], OUTPUT);
  }
  pinMode(commonPin, OUTPUT);
}

void loop() {
  // Countdown from 9 to 0
  for (int count = 9; count >= 0; count--) {
    displayDigit(count);
    delay(1000); // One-second delay
  }
}
