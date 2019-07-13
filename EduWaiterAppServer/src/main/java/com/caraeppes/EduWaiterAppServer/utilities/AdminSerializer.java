package com.caraeppes.EduWaiterAppServer.utilities;

import com.caraeppes.EduWaiterAppServer.models.AdminAccount;
import com.caraeppes.EduWaiterAppServer.models.Ingredient;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminSerializer extends StdSerializer<List<AdminAccount>> {

    public AdminSerializer() {
        this(null);
    }

    public AdminSerializer(Class<List<AdminAccount>> a) {
        super(a);
    }

    @Override
    public void serialize(List<AdminAccount> admins, JsonGenerator gen, SerializerProvider provider) throws IOException {
        List<AdminAccount> serializedAdmins = new ArrayList<>();
        for(AdminAccount a :admins){
            a.setRestaurant(null);
            serializedAdmins.add(a);
        }
        gen.writeObject(serializedAdmins);
    }
}
