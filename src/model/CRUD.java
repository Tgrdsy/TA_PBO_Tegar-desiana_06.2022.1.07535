package model;

public interface CRUD<T> {
    void add(T dta);
    boolean edit(T dta);
    boolean delete(int key);
    T searchByNik(int key);
    T searchByBpjs(int key);
    T get(int key);
}
