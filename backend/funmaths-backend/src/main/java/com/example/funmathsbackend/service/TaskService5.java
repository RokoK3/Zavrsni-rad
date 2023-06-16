package com.example.funmathsbackend.service;

import com.example.funmathsbackend.model.Ime;
import com.example.funmathsbackend.model.Task;
import com.example.funmathsbackend.repository.ImeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class TaskService5 {

    @Autowired
    private ImeRepository imeRepository;

    public Task generateDijeljenjeprvi() {
        Random random = new Random();

        
        List<Ime> imena = imeRepository.findAll();
        Ime ime = imena.get(random.nextInt(imena.size()));


        int W = random.nextInt(51) + 50;
        int Y = random.nextInt(11) + 5;
        int Z = W * Y;


        String taskText;
        if (ime.getSpol().equals("M")) {
            taskText = String.format("%s je zamislio broj koji uvećan %d puta daje broj %d. Koji je broj zamislio %s?", ime.getIme(), Y, Z, ime.getIme());
        } else {
            taskText = String.format("%s je zamislila broj koji uvećan %d puta daje broj %d. Koji je broj zamislila %s?", ime.getIme(), Y, Z, ime.getIme());
        }

        return new Task(taskText, W, "Podijeli brojeve kako bi došao do rješenja.");
    }

    public Task generateDijeljenjedrugi() {
        Random random = new Random();


        List<Ime> imena = imeRepository.findAll();
        Ime ime = imena.get(random.nextInt(imena.size()));


        int Y = random.nextInt(6) + 7;
        int Z = random.nextInt(60);
        int Q = random.nextInt(5) + 14;
        int R = Z;
        int S = random.nextInt(61) + 60;
        int W = (Q - Y) * S;

        String taskText;
        if (ime.getSpol().equals("M")) {
            taskText = String.format("%s je krenuo na put u %d sati i %d minuta i na odredište udaljeno %d kilometara stigao u %d sati i %d minuta. Izračunaj koliko je kilometara prešao po satu ako je u svakom satu prevalio jednak put.", ime.getIme(), Y, Z, W, Q, R);
        } else {
            taskText = String.format("%s je krenula na put u %d sati i %d minuta i na odredište udaljeno %d kilometara stigla u %d sati i %d minuta. Izračunaj koliko je kilometara prešla po satu ako je u svakom satu prevalila jednak put.", ime.getIme(), Y, Z, W, Q, R);
        }

        return new Task(taskText, S, "Izračunaj koliko je ukupno put trajao, a zatim podijeli ukupnu duljinu puta sa brojem sati. U rješenje NE upisuj mjernu jedinicu.");
    }

    public Task generateDijeljenjetreci() {
        Random random = new Random();

        int X = random.nextInt(10) + 1;
        int Y = random.nextInt(10) + 1;
        int Z = random.nextInt(10) + 1;
        int Q = random.nextInt(31) + 20;

        int number = 100*Y + 10*Z + X;

        int resultDiv = number / Q;
        int result = number - (resultDiv * Q);
        String taskText = String.format("Broj koji na mjestu jedinica ima znamenku %d, na mjestu stotica znamenku %d i na mjestu desetica znamenku %d umanji %d puta. Koliko iznosi ostatak prilikom dijeljenja?", X, Y, Z, Q);

        return new Task(taskText, result, "Pisanim dijeljenjem dođi do ostatka.");
    }
}

