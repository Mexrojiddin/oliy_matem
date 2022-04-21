package uz.mexboy.oliy_matem.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import uz.mexboy.oliy_matem.R;
import uz.mexboy.oliy_matem.model.MundarijaModel;

public class MundarijaAdapter extends RecyclerView.Adapter<MundarijaAdapter.MyViewHolder> {

    private List<MundarijaModel> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public MundarijaAdapter(Context context, List<MundarijaModel> mData) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.rv_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String animal = mData.get(position).getTitle();
        holder.myTextView.setText(animal);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.theme_txt);
            itemView.setOnClickListener(this);
            itemView.setBackgroundColor(Color.TRANSPARENT);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());

        }
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}

