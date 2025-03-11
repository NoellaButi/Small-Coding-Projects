//Author: Noella Buti
//CS 370 IoT
//13 April 2024
//LAB ASSIGNMENT 1

//Experiment #2

int delay_dur = 1000; // delay of 1000ms

void setup() {
  int i;
  for (i = 7; i <= 13; i += 2) {
    pinMode(i, OUTPUT); // set odd pins 7 to 13 as output
    digitalWrite(i, LOW); // initialize LEDs to off
  }
}

void loop() {
  int i;
  // left to right odd LED glow
  for (i = 7; i <= 13; i += 2) {
    digitalWrite(i, HIGH);
    delay(delay_dur);
  }
  // right to left odd LED glow
  for (i = 13; i >= 7; i -= 2) {
    digitalWrite(i, LOW);
    delay(delay_dur);
  }
}
