package time_management_application.com;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class calenderviewholder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public final TextView dayofmonth;
    private final calenderadapter.OnItemListener onItemListener;

    public calenderviewholder(@NonNull View itemView, calenderadapter.OnItemListener onItemListener) {
        super(itemView);
        dayofmonth=itemView.findViewById(R.id.celldaytext);
        this.onItemListener = onItemListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        onItemListener.onItemClick(getAdapterPosition(),(String) dayofmonth.getText());

    }
}
