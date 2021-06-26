package Plik;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    public void dodajStudenta(String imie, String nazwisko, String sciezkaDoPliku) throws IOException {
        FileWriter plik = new FileWriter(sciezkaDoPliku, true);
        plik.append(imie + " " + nazwisko + " OCENY: " + "\n");
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
            String[] studentAOceny = student.split(":");

            if(dziel[0].equals(imie) && dziel[1].equals(nazwisko)){
                listaStudentow.add(dziel[0] + " " + dziel[1] + " OCENY: " + studentAOceny[1].substring(1, studentAOceny[1].length()) + " " + ocena);
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



