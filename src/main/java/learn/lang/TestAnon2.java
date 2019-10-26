package learn.lang;

public class TestAnon2 implements TestAnon {

    int i;

    public TestAnon2(int i) {
        this.i = i;
    }

    @Override
    public int a() {
        return i;
    }
}
