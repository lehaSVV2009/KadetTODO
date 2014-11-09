package com.kadet.kadetTODO.util.mapper;

import com.kadet.kadetTODO.web.model.LevelUI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kadet on 09.11.2014.
 */
@Service
public class LevelMapper {

    public List<LevelUI> toUIEntity (List<String> levels) {
        List<LevelUI> levelUIs = new ArrayList<LevelUI>();
        for (String level: levels) {
            LevelUI levelUI = new LevelUI();
            levelUI.setText(level);
            levelUIs.add(levelUI);
        }
        return levelUIs;
    }

}
