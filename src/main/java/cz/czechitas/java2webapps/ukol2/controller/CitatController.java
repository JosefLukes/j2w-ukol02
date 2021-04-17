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




    public CitatController()  {
    }


    @GetMapping("/")
    public ModelAndView vyberCitat () throws IOException {
        Citat citatVybrany = new Citat();
        System.out.println(citatVybrany.getAutorCitatu());
        System.out.println(citatVybrany.getTextCitatu());
        ModelAndView result = new ModelAndView("citat");
        result.addObject("citace",citatVybrany);
        //result.addObject("citaceAutor",citatVybrany);
        return result;
    }





}
