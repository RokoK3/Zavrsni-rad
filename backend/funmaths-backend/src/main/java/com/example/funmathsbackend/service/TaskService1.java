package com.example.funmathsbackend.service;

import com.example.funmathsbackend.model.Ime;
import com.example.funmathsbackend.model.SkupeStvari;
import com.example.funmathsbackend.model.Task;
import com.example.funmathsbackend.model.ZbrajanjeDo1000prvi;
import com.example.funmathsbackend.repository.ImeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class TaskService1 {

    private final ImeRepository imeRepository;
    @Autowired
    private SkupeStvariService skupeStvariService;

    public TaskService1(ImeRepository imeRepository) {
        this.imeRepository = imeRepository;
    }

    public ZbrajanjeDo1000prvi generateZbrajanjeDo1000prvi() {
        Random random = new Random();
        int x = random.nextInt(2334) + 1000;
        int y = random.nextInt(2334) + 1000;
        int z = random.nextInt(2334) + 1000;

        return new ZbrajanjeDo1000prvi(x, y, z);
    }


    public Task generateZbrajanjeDo1000drugi() {
        boolean isFemale = Math.random() < 0.5;
        List<Ime> persons = imeRepository.findBySpol(isFemale ? "F" : "M");

        Collections.shuffle(persons);
        List<Ime> selectedPersons = persons.subList(0, 3);

        Random random = new Random();
        int earnedToday = random.nextInt(1001) + 500;
        int earnedDayBeforeYesterday = 2 * earnedToday;
        int earnedDifference = random.nextInt(1001) + 500;
        int earnedYesterday = earnedDayBeforeYesterday + earnedDifference;
        int totalEarnings = earnedToday + earnedYesterday + earnedDayBeforeYesterday;
        String personsText = selectedPersons.stream().map(Ime::getIme).collect(Collectors.joining(", "));
        String taskText;
        if (selectedPersons.get(0).getSpol().equals("F")) {
            taskText =  String.format("Tri sestre, %s, imaju prodavaonicu. Jučer su zaradile čak %d eura više nego prethodnog dana. " +
                            "Danas su imale manje sreće, zaradile su samo %d eura - točno pola manje nego prekjučer. " +
                            "Koliko su eura sestre zaradile u tri dana?",
                    personsText, earnedDifference, earnedToday);
        } else {
            taskText = String.format("Tri brata, %s, imaju prodavaonicu. Jučer su zaradili čak %d eura više nego prethodnog dana. " +
                            "Danas su imali manje sreće, zaradili su samo %d eura - točno pola manje nego prekjučer. " +
                            "Koliko su eura braća zaradila u tri dana?",
                    personsText, earnedDifference, earnedToday);
        }

        String hint = "Prvo izračunajte kolika je zarada bila prekjučer, zatim iz tog rezultata zaključite kolika je zarada bila jučer, a na kraju sve to zbrojite sa sumom zarađenom danas.";

        return new Task(taskText, totalEarnings, hint);
    }

    public Task generateZbrajanjeDo1000treci() {
        Random random = new Random();
        int number1 = random.nextInt(10000 - 8500) + 8500;
        int number2 = random.nextInt(8500 - 7500) + 7500;
        int number3 = random.nextInt(2500 - 500) + 500;
        int number4 = random.nextInt(2500 - 500) + 500;
        int number5 = random.nextInt(2500 - 500) + 500;

        Ime randomIme = imeRepository.findById((long) (random.nextInt((int) imeRepository.count()) + 1)).orElse(null);
        if (randomIme == null) {
            return null;
        }

        SkupeStvari randomItem1 = skupeStvariService.getRandomExpensiveItem();
        SkupeStvari randomItem2 = skupeStvariService.getRandomExpensiveItem();
        SkupeStvari randomItem3 = skupeStvariService.getRandomExpensiveItem();

        if (randomItem1 == null || randomItem2 == null || randomItem3 == null) {
            return null;
        }

        String taskTextTemplate;
        if (randomIme.getSpol().equals("M")) {
            taskTextTemplate = "Od ukupno %d eura koliko je %s imao na računu u banci, podigao je %d eura. Tim je novcem namjeravao kupiti %s za %d eura, %s za %d eura i %s za %d eura. Izračunaj koliko ukupno novca %s ima nakon šopinga.";
        } else {
            taskTextTemplate = "Od ukupno %d eura koliko je %s imala na računu u banci, podigla je %d eura. Tim je novcem namjeravala kupiti %s za %d eura, %s za %d eura i %s za %d eura. Izračunaj koliko ukupno novca %s ima nakon šopinga.";
        }

        int solution = number1 - number2;
        String taskText = String.format(taskTextTemplate, number1, randomIme.getIme(), number2, randomItem1.getImeProizvoda(), number3, randomItem2.getImeProizvoda(), number4, randomItem3.getImeProizvoda(), number5, randomIme.getIme());
        String hint = "Nakon šopinga iznos koji preostaje jednak je sumi nepodignutog novca sa banke i nepotrošenog podignutog novca.";
        Task task = new Task(taskText, solution, hint);
        return task;
    }

}