//Author: Noella Buti
//CS 370 IoT
//13 April 2024
//LAB ASSIGNMENT 1

//Experiment #1

int delay_dur = 1000; // delay of 1000ms

void setup() {
  int i;
  for (i = 6; i <= 13; i++) {
    pinMode(i, OUTPUT); // set pins 6 to 13 as output
    digitalWrite(i, LOW); // initialize LEDs to off
  }
}

void loop() {
  int i;
  // left to right LED glow
  for (i = 6; i <= 13; i++) {
    digitalWrite(i, HIGH);
    delay(delay_dur);
  }
  // right to left LED glow
  for (i = 13; i >= 6; i--) {
    digitalWrite(i, LOW);
    delay(delay_dur);
  }
}
