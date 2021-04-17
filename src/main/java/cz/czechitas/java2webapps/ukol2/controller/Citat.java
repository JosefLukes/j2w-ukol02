package cz.czechitas.java2webapps.ukol2.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Citat {
    private String textCitatu;
    private String autorCitatu;
    private List<String> citatyVsechny;
    private String[] radekNaRozdeleni;
    Random rand = new Random();
    String cesta = "./templates/citaty.txt";


    //System.out.println(citatVybrany);
    //int cisloRadku = rand.nextInt(citaty.size());
    //String citatVybrany = citaty.get(cisloRadku);

    public Citat() throws IOException {
        this.citatyVsechny = readAllLines(cesta);
        int cisloRadku = rand.nextInt(citatyVsechny.size());
        this.radekNaRozdeleni = citatyVsechny.get(cisloRadku).split(";");
        this.textCitatu = radekNaRozdeleni[0];
        this.autorCitatu = radekNaRozdeleni[1];
    }

/*    public Citat(String cestaNova) throws IOException {
        this.citatyVsechny = readAllLines(cestaNova);

    }*/




    public String getTextCitatu() {
        return textCitatu;
    }

    public void setTextCitatu(String textCitatu) {
        this.textCitatu = textCitatu;
    }

    public String getAutorCitatu() {
        return autorCitatu;
    }

    public void setAutorCitatu(String autorCitatu) {
        this.autorCitatu = autorCitatu;
    }

    private static List<String> readAllLines(String resource) throws IOException {
        //Soubory z resources se získávají pomocí classloaderu. Nejprve musíme získat aktuální classloader.
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        //Pomocí metody getResourceAsStream() získáme z classloaderu InpuStream, který čte z příslušného souboru.
        //Následně InputStream převedeme na BufferedRead, který čte text v kódování UTF-8
        try (InputStream inputStream = classLoader.getResourceAsStream(resource);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            //Metoda lines() vrací stream řádků ze souboru. Pomocí kolektoru převedeme Stream<String> na List<String>.
            return reader
                    .lines()
                    .collect(Collectors.toList());
        }
    }
}
