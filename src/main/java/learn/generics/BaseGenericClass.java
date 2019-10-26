package learn.generics;

import java.lang.reflect.Array;

public class BaseGenericClass<T> {

    private T field = null;

    public BaseGenericClass(T field) {
        this.field = field;
    }

    public T getField() {
        return field;
    }

    public void setField(T field) {
        this.field = field;
    }

    public static <P> P[] getArray(P[] input) {
        return (P[]) Array.newInstance(input.getClass().getComponentType(), 5);
    }
}
