package learn.lang;

public class HashTest2 {

    private int id;
    private String str;
    private double d;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashTest2 hashTest2 = (HashTest2) o;

        if (id != hashTest2.id) return false;
        if (Double.compare(hashTest2.d, d) != 0) return false;
        return str != null ? str.equals(hashTest2.str) : hashTest2.str == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (str != null ? str.hashCode() : 0);
        temp = Double.doubleToLongBits(d);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
