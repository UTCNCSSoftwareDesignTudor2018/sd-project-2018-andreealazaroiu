package com.cookingrecipes.project.dataAccess.entities;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="users")
public class User implements GeneralUser {

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

    @Column(name="email")
    private String email;


    public User(UserBuilder userBuilder) {
        this.id=userBuilder.id;
        this.name=userBuilder.name;
        this.username=userBuilder.username;
        this.recipes=userBuilder.recipes;
        this.passw=userBuilder.passw;
        this.email=userBuilder.email;
    }

    public User(){
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassw() {
        return passw;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public void setEmail(String email) {
        this.email = email;
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
                Objects.equals(recipes, user.recipes) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, username, passw, recipes, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", passw='" + passw + '\'' +
                ", recipes=" + recipes +
                ", email='" + email + '\'' +
                '}';
    }

    public static class UserBuilder
    {
        private int id;
        private String name;
        private String username;
        private String passw;
        private List<Recipe> recipes;
        private String email;

        public UserBuilder(){}

        public UserBuilder setId(int id)
        {   this.id=id; return this; }

        public UserBuilder setName(String name)
        {   this.name=name; return this;}

        public UserBuilder setUsername(String username)
        {   this.username=username; return this; }

        public UserBuilder setPassw(String passw)
        {   this.passw=passw; return this; }

        public UserBuilder setRecipes(List<Recipe> recipes)
        {   this.recipes=recipes; return this;  }

        public UserBuilder setEmail(String email)
        {   this.email=email; return this; }

        public User build()
        {
            return new User(this);
        }
    }

}
