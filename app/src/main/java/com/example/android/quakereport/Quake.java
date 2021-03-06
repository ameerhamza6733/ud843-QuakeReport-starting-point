package com.example.android.quakereport;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by Konis on 8/2/2017.
 */

public class Quake {
    private double kmag;
    private String klocation;
    private String kdate;
    private String kurl;
    private double klongitude;
    private double klatitude;
    private int kdepth;
    private int kfelt;
    public double kdistance;
    private static final String LOCATION_SEPARATOR = " of ";
    public Quake(double mag, String location, String date, String url, int felt, double longitude, double latitude, int depth, double distance){
        kmag = mag;
        klocation = location;
        kdate = date;
        kurl = url;
        klongitude = longitude;
        klatitude = latitude;
        kdepth = depth;
        kfelt = felt;
        kdistance = distance;
    }
    public String getMag(){
        DecimalFormat formatter = new DecimalFormat("0.00");
        String FrMag = formatter.format(kmag);
        return FrMag;
    }
    public String getLocation() {
        String originalLocation = klocation;
        String primaryLocation;
        String locationOffset;
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = "near the";
            primaryLocation = originalLocation;
        }
        return primaryLocation;
    }
    public String getLocationOff(){
        String originalLocation = klocation;
        String primaryLocation;
        String locationOffset;
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = "near the";
            primaryLocation = originalLocation;
        }
        return locationOffset;
    }
    public String getDate(){
        long timeInMilliseconds = Long.parseLong(kdate);
        Date dateObject = new Date(timeInMilliseconds);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM dd, yyyy");
        String dateToDisplay = dateFormatter.format(dateObject);
        return dateToDisplay;
    }
    public String getTime(){
        long timeInMilliseconds = Long.parseLong(kdate);
        Date timeObject = new Date(timeInMilliseconds);
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
        String timeToDisplay = timeFormatter.format(timeObject);
        return timeToDisplay;
    }
    public String getFelt(){
        String felt = String.valueOf(kfelt);
        return felt;
    }
    public String getKdistance(){
        DecimalFormat formatter = new DecimalFormat("0.00");
        String kdist = formatter.format(kdistance);
        return kdist;
    }
    //returning initial values for object reconstruction
    public double getOrigMag(){
        return kmag;
    }
    public String getOrigLoc(){
        return klocation;
    }
    public String getOrigDate(){
        return kdate;
    }
    public String getUrl(){
        return kurl;
    }
    public int getOrigFelt(){
        return kfelt;
    }
    public double getLongitude(){
        return klongitude;
    }
    public double getLatitude(){
        return klatitude;
    }
    public int getDepth(){
        return kdepth;
    }
    public double getDistance(){ return kdistance;}
    public static Comparator<Quake> DistanceComparator = new Comparator<Quake>() {

        @Override
        public int compare(Quake e1, Quake e2) {

            return e1.getKdistance().compareTo(e2.getKdistance());
        }
    };
}
