package places3;

import java.util.Set;
import java.util.HashSet;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/resourcesC")
public class RestfulPlace extends Application {
    @Override
    public Set<Class<?>> getClasses() {
	Set<Class<?>> set = new HashSet<Class<?>>();
        set.add(PlacesRS.class);
        return set;
    }
}