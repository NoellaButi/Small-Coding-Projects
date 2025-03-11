#include <LiquidCrystal.h>  // Include LCD library
#include <Keypad.h>         // Include Keypad library

#define redLED 10     // Define the red LED pin
#define greenLED 11   // Define the green LED pin

char* password = "1234";  // Set the password
int position = 0;         // Track keypad position

const byte rows = 4;  // Number of rows in the keypad
const byte cols = 4;  // Number of columns in the keypad

// Define keypad layout
char keyMap[rows][cols] = {
    {'1', '2', '3', 'A'},
    {'4', '5', '6', 'B'},
    {'7', '8', '9', 'C'},
    {'*', '0', '#', 'D'}
};

// Define the pins used for the keypad
byte rowPins[rows] = {1, 2, 3, 4};
byte colPins[cols] = {5, 6, 7, 8};

// Initialize Keypad
Keypad myKeypad = Keypad(makeKeymap(keyMap), rowPins, colPins, rows, cols);

// Initialize LCD (RS, E, D4, D5, D6, D7)
LiquidCrystal lcd(A0, A1, A2, A3, A4, A5);

void setup() {
    lcd.begin(16, 2);           // Set up the LCD with 16 columns and 2 rows
    pinMode(redLED, OUTPUT);    // Set LED pins as outputs
    pinMode(greenLED, OUTPUT);
    setLocked(true);            // Lock the system initially
}

void loop() {
    char whichKey = myKeypad.getKey();  // Detect which key is pressed

    lcd.setCursor(0, 0);
    lcd.print(" Welcome");
    lcd.setCursor(0, 1);
    lcd.print(" Enter Password");

    // Check for invalid keys
    if (whichKey == '*' || whichKey == '#' || whichKey == 'A' || 
        whichKey == 'B' || whichKey == 'C' || whichKey == 'D') {
        position = 0;
        setLocked(true);
        lcd.clear();
        lcd.setCursor(0, 0);
        lcd.print(" Invalid Key!");
        delay(1000);
        lcd.clear();
    }

    // Check if correct key is pressed
    if (whichKey == password[position]) {
        position++;
    }

    // If password is fully entered
    if (position == 4) {
        setLocked(false);
        lcd.clear();
        lcd.setCursor(0, 0);
        lcd.print("*** Verified ***");
        delay(3000);
        lcd.clear();
        lcd.setCursor(0, 0);
        lcd.print(" Hello Noella B");
        lcd.setCursor(0, 1);
        lcd.print("Congratulations");
        delay(7000);
        lcd.clear();
    }

    delay(100);
}

// Function to control LED status
void setLocked(int locked) {
    if (locked) {
        digitalWrite(redLED, HIGH);   // Red LED on
        digitalWrite(greenLED, LOW);  // Green LED off
    } else {
        digitalWrite(redLED, LOW);    // Red LED off
        digitalWrite(greenLED, HIGH); // Green LED on
    }
}
