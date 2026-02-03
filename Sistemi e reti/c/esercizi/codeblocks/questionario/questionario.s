	.file	"main.c"
	.text
	.section .rdata,"dr"
	.align 8
.LC0:
	.ascii "\12------MENU QUESTIONARIO------\0"
.LC1:
	.ascii "1. esegui il questionario\0"
	.align 8
.LC2:
	.ascii "2. aggiungi domanda al questionario\0"
	.align 8
.LC3:
	.ascii "3. rimuovi domanda al questionario\0"
.LC4:
	.ascii "0. esci dal questionario\0"
.LC5:
	.ascii "seleziona un'opzione: \0"
	.text
	.globl	print_menu
	.def	print_menu;	.scl	2;	.type	32;	.endef
	.seh_proc	print_menu
print_menu:
	pushq	%rbp
	.seh_pushreg	%rbp
	movq	%rsp, %rbp
	.seh_setframe	%rbp, 0
	subq	$32, %rsp
	.seh_stackalloc	32
	.seh_endprologue
	leaq	.LC0(%rip), %rax
	movq	%rax, %rcx
	call	puts
	leaq	.LC1(%rip), %rax
	movq	%rax, %rcx
	call	puts
	leaq	.LC2(%rip), %rax
	movq	%rax, %rcx
	call	puts
	leaq	.LC3(%rip), %rax
	movq	%rax, %rcx
	call	puts
	leaq	.LC4(%rip), %rax
	movq	%rax, %rcx
	call	puts
	leaq	.LC5(%rip), %rax
	movq	%rax, %rcx
	call	printf
	nop
	addq	$32, %rsp
	popq	%rbp
	ret
	.seh_endproc
	.section .rdata,"dr"
.LC6:
	.ascii "%d\0"
.LC7:
	.ascii "r\0"
.LC8:
	.ascii "questionario.txt\0"
.LC9:
	.ascii "errore di apertura file.\0"
.LC10:
	.ascii "A\12\0"
.LC11:
	.ascii "B\12\0"
.LC12:
	.ascii "C\12\0"
.LC13:
	.ascii "D\12\0"
.LC14:
	.ascii "scegliere tra A,B,C,D: \0"
.LC15:
	.ascii "%s\0"
	.align 8
.LC16:
	.ascii "\12 hai totalizzato %d su %d risposte corrette\12\0"
.LC17:
	.ascii "a\0"
.LC18:
	.ascii "inserire il quesito: \0"
.LC19:
	.ascii " %[^\12]\0"
.LC20:
	.ascii "fine\0"
.LC21:
	.ascii "FINE\0"
.LC22:
	.ascii "%s\12\0"
.LC23:
	.ascii "inserire la %d risposta: \0"
	.align 8
.LC24:
	.ascii "inserisci l'opzione corretta (A o B o C o D): \0"
.LC25:
	.ascii "%s\12\12\0"
.LC26:
	.ascii "%d)%s\0"
.LC27:
	.ascii "\12\0"
.LC28:
	.ascii "%d)%.48s...\12\0"
	.align 8
.LC29:
	.ascii "quale quesito cancellare?(scrivere il numero accanto il quesito): \0"
.LC30:
	.ascii "w\0"
.LC31:
	.ascii "temp.txt\0"
	.align 8
.LC32:
	.ascii "\12il quesito %d e' stato eliminato\12\0"
	.align 8
.LC33:
	.ascii "-----------in uscita dal questionario------------\0"
	.text
	.globl	main
	.def	main;	.scl	2;	.type	32;	.endef
	.seh_proc	main
main:
	pushq	%rbp
	.seh_pushreg	%rbp
	subq	$368, %rsp
	.seh_stackalloc	368
	leaq	128(%rsp), %rbp
	.seh_setframe	%rbp, 128
	.seh_endprologue
	call	__main
