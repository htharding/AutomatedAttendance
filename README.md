# Automated Attendance System

Our goal for this project is to eventually create a system that can track attendance of a group of people, using computer vision.

So far, we have implemented basic face tracking of human faces.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites/Downloads

Java 11, Windows or Mac:
```

https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html
```
OpenCV, Windows or Mac:

```
https://opencv.org/releases.html
```
JavaFX 11, Windows or Mac !SDK!
```
https://gluonhq.com/products/javafx/
```

### Installing

First, you need to add openCV lib, the openCV jar, and javaFX SDK to your libraries in your IDE, wether it's Eclipse, Intellij, etc.

Eclipse:
http://www.oxfordmathcenter.com/drupal7/node/44
IntelliJ (first answer):
https://stackoverflow.com/questions/48472542/how-do-you-add-external-libraries-to-intellij-project-during-setup

Here's the different paths you need to add for both:
```
C:/Users/YOURUSERHERE/Downloads/opencv/build/java/opencv-401.jar
C:/Users/YOURUSERHERE/Downloads/opencv/build/java/x64/opencv_java401.dll
C:/Users/YOURUSERHERE/Downloads/openjfx-11.0.2_windows-x64_bin-sdk/javafx-sdk-11.0.2\lib
C:/Users/WHATEVERPATHTOPROJECT/AutomatedAttendance/mysql-connector-java-8.0.15
```

Last, you need to edit the VM configurations for your IDE, so that when Java is started, the IDE points it to JavaFX's location.

Eclipse (first answer, not comment):
https://stackoverflow.com/questions/15313393/how-to-increase-application-heap-size-in-eclipse 
IntelliJ (first answer, not comment):
https://stackoverflow.com/questions/50938383/how-to-set-jvm-arguments-in-intellij-idea

The argument you need to add is this (change the file path to where your javaFX /lib folder is):
```
--module-path D:\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib --add-modules=javafx.controls,javafx.fxml
```

## Running
You should now be able to run it by running the main method inside FaceDetection.java. Make sure you have a webcam connected.

## Built With

* [JavaFx11](https://gluonhq.com/products/javafx/) - Gui library used
* [Java 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html/) - Java lol
* [OpenCV](https://opencv.org/releases.html) - Computer vision used to face detection
* [OpenCV-Java-Tuts](https://opencv-java-tutorials.readthedocs.io/en/latest/06-face-detection-and-tracking.html) - Free-use tutorials/algorithms to get started with openCV

## Contributing

Please start a new branch, name it what your goal is, and push to that branch specifically. We can then use Merge Requests for the team to look over the code, make sure nothing is overwritten or broken, and then merge.


## License

This project is licensed under the MIT License

## Acknowledgments

* [OpenCV-Java-Tuts](https://opencv-java-tutorials.readthedocs.io/en/latest/06-face-detection-and-tracking.html)


