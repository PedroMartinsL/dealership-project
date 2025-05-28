package com.dealership.project.domain.entities.offers;

import java.io.Serializable;

import com.dealership.project.domain.entities.enums.CustomCoating;
import com.dealership.project.domain.entities.enums.CustomColor;
import com.dealership.project.domain.entities.enums.CustomWheel;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Customization implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private CustomColor customColor;
    private CustomWheel customWheel;
    private CustomCoating customCoating;

    public Customization() {

    }

    public Customization(Long id, CustomColor customColor, CustomWheel customWheel, CustomCoating customCoating) {
        this.id = id;
        this.customColor = customColor;
        this.customWheel = customWheel;
        this.customCoating = customCoating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomColor getCustomColor() {
        return customColor;
    }

    public void setCustomColor(CustomColor customColor) {
        this.customColor = customColor;
    }

    public CustomWheel getCustomWheel() {
        return customWheel;
    }

    public void setCustomWheel(CustomWheel customWheel) {
        this.customWheel = customWheel;
    }

    public CustomCoating getCustomCoating() {
        return customCoating;
    }

    public void setCustomCoating(CustomCoating customCoating) {
        this.customCoating = customCoating;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customization other = (Customization) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
