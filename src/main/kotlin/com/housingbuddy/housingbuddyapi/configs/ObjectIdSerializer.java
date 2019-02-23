package com.housingbuddy.housingbuddyapi.configs;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.bson.types.ObjectId;

import java.io.IOException;

final class ObjectIdSerializer extends JsonSerializer<ObjectId> {
    @Override
    public void serialize(ObjectId id, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeString(id.toString());
    }
}
