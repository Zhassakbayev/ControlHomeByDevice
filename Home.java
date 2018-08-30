package Task2;

import java.util.ArrayList;

public class Home {

    private String homeName;
    ArrayList<Device> devices = new ArrayList<>();

    public Home(String homeName){
        this.homeName = homeName;
        if (homeName == null || homeName == " "){
            System.out.println("Name of Home can not be empty ");
        }
    }

    public void addDevice(Device device){
        if (device == null){throw  new IllegalArgumentException("Device can not be null");}
        if(!checkExistDevice(device)){devices.add(device);}
    }

    public  void deleteDevice(Device device){
        if (device == null){throw  new IllegalArgumentException("Device can not be null");}
        if(checkExistDevice(device)){devices.remove(device);}
    }

    public String getHomeName() {return homeName;}

    public ArrayList<Device> getDevices() {return devices;}

    private boolean checkExistDevice(Device device){
        for (Device dev : devices) {
            if (dev.equals(device)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return  homeName ;
    }
}
