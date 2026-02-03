	.file	"dado.c"
	.text
	.def	__main;	.scl	2;	.type	32;	.endef
	.section .rdata,"dr"
	.align 8
.LC0:
	.ascii "a quante facce si vuole il dado? \0"
.LC1:
	.ascii "%d\0"
	.align 8
.LC2:
	.ascii "quanti dadi si vogliono usare? \0"
	.align 8
.LC3:
	.ascii "quanti lanci si vogliono eseguire? \0"
	.align 8
.LC4:
	.ascii "\12del dado numero %d e' uscito il numero %d e' uscito %d volte\0"
	.text
	.globl	main
	.def	main;	.scl	2;	.type	32;	.endef
	.seh_proc	main
main:
	pushq	%rbp
	.seh_pushreg	%rbp
	pushq	%r15
	.seh_pushreg	%r15
	pushq	%r14
	.seh_pushreg	%r14
	pushq	%r13
	.seh_pushreg	%r13
	pushq	%r12
	.seh_pushreg	%r12
	pushq	%rdi
	.seh_pushreg	%rdi
	pushq	%rsi
	.seh_pushreg	%rsi
	pushq	%rbx
	.seh_pushreg	%rbx
	subq	$152, %rsp
	.seh_stackalloc	152
	leaq	128(%rsp), %rbp
	.seh_setframe	%rbp, 128
	.seh_endprologue
	call	__main
	movq	%rsp, %rax
	movq	%rax, -88(%rbp)
	movl	$0, %ecx
	call	time
	movl	%eax, %ecx
	call	srand
	movl	$1, 4(%rbp)
	leaq	.LC0(%rip), %rcx
	call	printf
	leaq	-36(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC1(%rip), %rcx
	call	scanf
	leaq	.LC2(%rip), %rcx
	call	printf
	leaq	-40(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC1(%rip), %rcx
	call	scanf
	leaq	.LC3(%rip), %rcx
	call	printf
	leaq	-32(%rbp), %rax
	movq	%rax, %rdx
	leaq	.LC1(%rip), %rcx
	call	scanf
	movl	-36(%rbp), %ecx
	movl	-40(%rbp), %r8d
	movslq	%ecx, %rax
	subq	$1, %rax
	movq	%rax, -8(%rbp)
	movslq	%ecx, %rax
	movq	%rax, -80(%rbp)
	movq	$0, -72(%rbp)
	movslq	%ecx, %rax
	leaq	0(,%rax,4), %rdi
	movslq	%r8d, %rax
	subq	$1, %rax
	movq	%rax, -16(%rbp)
	movslq	%ecx, %rax
	movq	%rax, -64(%rbp)
	movq	$0, -56(%rbp)
	movslq	%r8d, %rax
	movq	%rax, %r14
	movl	$0, %r15d
	movq	-64(%rbp), %r10
	movq	-56(%rbp), %r11
	movq	%r11, %rdx
	imulq	%r14, %rdx
	movq	%r10, %rax
	imulq	%r15, %rax
	leaq	(%rdx,%rax), %r9
	movq	%r10, %rax
	mulq	%r14
	addq	%rdx, %r9
	movq	%r9, %rdx
	movslq	%ecx, %rax
	movq	%rax, %r12
	movl	$0, %r13d
	movslq	%r8d, %rax
	movq	%rax, %rbx
	movl	$0, %esi
	movq	%r13, %rdx
	imulq	%rbx, %rdx
	movq	%rsi, %rax
	imulq	%r12, %rax
	leaq	(%rdx,%rax), %r9
	movq	%r12, %rax
	mulq	%rbx
	addq	%rdx, %r9
	movq	%r9, %rdx
	movslq	%ecx, %rdx
	movslq	%r8d, %rax
	imulq	%rdx, %rax
	salq	$2, %rax
	addq	$15, %rax
	shrq	$4, %rax
	salq	$4, %rax
	call	___chkstk_ms
	subq	%rax, %rsp
	leaq	32(%rsp), %rax
	addq	$3, %rax
	shrq	$2, %rax
	salq	$2, %rax
	movq	%rax, -24(%rbp)
	movl	$0, 8(%rbp)
	jmp	.L2
.L5:
	movl	$0, 4(%rbp)
	jmp	.L3
.L4:
	movq	%rdi, %r8
	shrq	$2, %r8
	movq	-24(%rbp), %rax
	movl	4(%rbp), %edx
	movslq	%edx, %rcx
	movl	8(%rbp), %edx
	movslq	%edx, %rdx
	imulq	%r8, %rdx
	addq	%rcx, %rdx
	movl	$0, (%rax,%rdx,4)
	addl	$1, 4(%rbp)
.L3:
	movl	-32(%rbp), %eax
	cmpl	%eax, 4(%rbp)
	jl	.L4
	addl	$1, 8(%rbp)
.L2:
	movl	-40(%rbp), %eax
	cmpl	%eax, 8(%rbp)
	jl	.L5
	movl	$0, 8(%rbp)
	jmp	.L6
.L9:
	movl	$0, 12(%rbp)
	jmp	.L7
.L8:
	call	rand
	movl	-36(%rbp), %ecx
	cltd
	idivl	%ecx
	movl	%edx, %eax
	addl	$1, %eax
	movl	%eax, -28(%rbp)
	movq	%rdi, %rax
	shrq	$2, %rax
	movq	-24(%rbp), %rcx
	movl	-28(%rbp), %edx
	movslq	%edx, %r8
	movl	8(%rbp), %edx
	movslq	%edx, %rdx
	imulq	%rax, %rdx
	addq	%r8, %rdx
	movl	(%rcx,%rdx,4), %edx
	leal	1(%rdx), %ecx
	movq	-24(%rbp), %rdx
	movl	-28(%rbp), %r8d
	movslq	%r8d, %r8
	movl	8(%rbp), %r9d
	movslq	%r9d, %r9
	imulq	%r9, %rax
	addq	%r8, %rax
	movl	%ecx, (%rdx,%rax,4)
	addl	$1, 12(%rbp)
.L7:
	movl	-32(%rbp), %eax
	cmpl	%eax, 12(%rbp)
	jl	.L8
	addl	$1, 8(%rbp)
.L6:
	movl	-40(%rbp), %eax
	cmpl	%eax, 8(%rbp)
	jle	.L9
	movl	$1, 8(%rbp)
	jmp	.L10
.L13:
	movl	$1, 4(%rbp)
	movl	$0, 12(%rbp)
	jmp	.L11
.L12:
	movq	%rdi, %r8
	shrq	$2, %r8
	movq	-24(%rbp), %rax
	movl	12(%rbp), %edx
	movslq	%edx, %rcx
	movl	8(%rbp), %edx
	movslq	%edx, %rdx
	imulq	%r8, %rdx
	addq	%rcx, %rdx
	movl	(%rax,%rdx,4), %ecx
	movl	12(%rbp), %eax
	leal	1(%rax), %edx
	movl	8(%rbp), %eax
	movl	%ecx, %r9d
	movl	%edx, %r8d
	movl	%eax, %edx
	leaq	.LC4(%rip), %rcx
	call	printf
	addl	$1, 4(%rbp)
	addl	$1, 12(%rbp)
.L11:
	movl	-36(%rbp), %eax
	cmpl	%eax, 12(%rbp)
	jl	.L12
	addl	$1, 8(%rbp)
.L10:
	movl	-40(%rbp), %eax
	cmpl	%eax, 8(%rbp)
	jle	.L13
	movl	$0, %eax
	movq	-88(%rbp), %rsp
	leaq	24(%rbp), %rsp
	popq	%rbx
	popq	%rsi
	popq	%rdi
	popq	%r12
	popq	%r13
	popq	%r14
	popq	%r15
	popq	%rbp
	ret
	.seh_endproc
	.ident	"GCC: (x86_64-posix-seh-rev0, Built by MinGW-W64 project) 8.1.0"
	.def	time;	.scl	2;	.type	32;	.endef
	.def	srand;	.scl	2;	.type	32;	.endef
	.def	printf;	.scl	2;	.type	32;	.endef
	.def	scanf;	.scl	2;	.type	32;	.endef
	.def	rand;	.scl	2;	.type	32;	.endef
