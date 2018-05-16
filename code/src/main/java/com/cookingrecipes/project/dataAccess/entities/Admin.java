package com.cookingrecipes.project.dataAccess.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="admin")
public class Admin implements GeneralUser{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String passw;

    @OneToMany(mappedBy="admin",fetch= FetchType.EAGER)
    private List<Recipe> recipes;

    public Admin(int id, String username, String password, List<Recipe> recipes) {
        this.id = id;
        this.username = username;
        this.passw = password;
        this.recipes = recipes;
    }
    public Admin(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return passw;
    }

    public void setPassword(String password) {
        this.passw = password;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return id == admin.id &&
                Objects.equals(username, admin.username) &&
                Objects.equals(passw, admin.passw) &&
                Objects.equals(recipes, admin.recipes);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, passw, recipes);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + passw + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
