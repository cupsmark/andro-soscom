package com.cups.soscom.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
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
import com.cups.soscom.util.RecyclerViewDecorationGrid;
import com.cups.soscom.util.RecyclerViewItemDecoration;
import com.cups.soscom.util.RecyclerViewItemDivider;
import com.cups.soscom.util.UIImageLoader;

import java.util.ArrayList;

/**
 * Created by ekobudiarto on 6/6/17.
 */

public class FragmentSearch extends BaseFragment {

    View mainView;
    HelperGlobal.InterfaceFragment interfaceFragment;
    BaseActivity activity;
    final String TAG_FRAGMENT_SEARCH = "tag:fragment_search";

    ArrayList<String> dataSearchID, dataSearchFullname, dataSearchImage, dataSearchTitle,
            dataSearchPrice, dataPopularCountStar;

    RecyclerView recyclerSearch;
    AdapterSearch adapters;
    UIImageLoader imageLoader;
    SwipeRefreshLayout refreshLayout;
    boolean isRefresh = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if(mainView == null)
        {
            mainView = inflater.inflate(R.layout.fragment_search, container, false);
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
        setTAG(TAG_FRAGMENT_SEARCH);
        dataSearchID = new ArrayList<String>();
        dataSearchFullname = new ArrayList<String>();
        dataSearchImage = new ArrayList<String>();
        dataSearchTitle = new ArrayList<String>();
        dataSearchPrice = new ArrayList<String>();
        dataPopularCountStar = new ArrayList<String>();
        imageLoader = new UIImageLoader(activity);
        adapters = new AdapterSearch();
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
        recyclerSearch = (RecyclerView) mainView.findViewById(R.id.frg_search_recycler);
        refreshLayout = (SwipeRefreshLayout) mainView.findViewById(R.id.frg_search_swiperefresh);
        RecyclerViewDecorationGrid decoration = new RecyclerViewDecorationGrid(1);
        GridLayoutManager glm = new GridLayoutManager(activity, 2);
        recyclerSearch.setLayoutManager(glm);
        recyclerSearch.setHasFixedSize(true);
        recyclerSearch.setItemAnimator(new DefaultItemAnimator());
        recyclerSearch.addItemDecoration(decoration);
        recyclerSearch.setAdapter(adapters);
        recyclerSearch.addOnItemTouchListener(new HelperGlobal.RecyclerTouchListener(activity, recyclerSearch, new HelperGlobal.ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        recyclerSearch.addOnScrollListener(new EndlessRecyclerViewScrollListener(glm) {
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
            dataSearchID.add("1");
            dataSearchID.add("2");
            dataSearchID.add("3");
            dataSearchID.add("4");
            dataSearchID.add("5");
            dataSearchID.add("6");
            dataSearchFullname.add("Alcatel Phone");
            dataSearchFullname.add("Samsin Store");
            dataSearchFullname.add("Shoesbox");
            dataSearchFullname.add("Zigzag Camera");
            dataSearchFullname.add("Polo Store");
            dataSearchFullname.add("SepatuBoy");
            dataSearchImage.add("http://media.alcatelonetouch.us/pub/media/catalog/product/cache/1/image/e9c3970ab036de70892d86c6d221abfe/p/o/pop_astro_front.png");
            dataSearchImage.add("https://paketblackberry.com/wp-content/uploads/2013/08/harga-samsung-galaxy-young-s6310.jpg");
            dataSearchImage.add("http://media.dinomarket.com/docs/imgusr/2014-10/Nike_Rabona_0_11_211014141053_ll.jpg.jpg");
            dataSearchImage.add("http://www.pusatharga.net/wp-content/uploads/2015/04/Nikon-D3200.jpg");
            dataSearchImage.add("https://ecs7.tokopedia.net/img/product-1/2015/9/6/304112/304112_4cc3d6ac-2b3b-41f3-9ee6-a0bd4cb885f1.jpg");
            dataSearchImage.add("https://ecs7.tokopedia.net/img/product-1/2015/9/3/578885/578885_5690f0d8-5202-11e5-a698-926387772fba.jpg");
            dataSearchTitle.add("Alcatel Model");
            dataSearchTitle.add("Samsung Galasin Young");
            dataSearchTitle.add("Sepatu Nike KW");
            dataSearchTitle.add("NIKON D3200");
            dataSearchTitle.add("Kaos Polo Murah");
            dataSearchTitle.add("Sepatu Adidas Ori");
            dataSearchPrice.add("IDR 250.000");
            dataSearchPrice.add("IDR 300.000");
            dataSearchPrice.add("IDR 600.000");
            dataSearchPrice.add("IDR 1.400.000");
            dataSearchPrice.add("IDR 70.000");
            dataSearchPrice.add("IDR 8.000.000");
            dataPopularCountStar.add("112");
            dataPopularCountStar.add("32");
            dataPopularCountStar.add("544");
            dataPopularCountStar.add("143");
            dataPopularCountStar.add("165");
            dataPopularCountStar.add("170");
            adapters.notifyDataSetChanged();
        }
        else
        {
            isRefresh = false;
            refreshLayout.setRefreshing(false);
        }
    }

    class AdapterSearch extends RecyclerView.Adapter<AdapterSearch.AdapterSearchHolder>{

        private static final int TYPE_HEADER = 0;
        private static final int TYPE_ITEM = 1;

        public AdapterSearch()
        {

        }

        @Override
        public int getItemViewType(int position) {
            return TYPE_ITEM;
        }

        @Override
        public AdapterSearch.AdapterSearchHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_frg_search, parent, false);
            return new AdapterSearch.AdapterSearchHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final AdapterSearch.AdapterSearchHolder holder, int position) {
            holder.comFullname.setText(dataSearchFullname.get(position));
            holder.comTitle.setText(dataSearchTitle.get(position));
            holder.comPrice.setText(dataSearchPrice.get(position));
            holder.comStar.setText(dataPopularCountStar.get(position));
            imageLoader.showImage(dataSearchImage.get(position), holder.comBigImage);
        }

        @Override
        public int getItemCount() {
            return dataSearchID.size();
        }


        public class AdapterSearchHolder extends RecyclerView.ViewHolder{
            UIText comFullname,comStar, comTitle, comPrice;
            ImageView comBigImage;

            public AdapterSearchHolder(View itemView) {
                super(itemView);
                comFullname = (UIText) itemView.findViewById(R.id.item_list_frg_search_fullname);
                comTitle = (UIText) itemView.findViewById(R.id.item_list_frg_search_title);
                comPrice = (UIText) itemView.findViewById(R.id.item_list_frg_search_price);
                comStar = (UIText) itemView.findViewById(R.id.item_list_frg_search_rate);
                comBigImage = (ImageView) itemView.findViewById(R.id.item_list_frg_search_image);
            }
        }

        public boolean isHeader(int position)
        {
            return position == 0;
        }

        public void clear()
        {
            dataSearchID.clear();
            dataSearchFullname.clear();
            dataSearchImage.clear();
            dataSearchTitle.clear();
            dataSearchPrice.clear();
            dataPopularCountStar.clear();
        }
    }

    @Override
    public String getTAG() {
        return TAG_FRAGMENT_SEARCH;
    }
}
