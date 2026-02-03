	.file	"TERNE_PITAGORICHE - Kpante.c"
	.text
	.def	__main;	.scl	2;	.type	32;	.endef
	.section .rdata,"dr"
	.align 8
.LC0:
	.ascii "inserire il valore di numero massimo che devono avere i valori della terna pitagorica: \0"
.LC1:
	.ascii "%d\0"
	.align 8
.LC2:
	.ascii "\12questa e' una terna pitagorica trovata prima di %d  %d+%d=%d\0"
	.text
	.globl	main
	.def	main;	.scl	2;	.type	32;	.endef
	.seh_proc	main
main:
	pushq	%rbp
	.seh_pushreg	%rbp
	movq	%rsp, %rbp
	.seh_setframe	%rbp, 0
	subq	$64, %rsp
	.seh_stackalloc	64
	.seh_endprologue
	call	__main
	leaq	.LC0(%rip), %rcx
	call	printf
	leaq	-16(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC1(%rip), %rcx
	call	scanf
	movl	$1, -4(%rbp)
	jmp	.L2
.L8:
	movl	-4(%rbp), %eax
	movl	%eax, -8(%rbp)
	jmp	.L3
.L7:
	movl	-4(%rbp), %eax
	movl	%eax, -12(%rbp)
	jmp	.L4
.L6:
	movl	-4(%rbp), %eax
	imull	-4(%rbp), %eax
	movl	%eax, %edx
	movl	-8(%rbp), %eax
	imull	-8(%rbp), %eax
	addl	%eax, %edx
	movl	-12(%rbp), %eax
	imull	-12(%rbp), %eax
	cmpl	%eax, %edx
	jne	.L5
	movl	-16(%rbp), %eax
	movl	-8(%rbp), %r8d
	movl	-4(%rbp), %ecx
	movl	-12(%rbp), %edx
	movl	%edx, 32(%rsp)
	movl	%r8d, %r9d
	movl	%ecx, %r8d
	movl	%eax, %edx
	leaq	.LC2(%rip), %rcx
	call	printf
.L5:
	addl	$1, -12(%rbp)
.L4:
	movl	-16(%rbp), %eax
	cmpl	%eax, -12(%rbp)
	jl	.L6
	addl	$1, -8(%rbp)
.L3:
	movl	-16(%rbp), %eax
	cmpl	%eax, -8(%rbp)
	jl	.L7
	addl	$1, -4(%rbp)
.L2:
	movl	-16(%rbp), %eax
	cmpl	%eax, -4(%rbp)
	jl	.L8
	movl	$0, %eax
	addq	$64, %rsp
	popq	%rbp
	ret
	.seh_endproc
	.ident	"GCC: (x86_64-posix-seh-rev0, Built by MinGW-W64 project) 8.1.0"
	.def	printf;	.scl	2;	.type	32;	.endef
	.def	scanf;	.scl	2;	.type	32;	.endef
