package com.app.fotagmobile;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.util.ArrayList;

public class ImageAdapter extends ArrayAdapter implements Filterable {

    private Context mContext;
    private int layoutResourceId;
    private ArrayList<Image> list = null;
    private ArrayList<Image> origList = null;

    public ImageAdapter(Context mContext, int layoutResourceId, ArrayList<Image> data) {
        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.list = data;
        this.origList = data;
    }

    @Override
    public Image getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    public void addItem(Image i) {
        origList.add(i);
        notifyDataSetChanged();
    }

    public void clearAll() {
        origList.clear();
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {

            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder(convertView);
            holder.ratingBar = (RatingBar) convertView.findViewById(R.id.rating);
            holder.image = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        addListenerOnRatingBar(holder, position);

        holder.ratingBar.setTag(position);
        holder.ratingBar.setRating(getItem(position).getRatingStar());
        holder.image.setImageBitmap(getItem(position).getImage());

        return convertView;
    }

    public void addListenerOnRatingBar(ViewHolder holder, final int position) {
        holder.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Image item = getItem(position);
                item.setRatingStar(rating);
            }
        });
    }


    @Override
    public Filter getFilter() {

        Filter filter = new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                list = (ArrayList<Image>) results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults results = new FilterResults();

                ArrayList<Image> filteredImages = new ArrayList<Image>();

                // perform your search here using the searchConstraint String.

                if (constraint == null || constraint.length() == 0) {
                    results.values = origList;
                    results.count = origList.size();
                } else {
                    constraint = constraint.toString().toLowerCase();
                    for (int i = 0; i < origList.size(); i++) {
                        Image image = origList.get(i);
                        if (constraint.toString().equals("one")) {
                            if (image.getRatingStar() == 1) {
                                filteredImages.add(image);
                                System.out.println("1 Star");
                                System.out.println(origList.size());
                            }
                        } else if (constraint.toString().equals("two")) {
                            if (image.getRatingStar() == 2) {
                                filteredImages.add(image);
                                System.out.println("2 Star");
                                System.out.println(origList.size());
                            }
                        } else if (constraint.toString().equals("three")) {
                            if (image.getRatingStar() == 3) {
                                filteredImages.add(image);
                                System.out.println("3 Star");
                                System.out.println(origList.size());
                            }
                        } else if (constraint.toString().equals("four")) {
                            if (image.getRatingStar() == 4) {
                                filteredImages.add(image);
                                System.out.println("4 Star");
                                System.out.println(origList.size());
                            }
                        } else if (constraint.toString().equals("five")) {
                            if (image.getRatingStar() == 5) {
                                filteredImages.add(image);
                                System.out.println("5 Star");
                                System.out.println(origList.size());
                            }
                        }
                    }

                    results.count = filteredImages.size();
                    results.values = filteredImages;
                }

                return results;
            }
        };

        return filter;
    }

    static class ViewHolder {
        private RatingBar ratingBar;
        private ImageView image;

        public ViewHolder(View view) {
            ratingBar = (RatingBar) view.findViewById(R.id.rating);
            image = (ImageView) view.findViewById(R.id.image);
        }
    }
}
