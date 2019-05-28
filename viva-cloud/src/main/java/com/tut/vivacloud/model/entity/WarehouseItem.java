package com.tut.vivacloud.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Setter
@Getter
public class WarehouseItem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @NotNull
    private Integer length;
    @NotNull
    private ItemType type;
    @ManyToOne
    @JoinColumn
    private WarehouseItemSubType subType;

    public enum ItemType{
        GARLAND,
        OTHER;
    }


}
