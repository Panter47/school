#ifndef RANDIP_H_INCLUDED
#define RANDIP_H_INCLUDED

extern char classe;
extern unsigned char ip_subnet[4];
extern unsigned char ip_casuale[4];
extern char mask;

int  parse_cli(int argc, char* argv[]);

void generate_ip();

void print_help();

#endif // RANDIP_H_INCLUDED
