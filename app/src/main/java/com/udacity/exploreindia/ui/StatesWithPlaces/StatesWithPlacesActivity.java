package com.udacity.exploreindia.ui.StatesWithPlaces;


        import android.support.annotation.Nullable;
        import android.os.Bundle;
        import android.widget.ListView;




        import com.udacity.exploreindia.R;
        import com.udacity.exploreindia.adapter.SelectedStatePlaceAdapter;
        import com.udacity.exploreindia.base.BaseActivity;
        import com.udacity.exploreindia.databinding.ActivityStatesWithPlacesBinding;

public class StatesWithPlacesActivity extends BaseActivity<StatesWithPlacesContract.Presenter, ActivityStatesWithPlacesBinding> implements StatesWithPlacesContract.View {
    private ListView listViewLeft;
    private ListView listViewRight;
    private SelectedStatePlaceAdapter leftAdapter;
    private SelectedStatePlaceAdapter rightAdapter;

    @Override
    protected int getContentResource() {
        return R.layout.image_item_list;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {
        listViewLeft = (ListView) findViewById(R.id.list_view_left);
        listViewRight = (ListView) findViewById(R.id.list_view_right);

        loadItems();

    }

    @Override
    protected void beforeView(@Nullable Bundle savedInstanceState) {

    }


    private void loadItems(){
        Integer[] leftItems = new Integer[]{R.drawable.gujarat1, R.drawable.gujarat2,R.drawable.gujarat3, R.drawable.gujarat4, R.drawable.gujarat5,R.drawable.gujarat6, R.drawable.gujarat7, R.drawable.gujarat8};
        Integer[] rightItems = new Integer[]{ R.drawable.gujarat5, R.drawable.gujarat7,R.drawable.gujarat8, R.drawable.gujarat6, R.drawable.gujarat4,R.drawable.gujarat3, R.drawable.gujarat2, R.drawable.gujarat1};
        String[]  leftplacenames =new String[]{"Bharuch","Vadodara","Akshardham","Sarkhej Roza","Nagina Masjid","Akshardham","Gandhinagar","Rajkot"};
        String[]  rightplacenames =new String[]{"Nagina Masjid","Gandhinagar","Rajkot","Akshardham","Sarkhej Roza","Bharuch","Vadodara","Akshardham"};

        leftAdapter = new SelectedStatePlaceAdapter(this, R.layout.activity_states_with_places, leftItems,leftplacenames);
        rightAdapter = new SelectedStatePlaceAdapter(this, R.layout.activity_states_with_places, rightItems,rightplacenames);
        listViewLeft.setAdapter(leftAdapter);
        listViewRight.setAdapter(rightAdapter);

    }
}
