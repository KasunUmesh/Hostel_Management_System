package entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Room implements SuperEntity{
    @Id
    private String room_type_id;
    private String room_type;
    private double key_money;
    private int qty;

    @OneToMany(mappedBy = "room", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Reservation> roomDetails = new ArrayList<>();

    public Room() {
    }

    public Room(String room_type_id, String room_type, double key_money, int qty) {
        this.room_type_id = room_type_id;
        this.room_type = room_type;
        this.key_money = key_money;
        this.qty = qty;
    }

    public Room(String room_type_id, String room_type, double key_money, int qty, List<Reservation> roomDetails) {
        this.room_type_id = room_type_id;
        this.room_type = room_type;
        this.key_money = key_money;
        this.qty = qty;
        this.roomDetails = roomDetails;
    }

    public String getRoom_type_id() {
        return room_type_id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public double getKey_money() {
        return key_money;
    }

    public int getQty() {
        return qty;
    }

    public void setRoom_type_id(String room_type_id) {
        this.room_type_id = room_type_id;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public void setKey_money(double key_money) {
        this.key_money = key_money;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public List<Reservation> getRoomDetails() {
        return roomDetails;
    }

    public void setRoomDetails(List<Reservation> roomDetails) {
        this.roomDetails = roomDetails;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_type_id='" + room_type_id + '\'' +
                ", room_type='" + room_type + '\'' +
                ", key_money=" + key_money +
                ", qty=" + qty +
                '}';
    }
}
