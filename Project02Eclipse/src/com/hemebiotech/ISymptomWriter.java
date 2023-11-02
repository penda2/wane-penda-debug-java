package com.hemebiotech;

import java.io.IOException;
import java.util.Map;

public interface ISymptomWriter {
    public void WriteSymptoms(Map<String, Integer>Symptoms) throws IOException;
}