package projetJPA.Entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "departement")
@SequenceGenerator(name = "seqDepartment", sequenceName = "department_seq_id", initialValue = 25, allocationSize = 1)
public class Departement {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqDepartment")
	private Long id;
	@Column(name = "department_name")
	private String nom;
	@OneToOne
	@JoinColumn(name = "department_responsible_id", foreignKey = @ForeignKey(name ="fk_department_responsible_id"))
	private Employe responsable;
	
	@OneToMany(mappedBy = "employeDepartment")
	private List<Employe> employeesDepartment;
	
	
	public Departement() {
		super();
	}

	public Departement(String nom, Employe responsable, List<Employe> employeesDepartment) {
		super();
		this.nom = nom;
		this.responsable = responsable;
		this.employeesDepartment = employeesDepartment;
	}

	public Departement(String nom) {
		super();
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
		Departement other = (Departement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Employe getResponsable() {
		return responsable;
	}

	public void setResponsable(Employe responsable) {
		this.responsable = responsable;
	}

	public List<Employe> getEmployeesDepartment() {
		return employeesDepartment;
	}

	public void setEmployeesDepartment(List<Employe> employeesDepartment) {
		this.employeesDepartment = employeesDepartment;
	}
	
	

}
