package serializer;

import java.io.IOException;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class ObjectIdSerializerModule extends SimpleModule {
	
	private static final long serialVersionUID = 909992202970448402L;
	
	public ObjectIdSerializerModule() {
		super("ObjectIdSerializerModule",new Version(0, 1, 0, "alpha","com.belatrix.rest.serializer","ObjectIdSerializer"));
		this.addSerializer(ObjectId.class,new ObjectIdSerializer());
		
	}
	
	public class ObjectIdSerializer extends JsonSerializer<ObjectId>{

		@Override
		public void serialize(ObjectId value, JsonGenerator gen, SerializerProvider serializers)
				throws IOException, JsonProcessingException {

			gen.writeString(value.toString());			
		}
		
	}
}
