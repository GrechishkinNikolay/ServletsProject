package ru.rsreu.Grechishkin.db.dao.oracle;

import ru.rsreu.Grechishkin.db.dao.AbstractProjectDAO;
import ru.rsreu.Grechishkin.db.dto.Project;

import java.util.List;

public class OracleProjectDAO extends AbstractProjectDAO {
    public OracleProjectDAO() {
    }

    @Override
    public List<Project> getProjectsByCommunityId(int communityId) {
        return OracleManager.getProjectsByCommunityId(communityId);
    }

    @Override
    public void addProject(int communityId, String nameProject, String descriptionProject) {
        OracleManager.addProject(communityId, nameProject, descriptionProject);
    }
}
