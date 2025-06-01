package com.dealership.project.domain.entities;

import java.io.Serializable;

import com.dealership.project.api.dto.CustomizationDTO;
import com.dealership.project.domain.entities.enums.CustomCoating;
import com.dealership.project.domain.entities.enums.CustomColor;
import com.dealership.project.domain.entities.enums.CustomWheel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Customization implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer customColor;
    private Integer customWheel;
    private Integer customCoating;

    
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Customization() {

    }

    public Customization(Long id, Integer customColor, Integer customWheel, Integer customCoating) {
        this.id = id;
        this.customColor = customColor;
        this.customWheel = customWheel;
        this.customCoating = customCoating;
    }

    public Customization(CustomizationDTO customizationDTO) {
        this.customCoating = customizationDTO.getCustomCoating();
        this.customColor = customizationDTO.getCustomColor();
        this.customWheel = customizationDTO.getCustomWheel();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomColor getCustomColor() {
        if (customColor == null) {
            return null;
        }
        return CustomColor.valueOf(customColor);
    }

    public void setCustomColor(CustomColor customColor) {
        if (customColor != null) {
            this.customColor = customColor.getCode();
        }
    }

    public CustomWheel getCustomWheel() {
        if (customWheel == null) {
            return null;
        }
        return CustomWheel.valueOf(customWheel);
    }

    public void setCustomWheel(CustomWheel customWheel) {
        if (customWheel != null) {
            this.customWheel = customWheel.getCode();
        }
    }

    public CustomCoating getCustomCoating() {
        if (customCoating == null) {
            return null;
        }
        return CustomCoating.valueOf(customCoating);
    }

    public void setCustomCoating(CustomCoating customCoating) {
        if (customCoating != null) {
            this.customCoating = customCoating.getCode();
        }
    }

    public Order getOrder() {
        return order;
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
