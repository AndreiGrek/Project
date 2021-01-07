package ru.academy.project.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.academy.project.R;
import ru.academy.project.data.database.Contragent;
import ru.academy.project.data.database.Contragent73;

public class ItemListAdapter73 extends RecyclerView.Adapter<ItemListAdapter73.ItemViewHolder> {
    private List<Contragent73> itemList;


    public ItemListAdapter73(List<Contragent73> itemList) {
        this.itemList = itemList;
    }

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position, String name, String data);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contragent_item, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view, mListener);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(position);
        Contragent73 currentItem = itemList.get(position);
        holder.textViewName.setText(currentItem.getName());
        holder.phoneView.setText(currentItem.getData());
    }

    @Override
    public int getItemCount() {
        return itemList != null ? itemList.size() : 0;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView phoneView;
        private TextView textViewName;
        private TextView textNumberView;

        public ItemViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            textNumberView = itemView.findViewById(R.id.numberView);
            imageView = itemView.findViewById(R.id.lineView);
            phoneView = itemView.findViewById(R.id.phoneView);
            textViewName = itemView.findViewById(R.id.nameView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        String name = textViewName.getText().toString();
                        String data = phoneView.getText().toString();
                        listener.onItemClick(position, name, data);
                    }
                }
            });
        }

        public void bind(final int number) {
            textNumberView.setText(String.valueOf(number + 1));
        }
    }
}