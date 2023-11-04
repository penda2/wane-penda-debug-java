package com.hemebiotech.analytics;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.hemebiotech.ISymptomWriter;
import com.hemebiotech.WriteSymptomDataToFile;

public class AnalyticsCounter {
	public static void main(String args[]) throws Exception {
		ISymptomReader readFile = new ReadSymptomDataFromFile("symptoms.txt");
		/*
		 * Récupération de la liste de tous les symptômes
		 */
		List<String> allSymptoms = readFile.getSymptoms(); 
		/*
		 * tri  des Syptomes, compte et assignation de leur valeur correspondante
		 */
		Map<String,Integer> sortSymptoms = new TreeMap<>();
		for(String symptom : allSymptoms) {
			if(sortSymptoms.containsKey(symptom)) {
				int countSymptoms = sortSymptoms.get(symptom);
				sortSymptoms.put(symptom, countSymptoms + 1);
			}else {
				sortSymptoms.put(symptom, 1);
			}
		}
		/*
		 * Ecriture de la liste des sypmtômes dans un fichier donné en arguments
		 */
		ISymptomWriter writeToFile = new WriteSymptomDataToFile("result.out");
		writeToFile.writeSymptoms(sortSymptoms);
	}
}