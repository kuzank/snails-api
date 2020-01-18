package com.kuzank.snails.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys_menu")
public class Menu extends Base {

    @Column
    private String pid;
    @Column
    private String url;
    @Column
    private String icon;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String idpath;


    public static Menu of(String id, String title, String url, String icon, Menu parent) {
        Menu obj = new Menu();
        obj.setId(id);
        obj.setTitle(title);
        obj.setUrl(url);
        obj.setIcon(icon);
        if (parent != null) {
            obj.setPid(parent.getId());
            obj.setIdpath(parent.getIdpath() + "," + id);
        } else {
            obj.setIdpath(id);
        }
        return obj;
    }
}

