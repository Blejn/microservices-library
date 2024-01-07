package com.library.springboot.demo.authService.entities;

import com.library.springboot.demo.authService.types.Erole;
import jakarta.persistence.*;

@Table(name = "roles")
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private  Erole name;
}
