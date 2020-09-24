package ru.rsreu.Grechishkin.db.dao;

import ru.rsreu.Grechishkin.db.dto.Project;

import java.util.List;

public abstract class AbstractProjectDAO {
    public abstract List<Project> getProjectsByCommunityId(int communityId);
    public abstract void addProject(int communityId, String nameProject, String descriptionProject);
}
