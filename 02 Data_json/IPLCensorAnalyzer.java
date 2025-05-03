import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.*;
import java.util.*;

class Match {
    int match_id;
    String team1;
    String team2;
    Map<String, Integer> score;
    String winner;
    String player_of_match;

    public Match() {}

    public int getMatch_id() { return match_id; }
    public void setMatch_id(int match_id) { this.match_id = match_id; }
    public String getTeam1() { return team1; }
    public void setTeam1(String team1) { this.team1 = team1; }
    public String getTeam2() { return team2; }
    public void setTeam2(String team2) { this.team2 = team2; }
    public Map<String, Integer> getScore() { return score; }
    public void setScore(Map<String, Integer> score) { this.score = score; }
    public String getWinner() { return winner; }
    public void setWinner(String winner) { this.winner = winner; }
    public String getPlayer_of_match() { return player_of_match; }
    public void setPlayer_of_match(String player_of_match) { this.player_of_match = player_of_match; }
}

public class IPLCensorAnalyzer {
    public static void main(String[] args) throws Exception {
        processJson("input.json", "output.json");
        processCsv("input.csv", "output.csv");
    }

    private static String censorTeamName(String team) {
        String[] parts = team.split(" ");
        return parts.length > 1 ? parts[0] + " ***" : team;
    }

    private static void processJson(String inputFile, String outputFile) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Match[] matches = mapper.readValue(new File(inputFile), Match[].class);
        List<Match> censoredMatches = new ArrayList<>();

        for (Match match : matches) {
            Match censored = new Match();
            censored.setMatch_id(match.getMatch_id());
            censored.setTeam1(censorTeamName(match.getTeam1()));
            censored.setTeam2(censorTeamName(match.getTeam2()));
            censored.setWinner(censorTeamName(match.getWinner()));
            censored.setPlayer_of_match("REDACTED");

            Map<String, Integer> censoredScore = new HashMap<>();
            match.getScore().forEach((team, score) -> censoredScore.put(censorTeamName(team), score));
            censored.setScore(censoredScore);

            censoredMatches.add(censored);
        }

        mapper.writeValue(new File(outputFile), censoredMatches);
    }

    private static void processCsv(String inputFile, String outputFile) throws Exception {
        List<String[]> censoredRows = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(inputFile))) {
            String[] headers = reader.readNext();
            censoredRows.add(headers);

            String[] row;
            while ((row = reader.readNext()) != null) {
                String[] censoredRow = new String[row.length];
                censoredRow[0] = row[0];
                censoredRow[1] = censorTeamName(row[1]);
                censoredRow[2] = censorTeamName(row[2]);
                censoredRow[3] = row[3];
                censoredRow[4] = row[4];
                censoredRow[5] = censorTeamName(row[5]);
                censoredRow[6] = "REDACTED";
                censoredRows.add(censoredRow);
            }
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
            writer.writeAll(censoredRows);
        }
    }
}