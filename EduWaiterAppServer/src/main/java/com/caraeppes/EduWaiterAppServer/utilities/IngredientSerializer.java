package com.caraeppes.EduWaiterAppServer.utilities;

import com.caraeppes.EduWaiterAppServer.models.Ingredient;
import com.caraeppes.EduWaiterAppServer.models.MenuItem;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IngredientSerializer extends StdSerializer<List<Ingredient>> {

    public IngredientSerializer() {
        this(null);
    }

    public IngredientSerializer(Class<List<Ingredient>> i) {
        super(i);
    }

    @Override
    public void serialize(List<Ingredient> ingredients, JsonGenerator generator,
                          SerializerProvider provider) throws IOException{

        List<Ingredient> serializedIngredients = new ArrayList<>();
        for (Ingredient i : ingredients) {
            i.setMenuItems(null);
            serializedIngredients.add(i);
        }
        generator.writeObject(serializedIngredients);
    }
}