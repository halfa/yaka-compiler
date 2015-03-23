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
;istore -6
pop ax
mov word ptr[bp-6],ax
SI1:
;iload -6
push word ptr [bp-6]
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
;iload -6
push word ptr [bp-6]
;jump FSI1
jmp FSI1
SINON1:
FSI1:
ouvrePrinc 6
mov bp,sp
sub sp,6
SI2:
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
;jump FSI2
jmp FSI2
SINON2:
FSI2:
ouvrePrinc 6
mov bp,sp
sub sp,6
;iinf
pop bx
pop ax
cmp bx,ax
jge $+6
push TRUE
jmp $+4
push FALSE
debut :
STARTUPCODE
main :
ouvrePrinc 14
mov bp,sp
sub sp,14
;iconst 5
push 5
;istore -8
pop ax
mov word ptr[bp-8],ax
;lireEnt -10
lea dx,[bp-10]
push dx
call lirent
;aLaLigne
call ligsuiv
;iload -8
push word ptr [bp-8]
;iload -10
push word ptr [bp-10]
;iconst 5
push 5
;iconst 2
push 2
;iadd
pop bx
pop ax
add ax,bx
push ax
;istore -12
pop ax
mov word ptr[bp-12],ax
;iconst 1
push 1
;iload -8
push word ptr [bp-8]
;iload -10
push word ptr [bp-10]
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
;iload -8
push word ptr [bp-8]
;iconst 2
push 2
;imul
pop bx
pop ax
imul bx
push ax
;iload -10
push word ptr [bp-10]
;istore -14
pop ax
mov word ptr[bp-14],ax
;aLaLigne
call ligsuiv
;iload -12
push word ptr [bp-12]
;ecrireEnt
call ecrent
;aLaLigne
call ligsuiv
;iload -14
push word ptr [bp-14]
;ecrireEnt
call ecrent
