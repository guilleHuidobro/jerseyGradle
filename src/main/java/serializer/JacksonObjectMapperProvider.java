package serializer;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;

@Provider
public class JacksonObjectMapperProvider implements ContextResolver<ObjectMapper> {

	final ObjectMapper defaultObjectMapper;	
	
	public JacksonObjectMapperProvider() {
		defaultObjectMapper = createDefaultMapper();
	}
	
	@Override
	public ObjectMapper getContext(Class<?> type) {
		return defaultObjectMapper;
	}
	
	private static ObjectMapper createDefaultMapper(){
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new ObjectIdSerializerModule());
		mapper.registerModule(new DocumentDeserializerModule());
		return mapper;
	}

}
