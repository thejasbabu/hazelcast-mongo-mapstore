package mongoExample;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.MapLoaderLifecycleSupport;
import com.hazelcast.core.MapStore;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Collection;
import java.util.Map;
import java.util.Properties;

import static com.mongodb.client.model.Filters.eq;

public class MongoMapStore implements MapStore<String, Person>, MapLoaderLifecycleSupport {
    private MongoClient mongoClient;
    private MongoCollection<Document> collection;

    public MongoMapStore() {
    }

    @Override
    public void init(HazelcastInstance hazelcastInstance, Properties properties, String mapName) {
        String mongoUrl = (String) properties.get("mongo.url");
        String dbName = (String) properties.get("mongo.db");
        String collectionName = (String) properties.get("mongo.collection");
        this.mongoClient = new MongoClient(new MongoClientURI(mongoUrl));
        this.collection = mongoClient.getDatabase(dbName).getCollection(collectionName);
    }

    public void destroy() {
        mongoClient.close();
    }


    public void store(String s, Person person) {
        System.out.println("Storing doc");
        Document document = new Document("name", s).append("age", person.getAge());
        this.collection.insertOne(document);
    }

    public void storeAll(Map<String, Person> map) {

    }

    public void delete(String s) {

    }

    public void deleteAll(Collection<String> collection) {

    }

    public Person load(String s) {
        System.out.println("Loading from Mongo");
        Document doc = this.collection.find(eq("name", s)).first();
        String name = (String) doc.get("name");
        String age = (String) doc.get("age");
        return new Person(name, age);
    }

    public Map<String, Person> loadAll(Collection<String> collection) {
        return null;
    }

    public Iterable<String> loadAllKeys() {
        return null;
    }
}
