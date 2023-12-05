package com.company.jmixpm.screen.projecttasksbrowser;

import com.company.jmixpm.entity.Project;
import com.company.jmixpm.entity.Task;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.DialogMode;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Nullable;

@UiController("ProjectTasksBrowser")
@UiDescriptor("project-tasks-browser.xml")
@DialogMode(forceDialog = true)
public class ProjectTasksBrowser extends Screen {

    @Autowired
    private CollectionLoader<Task> tasksDl;

    public ProjectTasksBrowser withProject(@Nullable Project project) {
        if (project != null) {
            tasksDl.setParameter("projectId", project.getId());
        } else {
            tasksDl.removeParameter("projectId");
        }

        tasksDl.load();
        return this;
    }
}