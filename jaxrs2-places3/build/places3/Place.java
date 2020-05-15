package places3;

import javax.xml.bind.annotation.XmlRootElement; 
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "place")
public class Place implements Comparable<Place> {
    private String where;   // place
    private String poiOne;  // first point of interest
    private String poiTwo;  //second point of interest
    private int    id;    // identifier used as lookup-key

    public Place() { }

    @Override
    public String toString() {
	return String.format("%2d: ", id) + where + " 1.) " + poiOne + " 2.) " + poiTwo + "\n";
    }
    
    //** properties
    public void setWhere(String where) {
	this.where = where;
    }
    @XmlElement
    public String getWhere() {
	return this.where;
    }

    public void setPoiOne(String poiOne) {
	this.poiOne = poiOne;
    }
    @XmlElement
    public String getPoiOne() {
	return this.poiOne;
    }

    public void setPoiTwo(String poiTwo) {
    this.poiTwo = poiTwo;
    }
    @XmlElement
    public String getPoiTwo() {
    return this.poiTwo;
    }

    public void setId(int id) {
	this.id = id;
    }
    @XmlElement
    public int getId() {
	return this.id;
    }

    // implementation of Comparable interface
    public int compareTo(Place other) {
	return this.id - other.id;
    }	
}