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
debut :
STARTUPCODE
;ouvrePrinc 14
mov bp,sp
sub sp,14
;iconst 10
push 10
;iconst 10
push 10
;iconst 2
push 2
;idiv
pop bx
pop ax
cwd
idiv bx
push bx
;iadd
pop bx
pop ax
add ax,bx
push bx
;iconst 5
push 5
;idiv
pop bx
pop ax
cwd
idiv bx
push bx
;istore -2
pop ax
mov word ptr[bp-2],ax
;iload -2
push word ptr [bp-2]
;iconst 3
push 3
;iload -2
push word ptr [bp-2]
;imul
pop bx
pop ax
imul bx
push bx
;iadd
pop bx
pop ax
add ax,bx
push bx
;iconst 10
push 10
;isub
pop bx
pop ax
sub ax,bx
push bx
;istore -4
pop ax
mov word ptr[bp-4],ax
;iconst -1
push -1
;iconst -1
push -1
;ior
pop bx
pop ax
or ax,bx
push ax
;istore -12
pop ax
mov word ptr[bp-12],ax
;iload -2
push word ptr [bp-2]
;iload -4
push word ptr [bp-4]
;iconst 4
push 4
;iadd
pop bx
pop ax
add ax,bx
push bx
;iinfegal
pop bx
pop ax
cmp ax,bx
jg $+6
push TRUE
jmp $+4
push FALSE
;istore -14
pop ax
mov word ptr[bp-14],ax
;queue
nop
EXITCODE
end debut
