package com.orbisds.hawfinch.users;

import com.orbisds.hawfinch.lang.Lang;
import com.orbisds.hawfinch.lang.LangRepository;
import com.orbisds.hawfinch.positions.Position;
import com.orbisds.hawfinch.positions.PositionRepository;
import lombok.AllArgsConstructor;
import org.hibernate.event.spi.PostCollectionRecreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final LangRepository langRepository;
    private final PositionRepository positionRepository;

    public User getUser(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(String id, User user) {
        userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }


    public User enrollLangToUser(String userId, String langId) {
        User user = userRepository.findById(userId).get();
        Lang lang = langRepository.findById(langId).get();
        user.enrollLangs(lang);
        return userRepository.save(user);
    }

    public User enrollPositionToUser(String userId, String positionId) {
        User user = userRepository.findById(userId).get();
        Position position = positionRepository.findById(positionId).get();
        user.enrollPosition(position);
        return userRepository.save(user);
    }
}
