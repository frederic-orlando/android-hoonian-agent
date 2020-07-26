package com.example.hoonianAgent.view.fragment.news;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.CustomContent;
import com.example.hoonianAgent.model.content.home.HomeItem;
import com.example.hoonianAgent.model.content.news.News;
import com.example.hoonianAgent.model.response.news.ResponseGetNewsDetail;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;
import com.example.hoonianAgent.view.adapter.recycler.AdapterCustomContent;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;

import java.util.ArrayList;

import lombok.Setter;

@EBean
public class NewsDetailImpl extends BaseImpl<NewsDetailView> implements NewsDetailPres, RecyclerListener {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;
    @Setter
    private HomeItem newsItem;

    private News news;

    @Override
    public void init() {
        serviceManager.getNewsDetail(newsItem.getId());
    }

    @Override
    public void initData() {
        loadImage(news.getImage(), viewAct.image());
        viewAct.titleLbl().setText(news.getTitle());

        setDataContent(news.getContent());
    }

    @Override
    @UiThread
    public void setDataContent(ArrayList<CustomContent> listContents) {
        if (viewAct.content() != null) {
            AdapterCustomContent adapter = new AdapterCustomContent(listContents, this);
            viewAct.content().setAdapter(adapter);
            viewAct.content().setLayoutManager(new LinearLayoutManager(activity));
        }
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof ResponseGetNewsDetail) {
            news = ((ResponseGetNewsDetail) o).getNews();
            initData();
        }
    }

    @Override
    public void onItemClick(Object o) {

    }
}
