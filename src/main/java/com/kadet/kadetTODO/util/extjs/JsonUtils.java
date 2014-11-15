package com.kadet.kadetTODO.util.extjs;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Soroka
 */
public class JsonUtils {

    private final static Logger logger = Logger.getLogger(JsonUtils.class);

    public static List<SortFilter> getSortFiltersFromJsonArray (String data) {

        List<SortFilter> values = new ArrayList<SortFilter>();

        try {
            ObjectMapper mapper = new ObjectMapper();

            values = mapper.readValue(data,
                    new TypeReference<List<SortFilter>>() {
                    });
        } catch (Exception ex) {
            logger.error(ex);
        }
        return values;
    }

}
