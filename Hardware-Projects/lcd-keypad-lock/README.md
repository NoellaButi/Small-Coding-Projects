# Arduino LCD & Keypad Lock 🔒

This project is a **digital lock system** using an **LCD display, Keypad, and LED indicators**.

## 🛠️ Required Components
- **Arduino**
- **Arduino IDE**
- **USB cable**
- **Power supply**
- **Breadboard**
- **Resistors (220 Ω)**
- **LCD 1602**
- **Membrane Switch Keypad**
- **RGB LED**
- **Connecting wires**

## 📌 Features
✅ Displays `"Enter Password"` on the LCD.  
✅ Accepts a **4-digit password** using the **keypad**.  
✅ Shows `"*"` for each entered digit.  
✅ Pressing `#` checks the entered password:
   - ✅ **Correct password** → **Green LED** blinks for 2 seconds, displays `"Hello Noella B"` and `"Congratulations"`.  
   - ❌ **Incorrect password** → **Red LED** blinks, shows `"Invalid Key!"`, and resets.  

## 🔧 How to Run
1. **Connect the circuit** using a breadboard.
2. **Upload `lcd-keypad-lock.ino`** to the Arduino via **Arduino IDE**.
3. **Enter the password (`1234`)** using the keypad.
4. If correct, the **Green LED** lights up; if incorrect, the **Red LED** blinks.

## 📷 Circuit Diagram
![LCD](https://github.com/user-attachments/assets/3a10782b-a9f6-4453-984b-c91d6ecb8838)

