package com.caraeppes.EduWaiterAppServer.utilities;


import com.caraeppes.EduWaiterAppServer.models.MenuItem;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuItemSerializer extends StdSerializer<List<MenuItem>> {

    public MenuItemSerializer() {
        this(null);
    }

    public MenuItemSerializer(Class<List<MenuItem>> m) {
        super(m);
    }

    @Override
    public void serialize(List<MenuItem> menuItems, JsonGenerator generator,
            SerializerProvider provider) throws IOException, JsonProcessingException {

        List<MenuItem> serializedMenuItems = new ArrayList<>();
        for (MenuItem m : menuItems) {
            m.setMenus(null);
            serializedMenuItems.add(m);
        }
        generator.writeObject(serializedMenuItems);
    }
}