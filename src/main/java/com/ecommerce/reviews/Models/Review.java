package com.ecommerce.reviews.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Formula;


import java.time.ZonedDateTime;

@Entity
@Table(name = "Reviews")
@Getter
@Setter
@ToString(exclude = {"hibernateLazyInitializer", "handler"})

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "users"})
public class Review {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id_review;
     @Column
     private int score;
     @Column
     private String review;
     @Column
     private ZonedDateTime posted_date;

     @Formula("(select u.name from users u where u.id_user = id_user)")
     private String name;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "id_user")
     private User user;
}
