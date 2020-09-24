package ru.rsreu.Grechishkin.db.dao;

import ru.rsreu.Grechishkin.db.dto.Comment;

import java.util.List;

public abstract class AbstractCommentDAO {
    public abstract List<Comment> getCommentsByProjectId(int projectId);
    public abstract void deleteComment(int commentId);
}