.L33:
	call	print_menu
	leaq	176(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC6(%rip), %rax
	movq	%rax, %rcx
	call	scanf
	movl	176(%rbp), %eax
	cmpl	$3, %eax
	je	.L3
	cmpl	$3, %eax
	jg	.L4
	cmpl	$2, %eax
	je	.L5
	cmpl	$2, %eax
	jg	.L4
	testl	%eax, %eax
	je	.L6
	cmpl	$1, %eax
	jne	.L4
	leaq	.LC7(%rip), %rax
	movq	%rax, %rdx
	leaq	.LC8(%rip), %rax
	movq	%rax, %rcx
	call	fopen
	movq	%rax, 192(%rbp)
	cmpq	$0, 192(%rbp)
	jne	.L7
	leaq	.LC9(%rip), %rax
	movq	%rax, %rcx
	call	printf
	movl	$0, %eax
	jmp	.L34
.L7:
	movl	$1, 236(%rbp)
	movl	$0, 232(%rbp)
	jmp	.L9
.L12:
	addl	$1, 236(%rbp)
	leaq	-96(%rbp), %rax
	leaq	.LC10(%rip), %rdx
	movq	%rax, %rcx
	call	strcmp
	testl	%eax, %eax
	je	.L10
	leaq	-96(%rbp), %rax
	leaq	.LC11(%rip), %rdx
	movq	%rax, %rcx
	call	strcmp
	testl	%eax, %eax
	je	.L10
	leaq	-96(%rbp), %rax
	leaq	.LC12(%rip), %rdx
	movq	%rax, %rcx
	call	strcmp
	testl	%eax, %eax
	je	.L10
	leaq	-96(%rbp), %rax
	leaq	.LC13(%rip), %rdx
	movq	%rax, %rcx
	call	strcmp
	testl	%eax, %eax
	jne	.L11
.L10:
	movzbl	-96(%rbp), %edx
	movl	232(%rbp), %eax
	cltq
	movb	%dl, 144(%rbp,%rax)
	leaq	.LC14(%rip), %rax
	movq	%rax, %rcx
	call	printf
	movl	232(%rbp), %eax
	leal	1(%rax), %edx
	movl	%edx, 232(%rbp)
	leaq	112(%rbp), %rdx
	cltq
	addq	%rdx, %rax
	movq	%rax, %rdx
	leaq	.LC15(%rip), %rax
	movq	%rax, %rcx
	call	scanf
	jmp	.L9
.L11:
	leaq	-96(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC15(%rip), %rax
	movq	%rax, %rcx
	call	printf
.L9:
	movq	192(%rbp), %rdx
	leaq	-96(%rbp), %rax
	movq	%rdx, %r8
	movl	$200, %edx
	movq	%rax, %rcx
	call	fgets
	testq	%rax, %rax
	jne	.L12
	movl	$0, 228(%rbp)
	movl	$0, 224(%rbp)
	jmp	.L13
.L15:
	movl	224(%rbp), %eax
	cltq
	movzbl	144(%rbp,%rax), %edx
	movl	224(%rbp), %eax
	cltq
	movzbl	112(%rbp,%rax), %eax
	cmpb	%al, %dl
	jne	.L14
	addl	$1, 228(%rbp)
.L14:
	addl	$1, 224(%rbp)
.L13:
	movl	236(%rbp), %eax
	movslq	%eax, %rdx
	imulq	$715827883, %rdx, %rdx
	movq	%rdx, %rcx
	shrq	$32, %rcx
	cltd
	movl	%ecx, %eax
	subl	%edx, %eax
	cmpl	%eax, 224(%rbp)
	jl	.L15
	movq	192(%rbp), %rax
	movq	%rax, %rcx
	call	fclose
	movl	236(%rbp), %eax
	movslq	%eax, %rdx
	imulq	$715827883, %rdx, %rdx
	shrq	$32, %rdx
	sarl	$31, %eax
	subl	%eax, %edx
	movl	228(%rbp), %eax
	movl	%edx, %r8d
	movl	%eax, %edx
	leaq	.LC16(%rip), %rax
	movq	%rax, %rcx
	call	printf
	jmp	.L4
.L5:
	leaq	.LC17(%rip), %rax
	movq	%rax, %rdx
	leaq	.LC8(%rip), %rax
	movq	%rax, %rcx
	call	fopen
	movq	%rax, 192(%rbp)
	movl	$0, 220(%rbp)
.L21:
	leaq	.LC18(%rip), %rax
	movq	%rax, %rcx
	call	printf
	leaq	-96(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC19(%rip), %rax
	movq	%rax, %rcx
	call	scanf
	leaq	-96(%rbp), %rax
	leaq	.LC20(%rip), %rdx
	movq	%rax, %rcx
	call	strcmp
	testl	%eax, %eax
	je	.L16
	leaq	-96(%rbp), %rax
	leaq	.LC21(%rip), %rdx
	movq	%rax, %rcx
	call	strcmp
	testl	%eax, %eax
	jne	.L17
.L16:
	addl	$1, 220(%rbp)
	jmp	.L18
.L17:
	leaq	-96(%rbp), %rdx
	movq	192(%rbp), %rax
	movq	%rdx, %r8
	leaq	.LC22(%rip), %rdx
	movq	%rax, %rcx
	call	fprintf
	movl	$1, 216(%rbp)
	jmp	.L19
.L20:
	movl	216(%rbp), %eax
	movl	%eax, %edx
	leaq	.LC23(%rip), %rax
	movq	%rax, %rcx
	call	printf
	leaq	-96(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC19(%rip), %rax
	movq	%rax, %rcx
	call	scanf
	leaq	-96(%rbp), %rdx
	movq	192(%rbp), %rax
	movq	%rdx, %r8
	leaq	.LC22(%rip), %rdx
	movq	%rax, %rcx
	call	fprintf
	addl	$1, 216(%rbp)
.L19:
	cmpl	$4, 216(%rbp)
	jle	.L20
	leaq	.LC24(%rip), %rax
	movq	%rax, %rcx
	call	printf
	leaq	-96(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC19(%rip), %rax
	movq	%rax, %rcx
	call	scanf
	leaq	-96(%rbp), %rdx
	movq	192(%rbp), %rax
	movq	%rdx, %r8
	leaq	.LC25(%rip), %rdx
	movq	%rax, %rcx
	call	fprintf
.L18:
	cmpl	$1, 220(%rbp)
	jne	.L21
	movq	192(%rbp), %rax
	movq	%rax, %rcx
	call	fclose
	jmp	.L4
.L3:
	leaq	.LC7(%rip), %rax
	movq	%rax, %rdx
	leaq	.LC8(%rip), %rax
	movq	%rax, %rcx
	call	fopen
	movq	%rax, 192(%rbp)
	movl	$1, 212(%rbp)
	movl	$1, 208(%rbp)
	movl	$1, 204(%rbp)
	jmp	.L22
.L27:
	movl	212(%rbp), %eax
	cmpl	208(%rbp), %eax
	jne	.L23
	addl	$7, 208(%rbp)
	leaq	-96(%rbp), %rax
	movq	%rax, %rcx
	call	strlen
	cmpq	$49, %rax
	ja	.L24
	leaq	-96(%rbp), %rdx
	movl	204(%rbp), %eax
	movq	%rdx, %r8
	movl	%eax, %edx
	leaq	.LC26(%rip), %rax
	movq	%rax, %rcx
	call	printf
	jmp	.L25
.L24:
	leaq	-96(%rbp), %rax
	leaq	.LC27(%rip), %rdx
	movq	%rax, %rcx
	call	strcspn
	movb	$0, -96(%rbp,%rax)
	leaq	-96(%rbp), %rdx
	movl	204(%rbp), %eax
	movq	%rdx, %r8
	movl	%eax, %edx
	leaq	.LC28(%rip), %rax
	movq	%rax, %rcx
	call	printf
	nop
.L26:
	movq	192(%rbp), %rax
	movq	%rax, %rcx
	call	fgetc
	movl	%eax, 180(%rbp)
	cmpl	$10, 180(%rbp)
	je	.L25
	cmpl	$-1, 180(%rbp)
	jne	.L26
.L25:
	addl	$1, 204(%rbp)
.L23:
	addl	$1, 212(%rbp)
.L22:
	movq	192(%rbp), %rdx
	leaq	-96(%rbp), %rax
	movq	%rdx, %r8
	movl	$200, %edx
	movq	%rax, %rcx
	call	fgets
	testq	%rax, %rax
	jne	.L27
	movq	192(%rbp), %rax
	movq	%rax, %rcx
	call	fclose
	leaq	.LC29(%rip), %rax
	movq	%rax, %rcx
	call	printf
	leaq	108(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC6(%rip), %rax
	movq	%rax, %rcx
	call	scanf
	leaq	.LC7(%rip), %rax
	movq	%rax, %rdx
	leaq	.LC8(%rip), %rax
	movq	%rax, %rcx
	call	fopen
	movq	%rax, 192(%rbp)
	leaq	.LC30(%rip), %rax
	movq	%rax, %rdx
	leaq	.LC31(%rip), %rax
	movq	%rax, %rcx
	call	fopen
	movq	%rax, 184(%rbp)
	movl	$1, 212(%rbp)
	jmp	.L28
.L30:
	movl	108(%rbp), %eax
	leal	-1(%rax), %edx
	movl	%edx, %eax
	sall	$3, %eax
	subl	%edx, %eax
	addl	$1, %eax
	cmpl	%eax, 212(%rbp)
	je	.L29
	movl	108(%rbp), %eax
	leal	-1(%rax), %edx
	movl	%edx, %eax
	sall	$3, %eax
	subl	%edx, %eax
	addl	$2, %eax
	cmpl	%eax, 212(%rbp)
	je	.L29
	movl	108(%rbp), %eax
	leal	-1(%rax), %edx
	movl	%edx, %eax
	sall	$3, %eax
	subl	%edx, %eax
	addl	$3, %eax
	cmpl	%eax, 212(%rbp)
	je	.L29
	movl	108(%rbp), %eax
	leal	-1(%rax), %edx
	movl	%edx, %eax
	sall	$3, %eax
	subl	%edx, %eax
	addl	$4, %eax
	cmpl	%eax, 212(%rbp)
	je	.L29
	movl	108(%rbp), %eax
	leal	-1(%rax), %edx
	movl	%edx, %eax
	sall	$3, %eax
	subl	%edx, %eax
	addl	$5, %eax
	cmpl	%eax, 212(%rbp)
	je	.L29
	movl	108(%rbp), %eax
	leal	-1(%rax), %edx
	movl	%edx, %eax
	sall	$3, %eax
	subl	%edx, %eax
	addl	$6, %eax
	cmpl	%eax, 212(%rbp)
	je	.L29
	movl	108(%rbp), %edx
	movl	%edx, %eax
	sall	$3, %eax
	subl	%edx, %eax
	cmpl	%eax, 212(%rbp)
	je	.L29
	movq	184(%rbp), %rdx
	leaq	-96(%rbp), %rax
	movq	%rax, %rcx
	call	fputs
.L29:
	addl	$1, 212(%rbp)
.L28:
	movq	192(%rbp), %rdx
	leaq	-96(%rbp), %rax
	movq	%rdx, %r8
	movl	$200, %edx
	movq	%rax, %rcx
	call	fgets
	testq	%rax, %rax
	jne	.L30
	movq	192(%rbp), %rax
	movq	%rax, %rcx
	call	fclose
	movq	184(%rbp), %rax
	movq	%rax, %rcx
	call	fclose
	leaq	.LC30(%rip), %rax
	movq	%rax, %rdx
	leaq	.LC8(%rip), %rax
	movq	%rax, %rcx
	call	fopen
	movq	%rax, 192(%rbp)
	leaq	.LC7(%rip), %rax
	movq	%rax, %rdx
	leaq	.LC31(%rip), %rax
	movq	%rax, %rcx
	call	fopen
	movq	%rax, 184(%rbp)
	jmp	.L31
.L32:
	movq	192(%rbp), %rdx
	leaq	-96(%rbp), %rax
	movq	%rax, %rcx
	call	fputs
.L31:
	movq	184(%rbp), %rdx
	leaq	-96(%rbp), %rax
	movq	%rdx, %r8
	movl	$200, %edx
	movq	%rax, %rcx
	call	fgets
	testq	%rax, %rax
	jne	.L32
	movq	184(%rbp), %rax
	movq	%rax, %rcx
	call	fclose
	movq	192(%rbp), %rax
	movq	%rax, %rcx
	call	fclose
	movl	108(%rbp), %eax
	movl	%eax, %edx
	leaq	.LC32(%rip), %rax
	movq	%rax, %rcx
	call	printf
	jmp	.L4
.L6:
	leaq	.LC33(%rip), %rax
	movq	%rax, %rcx
	call	printf
	nop
.L4:
	movl	176(%rbp), %eax
	testl	%eax, %eax
	jne	.L33
	movl	$0, %eax
.L34:
	addq	$368, %rsp
	popq	%rbp
	ret
	.seh_endproc
	.def	__main;	.scl	2;	.type	32;	.endef
	.ident	"GCC: (MinGW-W64 x86_64-ucrt-posix-seh, built by Brecht Sanders, r3) 14.2.0"
	.def	puts;	.scl	2;	.type	32;	.endef
	.def	printf;	.scl	2;	.type	32;	.endef
	.def	scanf;	.scl	2;	.type	32;	.endef
	.def	fopen;	.scl	2;	.type	32;	.endef
	.def	strcmp;	.scl	2;	.type	32;	.endef
	.def	fgets;	.scl	2;	.type	32;	.endef
	.def	fclose;	.scl	2;	.type	32;	.endef
	.def	fprintf;	.scl	2;	.type	32;	.endef
	.def	strlen;	.scl	2;	.type	32;	.endef
	.def	strcspn;	.scl	2;	.type	32;	.endef
	.def	fgetc;	.scl	2;	.type	32;	.endef
	.def	fputs;	.scl	2;	.type	32;	.endef
