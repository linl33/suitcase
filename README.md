# suitcase

This project is __*actively maintained*__

It is part of the ODK 2.0 Android tools suite.

ODK Scan takes an image of a filled-in mark-sense form and converts it into a data row accessible from ODK Tables or ODK Survey. Scan forms are generated with the [form designer](http://uw-ictd.github.io/odk-scan-form-designer/).

Instructions on how to use Scan can be found [here](https://opendatakit.org/use/2_0_tools/introduction-to-odk-scan/).

The developer [wiki](https://github.com/opendatakit/opendatakit/wiki) (including release notes) and
[issues tracker](https://github.com/opendatakit/opendatakit/issues) are located under
the [**opendatakit**](https://github.com/opendatakit/opendatakit) project.

The Google group for software engineering questions is: [opendatakit-developers@](https://groups.google.com/forum/#!forum/opendatakit-developers)

## Building instructions (Linux and Mac):

1. Install maven onto your system.
1. Run the shell script *mvn_local_installs* in the dependencies folder. 
1. From the root directory (with the pom.xml), run: *mvn clean compile assembly:single*

A new folder, target, will be created with the resuling jar file. 
