package com.algaworks.courseapi.core.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_module")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Module implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "nm_modulo")
  private String name;

  @Column(name = "carga_horaria")
  private String workload;

  @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  private List<Content> contents;
}
