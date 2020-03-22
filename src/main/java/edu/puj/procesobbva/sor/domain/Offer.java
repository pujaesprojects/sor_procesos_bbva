package edu.puj.procesobbva.sor.domain;

import edu.puj.procesobbva.sor.domain.enumeration.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@Entity
@Table(name = "oferta")
public class Offer extends AbstractEntity {
    private static final long serialVersionUID = -6630406251638679845L;

    @Enumerated(EnumType.STRING)
    @Column(name = "estatus", length = 32)
    private Status status;

    @Size(max = 512)
    @Column(name = "descripcion", length = 512)
    private String description;
}
