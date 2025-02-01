package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionResultsTest {

    @Test
    void testFileParsingWithHeader() {

        List<String> lines = Arrays.asList(
                "number,name,country,skiTimeResult,firstShootingRange,secondShootingRange,thirdShootingRange",
                "1,Mircea Mituca,RO,550,xoxox,xxoxx,xxoxo",
                "2,Umar Jorgson,SK,500,xxxox,xxxxx,xxoxo");

        List<Athlete> athletes = CompetitionResults.parseStringList(lines, true);

        assertEquals(2, athletes.size());
        Athlete first = athletes.get(0);
        assertEquals(1, first.getNumber());
        assertEquals("Mircea Mituca", first.getName());
        assertEquals("RO", first.getCountry());
    }

    @Test
    void testStandingCalculation() {
        List<String> lines = Arrays.asList(
                "1,Mircea,RO,550,xoxox,xxoxx,xxoxo",
                "2,Umar,SK,500,xxxox,xxxxx,xxoxo",
                "3,Jimmy,UK,600,xxoox,xooxo,xxxxo",
                "4,Piotr,CZ,650,xxxxx,xxxxx,xxxxx");

        List<Athlete> athletes = CompetitionResults.parseStringList(lines, false);
        CompetitionResults.sortAthletesByFinalTime(athletes);

        assertEquals("Umar",   athletes.get(0).getName(), "Winner");
        assertEquals("Mircea", athletes.get(1).getName(), "Runner-up");
        assertEquals("Piotr",  athletes.get(2).getName(), "Third place");
        assertEquals("Jimmy",  athletes.get(3).getName(), "Fourth");
    }
}