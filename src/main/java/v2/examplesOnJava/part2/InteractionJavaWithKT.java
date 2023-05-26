package v2.examplesOnJava.part2;

import v2.examplesOnJava.part1.PersonJava;
import v2.examplesOnKotlin.part1.PersonKT;
import v2.examplesOnKotlin.part2.DBMockKT;

public class InteractionJavaWithKT {
    private DBMockJava dbJava = new DBMockJava();
    private DBMockKT dbKt = new DBMockKT();

    public void addPersonJava(PersonJava personJava) {
        dbJava.insertPersonJava(personJava);
    }
    public void deletePerson(Object object) {
        if (object instanceof PersonJava) {
            dbJava.deletePersonJava((PersonJava) object);
        } else {
            dbKt.deletePersonKT((PersonKT) object);
        }

    }

}
