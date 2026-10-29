package com.example.SAEP_SIM.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "TB_LOG")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLog;
    private LocalDateTime momento;



    @ManyToOne
    @JoinColumn (name = "idProduto")
    private List<Produto> produto;

    @ManyToOne
    @JoinColumn (name = "idUsuario")
    private List<Usuario> usuario;


}
