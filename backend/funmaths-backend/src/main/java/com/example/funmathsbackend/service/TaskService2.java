package com.example.funmathsbackend.service;

import com.example.funmathsbackend.model.Cvijece;
import com.example.funmathsbackend.model.Ime;
import com.example.funmathsbackend.model.Task;
import com.example.funmathsbackend.model.TaskString;
import com.example.funmathsbackend.repository.CvijeceRepository;
import com.example.funmathsbackend.repository.ImeRepository;

import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class TaskService2 {

    private final ImeRepository imeRepository;
    private final CvijeceRepository cvijeceRepository;

    public TaskService2(ImeRepository imeRepository, CvijeceRepository cvijeceRepository) {
        this.imeRepository = imeRepository;
        this.cvijeceRepository = cvijeceRepository;
    }

    public Task generateDekadskeZnamenkeprvi() {
        List<Ime> imena = imeRepository.findAll();
        Random random = new Random();
        Ime ime = imena.get(random.nextInt(imena.size()));

        int thousandEuros = random.nextInt(9) + 1;
        int hundredEuros = random.nextInt(9) + 1;
        int tenEuros = random.nextInt(9) + 1;
        int fiveEuros = random.nextInt(9) + 1;
        int twoEuros = random.nextInt(9) + 1;

        String taskText;
        if (ime.getSpol().equals("M")) {
            taskText = String.format("Da bi platio račun, %s je dao %d novčanica od tisuću eura, %d novčanica od 100 eura, %d novčanica od 10 eura, %d novčanica od 5 eura i %d kovanice od 2 eura. Koliko je iznosio račun?", ime.getIme(), thousandEuros, hundredEuros, tenEuros, fiveEuros, twoEuros);
        } else {
            taskText = String.format("Da bi platila račun, %s je dala %d novčanica od tisuću eura, %d novčanica od 100 eura, %d novčanica od 10 eura, %d novčanica od 5 eura i %d kovanice od 2 eura. Koliko je iznosio račun?", ime.getIme(), thousandEuros, hundredEuros, tenEuros, fiveEuros, twoEuros);
        }

        int solution = thousandEuros * 1000 + hundredEuros * 100 + tenEuros * 10 + fiveEuros * 5 + twoEuros * 2;
        String hint = "Zbrojite sve novčanice i kovanice. Odgovor je SAMO BROJ, bez valute.";

        return new Task(taskText, solution, hint);
    }
    public TaskString generateDekadskeZnamenkedrugi() {
        List<Ime> imena = imeRepository.findAll();
        List<Cvijece> cvijeceList = cvijeceRepository.findAll();
        Random random = new Random();

        Ime ime = imena.get(random.nextInt(imena.size()));

        Set<Integer> indices = new HashSet<>();
        while (indices.size() < 4) {
            indices.add(random.nextInt(cvijeceList.size()));
        }

        List<Integer> uniqueIndices = new ArrayList<>(indices);
        Cvijece cvijet1 = cvijeceList.get(uniqueIndices.get(0));
        Cvijece cvijet2 = cvijeceList.get(uniqueIndices.get(1));
        Cvijece cvijet3 = cvijeceList.get(uniqueIndices.get(2));
        Cvijece cvijet4 = cvijeceList.get(uniqueIndices.get(3));

        int y = random.nextInt(90000) + 10000;
        int z = random.nextInt(90000) + 10000;
        int w = random.nextInt(90000) + 10000;
        int q = random.nextInt(90000) + 10000;

        String[] options = {"najmanje", "najviše"};
        String option = options[random.nextInt(options.length)];

        String taskText = String.format("%s ima obiteljsko poljoprivredno gospodarstvo koje se bavi proizvodnjom cvijeća.<br>" +
                "Prošle godine su uzgojili:<br>" +
                "%s: %d<br>" +
                "%s: %d<br>" +
                "%s: %d<br>" +
                "%s: %d<br>" +
                "Kojeg cvijeća je uzgojeno %s?", ime.getIme(), cvijet1.getNaziv(), y, cvijet2.getNaziv(), z, cvijet3.getNaziv(), w, cvijet4.getNaziv(), q, option);

        int[] flowerCounts = {y, z, w, q};
        String solution;

        if (option.equals("najmanje")) {
            int minIndex = 0;
            for (int i = 1; i < flowerCounts.length; i++) {
                if (flowerCounts[i] < flowerCounts[minIndex]) {
                    minIndex = i;
                }
            }
            solution = switch (minIndex) {
                case 0 -> cvijet1.getNaziv();
                case 1 -> cvijet2.getNaziv();
                case 2 -> cvijet3.getNaziv();
                default -> cvijet4.getNaziv();
            };
        } else {
            int maxIndex = 0;
            for (int i = 1; i < flowerCounts.length; i++) {
                if (flowerCounts[i] > flowerCounts[maxIndex]) {
                    maxIndex = i;
                }
            }
            solution = switch (maxIndex) {
                case 0 -> cvijet1.getNaziv();
                case 1 -> cvijet2.getNaziv();
                case 2 -> cvijet3.getNaziv();
                default -> cvijet4.getNaziv();
            };
        }

        solution = solution.toLowerCase();
        String hint = "Usporedite broj uzgojenih cvjetova za svaku vrstu cvijeća. Kao odgovor unesite ime cvijeta.";

        return new TaskString(taskText, solution, hint);
    }
    public Task generateDekadskeZnamenketreci() {
        Random random = new Random();

        // Generate a unique 6-digit number
        List<Integer> digits = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(digits);
        int number = digits.get(0) * 100000 + digits.get(1) * 10000 + digits.get(2) * 1000 + digits.get(3) * 100 + digits.get(4) * 10 + digits.get(5);

        // Choose a random digit from the number
        int randomIndex = random.nextInt(6);
        int randomDigit = digits.get(randomIndex);
        int digitValue = randomDigit * (int) Math.pow(10, 5 - randomIndex);

        String taskText = String.format("Koliko vrijedi znamenka %d u broju %d?", randomDigit, number);
        int solution = digitValue;
        String hint = "Pomnožite znamenku s vrijednošću pozicije na kojoj se nalazi.";

        return new Task(taskText, solution, hint);
    }

}