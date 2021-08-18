package io.gabbloquet.sandbox.utils;

public interface UrlRepository {
    Url save(Url url);
    Url findById(Long id);
}