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
;ouvrePrinc 6
mov bp,sp
sub sp,6
;ecrireChaine "n="
.DATA
mess0 DB "n=$"
.CODE
lea dx, mess0
push dx
call ecrch
;lireEnt -6
lea dx,[bp-6]
push dx
call lirent
;iconst 1
push 1
;istore -4
pop ax
mov word ptr[bp-4],ax
;iconst 0
push 0
;istore -2
pop ax
mov word ptr[bp-2],ax
FAIRE1:
;iload -4
push word ptr [bp-4]
;iload -6
push word ptr [bp-6]
;iinfegal
pop bx
pop ax
cmp ax,bx
jg $+6
push TRUE
jmp $+4
push FALSE
;iffaux FAIT1
pop ax
cmp ax,FALSE
je FAIT1
;iload -2
push word ptr [bp-2]
;iload -4
push word ptr [bp-4]
;iadd
pop bx
pop ax
add ax,bx
push ax
;istore -2
pop ax
mov word ptr[bp-2],ax
;iload -4
push word ptr [bp-4]
;iconst 1
push 1
;iadd
pop bx
pop ax
add ax,bx
push ax
;istore -4
pop ax
mov word ptr[bp-4],ax
;ecrireChaine "i = "
.DATA
mess1 DB "i = $"
.CODE
lea dx, mess1
push dx
call ecrch
;iload -4
push word ptr [bp-4]
;ecrireEnt
call ecrent
;ecrireChaine "  s = "
.DATA
mess2 DB "  s = $"
.CODE
lea dx, mess2
push dx
call ecrch
;iload -2
push word ptr [bp-2]
;ecrireEnt
call ecrent
;aLaLigne
call ligsuiv
;jump FAIRE1
jmp FAIRE1
FAIT1:
;aLaLigne
call ligsuiv
;ecrireChaine "s="
.DATA
mess3 DB "s=$"
.CODE
lea dx, mess3
push dx
call ecrch
;iload -2
push word ptr [bp-2]
;ecrireEnt
call ecrent
;queue
nop
EXITCODE
end debut
