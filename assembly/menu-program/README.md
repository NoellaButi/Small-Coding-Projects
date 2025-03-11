# Assembly Menu Program 🖥️

This project is an interactive **menu-driven program written in Assembly**.  
It allows the user to:
- Choose options from a menu.
- Read and write input from the console.
- Use **labels, conditionals, and jumps**.

## 📌 Features
✅ Displays a **menu with multiple options**.  
✅ Reads user input from the console.  
✅ Uses **conditional jumps** to navigate options.  
✅ Includes an **exit option** to terminate the program.

## 🔧 How to Compile and Run (Linux)
1. **Assemble the program using NASM:**
   ```bash
   nasm -f elf32 Assembly.asm -o Assembly.o

   ld -m elf_i386 Assembly.o -o Assembly

   ./Assembly


