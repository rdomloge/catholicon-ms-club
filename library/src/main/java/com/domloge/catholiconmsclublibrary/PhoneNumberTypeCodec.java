package com.domloge.catholiconmsclublibrary;

import javax.inject.Singleton;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

// @Singleton
public class PhoneNumberTypeCodec implements Codec<PhoneNumberType> {

    @Override
    public void encode(BsonWriter writer, PhoneNumberType value, EncoderContext encoderContext) {
        writer.writeString(value.getIdentifier());
    }

    @Override
    public Class<PhoneNumberType> getEncoderClass() {
        return PhoneNumberType.class;
    }

    @Override
    public PhoneNumberType decode(BsonReader reader, DecoderContext decoderContext) {
        
        return PhoneNumberType.forIdentifier(reader.readString());
    }
    
}
