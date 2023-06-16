package com.example.funmathsbackend.service;

import com.example.funmathsbackend.model.Ime;
import com.example.funmathsbackend.model.Pica;
import com.example.funmathsbackend.model.Task;
import com.example.funmathsbackend.repository.ImeRepository;
import com.example.funmathsbackend.repository.PicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class TaskService3 {

    private final ImeRepository imeRepository;
    private final PicaRepository picaRepository;

    public TaskService3(ImeRepository imeRepository, PicaRepository picaRepository) {
        this.imeRepository = imeRepository;
        this.picaRepository = picaRepository;
    }


    public Task generatePovrsinaprvi() {
        List<Ime> imena = imeRepository.findAll();
        Random random = new Random();

        Ime ime = imena.get(random.nextInt(imena.size()));
        int randomNumber = random.nextInt(50) + 1;
        int y = randomNumber * 4;

        String taskText;
        if (ime.getSpol().equalsIgnoreCase("M")) {
            taskText = String.format("%s je potrošio %d metara žičane ograde da bi ogradio vrt oblika kvadrata. Kolika je površina vrta?", ime.getIme(), y);
        } else {
            taskText = String.format("%s je potrošila %d metara žičane ograde da bi ogradila vrt oblika kvadrata. Kolika je površina vrta?", ime.getIme(), y);
        }

        int solution = randomNumber * randomNumber;
        String hint = "Koristite formulu za površinu kvadrata. U rješenje NE upisujte mjernu jedinicu.";

        return new Task(taskText, solution, hint);
    }

    public Task generatePovrsinadrugi() {
        List<Ime> imena = imeRepository.findAll();
        List<Pica> picaList = picaRepository.findAll();
        Random random = new Random();

        Ime ime = imena.get(random.nextInt(imena.size()));
        int y = random.nextInt(10) + 1;
        Pica z = picaList.get(random.nextInt(picaList.size()));
        int daysInYear = random.nextBoolean() ? 365 : 366;
        String yearType = daysInYear == 365 ? "godini" : "prijestupnoj godini";

        String taskText = String.format("%s svakog dana popije %d decilitara %s. Koliko decilitara %s popije u %s?", ime.getIme(), y, z.getNaziv(), z.getNaziv(), yearType);

        int solution = y * daysInYear;

        String hint = String.format("Pomnožite broj decilitara koje %s popije svaki dan s brojem dana u %s.", ime.getIme(), yearType);

        return new Task(taskText, solution, hint);
    }

    public Task generatePovrsinatreci() {
        List<Pica> picaList = picaRepository.findAll();
        Random random = new Random();

        int x = random.nextInt(51) + 10; // Random number between 10-60
        Pica y = picaList.get(random.nextInt(picaList.size()));
        int z = random.nextInt(11) + 5; // Random number between 5-15

        String taskText = String.format("Ako u jednu posudu stane %d litara %s, izračunaj koliko %s stane u %d takvih posuda.", x, y.getNaziv(), y.getNaziv(), z);

        int solution = x * z;

        String hint = "Pomnoži broj litara u jednoj posudi s brojem posuda.";

        return new Task(taskText, solution, hint);
    }

    public Task generatePovrsinacetvrti() {
        List<Ime> imeList = imeRepository.findAll();
        Random random = new Random();

        int x = random.nextInt(36) + 15; // Random number between 15-50
        Ime y = imeList.get(random.nextInt(imeList.size()));

        String taskText;

        if (y.getSpol().equals("M")) {
            taskText = String.format("Dva jednako velika susjedna zemljišta razdvojena ogradom imala su oblik kvadrata duljine stranice %d m. %s je kupio oba zemljišta i uklonio ogradu između njih. Izračunaj ukupan opseg zemljišta koje %s ima nakon uklanjanja ograde.", x, y.getIme(), y.getIme());
        } else {
            taskText = String.format("Dva jednako velika susjedna zemljišta razdvojena ogradom imala su oblik kvadrata duljine stranice %d m. %s je kupila oba zemljišta i uklonila ogradu između njih. Izračunaj ukupan opseg zemljišta koje %s ima nakon uklanjanja ograde.", x, y.getIme(), y.getIme());
        }

        int solution = x * 6;
        String hint = "Razmisli kojeg je oblika zemljište nakon spajanja dva susjedna zemljišta, a zatim zbroji sve duljine stranica.";

        return new Task(taskText, solution, hint);
    }
}
