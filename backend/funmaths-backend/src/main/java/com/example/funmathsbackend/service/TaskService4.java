package com.example.funmathsbackend.service;

import com.example.funmathsbackend.model.Ime;
import com.example.funmathsbackend.model.SkupeStvari;
import com.example.funmathsbackend.model.Task;
import com.example.funmathsbackend.repository.ImeRepository;
import com.example.funmathsbackend.repository.SkupeStvariRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class TaskService4 {
    @Autowired
    private ImeRepository imeRepository;
    @Autowired
    private SkupeStvariRepository skupeStvariRepository;
    public Task generateMnozenjeprvi() {
        List<Ime> imenaM = imeRepository.findBySpol("M");
        List<Ime> imenaF = imeRepository.findBySpol("F");
        List<SkupeStvari> skupeStvariList = skupeStvariRepository.findAll();
        Random random = new Random();
        Ime imeM = imenaM.get(random.nextInt(imenaM.size()));
        Ime imeF = imenaF.get(random.nextInt(imenaF.size()));
        SkupeStvari stvar = skupeStvariList.get(random.nextInt(skupeStvariList.size()));

        String[] brojDjece = {"dvoje", "troje", "četvero", "petero"};
        int brojDjeceIndex = random.nextInt(brojDjece.length);
        String w = brojDjece[brojDjeceIndex];

        int q = random.nextInt(1001) + 1000;
        int ukupnoPoklona = (brojDjeceIndex + 2);
        int solution = ukupnoPoklona * q;

        String taskText = String.format("%s i %s odlučili su zajedno kupiti %s za svako od svoje %s djece. Za svaki %s morat će izdvojiti %d eura." +
                        " Koliko će ukupno koštati ti pokloni?",
                imeM.getIme(), imeF.getIme(), stvar.getImeProizvoda(), w, stvar.getImeProizvoda(), q);
        String hint = "Pomnoži cijenu poklona s brojem djece koja će dobiti poklon. ";
        return new Task(taskText, solution, hint);
    }

    public Task generateMnozenjedrugi() {
        List<Ime> imenaM = imeRepository.findBySpol("M");
        List<Ime> imenaF = imeRepository.findBySpol("F");
        Random random = new Random();

        Ime imeM = imenaM.get(random.nextInt(imenaM.size()));
        Ime imeF = imenaF.get(random.nextInt(imenaF.size()));

        String[] brojDjeceOptions = {"dvoje", "troje", "četvero", "petero"};
        int brojDjeceIndex = random.nextInt(brojDjeceOptions.length);
        String brojDjece = brojDjeceOptions[brojDjeceIndex];

        int W = random.nextInt(1001) + 1500;
        int ukupnoOsoba = (brojDjeceIndex + 2) + 2; // Add 2 for X and Y, and add 2 to the index to get the actual number of children
        int ukupnaDuljina = ukupnoOsoba * W;

        String taskText = String.format("%s, %s i njihovo %s djece vozili su bicikle jedan krug oko jezera po stazi duljine %d metara. Koliko su ukupno metara prešli biciklima?", imeM.getIme(), imeF.getIme(), brojDjece, W);
        String hint = "Pomnoži ukupan broj ljudi koji su biciklirali sa duljinom staze.";
        return new Task(taskText, ukupnaDuljina, hint);
    }

    public Task generateMnozenjetreci() {
        Random random = new Random();

        int X = random.nextInt(10) + 1;
        int Y = random.nextInt(10) + 1;
        int Z = random.nextInt(10) + 1;
        int Q = random.nextInt(10) + 1;

        int prviFaktor = Y * 10 + X;
        int drugiFaktor = Z * 10 + Q;
        int umnozak = prviFaktor * drugiFaktor;

        String taskText = String.format("Prvi faktor ima %d jedinica i %d desetica, a drugi faktor ima %d desetica i %d jedinica. Izračunaj njihov umnožak.", X, Y, Z, Q);
        String hint = "Razmisli o kojim brojevima se radi, a zatim ih pomnoži.";
        return new Task(taskText, umnozak, hint);
    }

    public Task generateMnozenjecetvrti() {
        Random random = new Random();

        int X = random.nextInt(201) + 200;
        int Y = random.nextInt(51) + 200;
        int Q = random.nextInt(21) + 280;

        int firstNumber = Y + X;
        int secondNumber = Q - Y;
        int product = firstNumber * secondNumber;

        String taskText = String.format("Broj koji je za %d veći od broja %d pomnoži brojem koji je za %d manji od broja %d.", X, Y, Y, Q);
        String hint = "Razmisli o kojim brojevima se radi, a zatim ih pomnoži.";
        return new Task(taskText, product, hint);
    }
}
