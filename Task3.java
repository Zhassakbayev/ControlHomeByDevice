package Task3;

import Task2.ControlDevice;
import Task2.Device;
import Task2.SortComparator;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Task3 {

    public static ArrayList<String> readDevices(){
        File file = new File("C:\\Task3\\devices.txt");
        ArrayList<String> devicesName = new ArrayList<>();
        BufferedReader br;
        {
        try {
            br = new BufferedReader(new FileReader(file));
            String str;
            while((str=br.readLine()) != null){
                devicesName.add(str);
                }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        return devicesName;
    }

    public static ArrayList<Integer> readPower(){
        ArrayList<Integer> devicesPower = new ArrayList<>();
        File file1 = new File("C:\\Task3\\devices_power.txt");
        BufferedReader br1;
        try {
            br1 = new BufferedReader(new FileReader(file1));
            String str;
            while ((str = br1.readLine()) != null){
                devicesPower.add(Integer.parseInt(str));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return devicesPower;
    }

    public static  void SaveOnDisk(){
        File file = new File("C:\\Task3\\SortedDeviceList.txt");
        try {
            PrintWriter pw = new PrintWriter(file);
            ArrayList<Device> devices = ControlDevice.getAllDevices();
            Collections.sort(devices, new SortComparator());
            for (int i=0; i<devices.size();i++){
                pw.println(devices.get(i));
            }
            pw.println();
            pw.println("The total power is " + ControlDevice.totalPowerUsed()+ " Watt");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Sorted List is successfully saved");
    }




}
