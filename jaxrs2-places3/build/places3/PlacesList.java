package places3;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlElementWrapper; 
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "placesList")
public class PlacesList {
    private List<Place> placs; 
    private AtomicInteger placId;

    public PlacesList() { 
	placs = new CopyOnWriteArrayList<Place>(); 
	placId = new AtomicInteger();
    }

    @XmlElement 
    @XmlElementWrapper(name = "places") 
    public List<Place> getPlaces() { 
	return this.placs;
    } 
    public void setPlaces(List<Place> placs) { 
	this.placs = placs;
    }

    @Override
    public String toString() {
	String s = "";
	for (Place p : placs) s += p.toString();
	return s;
    }

    public Place find(int id) {
	Place plac = null;
	// Search the list -- for now, the list is short enough that
	// a linear search is ok but binary search would be better if the
	// list got to be an order-of-magnitude larger in size.
	for (Place p : placs) {
	    if (p.getId() == id) {
		plac = p;
		break;
	    }
	}	
	return plac;
    }
    public int add(String where, String poiOne, String poiTwo) {
	int id = placId.incrementAndGet();
	Place p = new Place();
	p.setWhere(where);
    p.setPoiOne(poiOne);
    p.setPoiTwo(poiTwo);
	p.setId(id);
	placs.add(p);
	return id;
    }
}