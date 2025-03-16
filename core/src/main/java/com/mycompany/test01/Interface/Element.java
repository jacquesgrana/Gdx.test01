package com.mycompany.test01.Interface;

public interface Element {
    public int getId();

    public void setId(int id);

    public String getName();

    public void setName(String name);

    public boolean equals(Element element);

    public int hashCode();
}
