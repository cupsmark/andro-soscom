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
import com.cups.soscom.ui.UISquareImage;
import com.cups.soscom.ui.UIText;
import com.cups.soscom.util.EndlessRecyclerViewScrollListener;
import com.cups.soscom.util.RecyclerViewDecorationGrid;
import com.cups.soscom.util.RecyclerViewItemDivider;
import com.cups.soscom.util.UIImageLoader;

import java.util.ArrayList;

/**
 * Created by ekobudiarto on 6/6/17.
 */

public class FragmentPopular extends BaseFragment {

    View mainView;
    HelperGlobal.InterfaceFragment interfaceFragment;
    BaseActivity activity;
    final String TAG_FRAGMENT_POPULAR = "tag:fragment_popular";

    ArrayList<String> dataPopularID, dataPopularImage;

    RecyclerView recyclerPopular;
    AdapterPopular adapterPopular;
    UIImageLoader imageLoader;
    SwipeRefreshLayout refreshLayout;
    boolean isRefresh = false;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if(mainView == null)
        {
            mainView = inflater.inflate(R.layout.fragment_popular, container, false);
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
        setTAG(TAG_FRAGMENT_POPULAR);
        dataPopularID = new ArrayList<String>();
        dataPopularImage = new ArrayList<String>();
        imageLoader = new UIImageLoader(activity);
        adapterPopular = new AdapterPopular();
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
        recyclerPopular = (RecyclerView) mainView.findViewById(R.id.frg_popular_recycler);
        refreshLayout = (SwipeRefreshLayout) mainView.findViewById(R.id.frg_popular_swiperefresh);
        GridLayoutManager glm = new GridLayoutManager(activity, 3);
        RecyclerViewDecorationGrid decorationGrid = new RecyclerViewDecorationGrid(1);
        //RecyclerViewItemDivider rcDivider = new RecyclerViewItemDivider(activity, LinearLayoutManager.VERTICAL);
        recyclerPopular.setHasFixedSize(true);
        recyclerPopular.setLayoutManager(glm);
        recyclerPopular.setItemAnimator(new DefaultItemAnimator());
        recyclerPopular.addItemDecoration(decorationGrid);
        recyclerPopular.setAdapter(adapterPopular);
        recyclerPopular.addOnItemTouchListener(new HelperGlobal.RecyclerTouchListener(activity, recyclerPopular, new HelperGlobal.ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        recyclerPopular.addOnScrollListener(new EndlessRecyclerViewScrollListener(glm) {
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
            adapterPopular.clear();
            adapterPopular.notifyDataSetChanged();
            dataPopularID.add("1");
            dataPopularID.add("2");
            dataPopularID.add("3");
            dataPopularID.add("4");
            dataPopularID.add("5");
            dataPopularID.add("6");
            dataPopularID.add("7");
            dataPopularID.add("8");
            dataPopularID.add("9");
            dataPopularID.add("10");
            dataPopularID.add("11");
            dataPopularID.add("12");
            dataPopularID.add("13");
            dataPopularID.add("14");
            dataPopularID.add("15");
            dataPopularID.add("16");

            dataPopularImage.add("http://media.alcatelonetouch.us/pub/media/catalog/product/cache/1/image/e9c3970ab036de70892d86c6d221abfe/p/o/pop_astro_front.png");
            dataPopularImage.add("https://paketblackberry.com/wp-content/uploads/2013/08/harga-samsung-galaxy-young-s6310.jpg");
            dataPopularImage.add("http://media.dinomarket.com/docs/imgusr/2014-10/Nike_Rabona_0_11_211014141053_ll.jpg.jpg");
            dataPopularImage.add("http://www.pusatharga.net/wp-content/uploads/2015/04/Nikon-D3200.jpg");
            dataPopularImage.add("https://ecs7.tokopedia.net/img/product-1/2015/9/6/304112/304112_4cc3d6ac-2b3b-41f3-9ee6-a0bd4cb885f1.jpg");
            dataPopularImage.add("https://ecs7.tokopedia.net/img/product-1/2015/9/3/578885/578885_5690f0d8-5202-11e5-a698-926387772fba.jpg");
            dataPopularImage.add("http://media.alcatelonetouch.us/pub/media/catalog/product/cache/1/image/e9c3970ab036de70892d86c6d221abfe/p/o/pop_astro_front.png");
            dataPopularImage.add("https://paketblackberry.com/wp-content/uploads/2013/08/harga-samsung-galaxy-young-s6310.jpg");
            dataPopularImage.add("http://media.dinomarket.com/docs/imgusr/2014-10/Nike_Rabona_0_11_211014141053_ll.jpg.jpg");
            dataPopularImage.add("http://www.pusatharga.net/wp-content/uploads/2015/04/Nikon-D3200.jpg");
            dataPopularImage.add("https://ecs7.tokopedia.net/img/product-1/2015/9/6/304112/304112_4cc3d6ac-2b3b-41f3-9ee6-a0bd4cb885f1.jpg");
            dataPopularImage.add("https://ecs7.tokopedia.net/img/product-1/2015/9/3/578885/578885_5690f0d8-5202-11e5-a698-926387772fba.jpg");
            dataPopularImage.add("http://media.alcatelonetouch.us/pub/media/catalog/product/cache/1/image/e9c3970ab036de70892d86c6d221abfe/p/o/pop_astro_front.png");
            dataPopularImage.add("https://paketblackberry.com/wp-content/uploads/2013/08/harga-samsung-galaxy-young-s6310.jpg");
            dataPopularImage.add("http://media.dinomarket.com/docs/imgusr/2014-10/Nike_Rabona_0_11_211014141053_ll.jpg.jpg");
            dataPopularImage.add("http://www.pusatharga.net/wp-content/uploads/2015/04/Nikon-D3200.jpg");
            adapterPopular.notifyDataSetChanged();
        }
        else
        {
            isRefresh = false;
            refreshLayout.setRefreshing(false);
        }
    }

    class AdapterPopular extends RecyclerView.Adapter<AdapterPopular.AdapterPopularHolder>{

        private static final int TYPE_HEADER = 0;
        private static final int TYPE_ITEM = 1;

        public AdapterPopular()
        {

        }

        @Override
        public int getItemViewType(int position) {
            return TYPE_ITEM;
        }

        @Override
        public AdapterPopular.AdapterPopularHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_frg_popular, parent, false);
            return new AdapterPopular.AdapterPopularHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final AdapterPopular.AdapterPopularHolder holder, int position) {
            imageLoader.showImage(dataPopularImage.get(position), holder.comBigImage);
        }

        @Override
        public int getItemCount() {
            return dataPopularID.size();
        }


        public class AdapterPopularHolder extends RecyclerView.ViewHolder{
            UISquareImage comBigImage;

            public AdapterPopularHolder(View itemView) {
                super(itemView);
                comBigImage = (UISquareImage) itemView.findViewById(R.id.item_list_frg_popular_bigimage);
            }
        }

        public boolean isHeader(int position)
        {
            return position == 0;
        }

        public void clear()
        {
            dataPopularID.clear();
            dataPopularImage.clear();
        }
    }

    @Override
    public String getTAG() {
        return TAG_FRAGMENT_POPULAR;
    }
}
