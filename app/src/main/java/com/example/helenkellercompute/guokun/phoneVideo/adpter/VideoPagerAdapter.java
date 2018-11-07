package com.example.helenkellercompute.guokun.phoneVideo.adpter;

import android.content.Context;
import android.text.format.Formatter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helenkellercompute.guokun.R;
import com.example.helenkellercompute.guokun.phoneVideo.domain.MediaItem;

import java.util.ArrayList;

/**
 * Created by Helen keller compute on 2018/4/22.
 */

public class VideoPagerAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<MediaItem> mediaItems;

    public VideoPagerAdapter(Context context, ArrayList<MediaItem> mediaItems) {
        this.context = context;
        this.mediaItems = mediaItems;
    }

    @Override
    public int getCount() {
        return mediaItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoder viewHoder;
        if (convertView == null) {
            viewHoder = new ViewHoder();
            convertView = View.inflate(context, R.layout.item_video_pager, null);
            viewHoder.iv_video_pager_icon = (ImageView) convertView.findViewById(R.id.iv_video_pager_icon);
            viewHoder.tv_video_name = (TextView) convertView.findViewById(R.id.tv_video_name);
            viewHoder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
            viewHoder.tv_size = (TextView) convertView.findViewById(R.id.tv_size);

            convertView.setTag(viewHoder);
        } else {
            viewHoder = (ViewHoder) convertView.getTag();
        }
        //取得对应的数据
        MediaItem mediaItem = mediaItems.get(position);
        viewHoder.tv_video_name.setText(mediaItem.getName());
        viewHoder.tv_size.setText(Formatter.formatFileSize(context, mediaItem.getSize()));
//        viewHoder.tv_time.setText(mediaItem.get);
        return convertView;
    }

    static class ViewHoder {
        ImageView iv_video_pager_icon;
        TextView tv_video_name;
        TextView tv_time;
        TextView tv_size;
    }
}
