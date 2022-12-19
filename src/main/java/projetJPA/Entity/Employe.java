package projetJPA.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "employe")
@SequenceGenerator(name = "seqemploye", sequenceName = "employe_seq_id", initialValue = 1, allocationSize = 1)
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqemploye")
	private Long matricule;
	@Column(name = "employe_firstname")
	private String prenom;
	@Column(name = "employe_lastname")
	private String nom;
	@Column(name = "employe_address")
	private Adresse adresse;
	@Column(name = "employe_salary")
	private Double salaire;
	@Column(name = "employe_tel")
	private String telephone;
	@OneToOne(mappedBy = "responsable",cascade = {CascadeType.ALL})
	private Departement departement;
	@ManyToOne
	@JoinColumn(name = "department_responsible_id", foreignKey = @ForeignKey(name ="fk_department_responsible_id"))
	private Departement employeDepartment;
	
	
	public Employe() {
		super();
	}

	public Employe(String prenom, String nom, Adresse adresse, Double salaire, String telephone) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.salaire = salaire;
		this.telephone = telephone;
	}
	
	public Employe(String prenom, String nom, Adresse adresse, Double salaire, String telephone,
			Departement departement, Departement employeDepartment) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.salaire = salaire;
		this.telephone = telephone;
		this.departement = departement;
		this.employeDepartment = employeDepartment;
	}
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Departement getDepartement() {
		return departement;
	}

	

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	
	
	

	public Long getMatricule() {
		return matricule;
	}

	public void setMatricule(Long matricule) {
		this.matricule = matricule;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

	public Departement getemployeDepartment() {
		return employeDepartment;
	}

	public void setemployeDepartment(Departement employeDepartment) {
		this.employeDepartment = employeDepartment;
	}
	
	
	
}	
