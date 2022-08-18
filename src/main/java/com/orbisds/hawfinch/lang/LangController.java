package com.orbisds.hawfinch.lang;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class LangController {

    private final LangService langService;

    @RequestMapping("/langs/{id}")
    public Lang getLang(@PathVariable String id) {
        return langService.getLang(id);
    }

    @RequestMapping("/langs")
    public List<Lang> getAllLangs() {
        return langService.getAllLangs();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/langs")
    public void addLang(@RequestBody Lang lang) {
        langService.addLang(lang);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/langs/{id}")
    public void updateLang(@RequestBody Lang lang, @PathVariable String id) {
        langService.updateLang(id, lang);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/langs/{id}")
    public void deleteLang(@PathVariable String id) {
        langService.deleteLang(id);
    }
}
