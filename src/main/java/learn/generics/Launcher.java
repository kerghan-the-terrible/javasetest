package learn.generics;

public class Launcher {
    public static void main(String[] args) {
        BaseGenericClass<String> genObj1 = new BaseGenericClass<String>("v1");
        String str = "v2";
        Object obj = str+"_obj";
        genObj1.setField(str);
        System.out.println("get field : "+genObj1.getField());
        BaseGenericClass rawObj1 = genObj1;
        rawObj1.setField(obj);
        str = genObj1.getField();
        System.out.println("get string : "+str);
        obj = new int[10];
        System.out.println("set obj");
        rawObj1.setField(obj);
        System.out.println("get obj raw");
        System.out.println(rawObj1.getField());
        //System.out.println("get obj");
        //System.out.println(genObj1.getField());
        System.out.println("-----");
        SimpleClass1 sObj1 = new SimpleClass1();
        SimpleClass2 sObj2 = new SimpleClass2();
        SimpleClass3 sObj3 = new SimpleClass3();
        BaseGenericClass<SimpleClass2> genObj2 = new BaseGenericClass<SimpleClass2>(sObj2);
        BaseGenericClass<? extends SimpleClass1> ref1 = genObj2;
        SimpleClass1 ref3 = ref1.getField();
        //SimpleClass3 ref3_2 = ref1.getField();
        System.out.println(ref3);
        BaseGenericClass<? super SimpleClass2> ref2 = genObj2;
        ref2.setField(sObj3);
        //ref3 = ref2.getField();
        System.out.println(genObj2.getField());
        //ref2.setField(sObj1);
        ref2.setField(sObj2);
        System.out.println(genObj2.getField());
        BaseGenericClass<?> ref4 = genObj2;
        System.out.println(ref4.getField());
        //ref4.setField(sObj2);
        SimpleClass1[] arr1 = new SimpleClass1[4];
        SimpleClass1[] arr2 = BaseGenericClass.getArray(arr1);
        System.out.println(arr2.length);
    }
}
