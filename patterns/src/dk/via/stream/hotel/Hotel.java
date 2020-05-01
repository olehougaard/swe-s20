package dk.via.stream.hotel;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Hotel {
    private final String name;
    private final Room[] rooms;

    public Hotel(String name, Room[] rooms) {
        this.name = name;
        this.rooms = rooms.clone();
    }

    public String getName() {
        return name;
    }

    public int getNumberOfRooms() {
        return rooms.length;
    }

    private Stream<Room> getAvailableRoomStream() {
        return Stream.of(rooms).filter((room)->!room.isOccupied());
    }

    public long getNumberOfAvailableRooms() {
        return getAvailableRoomStream().count();
    }

    public Room getFirstAvailableRoom() {
        return getAvailableRoomStream().findFirst().orElse(null);
    }

    public Room getFirstAvailableRoom(double maxPrice) {
        return getAvailableRoomStream()
                .filter((room)->room.getPrice() < maxPrice)
                .findFirst()
                .orElse(null);
    }

    public List<Room> getAllAvailableRooms() {
        return getAvailableRoomStream().collect(toList());
    }

    public boolean hasGuest(Guest guest) {
        return Stream.of(rooms).anyMatch((room)->room.getGuest().equals(guest));
    }

    public Room getRoom(Guest guest) {
        return Stream.of(rooms)
                .filter(Room::isOccupied)
                .filter((room)->room.getGuest().equals(guest))
                .findFirst()
                .orElse(null);
    }
}
