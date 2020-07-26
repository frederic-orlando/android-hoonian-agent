package com.example.hoonianAgent.view.fragment.project.list;

import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.agent.Agent;
import com.example.hoonianAgent.model.content.property.Project;
import com.example.hoonianAgent.model.request.project.RequestFavorite;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.example.hoonianAgent.model.response.project.ModelDataProjectList;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.FavoriteListener;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.session.SessionUser;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;
import com.example.hoonianAgent.view.adapter.recycler.AdapterProjectList;
import com.example.hoonianAgent.view.adapter.recycler.itemDecoration.ItemDecorationVertical;
import com.example.hoonianAgent.view.fragment.project.ProjectFragment_;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import lombok.Setter;

@EBean
public class ProjectListImpl extends BaseImpl<ProjectListView> implements ProjectListPres, RecyclerListener, FavoriteListener {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;
    @Setter
    private ModelDataProjectList data;

    private int tempIndex = 0;

    @Override
    public void init() {
        setDataProjects(data.getProjects());
    }

    @Override
    public void setDataProjects(ArrayList<Project> listProjects) {
        if (viewAct.recycler() != null) {
            viewAct.recycler().addItemDecoration(new ItemDecorationVertical(activity, R.dimen.padding_smlarge, R.dimen.padding_smlarge));
            AdapterProjectList adapter = new AdapterProjectList(listProjects, this);
            viewAct.recycler().setAdapter(adapter);
            viewAct.recycler().setLayoutManager(new LinearLayoutManager(activity));
            viewAct.recycler().setNestedScrollingEnabled(false);
        }
    }

    @Override
    public void onItemClick(Object o) {
        Project project = (Project) o;
        intentManager.moveToNext(project.getName(), ProjectFragment_.FRAGMENT_ID, project);
    }

    @Override
    public void favorite(Project project) {
        tempIndex = data.getProjects().indexOf(project);

        Agent agent = new SessionUser(activity).getData();
        RequestFavorite request = new RequestFavorite(project.getId(), agent.getId());
        if (project.getIsFavorite()) {
            serviceManager.unfavoriteProject(request);
        }
        else {
            serviceManager.favoriteProject(request);
        }
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof BaseResponse) {
            Project project = data.getProjects().get(tempIndex);
            project.setIsFavorite(!project.getIsFavorite());
            viewAct.recycler().getAdapter().notifyDataSetChanged();
        }
    }
}
