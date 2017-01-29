package com.example.entities;

import com.agapsys.jpa.AbstractEntity;
import com.agapsys.rcf.Controller.Dto;
import com.example.entities.Property.PropertyDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Property extends AbstractEntity<Property> implements Dto {
    
    // <editor-fold desc="STATIC SCOPE">
    // =========================================================================
    public static class PropertyDto {
        public Long id;

        public Long ownerId;

        public String key;
        public String value;

        public PropertyDto() {}
        public PropertyDto(Property entity) {
            this.id = entity.getId();
            this.ownerId = entity.getOwner().getId();
            this.key = entity.getKey();
            this.value = entity.getValue();
        }
    }
    // =========================================================================
    // </editor-fold>

    // Id ----------------------------------------------------------------------
    @Id
    @GeneratedValue
    private Long id;

    @Override
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    // -------------------------------------------------------------------------

    // Owner -------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(nullable = false)
    public User owner;
    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        if (owner == null) throw new IllegalArgumentException("Null owner");
        this.owner = owner;
    }
    // -------------------------------------------------------------------------

    // Key ---------------------------------------------------------------------
    @Column(unique = true, name = "mKey", nullable = false)
    private String key;
    public String getKey() {
        return key;
    }
    public void setKey(String key) throws IllegalArgumentException {
        if (key == null || key.trim().isEmpty())
            throw new IllegalArgumentException("Null/Empty key");

        this.key = key;
    }
    // -------------------------------------------------------------------------

    // Value -------------------------------------------------------------------
    private String value;
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    // -------------------------------------------------------------------------

    @Override
    public Object getDto() {
        return new PropertyDto(this);
    }
}
