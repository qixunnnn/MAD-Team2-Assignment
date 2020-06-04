package sg.edu.sg.mad_t02_assignment;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GeneralContactViewHolder extends RecyclerView.ViewHolder {

    TextView title;
    TextView number;
    TextView email;

    public GeneralContactViewHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.contact_title);
        number = itemView.findViewById(R.id.contact_number);
        email = itemView.findViewById(R.id.contact_emaill);

    }
}
