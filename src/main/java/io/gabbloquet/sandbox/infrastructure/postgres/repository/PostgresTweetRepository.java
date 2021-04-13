package io.gabbloquet.sandbox.infrastructure.postgres.repository;

import io.gabbloquet.sandbox.Tweet.domain.entities.Tweet;
import io.gabbloquet.sandbox.Tweet.interfaces.providers.TweetRepository;
import io.gabbloquet.sandbox.User.domain.entities.User;
import io.gabbloquet.sandbox.infrastructure.postgres.dao.PostgresTweet;
import io.gabbloquet.sandbox.infrastructure.postgres.dao.PostgresUser;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
@Profile("sql")
public class PostgresTweetRepository implements TweetRepository {

    private PostgresSpringDataTweetRepository postgresSpringDataTweetRepository;

    @Override
    public Tweet save(Tweet tweet) {
        return postgresSpringDataTweetRepository.saveAndFlush(PostgresTweet.fromTweet(tweet)).toTweet();
    }

    @Override
    public List<Tweet> findAll() {
        return postgresSpringDataTweetRepository.findAll()
            .stream()
            .map(PostgresTweet::toTweet)
            .collect(Collectors.toList());
    }

    @Override
    public List<Tweet> find(User user) {
        return postgresSpringDataTweetRepository.findByUserOrderByDateDesc(PostgresUser.fromUser(user))
            .stream()
            .map(PostgresTweet::toTweet)
            .collect(Collectors.toList());
    }

//    @Override
//    public Customer save(Customer customer) {
//        return postgresSpringDataCustomerRepository.save(PostgresCustomer.fromCustomer(customer)).toCustomer();
//    }
//
//    @Override
//    public Option<Customer> findById(UUID id) {
//        return ofOptional(postgresSpringDataCustomerRepository.findById(id).map(PostgresCustomer::toCustomer));
//    }
//
//    @Override
//    public Option<Customer> findByLogin(String login) {
//        return ofOptional(postgresSpringDataCustomerRepository.findByName(login).map(PostgresCustomer::toCustomer));
//    }
//
//    @Override
//    public List<Customer> findAll() {
//        return ofAll(postgresSpringDataCustomerRepository.findAll()).map(PostgresCustomer::toCustomer);
//    }
}
