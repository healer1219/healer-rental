package com.healer.entity.item;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rental_item")
public class Item implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  private String num;
  private String carId;
  private Integer status;
  private Double price;
  @Column(name = "address_x")
  private String addressX;
  @Column(name = "address_y")
  private String addressY;

  @OneToOne(targetEntity = ItemDesc.class)
  @JoinColumn(name = "desc_id")
  private ItemDesc itemDesc;


}
