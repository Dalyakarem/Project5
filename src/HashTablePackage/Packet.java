package HashTablePackage;

public class Packet {
    private long sequenceNumber;

    private String protocol;

    private int port;

    private boolean isActive;

    public Packet(long sequenceNumber, String protocol, int port) {
        this.sequenceNumber = sequenceNumber;
        this.protocol = protocol;
        this.port = port;

        isActive = true;
    }

    public long getSequenceNumber() {
        return sequenceNumber;
    }

    public int getPort() {
        return port;
    }

    public String getProtocol() {
        return protocol;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
