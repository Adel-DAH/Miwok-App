package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {

    private int mBackgroundColor;

    public WordAdapter(@NonNull Context context, @NonNull ArrayList<Word> objects,int backgroundColor) {
        super(context, 0, objects);
        this.mBackgroundColor = backgroundColor;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View listItemView = convertView;
        if (listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Log.e("HYYYYYY",parent.toString());
        TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);
        TextView miwokTextTranslation = listItemView.findViewById(R.id.miwok_text_view);
        ImageView imageView = listItemView.findViewById(R.id.image_view);
        LinearLayout textLinearLayout = listItemView.findViewById(R.id.text_linear_layout);
        Word word = getItem(position);

        textLinearLayout.setBackgroundColor(this.getContext().getResources().getColor(this.mBackgroundColor));

        defaultTextView.setText(word.getmDefaultTranslation());
        miwokTextTranslation.setText(word.getmMiwokTranslation());

        if (word.hasImage()) {
            imageView.setImageResource(word.getmImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {

            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }


}
