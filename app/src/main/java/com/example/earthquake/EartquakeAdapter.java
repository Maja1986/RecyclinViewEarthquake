package com.example.earthquake;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EartquakeAdapter extends RecyclerView.Adapter<EartquakeAdapter.MyViewHolder> {
    private List<Earthquake> earthquakes;
    private static final String LOCATION_SEPARATOR = " of ";

    private Context context;

    public EartquakeAdapter(Context context, List<Earthquake> earthquakes) {
        this.context = context;
        this.earthquakes = earthquakes;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public TextView magnitudeView;
        public TextView primaryLocationView;
        public TextView locationOffsetView;
        public TextView dateView;
        public TextView timeView;


        public MyViewHolder(View view) {
            super(view);
            this.mView = view;
            magnitudeView = (TextView) mView.findViewById(R.id.magnitude);
            primaryLocationView = (TextView) mView.findViewById(R.id.primary_location);
            locationOffsetView = (TextView) mView.findViewById(R.id.location_offset);
            dateView = (TextView) mView.findViewById(R.id.date);
            timeView = (TextView) mView.findViewById(R.id.time);

        }

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
   View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Earthquake currentEarthquake = earthquakes.get(position);
        EarthquakeProperties earthquakeProperties = currentEarthquake.getProperties();

        String formattedMagnitude = formatMagnitude(earthquakeProperties.getMagnitude());
        holder.magnitudeView.setText(formattedMagnitude);



        String originalLocation = earthquakeProperties.getLocation();
        // If the original location string (i.e. "5km N of Cairo, Egypt") contains
        // a primary location (Cairo, Egypt) and a location offset (5km N of that city)
        // then store the primary location separately from the location offset in 2 Strings,
        // so they can be displayed in 2 TextViews.
        String primaryLocation;
        String locationOffset;

        // Check whether the originalLocation string contains the " of " text

            if (originalLocation.contains(LOCATION_SEPARATOR)) {
               // Split the string into different parts (as an array of Strings)
            // based on the " of " text. We expect an array of 2 Strings, where
            // the first String will be "5km N" and the second String will be "Cairo, Egypt".
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            // Location offset should be "5km N " + " of " --> "5km N of"
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            // Primary location should be "Cairo, Egypt"
            primaryLocation = parts[1];
        } else {
            // Otherwise, there is no " of " text in the originalLocation string.
            // Hence, set the default location offset to say "Near the".
            locationOffset = "Near the";
            // The primary location will be the full location string "Pacific-Antarctic Ridge".
            primaryLocation = originalLocation;
        }
       holder.primaryLocationView.setText(primaryLocation);
        holder.locationOffsetView.setText(locationOffset);

        Date dateObject = new Date(earthquakeProperties.getTimeInMilliseconds());
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        holder.dateView.setText(formattedDate);

        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        holder.timeView.setText(formattedTime);
    }

    @Override
    public int getItemCount() {
        return earthquakes.size();
    }




    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

}
