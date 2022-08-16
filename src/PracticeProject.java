import processing.core.PApplet;
import de.fhpotsdam.unfolding.providers.Microsoft;

import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.utils.MapUtils;


public class PracticeProject extends PApplet {
    UnfoldingMap map;
    
    public void setup() {
        size(800, 600);
        map = new UnfoldingMap(this, new Microsoft.AerialProvider());

        
        // Show map around the location in the given zoom level.
        //map.zoomAndPanTo(new Location(54.544540f, -1.927440f), 20);
        
        //Add Pan & Zoom Animations
       //map.setTweening(true);
 
        // Add mouse and keyboard interactions
        MapUtils.createDefaultEventDispatcher(this, map);
        
        List<Feature> countries = GeoJSONReader.loadData(this, "countries.geo.json");
        List<Marker> countryMarkers = MapUtils.createSimpleMarkers(countries);
       map.addMarkers(countryMarkers);
       
       
    }
 
    public void draw() {
        map.draw();
    }
}
    
 

