package model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by junyoung on 2017. 5. 24..
 */
@Entity
@Table(name="user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String name;


	private Set<Reservation> reservations;

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getUserId(){
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "user")
	public Set<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public String toString(){
		return new ToStringBuilder(this).append("userId", getUserId()).append("name", getName()).toString();
	}

	public boolean equals(Object other){
		if((this == other)) return true;
		if(!(other instanceof User)) return false;
		User castOther = (User) other;
		return new EqualsBuilder().append(this.getUserId(), castOther.getUserId()).append(this.getName(), castOther.getName()).isEquals();
	}

	public int hashCode(){
		return new HashCodeBuilder().append(getUserId()).append(getName()).toHashCode();
	}
}
