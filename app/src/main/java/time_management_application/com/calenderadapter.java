package time_management_application.com;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class calenderadapter extends RecyclerView.Adapter<calenderviewholder> {

    private final ArrayList<String> daysofmonth;
    private final OnItemListener onItemListener;

    public calenderadapter(ArrayList<String> daysofmonth, OnItemListener onItemListener)
    {
        this.daysofmonth = daysofmonth;
        this.onItemListener = onItemListener;
    }

    @Override
    public calenderviewholder onCreateViewHolder( ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.calender_cell,parent,false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height =(int) (parent.getHeight() * 0.1666666666);
        return new calenderviewholder(view, onItemListener);
    }

    @Override
    public void onBindViewHolder( calenderviewholder holder, int position)
    {
        holder.dayofmonth.setText(daysofmonth.get(position));

    }

    @Override
    public int getItemCount() {
        return daysofmonth.size();
    }

    public interface OnItemListener
    {
        void onItemClick(int position,String daytext);
    }
}
