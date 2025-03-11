// Binary counter using LEDs controlled by a push button

int delay_dur = 2000; // Delay duration
int count = 0; // Counter variable to store the current count
bool counting = false; // Flag to indicate if counting should occur

// Pins for connecting to LEDs
int ledPin2 = 2;
int ledPin3 = 3;
int ledPin4 = 4;
int ledPin5 = 5;
int ledPin6 = 6;
int ledPin7 = 7;
int ledPin8 = 8;
int ledPin9 = 9;

int buttonPin = 10; // Pin for the push button

void setup()
{
  // Initialize Serial Communication
  Serial.begin(9600);

  // Configure LED pins as outputs
  pinMode(ledPin2, OUTPUT);
  pinMode(ledPin3, OUTPUT);
  pinMode(ledPin4, OUTPUT);
  pinMode(ledPin5, OUTPUT);
  pinMode(ledPin6, OUTPUT);
  pinMode(ledPin7, OUTPUT);
  pinMode(ledPin8, OUTPUT);
  pinMode(ledPin9, OUTPUT);

  // Configure push button pin as input with internal pull-up resistor
  pinMode(buttonPin, INPUT_PULLUP);

  // Wait for serial port to connect
  while (!Serial);

  Serial.println("Press the button to start the binary counter");
}

void displayBinary(int num)
{
  digitalWrite(ledPin2, num & 1);      // LED1
  digitalWrite(ledPin3, (num >> 1) & 1); // LED2
  digitalWrite(ledPin4, (num >> 2) & 1); // LED3
  digitalWrite(ledPin5, (num >> 3) & 1); // LED4
  digitalWrite(ledPin6, (num >> 4) & 1); // LED5
  digitalWrite(ledPin7, (num >> 5) & 1); // LED6
  digitalWrite(ledPin8, (num >> 6) & 1); // LED7
  digitalWrite(ledPin9, (num >> 7) & 1); // LED8
}

void loop()
{
  int buttonState = digitalRead(buttonPin);

  if (buttonState == LOW && !counting) // If the button is pressed and counting hasn't started
  {
    counting = true; // Start counting
    Serial.println("Counting started");
  }

  if (counting) // If counting is enabled
  {
    Serial.print("Decimal: ");
    Serial.print(count);
    Serial.print("\tBinary: ");
    Serial.println(count, BIN);

    displayBinary(count); // Display binary on LEDs

    delay(delay_dur); // Wait

    count++; // Increment count
    if (count == 256) {
      counting = false; // Stop counting after reaching 255
      Serial.println("Counting stopped");
    }
  }
}
