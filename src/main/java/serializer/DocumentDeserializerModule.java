package serializer;

import java.io.IOException;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class DocumentDeserializerModule extends SimpleModule{
	
	private static final long serialVersionUID = -9183129538775779526L;
	
	public DocumentDeserializerModule() {
		super("DocumentDeserializerModule",new Version(0, 1, 0, "alpha","com.belatrix.rest.serializer","DocumentDeserializer"));
		this.addDeserializer(Document.class,new DocumentDeserializer());
	}
	
	public class DocumentDeserializer extends JsonDeserializer<Document>{
				
		@Override
		public Document deserialize(JsonParser jp, DeserializationContext ctxt)
				throws IOException, JsonProcessingException {
			
			ObjectMapper mapper = new ObjectMapper();
			
			Document document = mapper.readValue(jp, Document.class);
			
			if(document.containsKey("_id")){				
				document.put("_id", new ObjectId(document.getString("_id")));			
			}
			
			return document;
		}		
	}
}
