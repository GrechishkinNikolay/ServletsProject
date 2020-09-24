package ru.rsreu.Grechishkin.db.dao.oracle;

import ru.rsreu.Grechishkin.db.dao.AbstractCommentDAO;
import ru.rsreu.Grechishkin.db.dto.Comment;

import java.util.List;

public class OracleCommentDAO extends AbstractCommentDAO {
    public OracleCommentDAO() {
    }

    @Override
    public List<Comment> getCommentsByProjectId(int projectId) {
        return OracleManager.getCommentsByProjectId(projectId);
    }

    @Override
    public void deleteComment(int commentId) {
        OracleManager.deleteComment(commentId);
    }
}
