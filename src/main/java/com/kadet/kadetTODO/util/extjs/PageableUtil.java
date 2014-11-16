package com.kadet.kadetTODO.util.extjs;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Soroka
 */
public class PageableUtil {


    /**
     *  Create object of @Pageable class by parameters of ExtJS grid table
     *  Used for retrieving not all items from database but just items for one page
     *
     *  @param page     current page number
     *  @param start    start item number
     *  @param limit    maximum value for request
     *  @param sort     (not necessary required) json list of property (name of property for sorting) - value (ASC/DESC sort) objects
     */
    public static Pageable createPageableByExtJSTableRequest (int page, int start, int limit, Object sort) {
        Pageable pageable = null;
        if (sort != null) {
            List<SortFilter> sortFilters
                    = JsonUtil.getSortFiltersFromJsonArray((String) sort);
            if (sortFilters.size() != 0) {
                pageable = new PageRequest(page - 1,limit,
                        new Sort(
                                PageableUtil.sortFiltersToOrders(sortFilters)
                        )
                );
            } else {
                pageable = createPageableByPageAndLimit(page, limit);
            }
        } else {
            pageable = createPageableByPageAndLimit(page, limit);
        }
        return pageable;
    }

    /**
     *
     */
    public static Pageable createPageableByPageAndLimit (int page, int limit) {
        return new PageRequest(page - 1, limit);
    }


    public static List<Order> sortFiltersToOrders (List<SortFilter> filters) {
        List<Order> orders = new ArrayList<Order>();
        for (SortFilter filter : filters) {
            orders.add(sortFilterToOrder(filter));
        }
        return orders;
    }

    public static Order sortFilterToOrder (SortFilter sortFilter) {
        return new Order(
                Sort.Direction.fromString(sortFilter.getDirection()),
                sortFilter.getProperty()
        );
    }
}
