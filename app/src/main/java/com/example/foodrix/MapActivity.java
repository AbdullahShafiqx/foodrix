package com.example.foodrix;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap gMap;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    
    private TextView addressText;
    private Button btnConfirmLocation;
    private Marker currentMarker;
    private LatLng selectedLatLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_map);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addressText = findViewById(R.id.addressText);
        btnConfirmLocation = findViewById(R.id.btnConfirmLocation);

        // Get the SupportMapFragment and request the map to be ready
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.id_map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }

        btnConfirmLocation.setOnClickListener(v -> {
            if (selectedLatLng != null) {
                String locationString = String.format("Lat: %.4f, Lng: %.4f", selectedLatLng.latitude, selectedLatLng.longitude);
                Intent data = new Intent();
                data.putExtra("selected_location", locationString);
                setResult(RESULT_OK, data);
                finish();
            } else {
                Toast.makeText(MapActivity.this, "Please select a location on the map first", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        gMap = googleMap;

        // Enable zoom controls
        gMap.getUiSettings().setZoomControlsEnabled(true);

        // Set default map type (Normal, Satellite, Terrain, Hybrid)
        gMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Add a marker at a default location (e.g., Lahore, Pakistan)
        LatLng lahore = new LatLng(31.5497, 74.3436);
        selectedLatLng = lahore;
        currentMarker = gMap.addMarker(new MarkerOptions().position(lahore).title("Marker in Lahore"));
        addressText.setText("Selected: Lahore (31.5497, 74.3436)");

        // Move camera to the location with zoom level 12
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lahore, 12));

        // Enable user location tracking (with permission check)
        enableUserLocation();

        // Listen for map clicks to select location
        gMap.setOnMapClickListener(latLng -> {
            selectedLatLng = latLng;
            if (currentMarker != null) {
                currentMarker.remove();
            }
            currentMarker = gMap.addMarker(new MarkerOptions().position(latLng).title("Selected Delivery Location"));
            addressText.setText(String.format("Selected: (%.4f, %.4f)", latLng.latitude, latLng.longitude));
        });
    }

    private void enableUserLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Request location permissions
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
            return;
        }
        gMap.setMyLocationEnabled(true);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                enableUserLocation();
            }
        }
    }
}