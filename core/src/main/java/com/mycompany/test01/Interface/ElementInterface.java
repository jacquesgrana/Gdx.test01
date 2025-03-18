package com.mycompany.test01.Interface;

public interface ElementInterface {
    public int getId();

    public void setId(int id);

    public String getName();

    public void setName(String name);

    public boolean equals(ElementInterface element);

    public int hashCode();
}
