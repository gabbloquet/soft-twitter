package io.gabbloquet.sandbox.User.domain.useCases;

import io.gabbloquet.sandbox.User.domain.entities.User;
import io.gabbloquet.sandbox.User.interfaces.providers.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.create(user);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User get(String userId) {
        return null;
    }

    @Override
    public void delete(String userId) { }


//    public User create() {
//        return User.builder()
//            .id(1)
//            .name("Gabin Bloquet")
//            .username("@BloquetGabin")
//            .mail("gabbloquet@hotmail.fr")
//            .picture("https://pbs.twimg.com/profile_images/1081348420999221249/GV3sgbxT_400x400.jpg")
//            .description("Software Engineer & Front-end community Leader at @Decathlon • Sport \uD83C\uDFC3\uD83C\uDFFC\uD83D\uDEB4\uD83C\uDFFB\u200D♂️• Culture \uD83D\uDCDA\uD83C\uDFAF• Musique \uD83C\uDFB8• Flex-Remote working \uD83D\uDCBB")
//            .localisation("Mons-en-Baroeul, France")
//            .birthdate(LocalDateTime.of(LocalDate.of(1995, 11, 24), LocalTime.MIN))
//            .createdDate(LocalDateTime.now())
//            .followers(List.of())
//            .following(List.of())
//            .build();
//    }
}
