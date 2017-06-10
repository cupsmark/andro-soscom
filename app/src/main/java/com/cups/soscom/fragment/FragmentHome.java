package com.cups.soscom.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.cups.soscom.BaseActivity;
import com.cups.soscom.BaseFragment;
import com.cups.soscom.R;
import com.cups.soscom.helper.HelperGlobal;
import com.cups.soscom.ui.UIText;
import com.cups.soscom.util.EndlessRecyclerViewScrollListener;
import com.cups.soscom.util.RecyclerViewItemDivider;
import com.cups.soscom.util.UIImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;

/**
 * Created by ekobudiarto on 6/2/17.
 */

public class FragmentHome extends BaseFragment {

    View mainView;
    HelperGlobal.InterfaceFragment interfaceFragment;
    BaseActivity activity;
    final String TAG_FRAGMENT_HOME = "tag:fragment_signin";

    ArrayList<String> dataHomeID, dataHomeFullname, dataHomeAvatar, dataHomeImage, dataHomeTitle,
            dataHomePrice, dataHomeCountLove, dataHomeCountComment;

    RecyclerView recyclerHome;
    AdapterHome adapterHome;
    UIImageLoader imageLoader;
    SwipeRefreshLayout refreshLayout;
    boolean isRefresh = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if(mainView == null)
        {
            mainView = getLayoutInflater(savedInstanceState).inflate(R.layout.fragment_home, container, false);
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
        setTAG(TAG_FRAGMENT_HOME);
        dataHomeID = new ArrayList<String>();
        dataHomeFullname = new ArrayList<String>();
        dataHomeAvatar = new ArrayList<String>();
        dataHomeImage = new ArrayList<String>();
        dataHomeTitle = new ArrayList<String>();
        dataHomePrice = new ArrayList<String>();
        dataHomeCountLove = new ArrayList<String>();
        dataHomeCountComment = new ArrayList<String>();
        imageLoader = new UIImageLoader(activity);
        adapterHome = new AdapterHome();

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
        recyclerHome = (RecyclerView) mainView.findViewById(R.id.frg_home_recycler);
        refreshLayout = (SwipeRefreshLayout) mainView.findViewById(R.id.frg_home_swiperefresh);
        final LinearLayoutManager lm = new LinearLayoutManager(activity);
        RecyclerViewItemDivider rcDivider = new RecyclerViewItemDivider(activity, LinearLayoutManager.VERTICAL);
        recyclerHome.setLayoutManager(lm);
        recyclerHome.setItemAnimator(new DefaultItemAnimator());
        recyclerHome.addItemDecoration(rcDivider);
        recyclerHome.setAdapter(adapterHome);
        recyclerHome.addOnItemTouchListener(new HelperGlobal.RecyclerTouchListener(activity, recyclerHome, new HelperGlobal.ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        recyclerHome.addOnScrollListener(new EndlessRecyclerViewScrollListener(lm) {
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
            adapterHome.clear();
            adapterHome.notifyDataSetChanged();
            dataHomeID.add("1");
            dataHomeID.add("2");
            dataHomeID.add("3");
            dataHomeID.add("4");
            dataHomeID.add("5");
            dataHomeID.add("6");
            dataHomeFullname.add("Shoesbox");
            dataHomeFullname.add("SepatuBoy");
            dataHomeFullname.add("Alcatel Phone");
            dataHomeFullname.add("Samsin Store");
            dataHomeFullname.add("Polo Store");
            dataHomeFullname.add("Zigzag Camera");
            dataHomeAvatar.add("https://cdn.pixabay.com/photo/2016/04/15/18/05/computer-1331579_960_720.png");
            dataHomeAvatar.add("https://www.atomix.com.au/media/2015/06/atomix_user31.png");
            dataHomeAvatar.add("https://cdn.pixabay.com/photo/2016/04/15/18/05/computer-1331579_960_720.png");
            dataHomeAvatar.add("https://www.atomix.com.au/media/2015/06/atomix_user31.png");
            dataHomeAvatar.add("https://cdn.pixabay.com/photo/2016/04/15/18/05/computer-1331579_960_720.png");
            dataHomeAvatar.add("https://www.atomix.com.au/media/2015/06/atomix_user31.png");
            dataHomeImage.add("http://media.dinomarket.com/docs/imgusr/2014-10/Nike_Rabona_0_11_211014141053_ll.jpg.jpg");
            dataHomeImage.add("https://ecs7.tokopedia.net/img/product-1/2015/9/3/578885/578885_5690f0d8-5202-11e5-a698-926387772fba.jpg");
            dataHomeImage.add("http://media.alcatelonetouch.us/pub/media/catalog/product/cache/1/image/e9c3970ab036de70892d86c6d221abfe/p/o/pop_astro_front.png");
            dataHomeImage.add("https://paketblackberry.com/wp-content/uploads/2013/08/harga-samsung-galaxy-young-s6310.jpg");
            dataHomeImage.add("https://ecs7.tokopedia.net/img/product-1/2015/9/6/304112/304112_4cc3d6ac-2b3b-41f3-9ee6-a0bd4cb885f1.jpg");
            dataHomeImage.add("http://www.pusatharga.net/wp-content/uploads/2015/04/Nikon-D3200.jpg");
            dataHomeTitle.add("Sepatu Nike KW");
            dataHomeTitle.add("Sepatu Adidas Ori");
            dataHomeTitle.add("Alcatel Model");
            dataHomeTitle.add("Samsung Galasin Young");
            dataHomeTitle.add("Kaos Polo Murah");
            dataHomeTitle.add("NIKON D3200");
            dataHomePrice.add("250K");
            dataHomePrice.add("130K");
            dataHomePrice.add("670K");
            dataHomePrice.add("1.4M");
            dataHomePrice.add("70K");
            dataHomePrice.add("8M");
            dataHomeCountLove.add("100");
            dataHomeCountLove.add("50");
            dataHomeCountLove.add("124");
            dataHomeCountLove.add("1K");
            dataHomeCountLove.add("80");
            dataHomeCountLove.add("300");
            dataHomeCountComment.add("30");
            dataHomeCountComment.add("90");
            dataHomeCountComment.add("165");
            dataHomeCountComment.add("345");
            dataHomeCountComment.add("321");
            dataHomeCountComment.add("14");
            adapterHome.notifyDataSetChanged();
        }
        else
        {
            isRefresh = false;
            refreshLayout.setRefreshing(false);
        }
    }

    @Override
    public String getTAG() {
        return TAG_FRAGMENT_HOME;
    }

    class AdapterHome extends RecyclerView.Adapter<AdapterHome.AdapterHomeHolder>{

        private static final int TYPE_HEADER = 0;
        private static final int TYPE_ITEM = 1;

        public AdapterHome()
        {

        }

        @Override
        public int getItemViewType(int position) {
            return TYPE_ITEM;
        }

        @Override
        public AdapterHomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_frg_home, parent, false);
            return new AdapterHomeHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final AdapterHomeHolder holder, int position) {
            holder.comFullname.setText(dataHomeFullname.get(position));
            holder.comTitle.setText(dataHomeTitle.get(position));
            holder.comPrice.setText(dataHomePrice.get(position));
            holder.comLove.setText(dataHomeCountLove.get(position));
            holder.comComment.setText(dataHomeCountComment.get(position));
            imageLoader.showImage(dataHomeImage.get(position), holder.comBigImage);
            imageLoader.showImage(dataHomeAvatar.get(position), holder.comAvatar);
        }

        @Override
        public int getItemCount() {
            return dataHomeID.size();
        }


        public class AdapterHomeHolder extends RecyclerView.ViewHolder{
            UIText comFullname, comLove, comComment, comTitle, comPrice;
            ImageView comBigImage, comAvatar;

            public AdapterHomeHolder(View itemView) {
                super(itemView);
                comFullname = (UIText) itemView.findViewById(R.id.item_list_frg_home_fullname);
                comTitle = (UIText) itemView.findViewById(R.id.item_list_frg_home_product_name);
                comPrice = (UIText) itemView.findViewById(R.id.item_list_frg_home_product_price);
                comLove = (UIText) itemView.findViewById(R.id.item_list_frg_home_stat_love);
                comComment = (UIText) itemView.findViewById(R.id.item_list_frg_home_stat_comment);
                comBigImage = (ImageView) itemView.findViewById(R.id.item_list_frg_home_bigimage);
                comAvatar = (ImageView) itemView.findViewById(R.id.item_list_frg_home_avatar);
            }
        }

        public boolean isHeader(int position)
        {
            return position == 0;
        }

        public void clear()
        {
            dataHomeID.clear();
            dataHomeFullname.clear();
            dataHomeAvatar.clear();
            dataHomeImage.clear();
            dataHomeTitle.clear();
            dataHomePrice.clear();
            dataHomeCountLove.clear();
            dataHomeCountComment.clear();
        }
    }
}
