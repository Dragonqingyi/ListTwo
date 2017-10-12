package com.dragonyang.listtwo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 时光与你 on 2017/10/11.
 * 自定义适配器——重点与难点
 */

public class EffivientAdapter extends BaseAdapter {

    /**
     * 布局填充器
     * 数据源数组
     * 与数据源数组对应的图标id
     * 列表项布局文件
     * 所在上下文——句柄
     */
    private LayoutInflater mInflater;
    private String[] mDateSourse;
    private int[] mIcons;
    private int mRecourse;
    private Context mContext;

    public EffivientAdapter(Context mContext, int mRecourse, String[] mDateSourse, int[] mIcons) {
        this.mDateSourse = mDateSourse;
        this.mIcons = mIcons;
        this.mRecourse = mRecourse;
        this.mContext = mContext;
        /**
         * 通过上下文对象创建布局填充器
         * 这是一种工厂设计模式，详见java设计模式一书
         */
        mInflater = LayoutInflater.from(mContext);
    }

    //返回总数据源中总的记录数
    @Override
    public int getCount() {
        return mDateSourse.length;
    }

    //根据选择列表项位置，返回列表项所需数据
    @Override
    public Object getItem(int position) {
        return mDateSourse[position];
    }

    //根据选择列表项位置，返回列表项id
    @Override
    public long getItemId(int position) {
        return position;
    }

    //返回列表所在视图对象
    @Override
    /**
     * 自定义适配器的重点！！！！
     * 返回的是视图，就是列表每一项在屏幕上的显示，就会调用此方法获得列表视图
     * 如果每次每次实例化列表项，会带来巨大内存开支，参数convertView就是为了解决的此问题设计的
     * 他是一个可重复使用的列表项视图对象
     * 首先convertView是整个列表显示设置的操作者
     *如果它为空（一般是刚进入屏幕）就进行实例化，通过布局填充器的inflate方法实例化操作，mRecourse是布局文件id
     * 还要将holder里存放的控件获取，来显示内容
     *如果不为空，就返回它
     * 每一个view对象都有tag属性，属性类型是Object，可存放任何类型
     * setTag方法向列表里面放东西
     * 通过getTag取出holder对象
     * 但是holder是旧对象，是上次显示的，所以接下来用set方法放入新对象，设置新的显示内容
     * BitmapFactory工厂类decodeResource方法通过图片资源id获得当前句柄的图片对象
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(mRecourse, null);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.text1);
            holder.imageView = convertView.findViewById(R.id.icon1);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(mDateSourse[position]);
        Bitmap icon = BitmapFactory.decodeResource(mContext.getResources(), mIcons[position]);
        holder.imageView.setImageBitmap(icon);
        return convertView;
    }

    //保存列表项中控件的封装类，可以自由定义
    static class ViewHolder {
        TextView textView;
        ImageView imageView;
    }
}
