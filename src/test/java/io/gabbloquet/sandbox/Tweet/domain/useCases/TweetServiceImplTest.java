package io.gabbloquet.sandbox.Tweet.domain.useCases;

import io.gabbloquet.sandbox.Tweet.domain.entities.Tweet;
import io.gabbloquet.sandbox.Tweet.interfaces.providers.TweetRepository;
import io.gabbloquet.sandbox.User.domain.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest()
@ActiveProfiles({"test", "sql"})
class TweetServiceImplTest {

    @Autowired
    private TweetServiceImpl tweetService;

    @MockBean
    private TweetRepository tweetRepositoryMock;

    @Test
    void should_generate_tweet_without_like() {
        Tweet tweetToCreate = Tweet
                .builder()
                .id("1")
                .user(new User())
                .message("Message exemple")
                .likes(List.of(new User()))
                .linkedTweet(null)
                .date(LocalDateTime.now())
                .build();

        tweetService.createTweet(tweetToCreate);

        tweetToCreate.setLikes(List.of());
        verify(tweetRepositoryMock, times(1)).save(tweetToCreate);
    }
}