package com.cookingrecipes.project.dataAccess.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcomments")
    private int id;

    @Column(name="content")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Recipe.class)
    @JoinColumn(name="recipe_id")
    private Recipe recipe;

    public Comment(int id, String content, Recipe recipe) {
        this.id = id;
        this.content = content;
        this.recipe = recipe;
    }
    public Comment(){}

    public Comment(String comment, Recipe myRecipe) {
        this.content=comment;
        this.recipe=myRecipe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id &&
                Objects.equals(content, comment.content) &&
                Objects.equals(recipe, comment.recipe);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, content, recipe);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", recipe=" + recipe +
                '}';
    }
}
