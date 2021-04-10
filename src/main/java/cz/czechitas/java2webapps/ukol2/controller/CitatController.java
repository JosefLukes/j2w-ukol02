package cz.czechitas.java2webapps.ukol2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class CitatController {

    @GetMapping("/")
    public ModelAndView vyberCitat () throws IOException {
        Random rand = new Random();
        String cesta = "./templates/citaty.txt";
        List<String> citaty = readAllLines(cesta);


        int cisloRadku = rand.nextInt(citaty.size());
        String citatVybrany = citaty.get(cisloRadku);
        System.out.println(citatVybrany);
        ModelAndView result = new ModelAndView("citat");
        result.addObject("citace",citatVybrany);
        return result;
    }


    private static List<String> readAllLines(String resource)throws IOException {
        //Soubory z resources se získávají pomocí classloaderu. Nejprve musíme získat aktuální classloader.
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();

        //Pomocí metody getResourceAsStream() získáme z classloaderu InpuStream, který čte z příslušného souboru.
        //Následně InputStream převedeme na BufferedRead, který čte text v kódování UTF-8
        try(InputStream inputStream=classLoader.getResourceAsStream(resource);
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))){

            //Metoda lines() vrací stream řádků ze souboru. Pomocí kolektoru převedeme Stream<String> na List<String>.
            return reader
                    .lines()
                    .collect(Collectors.toList());
        }
    }


}
