/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.project.mavenproject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> els = null;
        try {
            File input = new File(args[0]);
            Document doc = Jsoup.parse(input, "UTF-8");
            //Document doc = Jsoup.connect(args[0]).get();
            Element el = doc.getElementById(args[1]);
            els = new ArrayList<>();
            while (el.parent() != null) {
                els.add(el.tagName());
                el = el.parent();
            }
            Collections.sort(els, Collections.reverseOrder());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(els.stream().map(Object::toString).collect(Collectors.joining(">")));
    }
}
