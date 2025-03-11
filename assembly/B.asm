.section .text         # Holds the code
    .global main       # Declare entry point

main:                  # Entry point
    mov $10, %esi      # Loop counter (10 times)

loop:
    mov $4, %eax       # syscall: sys_write
    mov $1, %ebx       # file descriptor: stdout
    mov $msg, %ecx     # message address
    mov $len, %edx     # message length
    int $0x80          # execute syscall

    dec %esi           # Decrease loop counter
    jnz loop           # Jump if not zero

    mov $1, %eax       # syscall: sys_exit
    mov $0, %ebx       # return 0
    int $0x80          # execute syscall

.section .data
    msg: .asciz "Hello I am Noella\n"  # Message with null terminator
    len: .equ . - msg                  # Calculate correct message length
