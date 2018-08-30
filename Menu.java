package Task2;

import Task3.Task3;

import java.util.Scanner;

public class  Menu {
    public static void menu() {
        ControlDevice controlDevice = new ControlDevice();
        boolean menu = true;
        while (menu) {
            setNumbersOfFunction();
            int i = inputInt("operation number");
            switch (i) {
                case 1: // add New Home
                    controlDevice.addNewHome(inputString("Home Name"));
                    break;
                case 2: // Delete Home
                    controlDevice.deleteHome(inputString("Home Name"));
                    break;
                case 3: // add New Device
                    controlDevice.addNewDevice(inputString("Device Name"), inputInt("Device power"), inputString("Home Name"));
                    break;
                case 4: // Delete Device
                    controlDevice.DeleteDevice(inputString("Device Name"));
                    break;
                case 5: // Switch On(Device)
                    controlDevice.switchOn(inputInt("Device Numeration"));
                    break;
                case 6: // Switch Off(Device)
                    controlDevice.switchOff(inputInt("Device Numeration"));
                    break;
                case 7: // Show All Devices
                    controlDevice.ShowAllDevices();
                    break;
                case 8: // Sort
                    controlDevice.sortedbyPower();
                    break;
                case 9: // Total Power
                    controlDevice.totalPowerUsed();
                    break;
                case 10: // Download Information about Devices from outside file
                    controlDevice.DownloadDevices(inputString("Existing Home Name"));
                    break;
                case 11:// Safe on Disk sorted DEVICE list
                   Task3.SaveOnDisk();
                    break;
                case 0: // Exit
                    menu = false;}
        }
    }
    private static int inputInt(String input) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Input " + input);
        return scan.nextInt();
    }
    private static String inputString(String input) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Input " + input);
        return scan.nextLine();
    }


    private static String[] numbersOfFunction= {
            "1) Add New Home",
            "2) Delete Home",
            "3) Add New Device",
            "4) Delete Device",
            "5) Switch On(Device)",
            "6) Switch off(Device)",
            "7) Show All Devices",
            "8) Sort of devices by actual power",
            "9) Total Power",
            "10)Download Devices from file ",
            "11)Save on Disk sorted DEVICE list ",
            "0) Exit"
    };

    private static void setNumbersOfFunction() {
        for (String menu :numbersOfFunction )
            System.out.println(menu);
    }
}
