package com.cookingrecipes.project.dataAccess.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idrecipes")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @ManyToOne(targetEntity = Admin.class)
    @JoinColumn(name="admin_id")
    private Admin admin;

    @OneToMany(mappedBy="recipe",fetch=FetchType.EAGER)
    private List<Comment> comments;

    public Recipe( String title, String content, Admin admin,List<Comment>comments) {
       // this.id = id;
        this.title = title;
        this.content = content;
        this.admin = admin;
        this.comments=comments;
    }
    public Recipe() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id &&
                Objects.equals(title, recipe.title) &&
                Objects.equals(content, recipe.content) &&
                Objects.equals(admin, recipe.admin);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, content, admin);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", admin=" + admin.getUsername() +
                '}';
    }
}
