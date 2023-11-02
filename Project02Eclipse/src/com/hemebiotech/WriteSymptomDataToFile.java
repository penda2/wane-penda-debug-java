package com.hemebiotech;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{
    private String filepath;
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }
    @Override
    public void WriteSymptoms(Map<String, Integer> Symptoms) throws IOException {//méthode pour l'écriture d'un fichier avec gestion des exceptions
        FileWriter fileWriter = new FileWriter(filepath);
        for (Map.Entry<String, Integer> entry : Symptoms.entrySet()) {
            fileWriter.write(entry.getKey() + ": " + entry.getValue() + System.lineSeparator());
        }
        fileWriter.close();
    }
}