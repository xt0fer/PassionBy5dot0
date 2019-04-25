package com.caraeppes.EduWaiterAppServer.utilities;

import com.caraeppes.EduWaiterAppServer.models.Menu;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuSerializer extends StdSerializer<List<Menu>> {

    public MenuSerializer() {
        this(null);
    }

    public MenuSerializer(Class<List<Menu>> m) {
        super(m);
    }

    @Override
    public void serialize(List<Menu> menus, JsonGenerator generator,
                          SerializerProvider provider) throws IOException{

        List<Menu> serializedMenus = new ArrayList<>();
        for (Menu m : menus) {
           m.setRestaurant(null);
            serializedMenus.add(m);
        }
        generator.writeObject(serializedMenus);
    }
}