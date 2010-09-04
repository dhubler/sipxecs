package org.sipfoundry.sipxconfig.phone.nortel;

import org.sipfoundry.sipxconfig.device.DeviceVersion;
import org.sipfoundry.sipxconfig.phone.PhoneModel;

public class NortelPhoneModel extends PhoneModel {
    public static final String VENDOR = "nortelPhone";
    public static final DeviceVersion FIRM_2_2 = new DeviceVersion(VENDOR, "2.2");
    public static final DeviceVersion FIRM_3_2 = new DeviceVersion(VENDOR, "3.2");

    public NortelPhoneModel() {
        super();
        setVersions(getDeviceVersions());
    }

    public static DeviceVersion[] getDeviceVersions() {
        return new DeviceVersion[] {
                FIRM_2_2, FIRM_3_2
        };
    }
}