package WorkerPackage;

import HashTablePackage.*;

public class packetRepository {

    public static void main(String[] args) {
        System.out.println("This is code that works with a hash table data strusture.");

        HT archive = new HT(701);

        Packet Alice = new Packet(2480908323L, "TCP", 80);

        Packet Bob = new Packet(2481428325L, "UDP", 53);

        archive.insertNewPacket(Alice);
        archive.insertNewPacket(Bob);

        Packet searchResult = archive.searchPacket(2481428325L, false);

        if (searchResult != null) {
            System.out.println("Packet found, and the protocol is: " + searchResult.getProtocol());
        } else {
            System.out.println("The search did not find the packet of interest");
        }
    }
}
