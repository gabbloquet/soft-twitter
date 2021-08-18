package io.gabbloquet.sandbox.infrastructure.mongodb.repository;

import io.gabbloquet.sandbox.infrastructure.mongodb.dao.MongoUrl;
import io.gabbloquet.sandbox.utils.Url;
import io.gabbloquet.sandbox.utils.UrlRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Profile("nosql")
public class MongoUrlRepository implements UrlRepository {

    private MongoSpringDataUrlRepository mongoSpringDataUrlRepository;

    @Override
    public Url save(Url url) {
        return mongoSpringDataUrlRepository.save(MongoUrl.fromUrl(url)).toUrl();
    }

    @Override
    public Url findById(Long id) {
        return mongoSpringDataUrlRepository
                .findById(id)
                .orElseThrow()
                .toUrl();
    }
}
