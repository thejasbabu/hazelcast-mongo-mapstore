package mongoExample;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import static com.hazelcast.core.Hazelcast.newHazelcastInstance;
public class Runner {

    public static void main(String[] args) {
        final HazelcastInstance hz = newHazelcastInstance();
        IMap<String, Person> personIMap = hz.getMap("person");

        Person rahul = new Person("Rahul", "23");
        Person suresh = new Person("Suresh", "29");

        personIMap.set("Rahul", rahul);
        personIMap.set("Suresh", suresh);

        System.out.println(personIMap.get("Rahul"));
        System.out.println(personIMap.get("Suresh"));
    }
}
