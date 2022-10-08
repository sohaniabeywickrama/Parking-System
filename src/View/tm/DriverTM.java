package View.tm;

public class DriverTM {
    private String driverName;
    private String nIC;
    private String driverLicenseNumber;
    private String address;
    private String contactNo;

    public DriverTM(String driverName) {
        this.driverName = driverName;
    }

    public DriverTM(String driverName, String nIC, String driverLicenseNumber, String address, String contactNo) {
        this.driverName = driverName;
        this.nIC = nIC;
        this.driverLicenseNumber = driverLicenseNumber;
        this.address = address;
        this.contactNo = contactNo;


    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getNIC() {
        return nIC;
    }

    public void setNIC(String nIC) {
        this.nIC = nIC;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return driverName;
    }
}
