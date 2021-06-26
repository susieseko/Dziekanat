package Plik;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    public void dodajStudenta(String imie, String nazwisko, ArrayList<String> oceny, String sciezkaDoPliku) throws IOException {
        FileWriter plik = new FileWriter(sciezkaDoPliku, true);
        plik.append(imie + " " + nazwisko + " " + oceny + "\n");
        plik.close();
    }

    public void usunStudenta(String imie, String nazwisko, String sciezkaDoPliku) throws FileNotFoundException {
        ArrayList<String> listaStudentow = new ArrayList<>();
        File plik = new File("/Users/zuzia/Library/Mobile Documents/com~apple~CloudDocs/MINE/IdeaProjects/Dziekanat/src/Plik/studenci");
        Scanner scanner = new Scanner(plik);

        while (scanner.hasNextLine()) {
            String student = scanner.nextLine();
            String[] dziel = student.split(" ");

            if (!dziel[0].equals(imie) && !dziel[1].equals(nazwisko)) {
                listaStudentow.add(student);
            }
        }
        scanner.close();

        PrintWriter plikZapis = new PrintWriter("/Users/zuzia/Library/Mobile Documents/com~apple~CloudDocs/MINE/IdeaProjects/Dziekanat/src/Plik/studenci");
        for (String x : listaStudentow) {
            plikZapis.println(x);
        }
        plikZapis.close();
    }

    public void wyswietlStudentow() throws FileNotFoundException {
        ArrayList<String> listaStudentow = new ArrayList<>();
        File plik = new File("/Users/zuzia/Library/Mobile Documents/com~apple~CloudDocs/MINE/IdeaProjects/Dziekanat/src/Plik/studenci");
        Scanner scanner = new Scanner(plik);

        while(scanner.hasNextLine()){
            String student = scanner.nextLine();
            String[] studentAOcena = student.split(" ");
            System.out.println(studentAOcena[0] + " " + studentAOcena[1]);
        }
        scanner.close();
    }

    public void wyswietlStudentaWrazZOcenami() throws FileNotFoundException {
        File plik = new File("/Users/zuzia/Library/Mobile Documents/com~apple~CloudDocs/MINE/IdeaProjects/Dziekanat/src/Plik/studenci");
        Scanner scanner = new Scanner(plik);

        while(scanner.hasNextLine()){
            String wiersz = scanner.nextLine();
            System.out.println(wiersz);
        }
        scanner.close();
    }

    public void dodajOcene(String imie, String nazwisko, String ocena) throws FileNotFoundException {
        ArrayList<String> listaOcen = new ArrayList<>();
        ArrayList<String> listaStudentow = new ArrayList<>();
        File plik = new File("/Users/zuzia/Library/Mobile Documents/com~apple~CloudDocs/MINE/IdeaProjects/Dziekanat/src/Plik/studenci");
        Scanner scanner = new Scanner(plik);

        while(scanner.hasNextLine()){
            String student = scanner.nextLine();
            String[] dziel = student.split(" ");

            if(dziel[0].equals(imie) && dziel[1].equals(nazwisko)){
                if (dziel[2].contains("1")) listaOcen.add("1");
                if (dziel[2].contains("2")) listaOcen.add("2");
                if (dziel[2].contains("3")) listaOcen.add("3");
                if (dziel[2].contains("4")) listaOcen.add("4");
                if (dziel[2].contains("5")) listaOcen.add("5");
                if (dziel[2].contains("6")) listaOcen.add("6");
                listaOcen.add(ocena);
                listaStudentow.add(dziel[0] + " " + dziel[1] + " " + listaOcen);
            }else{
                listaStudentow.add(student);
            }
        }
        scanner.close();

        for(int i = 0; i < listaOcen.size(); i++){
            listaOcen.remove(i);
        }

        PrintWriter plikZapis = new PrintWriter("/Users/zuzia/Library/Mobile Documents/com~apple~CloudDocs/MINE/IdeaProjects/Dziekanat/src/Plik/studenci");
        for(String x : listaStudentow){
            plikZapis.println(x);
        }
        plikZapis.close();
    }
}



