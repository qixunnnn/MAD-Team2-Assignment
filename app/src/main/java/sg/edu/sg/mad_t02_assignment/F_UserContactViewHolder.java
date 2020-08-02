package sg.edu.sg.mad_t02_assignment;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class F_UserContactViewHolder extends RecyclerView.ViewHolder {

    CircleImageView circleImageView;
    TextView username;

    public F_UserContactViewHolder(@NonNull View itemView) {
        super(itemView);

        circleImageView = itemView.findViewById(R.id.circle_usercontact);
        username = itemView.findViewById(R.id.textview_usercontact);
    }
}
