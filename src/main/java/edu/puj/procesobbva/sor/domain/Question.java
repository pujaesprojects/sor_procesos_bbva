package edu.puj.procesobbva.sor.domain;

import edu.puj.procesobbva.sor.domain.enumeration.QuestionType;
import edu.puj.procesobbva.sor.domain.enumeration.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@Entity
@Table(name = "pregunta")
public class Question extends AbstractEntity {
    private static final long serialVersionUID = -6386168666332412795L;

    @NotNull
    @Size(max = 255)
    @Column(name = "enunciado", nullable = false)
    private String statement;

    @NotNull
    @Size(max = 32)
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", length = 32, nullable = false)
    private QuestionType type;

    @NotNull
    @Size(max = 255)
    @Enumerated(EnumType.STRING)
    @Column(name = "estatus", length = 32, nullable = false)
    private Status status;
}
