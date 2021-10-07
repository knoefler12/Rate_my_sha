package com.example.demo.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@Table(name="kebab_shops")
@Entity
@Getter @Setter @NoArgsConstructor
public class KebabShop {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    @ApiModelProperty(notes="Name of the kebab shop")
    private String name;

    @Column
    private String address;

    @Column
    private double rating;


}
