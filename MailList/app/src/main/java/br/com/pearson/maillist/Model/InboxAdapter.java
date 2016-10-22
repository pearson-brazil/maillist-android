package br.com.pearson.maillist.Model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import br.com.pearson.maillist.R;

/**
 * Created by pearson on 29/09/16.
 */
public class InboxAdapter extends BaseAdapter {

    Context context;
    ArrayList<Email> data;
    private static LayoutInflater inflater = null;

    public InboxAdapter(Context context, ArrayList<Email> data) {
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        // Se a view for nula, infla do layout
        if (view == null)
            view = inflater.inflate(R.layout.row, null);

        // A ButterKnife pode ser um pouco problemática em um Adapter, então colete as Views de row do modo tradicional
        TextView brief = (TextView) view.findViewById(R.id.row_message);
        TextView from = (TextView) view.findViewById(R.id.row_contact);
        TextView subject = (TextView) view.findViewById(R.id.row_subject);
        final ImageView picture = (ImageView) view.findViewById(R.id.contact_picture);

        // Define os respectivos textos dado uma position
        brief.setText(data.get(position).getMessage());
        from.setText(data.get(position).getFrom());
        subject.setText(data.get(position).getSubject());

        ColorGenerator generator = ColorGenerator.MATERIAL;

        int color = generator.getColor(data.get(position).getFirstLetter());

        TextDrawable drawable = TextDrawable.builder()
                .buildRoundRect(data.get(position).getFirstLetter(), color, 46);

        picture.setImageDrawable(drawable);

        if (data.get(position).getImageUrl() != null) {
            Glide.with(context).load(data.get(position)
                    .getImageUrl())
                    .asBitmap()
                    .centerCrop()
                    .into(new BitmapImageViewTarget(picture) {

                        @Override
                        protected void setResource(Bitmap resource) {
                            RoundedBitmapDrawable circularBitmapDrawable =
                                    RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                            circularBitmapDrawable.setCircular(true);
                            picture.setImageDrawable(circularBitmapDrawable);
                        }
                    });

        }

        return view;
    }

}

