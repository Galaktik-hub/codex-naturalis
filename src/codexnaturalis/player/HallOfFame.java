package codexnaturalis.player;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HallOfFame {

    public static List<String> getHallOfFame() throws IOException {
        List<String> hallOfFame = new ArrayList<>();
        String fileName = "halloffame.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int count = 0;
            // On récupère que les 10 premières lignes, ou, si il y a moins de scores enregistrés que 10, on ne prend
            // ceux présents
            while ((line = br.readLine()) != null && count < 10) {
                hallOfFame.add(line);
                count++;
            }
        } catch (IOException e) {
            throw new IOException();
        }
        return hallOfFame;
    }

    public static void insertHallOfFame(String person) throws IOException {
        List<String> hallOfFame = getHallOfFame();
        hallOfFame.add(person);
        // On trie pour avoir les meilleurs scores
        hallOfFame.sort((s1, s2) -> {
            int score1 = Integer.parseInt(s1.split(" ")[1]);
            int score2 = Integer.parseInt(s2.split(" ")[1]);
            return Integer.compare(score2, score1);
        });

        // On ne garde que les 10 meilleures entrées
        if (hallOfFame.size() > 10) {
            hallOfFame = hallOfFame.subList(0, 10);
        }

        String fileName = "halloffame.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String entry : hallOfFame) {
                bw.write(entry);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new IOException();
        }
    }
}
