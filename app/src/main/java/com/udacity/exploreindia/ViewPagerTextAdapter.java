package com.udacity.exploreindia;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kamalshree on 4/29/2018.
 */

public class ViewPagerTextAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private String[] textdetails = {
            "The Taj Mahal is an enormous mausoleum complex commissioned in 1632 by the Mughal emperor Shah Jahan to house the remains of his beloved wife. Constructed over a 20-year period on the southern bank of the Yamuna River in Agra, India, the famed complex is one of the most outstanding examples of Mughal architecture, which combined Indian, Persian and Islamic influences.",
            "Shah Jahan was a member of the Mughal dynasty that ruled most of northern India from the early 16th to the mid 18th-century. After the death of his father, King Jahangir, in 1627, Shah Jahan emerged the victor of a bitter power struggle with his brothers, and crowned himself emperor at Agra in 1628. ",
            "Construction began around 1632 and would continue for the next two decades. The chief architect was probably Ustad Ahmad Lahouri, an Indian of Persian descent who would later be credited with designing the Red Fort at Delhi. "};


    public ViewPagerTextAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return textdetails.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

       layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View view=layoutInflater.inflate(R.layout.custom_text_layout,null);

        TextView textView=(TextView)view.findViewById(R.id.places_details_tv_place_description);
        textView.setText(textdetails[position]);

        ViewPager viewPager=(ViewPager)container;
        viewPager.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager=(ViewPager)container;
        View view=(View) object;
        viewPager.removeView(view);
    }
}
