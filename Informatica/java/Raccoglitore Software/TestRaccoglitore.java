public class TestRaccoglitore {
    public static void main(String[] args) {
        Programma p1 = new Programma("prog1", "Intel", 500, "Windows", 1958);
        Programma p2 = new Programma("prog2", "AMD", 1024, "Linux", 2003);
        Programma p3 = new Programma("prog3", "Apple M1", 8192, "macOS", 2021);
        Programma p4 = new Programma("prog4", "Intel i7", 4096, "Windows 10", 2016);
        Programma p5 = new Programma("prog5", "ARM", 2048, "Android", 2018);
        Programma p6 = new Programma("prog6", "Qualcomm", 3072, "Linux", 2014);
        Programma p7 = new Programma("prog7", "Intel i9", 16384, "Windows 11", 2023);
        Programma p8 = new Programma("prog8", "AMD Ryzen 7", 8192, "Ubuntu", 2020);
        Programma p9 = new Programma("prog9", "RISC-V", 4096, "FreeBSD", 2022);

        Raccoglitore raccoglitore1 = new Raccoglitore(5);

        System.out.println(raccoglitore1.setProgramma(0, p1));
        System.out.println(raccoglitore1.setProgramma(1, p2));
        System.out.println(raccoglitore1.setProgramma(1, p3));
        System.out.println(raccoglitore1.setProgramma(2, p4));
        System.out.println(raccoglitore1.setProgramma(3, p5));
        System.out.println(raccoglitore1.getProgramma(0));
        ;
        System.out.println(raccoglitore1);
        System.out.println("Il numero di programmi presenti all'interno della cartella  è " + raccoglitore1.getN());
        System.out.println("Il programma con denominazione prog2 si trova nella posizione "
                + raccoglitore1.cercaProgrammaPerDenominazione("prog2"));
        System.out.println(raccoglitore1.killProgramma(2));
        System.out.println("Il numero di programmi presenti all'interno della cartella è " + raccoglitore1.getN());
        System.out.println(raccoglitore1);

        Raccoglitore raccoglitore2 = new Raccoglitore(5);

        System.out.println(raccoglitore2.setProgramma(0, p1));
        System.out.println(raccoglitore2.setProgramma(1, p6));
        System.out.println(raccoglitore2.setProgramma(2, p7));
        System.out.println(raccoglitore2.setProgramma(3, p8));
        System.out.println(raccoglitore2.setProgramma(4, p9));

        System.out.println("Il numero di programmi presenti in entrambe le cartelle è "
                + raccoglitore1.confrontaContenitore(raccoglitore2));

    }
}
