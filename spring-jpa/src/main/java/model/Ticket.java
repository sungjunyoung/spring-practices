package model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by junyoung on 2017. 5. 24..
 */
@Entity
public class Ticket implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer ticketId;
	private Reservation reservation;
	private Rank rank;
	private Event event;


	@Id
	@Column(name = "ticket_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	@OneToOne(mappedBy = "ticket")
	public Reservation getReservation() {
		return this.reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@ManyToOne
	@JoinColumn(name = "rank_id")
	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	@ManyToOne
	@JoinColumn(name = "event_id")
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if (!(other instanceof Ticket)) {
			return false;
		}

		Ticket castOther = (Ticket) other;
		return new EqualsBuilder().append(this.getTicketId(), castOther.getTicketId()).isEquals();
	}

	public int hashCode(){
		return new HashCodeBuilder().append(getTicketId()).toHashCode();
	}

}
