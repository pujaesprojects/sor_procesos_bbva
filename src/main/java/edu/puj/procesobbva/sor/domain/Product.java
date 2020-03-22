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
@Table(name = "producto")
public class Product extends AbstractEntity {
    private static final long serialVersionUID = -5324931689791705113L;

    @Size(max = 255)
    @Column(name = "nombre")
    private String name;

    @Size(max = 32)
    @Column(name = "tipo", length = 32)
    private String type;

    @Enumerated(EnumType.STRING)
    @Column(name = "estatus", length = 16)
    private Status status;
}
