package maps.gokul.com;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuItem;

import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.overlay.Marker;
import com.mapbox.mapboxsdk.overlay.UserLocationOverlay;
import com.mapbox.mapboxsdk.tileprovider.tilesource.MapboxTileLayer;
import com.mapbox.mapboxsdk.views.MapView;

import org.xmlpull.v1.XmlPullParser;


public class MainActivity extends ActionBarActivity {

    private MapView mv;
    private UserLocationOverlay mLocationOverlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mv = (MapView) findViewById(R.id.mapview);
        XmlPullParser parser=getResources().getXml(R.xml.attrs);
        AttributeSet attrs = Xml.asAttributeSet(parser);
        mv  = new MapView(this,attrs);
        mv.setAccessToken("pk.eyJ1IjoiZ29rdWxhbmF0aCIsImEiOiIyM2YxMThjYzBlYTE3ZmU4MTFiM2VkZjg3NzEzZDgyYSJ9.ISrNUt0oBrYNoxj5QFl5lA");
        mv.setTileSource(new MapboxTileLayer("gokulanath.58133d1b"));
        this.setContentView(mv);
        mv.getOverlays();
        mv.setUserLocationEnabled(true);
        mv.setUserLocationTrackingMode(UserLocationOverlay.TrackingMode.FOLLOW);
        mv.setUserLocationRequiredZoom(14);

    // Retrieve UserLocation
        mv.getUserLocation();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
