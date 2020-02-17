/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Mobile Apps
 */
public class PoemGenerator {

     public List<String> getWords() throws IOException, FileNotFoundException {

        List<String> words = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("D://poem.txt"));

        String lines;
        while ((lines = br.readLine()) != null) {
            words.add(lines);
        }

        return words;

    }

    
}
