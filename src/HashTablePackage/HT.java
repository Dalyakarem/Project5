package HashTablePackage;

import java.util.LinkedList;

public class HT {
    private LinkedList<Packet>[] records;

    private int arraySize;

    public HT(int arraySize) {
        this.arraySize = arraySize;

        records = new LinkedList[arraySize];

        for (int i = 0; i < arraySize; i++) {
            records[i] = new LinkedList<>();
        }
    }

    private int hashFunction(long sequenceNumber) {
        return (int)(sequenceNumber % arraySize);
    }

    public void insertNewPacket(Packet packet) {
        long key = packet.getSequenceNumber();

        int index = this.hashFunction(key);

        records[index].add(packet);
    }

    public Packet searchPacket(long searchKey, boolean delete) {
        Packet currentPacket = null;

        int index = this.hashFunction(searchKey);

        for (Packet packet : records[index]) {
            if (packet.getSequenceNumber() == searchKey && packet.isActive()) {
                if (delete == true) packet.setActive(false);
                return packet;
            }
        }

        System.out.println("Sorry, the target packet is not present in the hash table");

        return null;
    }
}
