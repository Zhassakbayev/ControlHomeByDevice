package Task2;

public class Device {

    private Home home;
    private String DeviceName;
    private int power;
    private boolean PowerOn=false;
    private int DeviceNum;
    private static int DeviceCounter = 1;

    public Device(String DeviceName, int power, Home home){
        if (DeviceName == null || DeviceName.equals("")){System.out.println("Device Name can not be empty");}
        this.DeviceName = DeviceName;
        this.power = power;
        this.home=home;
        DeviceNum=DeviceCounter++;
    }

    public String getDeviceName() {
        return DeviceName;
    }

    public int getPower() {
        return power;
    }

    public void deviceOn() {
        this.PowerOn =true ;
    }
    public void deviceOff(){
        this.PowerOn=false;
    }

    public boolean isPowerOn() {
        return PowerOn;
    }

    public int getDevicesCounter() {
        return DeviceCounter-1;
    }

    public int getDeviceNum() {
        return DeviceNum;
    }

    public Home getHome() {
        return home;
    }
    @Override
    public String toString() {
        return
                "Device Num=" + DeviceNum+
                ", Device Name='" + DeviceName +
                "', Home=" + home +
                ", power=" + power +
                ", isPowerOn=" + PowerOn ;
    }
}
