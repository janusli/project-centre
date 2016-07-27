package nz.ac.auckland.eresearch.projectcentre.types.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import nz.ac.auckland.eresearch.projectcentre.types.IdNameType;
import nz.ac.auckland.eresearch.projectcentre.util.HasId;

@Entity
@Table(name = "personstatus")
public class PersonStatus implements Serializable, HasId, IdNameType {

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  protected Integer id;
  @Column(unique = true)
  @NotNull
  @Size(min = 1)
  protected String name;

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  
}
