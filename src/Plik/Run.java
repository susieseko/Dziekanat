package Plik;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String imie, nazwisko, ocena;
        String sciezkaDoPliku = "/Users/zuzia/Library/Mobile Documents/com~apple~CloudDocs/MINE/IdeaProjects/Dziekanat/src/Plik/studenci";
        int odp = 0;
        Student student = new Student();
        ArrayList<String> oceny = new ArrayList<>();
        ArrayList<Student> listaStudentow = new ArrayList<>();

        System.out.println("Witaj w wirtualnej uczelni!");

        while(true){
            System.out.println("Co chcesz zrobić?\n1-dodaj studenta, 2-usuń studenta, 3-wyświetl studentów, 4-wyświetl studenta wraz z jego ocenami, 5-dodaj ocenę studentowi, 6-zakończ program");
            odp = sc.nextInt();
            sc.nextLine();

            if(odp == 1){
                System.out.println("Podaj imię studenta:");
                imie = sc.nextLine();
                System.out.println("Podaj nazwisko studenta:");
                nazwisko = sc.nextLine();
                student.dodajStudenta(imie, nazwisko, oceny, sciezkaDoPliku);
            } else if(odp == 2){
                System.out.println("Podaj imię studenta, którego chcesz usunąć:");
                imie = sc.nextLine();
                System.out.println("Podaj nazwisko studenta, którego chcesz usunąć:");
                nazwisko = sc.nextLine();
                student.usunStudenta(imie, nazwisko, sciezkaDoPliku);
            } else if(odp == 3){
                student.wyswietlStudentow();
            } else if(odp == 4){
                student.wyswietlStudentaWrazZOcenami();
            } else if(odp == 5){
                System.out.println("Podaj imię studenta, któremu chcesz dodać ocenę:");
                imie = sc.nextLine();
                System.out.println("Podaj nazwisko studenta, któremu chcesz dodać ocenę:");
                nazwisko = sc.nextLine();
                System.out.println("Podaj ocenę:");
                ocena = sc.nextLine();
                student.dodajOcene(imie, nazwisko, ocena);
            } else if(odp == 6){
                break;
            }
        }
        sc.close();

    }
}
