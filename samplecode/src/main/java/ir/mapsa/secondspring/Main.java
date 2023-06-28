package ir.mapsa.secondspring;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        A a = new A();
        a.setName("A");
        B b = new B();
        b.setName("B");
        a.setB(b);
        b.setA(a);
        System.out.println(objectMapper.writeValueAsString(a));
    }
}

class A {
    private String name;
    private B b;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonManagedReference
    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}

class B {
    private String name;
    private A a;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonBackReference
    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}
