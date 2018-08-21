/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softtrons.genericentities.entities.jpa.generals;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "modules", catalog = "moto10racingHBT", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modules.findAll", query = "SELECT m FROM Modules m")
    , @NamedQuery(name = "Modules.findById", query = "SELECT m FROM Modules m WHERE m.id = :id")
    , @NamedQuery(name = "Modules.findByCode", query = "SELECT m FROM Modules m WHERE m.code = :code")
    , @NamedQuery(name = "Modules.findByName", query = "SELECT m FROM Modules m WHERE m.name = :name")
    , @NamedQuery(name = "Modules.findBySource", query = "SELECT m FROM Modules m WHERE m.source = :source")})
public class Modules implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "source")
    private String source;
    @JoinTable(name = "roles_modules", joinColumns = {
        @JoinColumn(name = "id_module", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "id_rol", referencedColumnName = "id")})
    @ManyToMany
    private List<Roles> rolesList;
    @OneToMany(mappedBy = "idParent")
    private List<Modules> modulesList;
    @JoinColumn(name = "id_parent", referencedColumnName = "id")
    @ManyToOne
    private Modules idParent;

    public Modules() {
    }

    public Modules(Integer id) {
        this.id = id;
    }

    public Modules(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @XmlTransient
    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    @XmlTransient
    public List<Modules> getModulesList() {
        return modulesList;
    }

    public void setModulesList(List<Modules> modulesList) {
        this.modulesList = modulesList;
    }

    public Modules getIdParent() {
        return idParent;
    }

    public void setIdParent(Modules idParent) {
        this.idParent = idParent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modules)) {
            return false;
        }
        Modules other = (Modules) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softtrons.genericentities.entities.jpa.generals.Modules[ id=" + id + " ]";
    }
    
}
