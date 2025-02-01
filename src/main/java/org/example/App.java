package org.example;

import java.io.File;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        CompetitionResults competitionResults = new CompetitionResults();

        List<String> lines = competitionResults.readFile();


        List<Athlete> athletes = competitionResults.parseStringList(lines, true);

        competitionResults.sortAthletesByFinalTime(athletes);

        for (int i = 0; i < athletes.size(); i++) {
            Athlete a = athletes.get(i);
            System.out.println((i+1) + ". " + a.getName() + " Time: " + a.finalTime());
        }

        if (athletes.size() >= 3) {
            Athlete first = athletes.get(0);
            Athlete second = athletes.get(1);
            Athlete third = athletes.get(2);

            System.out.println("\nWinner: " + first.getName() + " - " + first.finalTime());
            System.out.println("Runner-up: " + second.getName() + " - " + second.finalTime());
            System.out.println("Third Place: " + third.getName() + " - " + third.finalTime());
        }
    }
    }
