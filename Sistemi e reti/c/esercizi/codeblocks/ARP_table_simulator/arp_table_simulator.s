	.file	"main.c"
	.text
	.section .rdata,"dr"
.LC0:
	.ascii "w\0"
.LC1:
	.ascii "arp_table.txt\0"
.LC2:
	.ascii "errore di apertura file.\0"
.LC3:
	.ascii "inserire la coppia ip-mac: \0"
.LC4:
	.ascii "fine\12\0"
.LC5:
	.ascii "FINE\12\0"
.LC6:
	.ascii "%s\12\0"
.LC7:
	.ascii "chiusura del file\0"
.LC8:
	.ascii "r\0"
.LC9:
	.ascii "%s\0"
	.text
	.globl	main
	.def	main;	.scl	2;	.type	32;	.endef
	.seh_proc	main
main:
	pushq	%rbp
	.seh_pushreg	%rbp
	movq	%rsp, %rbp
	.seh_setframe	%rbp, 0
	subq	$176, %rsp
	.seh_stackalloc	176
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
	jmp	.L13
.L2:
	movl	$0, -4(%rbp)
.L7:
	leaq	.LC3(%rip), %rax
	movq	%rax, %rcx
	call	printf
	movl	$0, %ecx
	movq	__imp___acrt_iob_func(%rip), %rax
	call	*%rax
	movq	%rax, %rdx
	leaq	-144(%rbp), %rax
	movq	%rdx, %r8
	movl	$50, %edx
	movq	%rax, %rcx
	call	fgets
	leaq	-144(%rbp), %rax
	leaq	.LC4(%rip), %rdx
	movq	%rax, %rcx
	call	strcmp
	testl	%eax, %eax
	je	.L4
	leaq	-144(%rbp), %rax
	leaq	.LC5(%rip), %rdx
	movq	%rax, %rcx
	call	strcmp
	testl	%eax, %eax
	jne	.L5
.L4:
	addl	$1, -4(%rbp)
	jmp	.L6
.L5:
	leaq	-144(%rbp), %rdx
	movq	-16(%rbp), %rax
	movq	%rdx, %r8
	leaq	.LC6(%rip), %rdx
	movq	%rax, %rcx
	call	fprintf
.L6:
	cmpl	$1, -4(%rbp)
	jne	.L7
	movq	-16(%rbp), %rax
	movq	%rax, %rcx
	call	fclose
	leaq	.LC7(%rip), %rax
	movq	%rax, %rcx
	call	puts
	leaq	.LC8(%rip), %rax
	movq	%rax, %rdx
	leaq	.LC1(%rip), %rax
	movq	%rax, %rcx
	call	fopen
	movq	%rax, -16(%rbp)
	cmpq	$0, -16(%rbp)
	jne	.L9
	leaq	.LC2(%rip), %rax
	movq	%rax, %rcx
	call	printf
	movl	$0, %eax
	jmp	.L13
.L10:
	leaq	-80(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC9(%rip), %rax
	movq	%rax, %rcx
	call	printf
.L9:
	movq	-16(%rbp), %rdx
	leaq	-80(%rbp), %rax
	movq	%rdx, %r8
	movl	$50, %edx
	movq	%rax, %rcx
	call	fgets
	testq	%rax, %rax
	jne	.L10
	movq	-16(%rbp), %rax
	movq	%rax, %rcx
	call	fclose
	nop
.L12:
	call	getchar
	movl	%eax, -20(%rbp)
	cmpl	$10, -20(%rbp)
	je	.L11
	cmpl	$-1, -20(%rbp)
	jne	.L12
.L11:
	call	getchar
	movl	$0, %eax
.L13:
	addq	$176, %rsp
	popq	%rbp
	ret
	.seh_endproc
	.def	__main;	.scl	2;	.type	32;	.endef
	.ident	"GCC: (MinGW-W64 x86_64-ucrt-posix-seh, built by Brecht Sanders, r3) 14.2.0"
	.def	fopen;	.scl	2;	.type	32;	.endef
	.def	printf;	.scl	2;	.type	32;	.endef
	.def	fgets;	.scl	2;	.type	32;	.endef
	.def	strcmp;	.scl	2;	.type	32;	.endef
	.def	fprintf;	.scl	2;	.type	32;	.endef
	.def	fclose;	.scl	2;	.type	32;	.endef
	.def	puts;	.scl	2;	.type	32;	.endef
	.def	getchar;	.scl	2;	.type	32;	.endef
