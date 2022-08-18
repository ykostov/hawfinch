package com.orbisds.hawfinch.lang;

import com.orbisds.hawfinch.users.User;
import com.orbisds.hawfinch.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class LangService {

    private final LangRepository langRepository;

    public Lang getLang(String id) {
        return langRepository.findById(id).orElse(null);
    }

    public List<Lang> getAllLangs() {
        List<Lang> langs = new ArrayList<>();
        langRepository.findAll().forEach(langs::add);
        return langs;
    }

    public void addLang(Lang lang) {
        langRepository.save(lang);
    }

    public void updateLang(String id, Lang lang) {
        langRepository.save(lang);
    }

    public void deleteLang(String id) {
        langRepository.deleteById(id);
    }

}
