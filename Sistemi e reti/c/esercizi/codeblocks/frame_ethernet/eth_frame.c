#include "eth_frame.h"
#include <string.h>

int read_frame_from_text_file(FILE *fp, uint8_t *buf, size_t bufsize)
{

    char line[bufsize];
    int x=0,j=0;
    while(fp == NULL)
    {
        if(fgets(line,bufsize,fp)!= NULL)
        {
            if(line[0] != ' ' || line[0] !='#')
            {
                while (line[x] != '\0')
                {
                    if (line[x] != ' ')
                    {
                        line[j++] = line[x];
                    }
                    x++;
                }
                line[j] = '\0';
                return hex_to_bytes(line,buf,bufsize);
            }
            else
            {

            }
        }
        else
            return 0;
    }
    return 0;

//Buon lavoro!
}


int hex_to_bytes(const char *hex,uint8_t *buf,size_t bufsize)
{
    int j=0,n1,n2;
    size_t len=strlen(hex);

    if(len%2!=0 || bufsize<len/2)
        return -1;
    for(int i=0;i<len;i++){
        char h=hex[i], l=hex[++i];
        if(h>='0' && h<='9')
            n1=h-'0';
        else if(h>='a' && h<='f')
            n1=h-'a'+10;
        else if(h>='A' && h<='F')
            n1=h-'A'+10;
        else
            return -1;
        if(l>='0' && l<='9')
            n2=l-'0';
        else if(l>='a' && l<='f')
            n2=l-'a'+10;
        else if(l>='A' && l<='F')
            n2=l-'A'+10;
        else
            return -1;
        buf[j++]=(n1<<4)|n2;
    }
    return len/2;
}

int parse_ethernet(const payload_t *buf, eth_frame_t *eth) {

    int i=0;
    if(buf->len<14)
        return -1;

    const uint8_t *line=buf->data;

    for(int z=0;z<6;z++) {
        eth->dst.bytes[z]=line[i++];
    }
    for(int z=0;z<6;z++) {
        eth->src.bytes[z]=line[i++];
    }
    eth->type_or_len=(line[i++]<<8)|line[i++];
    eth->payload.len=buf->len-14;
    eth->total_len=buf->len;
    /*if(buf->len<0x0600)
        parse_llc(buf,);
    else
        parse_snap(buf,);*/
    return buf->len;
}

void print_mac(const mac_addr_t *mac, char separator, int decode){

    printf("%02x%c%02x%c%02x%c%02x%c%02x%c%02x", mac->bytes[0], separator, mac->bytes[1], separator, mac->bytes[2], separator, mac->bytes[3], separator, mac->bytes[4], separator, mac->bytes[5]);

    if(decode !=0) {
        if(mac->bytes[0]==0x01)
            printf(" multicast, ");
        else
            printf(" unicast, ");
        if(mac->bytes[1]==0x02)
            printf("locale\n");
        else
            printf("universale\n");
    }
    else
        printf("\n");
}

void print_eth_summary(const eth_frame_t *eth) {

    printf("------ETHERNET FRAME------\n");
    printf("MAC destinazione: ");
    print_mac(&eth->dst,':',1);
    printf("MAC sorgente: ");
    print_mac(&eth->src,':',1);

    printf("Type: 0x%04X\n", eth->type_or_len);

     printf("Lunghezza: %u byte\n", eth->total_len);
     printf("Lunghezza Payload: %zu byte\n", eth->payload.len);
}

int parse_llc(payload_t *raw, llc_pdu_t *llc){

    int i=0;
    if(raw->len<3)
        return -1;

    const uint8_t *line=raw->data+14;

    llc->dsap=line[i++];
    llc->ssap=line[i++];
    llc->control=line[i++];
    llc->payload.data=line;
    llc->payload.len=raw->len-3;
    parse_snap(raw->data,);
    return raw->len;
}

int parse_snap(payload_t *raw, snap_pdu_t *snap){
    int i=0;

    if(raw->len<5)
        return -1;

    const uint8_t *line=raw->data+14;

    for(int z=0;z<3;z++)
        snap->oui[z]=line[i++];

    snap->protocol_id=(line[i++]<<8)|line[i++];
    snap->payload.len=raw->len-5;
    snap->payload.data=raw->data;

    return 0;

}
