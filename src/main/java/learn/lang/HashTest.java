package learn.lang;

import java.util.Objects;

public class HashTest {

    private int id;
    private String str;
    private double d;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashTest hashTest = (HashTest) o;
        return id == hashTest.id &&
                Double.compare(hashTest.d, d) == 0 &&
                Objects.equals(str, hashTest.str);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, str, d);
    }
}
