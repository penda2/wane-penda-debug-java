package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.hemebiotech.WriteSymptomDataToFile;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		ReadSymptomDataFromFile readFile = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> allSymptoms = readFile.GetSymptoms();
		Map<String,Integer> map = new TreeMap<>();
        for (String symptom : allSymptoms) {
            if (map.containsKey(symptom)) {
                int count = map.get(symptom);
                map.put(symptom, count + 1);
            } else {
                map.put(symptom, 1);
            }
        }

		WriteSymptomDataToFile writeToFile = new WriteSymptomDataToFile("result.out");
		writeToFile.WriteSymptoms(map);
	}
}

/*
public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
	public List getSymptoms() { }
	public Map countSymptoms(List symptoms) { } 
	public Map sortSymptoms(Map symptoms) { }
	public void writeSymptoms(Map symptoms) { }
 } 
*/