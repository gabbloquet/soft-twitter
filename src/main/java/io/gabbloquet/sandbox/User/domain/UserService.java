package io.gabbloquet.sandbox.User.domain;

import io.gabbloquet.sandbox.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    public User create() {
        return User.builder()
            .id(1)
            .name("Gabin Bloquet")
            .username("@BloquetGabin")
            .mail("gabbloquet@hotmail.fr")
            .picture("https://pbs.twimg.com/profile_images/1081348420999221249/GV3sgbxT_400x400.jpg")
            .description("Software Engineer & Front-end community Leader at @Decathlon • Sport \uD83C\uDFC3\uD83C\uDFFC\uD83D\uDEB4\uD83C\uDFFB\u200D♂️• Culture \uD83D\uDCDA\uD83C\uDFAF• Musique \uD83C\uDFB8• Flex-Remote working \uD83D\uDCBB")
            .localisation("Mons-en-Baroeul, France")
            .birthdate(LocalDateTime.of(LocalDate.of(1995, 11, 24), LocalTime.MIN))
            .createdDate(LocalDateTime.now())
            .followers(List.of())
            .following(List.of())
            .build();
    }
}
