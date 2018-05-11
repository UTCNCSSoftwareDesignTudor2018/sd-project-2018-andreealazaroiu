package com.cookingrecipes.project.dataAccess.entities;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idusers")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="username")
    private String username;

    @Column(name="passw")
    private String passw;

    @ManyToMany(fetch = FetchType.EAGER,cascade={CascadeType.ALL})
    @JoinTable(
            name="users_recipes",
            joinColumns = {@JoinColumn(name="idusers")},
            inverseJoinColumns={@JoinColumn(name="idrecipes")})
    private List<Recipe> recipes;


    public User(String name, String username, String password, List<Recipe> recipes) {
        this.name = name;
        this.username = username;
        this.passw = password;
        this.recipes = recipes;
    }

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(username, user.username) &&
                Objects.equals(passw, user.passw) &&
                Objects.equals(recipes, user.recipes);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, username, passw, recipes);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + passw + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
