package com.kassandra.restapi.util;


import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;

/**
 * @author Onur Karaduman
 * @since 15.07.17
 */
public class MapperUtil {

    private static Mapper mapper;

    static {
        MapperUtil.mapper = new DozerBeanMapper();
    }

    public static <T> T map(Object object, Class<T> ref) {
        return mapper.map(object, ref);
    }

    public static <T> List<T> mapList(Object objects, Class<T> ref) throws IllegalFormatException {
        if (objects instanceof List) {
            List<T> list = new ArrayList<T>();
            for (Object o : (List) objects) {
                list.add(map(o, ref));
            }
            return list;
        } else {
            throw new ClassCastException();
        }

    }

}
