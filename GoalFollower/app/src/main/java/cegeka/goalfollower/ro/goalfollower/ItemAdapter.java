    package com.example.cristi.firstcegeka;

    import android.content.Context;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.BaseAdapter;
    import android.widget.TextView;

    import cegeka.goalfollower.ro.goalfollower.R;

    public class ItemAdapter extends BaseAdapter {

        LayoutInflater mInflater;
        String[] names;
        String[] duedate;

        public ItemAdapter(Context c , String[] n , String[] d )
        {
            names = n;
            duedate = d;
            mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View v = mInflater.inflate(R.layout.custom_list,null);

            TextView name_taskTextView = v.findViewById(R.id.name_task);
            TextView due_dateTextView = v.findViewById(R.id.due_date);

            String name = names[position];
            String date = duedate[position];

            name_taskTextView.setText(name);
            due_dateTextView.setText((date));

            return v;
        }
    }
