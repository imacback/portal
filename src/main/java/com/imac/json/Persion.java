package com.imac.json;

public class Persion {

//    private Long id;

    private String name;

    private Long age;

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Persion{" +
//                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
