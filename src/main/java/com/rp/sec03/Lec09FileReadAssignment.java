package com.rp.sec03;

import com.rp.courseutil.Util;
import com.rp.sec03.assignment.FileReader;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Lec09FileReadAssignment {
  public static void main(String[] args) {
    FileReader fileReader = new FileReader();
    Path path = Paths.get("src/main/resources/assignment/sec03/file01.txt");
    fileReader.read(path)
            .take(2)
            .subscribe(Util.subscriber());
  }
}
