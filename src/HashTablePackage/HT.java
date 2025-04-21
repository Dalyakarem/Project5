package HashTablePackage;

public class HT {
    private Packet[] records;

    private int arraySize;

    public HT(int arraySize) {
        this.arraySize = arraySize;

        records = new Packet[arraySize];
    }

    private int hashFunction(long sequenceNumber) {
        return (int)(sequenceNumber % arraySize);
    }

    public void insertNewPacket(Packet packet) {
        long key = packet.getSequenceNumber();

        int index = this.hashFunction(key);

        boolean foundHome = false;

        int endPoint = index;

        do {
            if ((records[index] == null) || (!records[index].isActive())) {
                records[index] = packet;
                foundHome = true;
            } else {
                index = (++index) % arraySize;
            }
        } while ((foundHome == false) && (index != endPoint));

        if (foundHome == false) {
            System.out.println("The hash table is full, and therefore the object was not inserted. Sorry!");
        }
    }

    public Packet searchPacket(long searchKey, boolean delete) {
        Packet currentPacket = null;

        int index = this.hashFunction(searchKey);

        int endPoint = index;

        do {
            currentPacket = records[index];

            if (currentPacket == null) return null;

            if (currentPacket.getSequenceNumber() == searchKey) {
                if (delete == true) records[index].setActive(false);
                return currentPacket;
            } else {
                index = (++index) % arraySize;
            }

        } while (index != endPoint);

        System.out.println("Sorry, the target packet is not present in the hash table");

        return null;
    }
}
