section .data
    menu_prompt db 'Menu:', 0xA
                db '1. View Profile', 0xA
                db '2. Edit Profile', 0xA
                db '3. Exit', 0xA
                db 'Enter your choice: ', 0
    menu_end equ $

section .bss
    choice resb 1

section .text
    global _start

_start:
    ; Display menu
    mov eax, 4         ; System call number for sys_write
    mov ebx, 1         ; File descriptor 1 (stdout)
    mov ecx, menu_prompt  ; Pointer to the message to write
    mov edx, menu_length ; Message length
    int 0x80           ; Call kernel

    ; Read user input
    mov eax, 3         ; System call number for sys_read
    mov ebx, 0         ; File descriptor 0 (stdin)
    mov ecx, choice    ; Pointer to the buffer to store input
    mov edx, 1         ; Maximum number of bytes to read
    int 0x80           ; Call kernel

    ; Check user choice
    cmp byte [choice], '1'
    je view_profile
    cmp byte [choice], '2'
    je edit_profile
    cmp byte [choice], '3'
    je exit_program
    jmp invalid_choice

view_profile:
    ; Code for viewing profile goes here
    ; For example:
    ; Display "View Profile" message
    ; Jump back to start to display the menu again
    jmp _start

edit_profile:
    ; Code for editing profile goes here
    ; For example:
    ; Display "Edit Profile" message
    ; Jump back to start to display the menu again
    jmp _start

exit_program:
    ; Exit the program
    mov eax, 1         ; System call number for sys_exit
    xor ebx, ebx       ; Exit code 0
    int 0x80           ; Call kernel

invalid_choice:
    ; Display "Invalid choice" message
    ; Jump back to start to display the menu again
    jmp _start

; Calculate the length of the menu_prompt string
menu_length equ menu_end - menu_prompt
