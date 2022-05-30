package sg.edu.np.mad.madpractical;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MessageViewHolder extends RecyclerView.ViewHolder{
    ImageView img;
    ImageView img2;
    TextView nme;
    TextView desc;
    public MessageViewHolder(View item) {
        super(item);
        img = item.findViewById(R.id.androidlogo1);
        img2 = item.findViewById(R.id.biglogo);
        nme = item.findViewById(R.id.name);
        desc = item.findViewById(R.id.description);
    }
}
