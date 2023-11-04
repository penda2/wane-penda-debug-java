package com.hemebiotech;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
public class WriteSymptomDataToFile implements ISymptomWriter {
    private String filepath;
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }
    @Override 
    /* 
     * méthode pour l'écriture d'un fichier avec gestion des exceptions
     */
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
        FileWriter fileWriter = new FileWriter(filepath);
        for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
            fileWriter.write(entry.getKey() + ": " + entry.getValue() + System.lineSeparator());
        }
        fileWriter.close();
    }
}