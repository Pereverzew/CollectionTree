package com.pereverzew.collectiontree;

import java.util.Optional;

public interface CollectionTree <T extends Comparable> {
    void add(T element);
    boolean delete(T element);
    Optional<T> get(T element);
    int size();
}
