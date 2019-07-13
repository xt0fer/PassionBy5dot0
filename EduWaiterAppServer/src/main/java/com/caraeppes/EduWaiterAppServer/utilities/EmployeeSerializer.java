package com.caraeppes.EduWaiterAppServer.utilities;

import com.caraeppes.EduWaiterAppServer.models.EmployeeAccount;
import com.caraeppes.EduWaiterAppServer.models.EmployeeAccount;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSerializer extends StdSerializer<List<EmployeeAccount>> {

    public EmployeeSerializer() {
        this(null);
    }

    public EmployeeSerializer(Class<List<EmployeeAccount>> e) {
        super(e);
    }

    @Override
    public void serialize(List<EmployeeAccount> employees, JsonGenerator gen, SerializerProvider provider) throws IOException {
        List<EmployeeAccount> serializedEmployees = new ArrayList<>();
        for(EmployeeAccount e : employees){
            e.setRestaurant(null);
            serializedEmployees.add(e);
        }
        gen.writeObject(serializedEmployees);
    }
}
