package Task2;

import Task3.Task3;

import java.util.ArrayList;
import java.util.Collections;

public class ControlDevice {
    static ArrayList<Home> homes;

    public ControlDevice(){homes = new ArrayList<>();}

    public void addNewHome(String homeName) {
        if (homeName.isEmpty() || homeName == " ") {
            System.out.println("Name of home can't be empty");
            return;
        }
        homes.add(new Home(homeName));
        System.out.println("Home was added");
    }
    public  void deleteHome(String homeName){
        if (homeName.isEmpty() || homeName == "") {
            System.out.println("Name of home can't be empty");
            return;
        }
        Home home = findHome(homeName);
        if (home==null){
            System.out.println("Home was not found");
            return;
        }
            homes.remove(homeName);
            System.out.println("Home was deleted");

    }
    public void addNewDevice(String DeviceName, int power, String homeName){
        if (DeviceName.isEmpty()|| DeviceName== "") {
            System.out.println("Name of device can't be empty");
            return;
        }
        Home home = findHome(homeName);
        if (home == null){
            System.out.println("Home was not found");
            return;
        }
        Device device = new Device(DeviceName,power,home);
        home.addDevice(device);
        System.out.println("Device was added");
    }

    public void DeleteDevice(String deviceName){
        if (deviceName.isEmpty()|| deviceName== "") {
            System.out.println("Name of device can't be empty");
            return;
        }
        for (Home home : homes) {
            for (Device device : home.getDevices()) {
                if (device.getDeviceName() == deviceName){
                home.deleteDevice(device);

                System.out.println("Device was deleted");
                return;}
            }
        }
        System.out.println("Unit wasn't found");
    }
    public void switchOn(int deviceNum){
        if (deviceNum < 0){
            System.out.println("Numeration can not be less zero!");
        }
        for (Home home : homes) {
            for (Device device : home.getDevices()) {
                if (device.getDeviceNum() == deviceNum ){
                    device.deviceOn();
                    System.out.println("Device "+device.getDeviceName()+ " is switch On");
                    return;}
            }
        }
    }
    public void switchOff(int deviceNum){
        if (deviceNum < 0){
            System.out.println("Numeration can not be less zero!");
        }
        for (Home home : homes) {
            for (Device device : home.getDevices()) {
                if (device.getDeviceNum() == deviceNum ){
                    device.deviceOff();
                    System.out.println("Device " + device.getDeviceName() + " is switch Off");
                    return;}
            }
        }
    }
    public void ShowAllDevices(){
        for (Home home : homes) {
            for (Device device : getAllDevices()) {
                System.out.println(device);
            }
        }
        return;
    }

    public static void sortedbyPower(){
        ArrayList<Device> devices = getAllDevices();
        Collections.sort(devices,new SortComparator());
            for (Device device : devices) { {
                if (device.isPowerOn()){
                    System.out.println(device);}
                }
            }
    }

    public static int totalPowerUsed(){
         int totalpower=0;
        ArrayList<Device> devices = getAllDevices();
        for (Device device : devices){
            if (device.isPowerOn()){
                totalpower = totalpower + device.getPower();
            }
        }
        System.out.println("Total power is= " + totalpower+"kW");
        return totalpower;
    }


    public void DownloadDevices(String homeName){
        Home home = findHome(homeName);
        if (home == null){
            System.out.println("Home was not found! Please add AT LEAST 1 home  ");
            return;
        }
        for (int i=0; i<Task3.readDevices().size();i++){
            Device device = new Device(Task3.readDevices().get(i),Task3.readPower().get(i),home);
            home.addDevice(device);
            device.deviceOn();
            System.out.println("Device was added");
        }
    }



    public static ArrayList<Device> getAllDevices(){
    ArrayList<Device> devices = new ArrayList<>();
        for (Home home : homes) {
            for (Device device : home.getDevices()) {
                devices.add(device);
            }
        }
        return devices;
    }

    private Home findHome(String homeName){
        for(Home home : homes){
            if (homeName.equals(home.getHomeName())){
                return  home;
            }
        }
        return null;
    }
 }
