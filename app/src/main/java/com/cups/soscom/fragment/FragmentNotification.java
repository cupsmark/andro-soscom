package com.cups.soscom.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cups.soscom.BaseActivity;
import com.cups.soscom.BaseFragment;
import com.cups.soscom.R;
import com.cups.soscom.helper.HelperGlobal;
import com.cups.soscom.ui.UIText;
import com.cups.soscom.util.EndlessRecyclerViewScrollListener;
import com.cups.soscom.util.RecyclerViewItemDivider;
import com.cups.soscom.util.UIImageLoader;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;


/**
 * Created by ekobudiarto on 6/2/17.
 */

public class FragmentNotification extends BaseFragment {

    View mainView;
    HelperGlobal.InterfaceFragment interfaceFragment;
    BaseActivity activity;
    final String TAG_FRAGMENT_NOTIFICATION = "tag:fragment_notification";

    ArrayList<String> dataNotifID, dataNotifAvatar, dataNotifCaption, dataNotifProductImage, dataNotifTime;
    RecyclerView recyclerNotif;
    UIImageLoader imageLoader;
    SwipeRefreshLayout refreshLayout;
    AdapterNotification adapters;
    boolean isRefresh = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if(mainView == null)
        {
            mainView = inflater.inflate(R.layout.fragment_notification, container, false);
        }
        onInit();
        return mainView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context != null)
        {
            this.activity = (BaseActivity) context;
            interfaceFragment = (HelperGlobal.InterfaceFragment) this.activity;
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity != null)
        {
            this.activity = (BaseActivity) activity;
            interfaceFragment = (HelperGlobal.InterfaceFragment) this.activity;
        }
    }

    @Override
    public void onInit() {
        super.onInit();
        setTAG(TAG_FRAGMENT_NOTIFICATION);
        dataNotifID = new ArrayList<String>();
        dataNotifAvatar = new ArrayList<String>();
        dataNotifCaption = new ArrayList<String>();
        dataNotifProductImage = new ArrayList<String>();
        dataNotifTime = new ArrayList<String>();
        imageLoader = new UIImageLoader(activity);
        adapters = new AdapterNotification();
    }

    @Override
    public void onStart() {
        super.onStart();
        onInitComponent();
        onLoadData();
    }


    @Override
    public void onInitComponent() {
        super.onInitComponent();
        recyclerNotif = (RecyclerView) mainView.findViewById(R.id.frg_notification_recycler);
        refreshLayout = (SwipeRefreshLayout) mainView.findViewById(R.id.frg_notification_swiperefresh);
        final LinearLayoutManager lm = new LinearLayoutManager(activity);
        RecyclerViewItemDivider rcDivider = new RecyclerViewItemDivider(activity, LinearLayoutManager.VERTICAL);
        recyclerNotif.setLayoutManager(lm);
        recyclerNotif.setItemAnimator(new DefaultItemAnimator());
        recyclerNotif.addItemDecoration(rcDivider);
        recyclerNotif.setAdapter(adapters);
        recyclerNotif.addOnItemTouchListener(new HelperGlobal.RecyclerTouchListener(activity, recyclerNotif, new HelperGlobal.ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        recyclerNotif.addOnScrollListener(new EndlessRecyclerViewScrollListener(lm) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {

            }
        });
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isRefresh = true;
                onLoadData();
            }
        });
    }

    @Override
    public void onLoadData() {
        super.onLoadData();
        if(!isRefresh) {
            adapters.clear();
            adapters.notifyDataSetChanged();
            dataNotifID.add("1");
            dataNotifID.add("2");
            dataNotifID.add("3");
            dataNotifID.add("4");
            dataNotifID.add("5");
            dataNotifID.add("6");
            dataNotifID.add("7");
            dataNotifID.add("8");
            dataNotifID.add("9");
            dataNotifID.add("10");
            dataNotifAvatar.add("http://www.saparch.com/public/widget/1_widget_john-doe.png");
            dataNotifAvatar.add("http://d169hzb81ub7u3.cloudfront.net/creative/wp-content/uploads/sites/8/2014/10/team03-notinclude.jpg");
            dataNotifAvatar.add("https://pbs.twimg.com/profile_images/478718430619508737/tYcaNp3k.jpeg");
            dataNotifAvatar.add("http://onfire.id/wp-content/uploads/2014/09/member2.jpg");
            dataNotifAvatar.add("https://daks2k3a4ib2z.cloudfront.net/57d81f90a05eea702f76f167/57d81f90a05eea702f76f23a_Jhon-Doe.jpg");
            dataNotifAvatar.add("http://www.wellafrica.com/inovus/wp-content/uploads/2016/07/team_circle_03-384x432.png");
            dataNotifAvatar.add("http://onfire.id/wp-content/uploads/2014/09/member2.jpg");
            dataNotifAvatar.add("https://pbs.twimg.com/profile_images/478718430619508737/tYcaNp3k.jpeg");
            dataNotifAvatar.add("http://www.saparch.com/public/widget/1_widget_john-doe.png");
            dataNotifAvatar.add("https://daks2k3a4ib2z.cloudfront.net/57d81f90a05eea702f76f167/57d81f90a05eea702f76f23a_Jhon-Doe.jpg");
            dataNotifCaption.add("Bayu loved your product");
            dataNotifCaption.add("John Doe commented your product");
            dataNotifCaption.add("Jenny Lee commented your product");
            dataNotifCaption.add("Burhan rated your product");
            dataNotifCaption.add("James loved your product");
            dataNotifCaption.add("Jenny Doe shared your product");
            dataNotifCaption.add("Karel loved your product");
            dataNotifCaption.add("Jay commented your product");
            dataNotifCaption.add("Maxim rated your product");
            dataNotifCaption.add("Krey rated your product");
            dataNotifProductImage.add("http://media.dinomarket.com/docs/imgusr/2014-10/Nike_Rabona_0_11_211014141053_ll.jpg.jpg");
            dataNotifProductImage.add("https://ecs7.tokopedia.net/img/product-1/2015/9/3/578885/578885_5690f0d8-5202-11e5-a698-926387772fba.jpg");
            dataNotifProductImage.add("http://media.alcatelonetouch.us/pub/media/catalog/product/cache/1/image/e9c3970ab036de70892d86c6d221abfe/p/o/pop_astro_front.png");
            dataNotifProductImage.add("https://paketblackberry.com/wp-content/uploads/2013/08/harga-samsung-galaxy-young-s6310.jpg");
            dataNotifProductImage.add("https://ecs7.tokopedia.net/img/product-1/2015/9/6/304112/304112_4cc3d6ac-2b3b-41f3-9ee6-a0bd4cb885f1.jpg");
            dataNotifProductImage.add("http://www.pusatharga.net/wp-content/uploads/2015/04/Nikon-D3200.jpg");
            dataNotifProductImage.add("http://media.alcatelonetouch.us/pub/media/catalog/product/cache/1/image/e9c3970ab036de70892d86c6d221abfe/p/o/pop_astro_front.png");
            dataNotifProductImage.add("https://paketblackberry.com/wp-content/uploads/2013/08/harga-samsung-galaxy-young-s6310.jpg");
            dataNotifProductImage.add("https://ecs7.tokopedia.net/img/product-1/2015/9/6/304112/304112_4cc3d6ac-2b3b-41f3-9ee6-a0bd4cb885f1.jpg");
            dataNotifProductImage.add("http://www.pusatharga.net/wp-content/uploads/2015/04/Nikon-D3200.jpg");
            dataNotifTime.add("1 hour ago");
            dataNotifTime.add("30 minute ago");
            dataNotifTime.add("25 minute ago");
            dataNotifTime.add("2 hour ago");
            dataNotifTime.add("15 hour ago");
            dataNotifTime.add("1 hour ago");
            dataNotifTime.add("30 minute ago");
            dataNotifTime.add("25 minute ago");
            dataNotifTime.add("2 hour ago");
            dataNotifTime.add("15 hour ago");
            adapters.notifyDataSetChanged();
        }
        else
        {
            isRefresh = false;
            refreshLayout.setRefreshing(false);
        }
    }

    class AdapterNotification extends RecyclerView.Adapter<AdapterNotification.AdapterNotificationHolder>{

        private static final int TYPE_HEADER = 0;
        private static final int TYPE_ITEM = 1;

        public AdapterNotification()
        {

        }

        @Override
        public int getItemViewType(int position) {
            return TYPE_ITEM;
        }

        @Override
        public AdapterNotification.AdapterNotificationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_frg_notification, parent, false);
            return new AdapterNotificationHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final AdapterNotificationHolder holder, int position) {
            holder.comCaption.setText(dataNotifCaption.get(position));
            holder.comTime.setText(dataNotifTime.get(position));
            imageLoader.showImage(dataNotifAvatar.get(position), holder.comAvatar);
            imageLoader.showImage(dataNotifProductImage.get(position), holder.comProductImage);
        }

        @Override
        public int getItemCount() {
            return dataNotifID.size();
        }


        public class AdapterNotificationHolder extends RecyclerView.ViewHolder{
            UIText comCaption, comTime;
            RoundedImageView comAvatar, comProductImage;

            public AdapterNotificationHolder(View itemView) {
                super(itemView);
                comCaption = (UIText) itemView.findViewById(R.id.item_list_frg_notification_caption);
                comTime = (UIText) itemView.findViewById(R.id.item_list_frg_notification_time);
                comAvatar = (RoundedImageView) itemView.findViewById(R.id.item_list_frg_notification_avatar);
                comProductImage = (RoundedImageView) itemView.findViewById(R.id.item_list_frg_notification_product_image);
            }
        }

        public boolean isHeader(int position)
        {
            return position == 0;
        }

        public void clear()
        {
            dataNotifID.clear();
            dataNotifCaption.clear();
            dataNotifAvatar.clear();
            dataNotifProductImage.clear();
            dataNotifTime.clear();
        }
    }

    @Override
    public String getTAG() {
        return TAG_FRAGMENT_NOTIFICATION;
    }
}
