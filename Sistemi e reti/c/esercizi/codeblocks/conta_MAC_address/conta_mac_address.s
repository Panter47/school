	.file	"main.c"
	.text
	.section .rdata,"dr"
.LC0:
	.ascii "r\0"
.LC1:
	.ascii "mac_list.txt\0"
.LC2:
	.ascii "errore di apertura file.\0"
.LC3:
	.ascii "%s\0"
.LC4:
	.ascii "\12il numero di righe e' %d\0"
	.text
	.globl	main
	.def	main;	.scl	2;	.type	32;	.endef
	.seh_proc	main
main:
	pushq	%rbp
	.seh_pushreg	%rbp
	movq	%rsp, %rbp
	.seh_setframe	%rbp, 0
	subq	$80, %rsp
	.seh_stackalloc	80
	.seh_endprologue
	call	__main
	leaq	.LC0(%rip), %rax
	movq	%rax, %rdx
	leaq	.LC1(%rip), %rax
	movq	%rax, %rcx
	call	fopen
	movq	%rax, -16(%rbp)
	cmpq	$0, -16(%rbp)
	jne	.L2
	leaq	.LC2(%rip), %rax
	movq	%rax, %rcx
	call	printf
	movl	$0, %eax
	jmp	.L8
.L2:
	movl	$0, -4(%rbp)
	jmp	.L4
.L5:
	leaq	-48(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC3(%rip), %rax
	movq	%rax, %rcx
	call	printf
	addl	$1, -4(%rbp)
.L4:
	movq	-16(%rbp), %rdx
	leaq	-48(%rbp), %rax
	movq	%rdx, %r8
	movl	$19, %edx
	movq	%rax, %rcx
	call	fgets
	testq	%rax, %rax
	jne	.L5
	movl	-4(%rbp), %eax
	movl	%eax, %edx
	leaq	.LC4(%rip), %rax
	movq	%rax, %rcx
	call	printf
	movq	-16(%rbp), %rax
	movq	%rax, %rcx
	call	fclose
	nop
.L7:
	call	getchar
	movl	%eax, -20(%rbp)
	cmpl	$10, -20(%rbp)
	je	.L6
	cmpl	$-1, -20(%rbp)
	jne	.L7
.L6:
	call	getchar
	movl	$0, %eax
.L8:
	addq	$80, %rsp
	popq	%rbp
	ret
	.seh_endproc
	.def	__main;	.scl	2;	.type	32;	.endef
	.ident	"GCC: (MinGW-W64 x86_64-ucrt-posix-seh, built by Brecht Sanders, r3) 14.2.0"
	.def	fopen;	.scl	2;	.type	32;	.endef
	.def	printf;	.scl	2;	.type	32;	.endef
	.def	fgets;	.scl	2;	.type	32;	.endef
	.def	fclose;	.scl	2;	.type	32;	.endef
	.def	getchar;	.scl	2;	.type	32;	.endef
