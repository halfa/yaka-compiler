;entete
extrn lirent:proc
extrn ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc
extrn ligsuiv:proc
.model SMALL
.586
.DATA
FALSE EQU 0
TRUE EQU -1
.CODE
ouvrePrinc 6
mov bp,sp
sub sp,6
;iload -2
push word ptr [bp-2]
;istore -10
pop ax
mov word ptr[bp-10],ax
SI1:
;iload -10
push word ptr [bp-10]
;iload -4
push word ptr [bp-4]
;iinf
pop bx
pop ax
cmp bx,ax
jge $+6
push TRUE
jmp $+4
push FALSE
;iffaux SINON1
pop ax
cmp ax,FALSE
je SINON1
;iload -10
push word ptr [bp-10]
   ;ireturn 12
   pop ax
mov [bp+12], ax
;jump FSI1
jmp FSI1
SINON1:
;iload -4
push word ptr [bp-4]
   ;ireturn 12
   pop ax
mov [bp+12], ax
FSI1:
ouvrePrinc 6
mov bp,sp
sub sp,6
SI2:
;iload -12
push word ptr [bp-12]
;iload -14
push word ptr [bp-14]
;iinf
pop bx
pop ax
cmp ax,bx
jge $+6
push TRUE
jmp $+4
push FALSE
;iffaux SINON2
pop ax
cmp ax,FALSE
je SINON2
;iload -12
push word ptr [bp-12]
   ;ireturn 14
   pop ax
mov [bp+14], ax
;jump FSI2
jmp FSI2
SINON2:
;iload -14
push word ptr [bp-14]
   ;ireturn 14
   pop ax
mov [bp+14], ax
FSI2:
ouvrePrinc 6
mov bp,sp
sub sp,6
;iload -16
push word ptr [bp-16]
;iload -18
push word ptr [bp-18]
;iinf
pop bx
pop ax
cmp bx,ax
jge $+6
push TRUE
jmp $+4
push FALSE
;ireturn 16
pop ax
mov [bp+16], ax
debut :
STARTUPCODE
main :
ouvrePrinc 14
mov bp,sp
sub sp,14
;iconst 5
push 5
;istore -20
pop ax
mov word ptr[bp-20],ax
;lireEnt -22
lea dx,[bp-22]
push dx
call lirent
;aLaLigne
call ligsuiv
;iload -20
push word ptr [bp-20]
;iload -22
push word ptr [bp-22]
;iconst 5
push 5
;iconst 2
push 2
;iadd
pop bx
pop ax
add ax,bx
push ax
;istore -24
pop ax
mov word ptr[bp-24],ax
;iconst 1
push 1
;iload -20
push word ptr [bp-20]
;iload -22
push word ptr [bp-22]
;iconst 5
push 5
;isub
pop bx
pop ax
sub ax,bx
push ax
;iadd
pop bx
pop ax
add ax,bx
push ax
;iload -20
push word ptr [bp-20]
;iconst 2
push 2
;imul
pop bx
pop ax
imul bx
push ax
;iload -22
push word ptr [bp-22]
;istore -26
pop ax
mov word ptr[bp-26],ax
;aLaLigne
call ligsuiv
;iload -24
push word ptr [bp-24]
;ecrireEnt
call ecrent
;aLaLigne
call ligsuiv
;iload -26
push word ptr [bp-26]
;ecrireEnt
call ecrent
;queue
nop
EXITCODE
end debut
