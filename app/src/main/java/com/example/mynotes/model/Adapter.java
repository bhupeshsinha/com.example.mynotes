package com.example.mynotes.model;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotes.note.NoteDetails;
import com.example.mynotes.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<String> titles;
    List<String> content;

    public Adapter(List<String> titles, List<String> content) {

        this.titles = titles;
        this.content = content;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_view_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.noteTitle.setText(titles.get(position));
        holder.noteContent.setText(content.get(position));
        final int code = getRandomColor();
        holder.mCardView.setCardBackgroundColor(holder.view.getResources().getColor(code, null));

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(), "The Item Is clicked", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(v.getContext(), NoteDetails.class);
                i.putExtra("title", titles.get(position));
                i.putExtra("content", content.get(position));
                i.putExtra("code", code);
                v.getContext().startActivity(i);

            }
        });
    }

    private int getRandomColor() {

        List<Integer> colorCode = new ArrayList<>();

        colorCode.add(R.color.deepskyblue);
        colorCode.add(R.color.lawngreen);
        colorCode.add(R.color.mediumaquamarine);
        colorCode.add(R.color.lightsteelblue);
        colorCode.add(R.color.tan);
        colorCode.add(R.color.Yellow);
        colorCode.add(R.color.PaleTurquoise);
        colorCode.add(R.color.Orange);
        colorCode.add(R.color.Magenta);
        colorCode.add(R.color.Gold);
        colorCode.add(R.color.MistyRose);
        colorCode.add(R.color.teal_200);
        colorCode.add(R.color.Wheat);
        colorCode.add(R.color.Khaki);
        colorCode.add(R.color.Thistle);
        colorCode.add(R.color.Orchid);
        colorCode.add(R.color.PapayaWhip);
        colorCode.add(R.color.Silver);
        colorCode.add(R.color.SandyBrown);
        colorCode.add(R.color.Violet);
        colorCode.add(R.color.dimgray);
        colorCode.add(R.color.Pink);
        colorCode.add(R.color.GreenYellow);
        colorCode.add(R.color.Red);
        colorCode.add(R.color.PaleTurquoise);
        colorCode.add(R.color.LightGoldenrodYellow);
        colorCode.add(R.color.DeepPink);

        Random randomColor = new Random();
        int number = randomColor.nextInt(colorCode.size());
        return colorCode.get(number);

    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView noteTitle, noteContent;
        View view;
        CardView mCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            noteTitle = itemView.findViewById(R.id.titles);
            noteContent = itemView.findViewById(R.id.content);
            mCardView = itemView.findViewById(R.id.noteCard);
            view = itemView;
        }
    }
}
