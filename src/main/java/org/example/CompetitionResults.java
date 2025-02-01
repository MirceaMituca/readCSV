package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompetitionResults {
    Path path = Paths.get("athlets.csv");

    public List<String> readFile(){
        try {
           List<String> allLines = Files.readAllLines(path);
           return allLines;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Athlete> parseStringList(List<String> stringList, boolean hasHeaderRow) {
        List<Athlete> athletes = new ArrayList<>();
        for (int i = hasHeaderRow ? 1 : 0; i < stringList.size(); i++) {
            String currentLine = stringList.get(i);
            String[] elements = currentLine.split(",");
            Athlete athlete = createAthlete(elements);
            athletes.add(athlete);
        }
        return athletes;
    }

        private static Athlete createAthlete(String[] elements){
            return new Athlete(
                    Integer.parseInt(elements[0]),
                    elements[1],
                    elements[2],
                    Integer.parseInt(elements[3]),
                    elements[4],
                    elements[5],
                    elements[6]
            );

        }

    public static List<Athlete> sortAthletesByFinalTime(List<Athlete> athletes) {
        Collections.sort(athletes);
        return athletes;
    }
}
