import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class aoctwo {
    public static void main(String[] args) {
        String text = ""; // Inicializa a variável

        try {
            text = Files.readString(Path.of("C:\\Users\\oscar\\Documents\\aoc2\\input.txt"));
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return; // Para o programa se não conseguir ler o arquivo
        }

        // Separar linhas do arquivo
        String[] lines = text.split("\n");

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        // Processar cada linha
        for (String line : lines) {
            String[] numbers = line.trim().split("\\s+"); // Divide por espaço

            if (numbers.length == 2) { // Garante que há dois números por linha
                leftList.add(Integer.parseInt(numbers[0]));
                rightList.add(Integer.parseInt(numbers[1]));
            }
        }

        // Criar um mapa para contar as ocorrências dos números na lista da direita
        Map<Integer, Integer> rightCount = new HashMap<>();

        for (int num : rightList) {
            rightCount.put(num, rightCount.getOrDefault(num, 0) + 1);
        }

        // Calcular o Similarity Score
        int similarityScore = 0;

        for (int num : leftList) {
            int count = rightCount.getOrDefault(num, 0);
            similarityScore += num * count;
        }

        // Exibir o resultado
        System.out.println("Similarity Score: " + similarityScore);
    }
}
