package uk.ac.ucl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PorterStemmer {

    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            System.out.println("usage:");
            System.out.println("PorterStemmer arg1 arg2 : stems \"arg1\" and \"arg2\"");
            System.out.println("PorterStemmer file://arg1.txt : Stems each line in file arg.txt. One word per line, please");
        } else {

            for (String word : args) {

                if (word.startsWith("file://")) {
                    BufferedReader br = null;

                    String sCurrentLine;

                    br = new BufferedReader(new FileReader(word.replace("file://", "")));

                    while ((sCurrentLine = br.readLine()) != null) {
                        stem(sCurrentLine);
                    }
                } else {
                    stem(word);
                }
            }
        }
    }

    public static void stem(String word) {
        PorterStemmerClass stemmer = new PorterStemmerClass();
        stemmer.add(word.toCharArray(), word.length());
        stemmer.stem();
        //System.out.println(word + " => " + stemmer.toString());
        System.out.println(stemmer.toString());
    }
}
