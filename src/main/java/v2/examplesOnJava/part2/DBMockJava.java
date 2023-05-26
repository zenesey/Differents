package v2.examplesOnJava.part2;

import v2.examplesOnJava.part1.PersonJava;
import v2.examplesOnKotlin.part1.PersonKT;
import v2.examplesOnKotlin.part2.InterfaceForPersons;

import java.util.ArrayList;
import java.util.List;

public class DBMockJava implements InterfaceForPersons {
    private List<PersonKT> listKt = new ArrayList<>();
    private List<PersonJava> listJava = new ArrayList<>();



    public void insertPersonKT(PersonKT personKT) {
        listKt.add(personKT);

    }
    public void deletePersonKT(PersonKT personKT) {
        listKt.remove(personKT);
    }

    public void insertPersonJava(PersonJava personJava) {
        listJava.add(personJava);
    }
    public void deletePersonJava(PersonJava personJava) {
        listJava.remove(personJava);
    }

    @Override
    public void printNameInstance() {
        System.out.println("DBMockJava");
    }
}
