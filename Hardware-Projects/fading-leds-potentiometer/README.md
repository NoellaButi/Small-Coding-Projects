# Arduino Fading LEDs with Potentiometer 🎛️

This project demonstrates **LED fading** using a **potentiometer and PWM (Pulse Width Modulation)**.

## 🛠️ Components Used
- **Arduino Uno**
- **6 LEDs**
- **Resistors (220Ω)**
- **Potentiometer**
- **Breadboard & Jumper Wires**
- **Power Supply**

## 📌 Features
✅ **Part A:** LED brightness decreases and increases gradually based on a **fixed step size**.  
✅ **Part B:** Reads the **potentiometer value dynamically** to adjust the fade rate.  
✅ **Part D:** LEDs light up in **reverse gradient pattern** (LED6 off → LED1 fully bright).  

## 🔧 How to Run
1. **Connect the circuit** using **PWM pins (3, 5, 6, 9, 10, 11)**.
2. **Upload the respective `.ino` file** to the Arduino via **Arduino IDE**.
3. **Turn the potentiometer** to control the fading effect dynamically (Part B).
4. Observe LED brightness patterns in **Part D**.
