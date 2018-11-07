package com.example.helenkellercompute.guokun.phoneVideo.page;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helenkellercompute.guokun.R;
import com.example.helenkellercompute.guokun.phoneVideo.activity.SystemVideoPlayer;
import com.example.helenkellercompute.guokun.phoneVideo.adpter.VideoPagerAdapter;
import com.example.helenkellercompute.guokun.phoneVideo.base.BasePager;
import com.example.helenkellercompute.guokun.phoneVideo.domain.MediaItem;

import java.util.ArrayList;

/**
 * Created by Helen keller compute on 2018/4/20.
 */

public class VideoPager extends BasePager {
    private ListView lv_video;
    private TextView tv_novideo;
    private ProgressBar pb_loading;
    private ArrayList<MediaItem> mediaItems;
    private VideoPagerAdapter videoPagerAdapter;
    private static final int PERMISSION_REQUEST_CODE = 1; //权限请求码


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (mediaItems != null && mediaItems.size() > 0) {
                //有数据
                videoPagerAdapter = new VideoPagerAdapter(context, mediaItems);
                lv_video.setAdapter(videoPagerAdapter);

                tv_novideo.setVisibility(View.GONE);


            } else {
                //没有数据
                tv_novideo.setVisibility(View.VISIBLE);

            }
            pb_loading.setVisibility(View.GONE);
        }
    };

    /**
     * @param context 上下文
     */
    public VideoPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.video_pager, null);
        lv_video = (ListView) view.findViewById(R.id.lv_video);
        tv_novideo = (TextView) view.findViewById(R.id.tv_novideo);
        pb_loading = (ProgressBar) view.findViewById(R.id.pb_loading);
        //设置listview的点击事件
        lv_video.setOnItemClickListener(new MyOnItemClickListener());
        return view;
    }

    class MyOnItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            MediaItem mediaItem = mediaItems.get(position);
            Toast.makeText(context, "mediaItem=" + mediaItem.toString(), Toast.LENGTH_SHORT).show();
            //调用播放器
//            Intent intent = new Intent();
//            intent.setDataAndType(Uri.parse(mediaItem.getData()),"video/*");
//            context.startActivity(intent);

            //自己写一个播放器
//            SystemVideoPlayer systemVideoPlayer = new SystemVideoPlayer(Uri.parse(mediaItem.getArtist()));
            Intent intent = new Intent(context, SystemVideoPlayer.class);
            Log.i("TEST", "标记一");
            intent.setDataAndType(Uri.parse(mediaItem.getData()), "video/*");
            context.startActivity(intent);

        }
    }

    @Override
    public void initData() {
        super.initData();
        Log.i("TEST", "本地音乐页面");
        //加载本地视频数据
        getDataFromLocal();
    }

    /**
     * 从本地的sdcard读取数据
     * 1.遍历sdcard信息。
     * 2.从内容提供者里面获取信息
     */
    private void getDataFromLocal() {
        mediaItems = new ArrayList<>();
        new Thread() {
            @Override
            public void run() {
                super.run();
                //取得内容提供者
                ContentResolver resolver = context.getContentResolver();

                Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                String[] objs = {
                        MediaStore.Video.Media.DISPLAY_NAME,//视频在cdcard下面的名称   0  name
                        MediaStore.Video.Media.DURATION,//视频总时长                    1  duration
                        MediaStore.Video.Media.SIZE,//大小                               2 size
                        MediaStore.Video.Media.DATA,//视频的绝对地址                      3 data
                        MediaStore.Video.Media.ARTIST,//歌曲艺术家                         4 arist
                };
                Cursor cursor = resolver.query(uri, objs, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        MediaItem mediaItem = new MediaItem();
                        mediaItems.add(mediaItem);

                        String name = cursor.getString(0);
                        long duration = cursor.getLong(1);
                        String data = cursor.getString(3);
                        String artist = cursor.getString(4);

                        mediaItem.setName(name);
                        mediaItem.setDuration(duration);
                        mediaItem.setData(data);
                        mediaItem.setArtist(artist);
                    }
                    cursor.close();
                }
                //发消息
                handler.sendEmptyMessage(10);//随便发什么消息都可以

            }
        }.start();

    }

}
