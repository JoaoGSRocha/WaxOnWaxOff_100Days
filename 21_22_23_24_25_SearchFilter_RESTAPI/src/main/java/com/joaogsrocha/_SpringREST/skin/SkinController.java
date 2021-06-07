package com.joaogsrocha._SpringREST.skin;

import com.joaogsrocha._SpringREST.experiment.ISkinDao;
import com.joaogsrocha._SpringREST.experiment.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@CrossOrigin("http://localhost:4200")
@RestController
public class SkinController {

    @Autowired
    private ISkinDao api;

    @RequestMapping(method = RequestMethod.GET, value = "/skins")
    @ResponseBody
    public List<Skin> findAll(@RequestParam(value = "search", required = false) String search) {
        List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        if (search != null) {
            Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
            Matcher matcher = pattern.matcher(search + ",");
            while (matcher.find()) {
                params.add(new SearchCriteria(matcher.group(1),
                        matcher.group(2), matcher.group(3)));
            }
        }
        return api.searchSkin(params);
    }
}