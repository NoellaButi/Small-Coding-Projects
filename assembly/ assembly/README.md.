# Assembly Projects 🖥️

This folder contains small Assembly programs.

## 📌 B.asm
- A simple Assembly program that prints **"Hello I am Noella"** 10 times using a loop.
- Uses **Linux system calls** (`sys_write` and `sys_exit`).

## 🔧 How to Run
To compile and run this program, follow these steps:

### **1️⃣ Assemble the Code**
Use the NASM assembler to create an object file:
```bash
nasm -f elf32 B.asm -o B.o

Link the object file using GNU ld:
ld -m elf_i386 B.o -o B

Run the executable:
./B

Running on a 64-bit System?
If you're using a 64-bit Linux system, you may need to install 32-bit compatibility libraries before running:
sudo apt update
sudo apt install gcc-multilib
